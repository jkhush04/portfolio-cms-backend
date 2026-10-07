package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExperienceRepository extends MongoRepository<Experience, String> {
}
