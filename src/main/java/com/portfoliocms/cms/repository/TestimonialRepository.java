package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.Testimonial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestimonialRepository extends MongoRepository<Testimonial, String> {
}