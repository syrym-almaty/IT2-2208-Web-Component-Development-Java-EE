package com.example.demo;

import jakarta.persistence.GenerationType;
import org.hibernate.boot.jaxb.mapping.JaxbGeneratedValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static JaxbGeneratedValue GradingStrategyFactory;

	public static <GradingStrategy> void main(String[] args) {
		Double score = 85.0;

		GenerationType letterStrategy = GradingStrategyFactory.getStrategy();
		Class<?> letterGrade = letterStrategy.getClass();
		System.out.println("Letter Grade: " + letterGrade);

		GradingStrategy percentageStrategy = (GradingStrategy) GradingStrategyFactory.getStrategy();
		Class<?> percentageGrade = percentageStrategy.getClass();
		System.out.println("Percentage Grade: " + percentageGrade);
		SpringApplication.run(DemoApplication.class, args);
	}
}
