package com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import static com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.EnumConstants.ADMIN;
import static com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.EnumConstants.USER;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {
    
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles = List.of(USER, ADMIN);
        return roles.contains(inputRole);
    }
}
