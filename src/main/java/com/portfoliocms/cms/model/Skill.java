package com.portfoliocms.cms.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    @Id
    private String id;

    @NotBlank
    private String name;      // e.g. "Spring Boot"

    private String category;  // e.g. "Backend", "Frontend", "Database"

    private Integer level;    // proficiency, e.g. 0-100
}