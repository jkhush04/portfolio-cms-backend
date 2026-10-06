package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.ContactMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactMessageRepository extends MongoRepository<ContactMessage, String> {
}
