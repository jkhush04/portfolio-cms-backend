package com.portfoliocms.cms.controller;

import com.portfoliocms.cms.model.Experience;
import com.portfoliocms.cms.service.ExperienceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public List<Experience> getAll() {
        return experienceService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getById(@PathVariable String id) {
        return experienceService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Experience> create(@Valid @RequestBody Experience experience) {
        return ResponseEntity.status(HttpStatus.CREATED).body(experienceService.create(experience));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> update(@PathVariable String id, @Valid @RequestBody Experience experience) {
        return experienceService.update(id, experience).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return experienceService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
