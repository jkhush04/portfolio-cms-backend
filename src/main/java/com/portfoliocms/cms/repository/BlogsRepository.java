package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.Blogs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogsRepository extends MongoRepository<Blogs, String> {
}
