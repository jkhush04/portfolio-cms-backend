package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.AdminUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminUserRepository extends MongoRepository<AdminUser, String> {

    Optional<AdminUser> findByUsername(String username);

    boolean existsByUsername(String username);

}
