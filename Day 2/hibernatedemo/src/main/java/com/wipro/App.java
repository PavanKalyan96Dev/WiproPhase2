package com.wipro;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wipro.entiry.Employee;

public class App {
    public static void main(String[] args) {
        // Create Configuration object and configure Hibernate
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml"); // Load hibernate.cfg.xml

        // Add annotated class
        config.addAnnotatedClass(Employee.class);

        // Build SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();

       
//        // Create Employee object
//       Employee employee = new Employee(500, "pavan"); //transistent
//
   Session session = sessionFactory.openSession();
  Transaction transaction = session.beginTransaction();
  
  
//
//        // Use save() instead of persist()
//       session.persist(employee); //persistent state
//       
//        
//       //by using the get method
//       Employee empl = session.find(Employee.class, 502);
//       System.out.println(empl);	//returns null if the data is not there
//       

        
        /*update
        Employee empl = session.get(Employee.class, 500); 
        if (empl != null) {
            empl.setName("Prem"); // Updating name field
            session.update(empl); // Save changes
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }*/
       
       /*delete
       int employeeId = 500; // The ID of the employee you want to delete
       Employee empl2 = session.get(Employee.class, employeeId); 

       if (empl2 != null) {
           session.delete(employee); // Delete employee record
           System.out.println("Employee deleted successfully!");
       } else {
           System.out.println("Employee not found!");
       }*/
        

  List<Employee> employees = session.createQuery("FROM Employee", Employee.class).getResultList();
  		for(Employee emp:employees) {
  			System.out.println(emp.getId()+" "+emp.getName());
  		}
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
