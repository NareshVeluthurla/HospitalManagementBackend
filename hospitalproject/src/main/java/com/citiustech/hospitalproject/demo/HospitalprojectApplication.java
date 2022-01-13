package com.citiustech.hospitalproject.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan({"com.citiustech.hospitalproject"})
@EntityScan("com.citiustech.hospitalproject.entity")
@EnableJpaRepositories("com.citiustech.hospitalproject")
public class HospitalprojectApplication {

	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(HospitalprojectApplication.class, args);
	
	}
	
	@Bean
	public WebMvcConfigurer corssConfigure() {

	return new WebMvcConfigurer() {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**").allowedHeaders("*").allowedOriginPatterns("http://localhost:4200")
	.allowedMethods("*")
	   .maxAge(3600L)
       .exposedHeaders("Authorization")
	.allowCredentials(true);
	}
	};
	}

}
