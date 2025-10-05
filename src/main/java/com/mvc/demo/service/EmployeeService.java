package com.mvc.demo.service;

import com.mvc.demo.model.EmployeeEntity;
import com.mvc.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
  private final EmployeeRepository repository;

  public EmployeeService(EmployeeRepository repository) {
    this.repository = repository;
  }

  public List<EmployeeEntity> findAll() {
    return repository.findAll();
  }

  public List<EmployeeEntity> search(String query) {
    if (query == null || query.isBlank()) {
      return repository.findAll();
    }
    return repository
      .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
        query, query, query);
  }

  public EmployeeEntity findById(Long id) {
    return repository.findById(id).orElseThrow();
  }

  public EmployeeEntity save(EmployeeEntity employee) {
    return repository.save(employee);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) {
    if (entity.getId() == null) {
      return repository.save(entity);
    } else {
      Optional<EmployeeEntity> existing = repository.findById(entity.getId());
      if (existing.isPresent()) {
        EmployeeEntity toUpdate = existing.get();
        toUpdate.setEmail(entity.getEmail());
        toUpdate.setFirstName(entity.getFirstName());
        toUpdate.setLastName(entity.getLastName());
        return repository.save(toUpdate);
      } else {
        return repository.save(entity);
      }
    }
  }
}


