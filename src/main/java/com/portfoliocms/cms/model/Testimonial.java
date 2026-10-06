package com.portfoliocms.cms.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testimonials")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Testimonial {

    @Id
    private String id;

    @NotBlank
    private String authorName;

    private String authorRole;
    private String authorPhotoUrl;

    @NotBlank
    private String message;
}