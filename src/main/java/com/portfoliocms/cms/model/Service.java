package com.portfoliocms.cms.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Service {

    @Id
    private String id;

    @NotBlank
    private String title;
    private String description;
    private String iconName;
}
