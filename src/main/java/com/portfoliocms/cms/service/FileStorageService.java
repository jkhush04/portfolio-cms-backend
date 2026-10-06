package com.portfoliocms.cms.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {
    private final Path uploadPath;

    public FileStorageService(@Value("${app.upload.dir}") String uploadDir) throws IOException {
        this.uploadPath = Paths.get(uploadDir);
        Files.createDirectories(this.uploadPath);
    }

    public String store(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String extension = "";
        if (originalName != null && originalName.contains(".")) {
            extension = originalName.substring(originalName.lastIndexOf("."));
        }

        String filename = UUID.randomUUID() + extension;

        Path target = uploadPath.resolve(filename);
        Files.copy(file.getInputStream(), target);

        return "/uploads/" + filename;
    }
}