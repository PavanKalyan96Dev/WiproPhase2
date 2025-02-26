package com.wipro.dao;
//used for database operations
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.entity.Employee;

@Transactional //used for transactions like commit or rollback
@Repository // exactly similar to @component= a component that Spring should automatically detect and manage in the application context
//as soon as @repostiroy exist people can understand this is a database related class
public class EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

   
    public void saveEmployee(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(emp);//saves the employee object into the databaase
    }
}

