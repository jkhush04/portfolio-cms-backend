package com.portfoliocms.cms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "about")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class About {

    @Id
    private String id;

    private String name;
    private String headline;
    private String bio;
    private String profileImageUrl;
    private String email;
    private String location;
    private String resumeUrl;
    private String githubUrl;
    private String linkedinUrl;
}