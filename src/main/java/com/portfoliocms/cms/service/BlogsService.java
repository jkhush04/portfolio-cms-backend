package com.portfoliocms.cms.service;

import com.portfoliocms.cms.model.Blogs;

import com.portfoliocms.cms.repository.BlogsRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class BlogsService {

    private final BlogsRepository blogsRepository;

    public BlogsService(BlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    public List<Blogs> getAll() {
        return blogsRepository.findAll();
    }

    public Optional<Blogs> getById(String id) {
        return blogsRepository.findById(id);
    }

    public Blogs create(Blogs blog) {
        blog.setId(null);
        blog.setCreatedAt(Instant.now());
        return blogsRepository.save(blog);
    }

    public Optional<Blogs> update(String id, Blogs incoming) {
        return blogsRepository.findById(id).map(existing -> {
            incoming.setId(id);
            incoming.setCreatedAt(existing.getCreatedAt()); // don't let updates overwrite the original date
            return blogsRepository.save(incoming);
        });

    }

    public boolean delete(String id) {
        if (!blogsRepository.existsById(id)) {
            return false;
        }
        blogsRepository.deleteById(id);
        return true;
    }
}
