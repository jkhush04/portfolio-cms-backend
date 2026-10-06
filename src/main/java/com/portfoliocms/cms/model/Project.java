package com.portfoliocms.cms.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    private String id;

    @NotBlank
    private String title;

    private String description;
    private List<String> techStack;
    private String githubUrl;
    private String liveUrl;
    private String imageUrl;
    private boolean featured;         // to highlight top projects on the homepage
}
