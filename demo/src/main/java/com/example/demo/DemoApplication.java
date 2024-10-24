package com.example.demo;

<<<<<<< HEAD
import com.example.demo.Factory.GradingStrategy;
import com.example.demo.Factory.GradingStrategyFactory;
=======
import jakarta.persistence.GenerationType;
import org.hibernate.boot.jaxb.mapping.JaxbGeneratedValue;
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
<<<<<<< HEAD
	public static void main(String[] args) {
		Double score = 85.0;

		GradingStrategy letterStrategy = GradingStrategyFactory.getStrategy("letter");
		Double letterGrade = letterStrategy.calculateGrade(score);
		System.out.println("Letter Grade: " + letterGrade);

		GradingStrategy percentageStrategy = GradingStrategyFactory.getStrategy("percentage");
		Double percentageGrade = percentageStrategy.calculateGrade(score);
		System.out.println("Percentage Grade: " + percentageGrade);

=======
	private static JaxbGeneratedValue GradingStrategyFactory;

	public static <GradingStrategy> void main(String[] args) {
		Double score = 85.0;

		GenerationType letterStrategy = GradingStrategyFactory.getStrategy();
		Class<?> letterGrade = letterStrategy.getClass();
		System.out.println("Letter Grade: " + letterGrade);

		GradingStrategy percentageStrategy = (GradingStrategy) GradingStrategyFactory.getStrategy();
		Class<?> percentageGrade = percentageStrategy.getClass();
		System.out.println("Percentage Grade: " + percentageGrade);
>>>>>>> 9c6331db6efbf2b8197414cfe5cd8c91495d5e3c
		SpringApplication.run(DemoApplication.class, args);
	}
}
