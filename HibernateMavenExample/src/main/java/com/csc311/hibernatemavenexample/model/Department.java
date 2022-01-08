package com.csc311.hibernatemavenexample.model;


import java.util.List;
import javax.persistence.*;
//import javax.validation.constraints.*;
//import java.math.BigDecimal;


@Entity
@Table(name = "Department", catalog = "employeeinformationsystem")
public class Department  {  

@Id
@GeneratedValue
@Column(name = "departmentId", unique = true, nullable = false, length = 60)
private int departmentId;  

@Column(name = "name", nullable = true, length = 255)
private String name;  

@OneToMany (mappedBy="departmentId")
private List<Employee> employees;

//constructor
public Department() {
        super();
    }
//constructor

public Department(String deptName) {
        super(); 
        name = deptName;
       
    }


//getters
public int getDepartmentId() {  
    return departmentId;  
}


public String getName() {  
    return name;  
}  


public List<Employee> getEmployees() {  
    return employees;  
}

//setters
public void setId(int id) {  
    this.departmentId = id;  
} 

public void setFirstName(String deptName) {  
    this.name = deptName;  
}

}