package com.example.demo.helpers;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CourseCodeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCourseCode {
    String message() default "Invalid course code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
