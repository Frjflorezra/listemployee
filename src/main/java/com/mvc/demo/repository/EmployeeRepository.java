package com.mvc.demo.repository;

import com.mvc.demo.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio JPA para acceder a empleados.
 */
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
  /**
   * Busca empleados por coincidencia parcial en nombre, apellido o correo.
   * @param firstName parte del nombre
   * @param lastName parte del apellido
   * @param email parte del correo
   * @return lista de empleados que coinciden
   */
  List<EmployeeEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
    String firstName, String lastName, String email);
}


