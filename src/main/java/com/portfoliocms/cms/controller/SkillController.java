package com.portfoliocms.cms.controller;

import com.portfoliocms.cms.model.Skill;
import com.portfoliocms.cms.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<Skill> getAll() {
        return skillService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getById(@PathVariable String id) {
        return skillService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   @PostMapping
    public ResponseEntity<Skill>create(@Valid @RequestBody Skill skill){
        return ResponseEntity.status(HttpStatus.CREATED).body(skillService.create(skill));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> update(@PathVariable String id, @Valid @RequestBody Skill skill) {
        return skillService.update(id, skill)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return skillService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
