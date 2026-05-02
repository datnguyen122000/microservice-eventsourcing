package com.example.employeeservice.command.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeModel {
    @NotBlank(message = "First name is madatory")
    private String firstName;
    @NotBlank(message = "Last name is madatory")
    private String lastName;
    @NotBlank(message = "Kin is mandatory")
    private String kin;
    @NotBlank(message = "IsDisciplinedin is mandatory")
    private Boolean isDisciplined;
}
