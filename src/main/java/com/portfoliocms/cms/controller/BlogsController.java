
package com.portfoliocms.cms.controller;

import com.portfoliocms.cms.model.Blogs;

import com.portfoliocms.cms.service.BlogsService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogsController {

    private final BlogsService blogsService;

    public BlogsController(BlogsService blogsService) {
        this.blogsService = blogsService;
    }

    @GetMapping
    public List<Blogs> getAll() {
        return blogsService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blogs> getById(@PathVariable String id) {
        return blogsService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Blogs> create(@Valid @RequestBody Blogs blog) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogsService.create(blog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blogs> update(@PathVariable String id, @Valid @RequestBody Blogs blog) {
        return blogsService.update(id, blog)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return blogsService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
