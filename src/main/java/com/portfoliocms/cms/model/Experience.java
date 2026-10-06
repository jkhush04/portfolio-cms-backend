package com.portfoliocms.cms.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "experience")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    @Id
    private String id;

    @NotBlank
    private String role;

    @NotBlank
    private String company;

    private String description;
    private String startDate;   // simple strings for now, e.g. "Jan 2025"
    private String endDate;     // null/empty means "Present"
}