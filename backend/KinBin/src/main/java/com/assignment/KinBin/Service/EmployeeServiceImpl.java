package com.assignment.KinBin.Service;

import com.assignment.KinBin.Exception.EmployeeExceptionHandler;
import com.assignment.KinBin.Repo.EmployeeRepo;
import com.assignment.KinBin.model.Employee;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public Employee registerEmployee(Employee employee) throws EmployeeExceptionHandler {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee removeEmployee(@NotNull Employee id) throws EmployeeExceptionHandler {
        Optional<Employee> find= employeeRepo.findById(id.getEmployeId());

        if(find.isPresent()){
            employeeRepo.delete(id);
        }else{
            throw new EmployeeExceptionHandler("no such employee is available in database");
        }
        return find.get();
    }

    @Override
    public List<Employee> viewAllEmployee() throws EmployeeExceptionHandler {
        List<Employee> alljob= employeeRepo.findAll();

        if(alljob.isEmpty()){
            throw new EmployeeExceptionHandler("No employee is available in database");
        }else{
            return alljob;
        }
    }

    @Override
    public Employee updateEmployee(Integer id, Employee emp) throws EmployeeExceptionHandler {
        Optional<Employee> opt = employeeRepo.findById(id);

        if(opt.isEmpty()) {
            throw new EmployeeExceptionHandler("No product found");
        }else {
            Employee e1 = opt.get();

            e1.setPhoneNumber(emp.getPhoneNumber());
            e1.setEmail(emp.getEmail());
            // Set other updated fields as needed

            return employeeRepo.save(e1);
        }
    }

    @Override
    public Employee getEmployee(Integer id) throws EmployeeExceptionHandler {
        Optional<Employee> find= employeeRepo.findById(id);

        if(find.isEmpty()){
            throw new EmployeeExceptionHandler("No employee found for the given Id");
        }else{
            return find.get();
        }
    }
}
