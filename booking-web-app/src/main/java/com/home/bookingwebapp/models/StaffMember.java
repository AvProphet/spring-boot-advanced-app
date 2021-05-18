package com.home.bookingwebapp.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Employee")
public class StaffMember {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private Position position;

    public StaffMember(String id, String firstName, String lastName, Position position) {
        this.employeeId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public StaffMember() {
        this.employeeId = UUID.randomUUID().toString();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
