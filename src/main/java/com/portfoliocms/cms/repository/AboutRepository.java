package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.About;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AboutRepository extends MongoRepository<About, String> {
}
