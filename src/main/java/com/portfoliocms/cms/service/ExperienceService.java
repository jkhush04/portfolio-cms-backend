package com.portfoliocms.cms.service;

import com.portfoliocms.cms.model.Experience;
import com.portfoliocms.cms.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> getById(String id) {
        return experienceRepository.findById(id);
    }

    public Experience create(Experience experience) {
        experience.setId(null);
        return experienceRepository.save(experience);
    }

    public Optional<Experience> update(String id, Experience incoming) {
        if (!experienceRepository.existsById(id)) {
            return Optional.empty();
        }
        incoming.setId(id);
        return Optional.of(experienceRepository.save(incoming));
    }

    public boolean delete(String id) {
        if (!experienceRepository.existsById(id)) {
            return false;
        }
        experienceRepository.deleteById(id);
        return true;
    }
}