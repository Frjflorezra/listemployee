package com.mvc.demo.web;

import com.mvc.demo.model.EmployeeEntity;
import com.mvc.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador MVC para gestionar empleados y vistas Thymeleaf.
 */
@Controller
@RequestMapping("/empleados")
public class EmployeeMvcController {
  private final EmployeeService service;

  public EmployeeMvcController(EmployeeService service) {
    this.service = service;
  }

  /**
   * Lista empleados con búsqueda opcional por parámetro q.
   */
  @GetMapping
  public String list(@RequestParam(value = "q", required = false) String q, Model model) {
    model.addAttribute("q", q);
    model.addAttribute("employees", service.search(q));
    return "list-employees";
  }

  /**
   * Redirige la raíz del recurso a la lista principal.
   */
  @GetMapping("/")
  public String rootRedirect() {
    return "redirect:/empleados";
  }

  /**
   * Muestra el formulario de creación.
   */
  @GetMapping("/nuevo")
  public String showCreateForm(Model model) {
    model.addAttribute("employee", new EmployeeEntity());
    return "add-edit-employee";
  }

  /**
   * Crea un empleado mediante validación.
   */
  @PostMapping
  public String create(@Valid @ModelAttribute("employee") EmployeeEntity employee, BindingResult errors) {
    if (errors.hasErrors()) return "add-edit-employee";
    service.save(employee);
    return "redirect:/empleados";
  }

  /**
   * Crea o actualiza un empleado en una sola operación.
   */
  @RequestMapping(path = "/crearEmpleado", method = RequestMethod.POST)
  public String createOrUpdate(EmployeeEntity employee) {
    service.createOrUpdateEmployee(employee);
    return "redirect:/empleados";
  }

  /**
   * Muestra formulario de edición.
   */
  @GetMapping("/{id}/editar")
  public String edit(@PathVariable Long id, Model model) {
    model.addAttribute("employee", service.findById(id));
    return "add-edit-employee";
  }

  /**
   * Actualiza un empleado existente.
   */
  @PostMapping("/{id}")
  public String update(@PathVariable Long id, @Valid @ModelAttribute("employee") EmployeeEntity employee, BindingResult errors) {
    if (errors.hasErrors()) return "add-edit-employee";
    employee.setId(id);
    service.save(employee);
    return "redirect:/empleados";
  }

  /**
   * Elimina un empleado.
   */
  @PostMapping("/{id}/eliminar")
  public String delete(@PathVariable Long id) {
    service.delete(id);
    return "redirect:/empleados";
  }
}


