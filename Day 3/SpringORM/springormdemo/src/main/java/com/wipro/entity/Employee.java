package com.wipro.entity;
//represents the employee table in the db
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee") // Match with your actual DB table name
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Works only with Integer or Long
    private Integer id; // Change from String to Integer

    private String name;

    public Employee() {
    }

    public Employee(Integer id, String name) {  // Update constructor
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public Integer getId() {  // Change return type to Integer
        return id;
    }

    public void setId(Integer id) {  // Change parameter type to Integer
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
