package com.wipro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.config.SpringConfig;
import com.wipro.dao.EmployeeDAO;
import com.wipro.entity.Employee;

public class App{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);

        Employee emp = new Employee();
        emp.setName("Prem Nath");
        employeeDAO.saveEmployee(emp);


        System.out.println("Employee inserted successfully!");

        context.close();
    }
}
