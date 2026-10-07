package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.Testimonial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestimonialRepository extends MongoRepository<Testimonial, String> {
}