package com.chinu.Anootation;




import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = CourseTypeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CourseTypeAnnotation {
    String message() default "Invalid course type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

