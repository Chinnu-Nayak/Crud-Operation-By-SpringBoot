package com.chinu.Anootation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.mapping.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseTypeValidator implements ConstraintValidator<CourseTypeAnnotation,String> {
    @Override
    public boolean isValid(String courseType, ConstraintValidatorContext context) {
        List<String> list = Arrays.asList("online", "offline");
        return list.contains(courseType);
    }
}
