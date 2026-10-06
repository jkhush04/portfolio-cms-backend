package com.portfoliocms.cms.controller;

import com.portfoliocms.cms.model.Service;
import com.portfoliocms.cms.service.ServiceOfferingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceOfferingService serviceOfferingService;

    public ServiceController(ServiceOfferingService serviceOfferingService) {
        this.serviceOfferingService = serviceOfferingService;
    }

    @GetMapping
    public List<Service> getAll() {
        return serviceOfferingService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getById(@PathVariable String id) {
        return serviceOfferingService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Service> create(@Valid @RequestBody Service service) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceOfferingService.create(service));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> update(@PathVariable String id, @Valid @RequestBody Service service) {
        return serviceOfferingService.update(id, service).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return serviceOfferingService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}