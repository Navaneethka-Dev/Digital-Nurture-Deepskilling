package com.dn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class HelloWorld {
    public void sayHello() { System.out.println("Hello, Spring!"); }
}

@Configuration
public class AppConfig {
    @Bean
    public HelloWorld helloWorld() { return new HelloWorld(); }
}
