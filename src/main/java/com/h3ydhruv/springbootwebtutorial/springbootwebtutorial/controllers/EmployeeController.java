package com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.controllers;

import com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.h3ydhruv.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    
//    @GetMapping(path = "/getSecretMessage")
//    public String getMySecretMessage(){
//        return "Secret Message: asjb13813@@!$~adq2";
//    }
    
    private final EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    
    /**Get Employee Details using id, employee structure defined in EmployeeDTO
     * Using @PathVariable here to pass the parameter from URL to logic
     * Use it when the parameter is mandatory **/
    
    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    
    /**Get All Employees details based on some sort of filtering, default will show all employees
    Using @RequestParam here to pass the optional parameters **/
    
    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy){
        //return "Returning List of Employees below age: " + age + " sorted by: " + sortBy;
        return employeeService.getAllEmployees();
    }
    
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(100L);
//        return inputEmployee;
        return employeeService.createNewEmployee(inputEmployee);
    }
    
    @PutMapping
    public String updateEmployeeById(){
        return "Hello from PUT createNewEmployee";
    }
}
