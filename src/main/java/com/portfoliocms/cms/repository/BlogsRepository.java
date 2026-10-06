package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.Blogs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogsRepository extends MongoRepository<Blogs, String> {
}
