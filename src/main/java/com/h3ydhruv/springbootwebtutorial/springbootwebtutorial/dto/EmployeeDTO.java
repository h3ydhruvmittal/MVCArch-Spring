package com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.dto;

import com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    
    @NotNull(message = "Required field in Employee: name")
    @NotBlank(message = "name should not be blank")
    @Size(min = 3, max=10, message = "Number of characters should be in the range: [3,10]")
    private String name;
    
    @Email(message = "Email should be a valid Email.")
    private String email;
    
    @Max(value = 80, message = "Age can not be more than 80")
    @Min(value = 18, message = "Age can not be less than 18")
    private Integer age;
    
    @NotBlank(message = "Role of Employee can not be blank")
    //@Pattern(regexp = "^(ADMIN|USER)$" , message = "Role of Employee can be either 'ADMIN' or 'USER' only")
    @EmployeeRoleValidation
    private String role; //ADMIN, USER
    
    @NotNull (message = "Salary shouldn't be null")
    @Positive (message = "Salary should be a Positive")
    @Digits(integer = 6,fraction = 2,message = "The Salary can only be the form of XXXXXX.YY")
    @DecimalMax(value = "100000.99", message = "Salary can't be more than 100000.99")
    @DecimalMin(value = "999.99", message = "Salary can't be less than 999.99")
    private Double salary;
    
    @PastOrPresent(message = "Date of Joining should be either Present or a Past date only.")
    private LocalDate dateOfJoining;
    
    @AssertTrue
    private Boolean isActive;
    
}