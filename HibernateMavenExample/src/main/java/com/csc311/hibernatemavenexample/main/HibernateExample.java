/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csc311.hibernatemavenexample.main;

import com.csc311.hibernatemavenexample.model.Employee;
import com.csc311.hibernatemavenexample.model.Department;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration; 
import org.hibernate.service.ServiceRegistry;


public class HibernateExample {  
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
public static void main(String[] args) {  
      
    //creating configuration object  
    Configuration cfg=new Configuration();
    cfg.addAnnotatedClass(Employee.class);
    cfg.addAnnotatedClass(Department.class);
           
   cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
    
     
    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
            cfg.getProperties()).build();
       
    sessionFactory = cfg.buildSessionFactory(serviceRegistry);
    
    
    //creating session object  
    Session session=sessionFactory.openSession();  
     
    //creating transaction object  
    Transaction t=session.beginTransaction();  
    
    Department department = new Department("Sales");
    session.save(department);
    
    Employee e1=new Employee();  
    e1.setId(606);  
    e1.setFirstName("Berry");  
    e1.setLastName("Adams");
    e1.setDepartmentId(department);
    session.persist(e1);//persisting the object  
    
    Employee e2=new Employee();  
    e2.setId(787);  
    e2.setFirstName("Dudu");  
    e2.setLastName("Msimango");
    e2.setDepartmentId(department);
    session.persist(e2);//persisting the object 
   
     
    
    t.commit();//transaction is commited  
    session.close();  
      
    System.out.println("successfully saved");  
      
}  
}  