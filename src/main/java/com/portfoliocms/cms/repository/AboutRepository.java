package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.About;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends MongoRepository<About, String> {
}
