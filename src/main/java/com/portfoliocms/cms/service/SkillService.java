package com.portfoliocms.cms.service;

import com.portfoliocms.cms.model.Skill;
import com.portfoliocms.cms.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {


    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAll() {
        return skillRepository.findAll();
    }

    public Optional<Skill> getById(String id) {
        return skillRepository.findById(id);
    }

    public Skill create(Skill skill) {
        skill.setId(null);
        return skillRepository.save(skill);
    }

    public Optional<Skill> update(String id, Skill incoming) {
        if (!skillRepository.existsById(id)) {
            return Optional.empty();
        }
        incoming.setId(id);
        return Optional.of(skillRepository.save(incoming));
    }

    public boolean delete(String id) {
        if (!skillRepository.existsById(id)) {
            return false;
        }
        skillRepository.deleteById(id);
        return true;
    }
}
