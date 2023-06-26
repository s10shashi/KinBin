package com.assignment.KinBin.Repo;

import com.assignment.KinBin.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
