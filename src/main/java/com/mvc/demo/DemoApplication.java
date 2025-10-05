package com.mvc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de la aplicación Spring Boot.
 * Inicia el contenedor y expone la aplicación MVC.
 */
@SpringBootApplication
public class DemoApplication {
  /**
   * Arranca la aplicación.
   * @param args argumentos de línea de comandos
   */
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}


