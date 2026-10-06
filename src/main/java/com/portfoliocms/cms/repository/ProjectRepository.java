package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
}
