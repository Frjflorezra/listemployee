# Aplicación MVC de Empleados (Spring Boot)

## Requisitos
- Java 17
- Maven 3.x

## Ejecutar
```bash
mvn clean spring-boot:run
```
- Aplicación: `http://localhost:8081/empleados`
- Consola H2: `http://localhost:8081/h2-console` (URL JDBC `jdbc:h2:mem:employeesdb`)

## Funcionalidades
- Listar empleados
- Crear, editar y eliminar
- Búsqueda por nombre/apellido/correo (parámetro `q`)
- Confirmación al eliminar

## Estructura principal
- `com.mvc.demo.DemoApplication` clase principal
- `model.EmployeeEntity` entidad JPA
- `repository.EmployeeRepository` acceso a datos
- `service.EmployeeService` lógica de negocio
- `web.EmployeeMvcController` controlador MVC
- Vistas Thymeleaf en `src/main/resources/templates`
- SQL de esquema y datos en `src/main/resources`
