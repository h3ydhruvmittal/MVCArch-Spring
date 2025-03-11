package com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.controllers;

import com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepositories;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    
//    @GetMapping(path = "/getSecretMessage")
//    public String getMySecretMessage(){
//        return "Secret Message: asjb13813@@!$~adq2";
//    }
    
    private final EmployeeRepositories employeeRepositories;
    
    public EmployeeController(EmployeeRepositories employeeRepositories) {
        this.employeeRepositories = employeeRepositories;
    }
    
    /**Get Employee Details using id, employee structure defined in EmployeeDTO
     * Using @PathVariable here to pass the parameter from URL to logic
     * Use it when the parameter is mandatory **/
    
    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id){
        //return new EmployeeDTO(id,"Dhruv","test@email.com", 24,LocalDate.of(2023,11,21),true);
        return employeeRepositories.findById(id).orElse(null);
    }
    
    /**Get All Employees details based on some sort of filtering, default will show all employees
    Using @RequestParam here to pass the optional parameters **/
    
    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy){
        //return "Returning List of Employees below age: " + age + " sorted by: " + sortBy;
        return employeeRepositories.findAll();
    }
    
    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
//        inputEmployee.setId(100L);
//        return inputEmployee;
        return employeeRepositories.save(inputEmployee);
    }
    
    @PutMapping
    public String updateEmployeeById(){
        return "Hello from PUT createNewEmployee";
    }
}
