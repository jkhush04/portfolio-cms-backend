package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExperienceRepository extends MongoRepository<Experience, String> {
}
