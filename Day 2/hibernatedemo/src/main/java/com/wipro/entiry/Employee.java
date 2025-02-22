package com.wipro.entiry;

import jakarta.persistence.*;

@Entity
@Table(name = "employee") // Match with your actual DB table name
public class Employee {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // REMOVE OR COMMENT THIS
    private int id;

    private String name;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
