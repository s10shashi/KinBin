package com.assignment.KinBin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "EmployeeDetails")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer employeId;
    @NotNull
    private String employeeName;

    @Min(10)
    private Long phoneNumber;

    @Email
    @NotNull
    private  String email;

    @NotNull
    private String address;

    @NotNull
    private String education;
    @Min(0)
    @NotNull
    private Integer experience;

    public Employee(String employeeName, Long phoneNumber, String email, String address, String education, Integer experience) {
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.education = education;
        this.experience = experience;
    }
}
