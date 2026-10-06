package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceRepository extends MongoRepository<Service, String> {
}
