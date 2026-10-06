package com.portfoliocms.cms.service;

import com.portfoliocms.cms.model.Project;
import com.portfoliocms.cms.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> getById(String id) {
        return projectRepository.findById(id);
    }

    public Project create(Project project) {
        project.setId(null);
        return projectRepository.save(project);
    }

    public Optional<Project> update(String id, Project incoming) {
        if (!projectRepository.existsById(id)) {
            return Optional.empty();
        }
        incoming.setId(id);
        return Optional.of(projectRepository.save(incoming));
    }

    public boolean delete(String id) {
        if (!projectRepository.existsById(id)) {
            return false;
        }
        projectRepository.deleteById(id);
        return true;
    }
}
