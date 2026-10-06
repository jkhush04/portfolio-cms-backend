package com.portfoliocms.cms.service;

import com.portfoliocms.cms.model.Testimonial;
import com.portfoliocms.cms.repository.TestimonialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestimonialService {

    private final TestimonialRepository testimonialRepository;

    public TestimonialService(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    public List<Testimonial> getAll() {
        return testimonialRepository.findAll();
    }

    public Optional<Testimonial> getById(String id) {
        return testimonialRepository.findById(id);
    }

    public Testimonial create(Testimonial testimonial) {
        testimonial.setId(null);
        return testimonialRepository.save(testimonial);
    }

    public Optional<Testimonial> update(String id, Testimonial incoming) {
        if (!testimonialRepository.existsById(id)) {
            return Optional.empty();
        }
        incoming.setId(id);
        return Optional.of(testimonialRepository.save(incoming));
    }

    public boolean delete(String id) {
        if (!testimonialRepository.existsById(id)) {
            return false;
        }
        testimonialRepository.deleteById(id);
        return true;
    }
}