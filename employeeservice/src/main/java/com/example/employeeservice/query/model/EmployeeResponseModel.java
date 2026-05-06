package com.example.employeeservice.query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModel {
    private String id;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;
}
