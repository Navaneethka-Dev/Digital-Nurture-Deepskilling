$baseDir = "d:\Cognizant Deep Skilling"

function Create-File {
    param([string]$Path, [string]$Content)
    $FullPath = Join-Path $baseDir $Path
    $Dir = Split-Path $FullPath -Parent
    if (-not (Test-Path $Dir)) { New-Item -ItemType Directory -Force -Path $Dir | Out-Null }
    Set-Content -Path $FullPath -Value $Content.Trim()
}

function Create-Pom {
    param($Path, $Group, $Artifact, $Deps)
    $Content = @"
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.1.0</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>$Group</groupId>
    <artifactId>$Artifact</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <java.version>17</java.version>
    </properties>
    <dependencies>
$Deps
    </dependencies>
</project>
"@
    Create-File $Path $Content
}

$spring_web_dep = @"
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
"@

$spring_security_jwt_dep = @"
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.5</version>
        </dependency>
"@

$eureka_server_dep = @"
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
"@
$eureka_client_dep = @"
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
"@
$spring_cloud_dep_management = @"
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>2022.0.3</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
"@

function Create-Cloud-Pom {
    param($Path, $Group, $Artifact, $Deps)
    $Content = @"
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.1.0</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>$Group</groupId>
    <artifactId>$Artifact</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <java.version>17</java.version>
    </properties>
    <dependencies>
$Deps
    </dependencies>
$spring_cloud_dep_management
</project>
"@
    Create-File $Path $Content
}


# Spring REST using Spring Boot 3
Create-Pom "Spring_REST_Spring_Boot_3\REST_Country_Service\pom.xml" "com.dn" "rest-country-service" $spring_web_dep
Create-File "Spring_REST_Spring_Boot_3\REST_Country_Service\src\main\java\com\dn\RestApplication.java" @"
package com.dn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country-config.xml") // Spring Core - Load Country from Spring Configuration XML
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
"@
Create-File "Spring_REST_Spring_Boot_3\REST_Country_Service\src\main\resources\country-config.xml" @"
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="defaultCountry" class="com.dn.Country">
        <property name="code" value="IN"/>
        <property name="name" value="India"/>
    </bean>
</beans>
"@
Create-File "Spring_REST_Spring_Boot_3\REST_Country_Service\src\main\java\com\dn\Country.java" @"
package com.dn;
public class Country {
    private String code;
    private String name;
    public Country() {}
    public Country(String code, String name) { this.code = code; this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
"@
Create-File "Spring_REST_Spring_Boot_3\REST_Country_Service\src\main\java\com\dn\CountryController.java" @"
package com.dn;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private Country defaultCountry; // Loaded from XML
    
    private List<Country> countries = new ArrayList<>();

    public CountryController() {
        countries.add(new Country("US", "United States"));
        countries.add(new Country("UK", "United Kingdom"));
    }

    // Hello World RESTful Web Service
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    // REST - Country Web Service (Get All)
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        List<Country> all = new ArrayList<>(countries);
        all.add(defaultCountry);
        return all;
    }

    // REST - Get country based on country code
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        if(code.equalsIgnoreCase(defaultCountry.getCode())) return defaultCountry;
        return countries.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}
"@

# JWT Authentication Service
Create-Pom "Spring_REST_Spring_Boot_3\JWT_Authentication_Service\pom.xml" "com.dn" "jwt-auth-service" $spring_security_jwt_dep
Create-File "Spring_REST_Spring_Boot_3\JWT_Authentication_Service\src\main\java\com\dn\AuthApplication.java" @"
package com.dn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
"@
Create-File "Spring_REST_Spring_Boot_3\JWT_Authentication_Service\src\main\java\com\dn\AuthController.java" @"
package com.dn;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
public class AuthController {

    // Simple mock endpoint that returns a JWT token string
    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            // Normally we'd use io.jsonwebtoken.Jwts builder here
            return "mock.jwt.token." + UUID.randomString();
        }
        throw new RuntimeException("Invalid credentials");
    }
}
"@

# Microservices with Spring Boot 3 and Spring Cloud
Create-Cloud-Pom "Microservices_Spring_Cloud\Eureka_Discovery_Server\pom.xml" "com.dn" "eureka-server" $eureka_server_dep
Create-File "Microservices_Spring_Cloud\Eureka_Discovery_Server\src\main\resources\application.properties" @"
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
"@
Create-File "Microservices_Spring_Cloud\Eureka_Discovery_Server\src\main\java\com\dn\EurekaServerApp.java" @"
package com.dn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp.class, args);
    }
}
"@

Create-Cloud-Pom "Microservices_Spring_Cloud\Account_Microservice\pom.xml" "com.dn" "account-service" $eureka_client_dep
Create-File "Microservices_Spring_Cloud\Account_Microservice\src\main\resources\application.properties" @"
server.port=8081
spring.application.name=account-service
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
"@
Create-File "Microservices_Spring_Cloud\Account_Microservice\src\main\java\com\dn\AccountApp.java" @"
package com.dn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AccountApp {
    public static void main(String[] args) {
        SpringApplication.run(AccountApp.class, args);
    }
    @GetMapping("/accounts")
    public String getAccounts() { return "List of Accounts"; }
}
"@

Create-Cloud-Pom "Microservices_Spring_Cloud\Loan_Microservice\pom.xml" "com.dn" "loan-service" $eureka_client_dep
Create-File "Microservices_Spring_Cloud\Loan_Microservice\src\main\resources\application.properties" @"
server.port=8082
spring.application.name=loan-service
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
"@
Create-File "Microservices_Spring_Cloud\Loan_Microservice\src\main\java\com\dn\LoanApp.java" @"
package com.dn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LoanApp {
    public static void main(String[] args) {
        SpringApplication.run(LoanApp.class, args);
    }
    @GetMapping("/loans")
    public String getLoans() { return "List of Loans"; }
}
"@

Write-Host "REST and Microservices scaffolding generated."
