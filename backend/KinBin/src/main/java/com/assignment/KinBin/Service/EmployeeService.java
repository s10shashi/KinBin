package com.assignment.KinBin.Service;

import com.assignment.KinBin.Exception.EmployeeExceptionHandler;
import com.assignment.KinBin.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee registerEmployee(Employee employee)throws EmployeeExceptionHandler;

    public Employee  removeEmployee(Employee id) throws EmployeeExceptionHandler;

    public List<Employee> viewAllEmployee()throws EmployeeExceptionHandler;


    public Employee updateEmployee(Integer id, Employee employee )throws EmployeeExceptionHandler;


    public Employee getEmployee(Integer id)throws EmployeeExceptionHandler;
}
