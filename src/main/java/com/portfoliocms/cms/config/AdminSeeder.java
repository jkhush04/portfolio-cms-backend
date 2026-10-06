package com.portfoliocms.cms.config;

import com.portfoliocms.cms.model.AdminUser;
import com.portfoliocms.cms.repository.AdminUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class AdminSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AdminSeeder.class);

    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin.username}")
    private String seedUsername;

    @Value("${app.admin.password}")
    private String seedPassword;

    public AdminSeeder(AdminUserRepository adminUserRepository, PasswordEncoder passwordEncoder) {
        this.adminUserRepository = adminUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (adminUserRepository.existsByUsername(seedUsername)) {
            log.info("Admin user '{}' already exists, skipping seed.", seedUsername);
            return;
        }

        AdminUser admin = new AdminUser(null, seedUsername, passwordEncoder.encode(seedPassword));
        adminUserRepository.save(admin);
        log.info("Created initial admin user '{}'.", seedUsername);
    }

}
