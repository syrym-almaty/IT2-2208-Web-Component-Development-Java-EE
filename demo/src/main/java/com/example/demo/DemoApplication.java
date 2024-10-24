package com.example.demo;

import com.example.demo.Factory.GradingStrategy;
import com.example.demo.Factory.GradingStrategyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		Double score = 85.0;

		GradingStrategy letterStrategy = GradingStrategyFactory.getStrategy("letter");
		Double letterGrade = letterStrategy.calculateGrade(score);
		System.out.println("Letter Grade: " + letterGrade);

		GradingStrategy percentageStrategy = GradingStrategyFactory.getStrategy("percentage");
		Double percentageGrade = percentageStrategy.calculateGrade(score);
		System.out.println("Percentage Grade: " + percentageGrade);

		SpringApplication.run(DemoApplication.class, args);
	}
}
