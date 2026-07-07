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
