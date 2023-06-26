package com.assignment.KinBin.Controller;

import com.assignment.KinBin.Exception.EmployeeExceptionHandler;
import com.assignment.KinBin.Service.EmployeeService;
import com.assignment.KinBin.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) throws EmployeeExceptionHandler {
        Employee newEmployee= employeeService.registerEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employeeList")
    public ResponseEntity<List<Employee>> findallEmployee() throws EmployeeExceptionHandler{
        List<Employee> list= employeeService.viewAllEmployee();
        return  new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getUserDetailsHandler(@PathVariable("id") Integer id) throws EmployeeExceptionHandler {

        Employee find = employeeService.getEmployee(id);

        return new ResponseEntity<Employee>(find, HttpStatus.OK);

    }

    @DeleteMapping("/remove")
    public ResponseEntity<Employee> delProductHandler(@RequestParam("eId") Employee id) throws EmployeeExceptionHandler{
        Employee del= employeeService.removeEmployee(id);
        return new ResponseEntity<>(del,HttpStatus.OK);
    }

}
