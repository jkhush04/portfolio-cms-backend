package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
}
