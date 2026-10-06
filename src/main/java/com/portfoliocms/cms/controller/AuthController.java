package com.portfoliocms.cms.controller;

import com.portfoliocms.cms.dto.LoginRequest;
import com.portfoliocms.cms.dto.LoginResponse;
import com.portfoliocms.cms.model.AdminUser;
import com.portfoliocms.cms.repository.AdminUserRepository;
import com.portfoliocms.cms.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(AdminUserRepository adminUserRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {
        this.adminUserRepository = adminUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        AdminUser admin = adminUserRepository.findByUsername(request.username()).orElse(null);


        if (admin == null || !passwordEncoder.matches(request.password(), admin.getPasswordHash())) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        String token = jwtService.generateToken(admin.getUsername());
        return ResponseEntity.ok(new LoginResponse(token, admin.getUsername()));
    }

}
