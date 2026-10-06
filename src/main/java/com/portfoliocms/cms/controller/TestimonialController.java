package com.portfoliocms.cms.controller;

import com.portfoliocms.cms.model.Testimonial;
import com.portfoliocms.cms.service.TestimonialService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
public class TestimonialController {

    private final TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService) {
        this.testimonialService = testimonialService;
    }

    @GetMapping
    public List<Testimonial> getAll() {
        return testimonialService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Testimonial> getById(@PathVariable String id) {
        return testimonialService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Testimonial> create(@Valid @RequestBody Testimonial testimonial) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testimonialService.create(testimonial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Testimonial> update(@PathVariable String id, @Valid @RequestBody Testimonial testimonial) {
        return testimonialService.update(id, testimonial).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return testimonialService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
