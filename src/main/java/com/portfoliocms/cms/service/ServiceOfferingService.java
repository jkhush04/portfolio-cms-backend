package com.portfoliocms.cms.service;

import com.portfoliocms.cms.model.Service;
import com.portfoliocms.cms.repository.ServiceRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceOfferingService {

    private final ServiceRepository serviceRepository;

    public ServiceOfferingService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getAll() {
        return serviceRepository.findAll();
    }

    public Optional<Service> getById(String id) {
        return serviceRepository.findById(id);
    }

    public Service create(Service service) {
        service.setId(null);
        return serviceRepository.save(service);
    }

    public Optional<Service> update(String id, Service incoming) {
        if (!serviceRepository.existsById(id)) {
            return Optional.empty();
        }
        incoming.setId(id);
        return Optional.of(serviceRepository.save(incoming));
    }

    public boolean delete(String id) {
        if (!serviceRepository.existsById(id)) {
            return false;
        }
        serviceRepository.deleteById(id);
        return true;
    }
}