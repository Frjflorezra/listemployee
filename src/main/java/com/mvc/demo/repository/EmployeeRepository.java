package com.mvc.demo.repository;

import com.mvc.demo.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
  List<EmployeeEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
    String firstName, String lastName, String email);
}


