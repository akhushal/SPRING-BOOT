package com.rest_db.crudrestdb.rest;

import com.rest_db.crudrestdb.entity.Employee;
import com.rest_db.crudrestdb.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
//    private EmployeeDAO employeeDAO;
//    // inject employee dao
//    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }
//    //expose "/employees" and return the list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll(){
//        return employeeDAO.findAll();
//    }
    private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("emoployee not found "+employeeId);
        }
        return theEmployee;
    }
    // adding new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    // updating the employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
       Employee tempEmployee = employeeService.findById(employeeId);
       if(tempEmployee == null){
           throw new RuntimeException("employee not found "+employeeId);
       }
        employeeService.deleteById(employeeId);
       return "deleted employee id: "+employeeId;
    }
}
