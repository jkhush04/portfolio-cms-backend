package com.portfoliocms.cms.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;


@Document(collection = "blogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blogs {

    @Id
    private String id;

    @NotBlank
    private String title;

    private String content;

    private String coverimageUrl;
    private List<String> tags;
    private Instant createdAt;
}