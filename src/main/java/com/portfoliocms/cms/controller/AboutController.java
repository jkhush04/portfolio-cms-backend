package com.portfoliocms.cms.controller;

import com.portfoliocms.cms.model.About;
import com.portfoliocms.cms.service.AboutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/about")
public class AboutController {

    private final AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping
    public ResponseEntity<About> getAbout() {
        return aboutService.getAbout()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<About> updateAbout(@RequestBody About about) {
        return ResponseEntity.ok(aboutService.saveAbout(about));
    }
}