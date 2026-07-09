package com.dn;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
public class AuthController {

    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            return "mock.jwt.token." + UUID.randomString();
        }
        throw new RuntimeException("Invalid credentials");
    }
}
