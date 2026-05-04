package com.example.employeeservice.command.aggregate;

import com.example.employeeservice.command.command.CreateEmployeeCommand;
import com.example.employeeservice.command.command.DeleteEmployeeCommand;
import com.example.employeeservice.command.command.UpdateEmployeeCommand;
import com.example.employeeservice.command.event.EmployeeCreatedEvent;
import com.example.employeeservice.command.event.EmployeeDeletedEvent;
import com.example.employeeservice.command.event.EmployeeUpdatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
@Aggregate
@NoArgsConstructor
public class EmployeeAggregate {
    @AggregateIdentifier
    private String id;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;

    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand command) {
        EmployeeCreatedEvent employeeCreatedEvent = new EmployeeCreatedEvent();
        BeanUtils.copyProperties(command, employeeCreatedEvent);
        AggregateLifecycle.apply(employeeCreatedEvent);
    }

    @CommandHandler
    public void handle(UpdateEmployeeCommand command){
        EmployeeUpdatedEvent employeeUpdatedEvent = new EmployeeUpdatedEvent();
        BeanUtils.copyProperties(command,employeeUpdatedEvent);
        AggregateLifecycle.apply(employeeUpdatedEvent);
    }

    @CommandHandler
    public void handle(DeleteEmployeeCommand command){
        EmployeeDeletedEvent employeeDeletedEvent = new EmployeeDeletedEvent();
        BeanUtils.copyProperties(command,employeeDeletedEvent);
        AggregateLifecycle.apply(employeeDeletedEvent);
    }

    @EventSourcingHandler
    public void on(EmployeeCreatedEvent event) {
        this.id = event.getId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.kin = event.getKin();
        this.isDisciplined = event.getIsDisciplined();
    }

    @EventSourcingHandler
    public void on(EmployeeUpdatedEvent event) {
        this.id = event.getId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.kin = event.getKin();
        this.isDisciplined = event.getIsDisciplined();
    }

    @EventSourcingHandler
    public void on(EmployeeDeletedEvent event) {
        this.id = event.getId();
    }
}
