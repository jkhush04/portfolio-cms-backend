package com.portfoliocms.cms.service;

import com.portfoliocms.cms.model.About;
import com.portfoliocms.cms.repository.AboutRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AboutService {

    private final AboutRepository aboutRepository;

    public AboutService(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    public Optional<About> getAbout() {
        return aboutRepository.findAll().stream().findFirst();
    }


    public About saveAbout(About incoming) {
        Optional<About> existing = getAbout();
        existing.ifPresent(e -> incoming.setId(e.getId()));
        return aboutRepository.save(incoming);
    }
}
