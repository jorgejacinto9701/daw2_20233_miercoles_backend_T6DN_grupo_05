package com.centroinformacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@CommonsLog
public class ProyectoDawiiBackendApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDawiiBackendApplication.class, args);
		log.info("¡Terminó de cargar spring ... Fuerza!");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:4200") // Cambia esto con la URL de tu aplicación Angular
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
				.allowedHeaders("*")
				.allowCredentials(true);
	}
}
