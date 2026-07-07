package com.dn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class MyBean {
    public void doSomething() { System.out.println("IoC Container configured!"); }
}

@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() { return new MyBean(); }
}
