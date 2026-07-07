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
