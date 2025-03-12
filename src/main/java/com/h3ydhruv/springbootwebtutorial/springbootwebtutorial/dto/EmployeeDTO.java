package com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;
    
    public EmployeeDTO(){
    
    }
    
    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        this.isActive = isActive;
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
    }
}