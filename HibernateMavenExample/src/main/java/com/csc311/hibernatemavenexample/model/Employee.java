
package com.csc311.hibernatemavenexample.model;


import com.csc311.hibernatemavenexample.model.Department;
import javax.persistence.*;



@Entity
@Table(name = "Employee", catalog = "employeeinformationsystem")
public class Employee  {  

@Id
@Column(name = "id", unique = true, nullable = false, length = 60)    
private int id;  

@Column(name = "firstname", nullable = true, length = 255)
private String firstName;

@Column(name = "lastname", nullable = true, length = 255)
private String lastName;

@ManyToOne
@JoinColumn(name = "departmentId", nullable = true)
private Department departmentId;

//constructor
public Employee() {
        super();
    }
//constructor

public Employee(int empId, String empFirstName, String empLastName ) {
        super();
        id= empId; 
        firstName = empFirstName;
        lastName = empLastName;  
        departmentId = null;
    }

//getters

public int getId() {  
    return id;  
}


public String getFirstName() {  
    return firstName;  
}  


public String getLastName() {  
    return lastName;  
}  

public Department getDepartmentId() {  
    return departmentId;  
}  

//setters
public void setId(int id) {  
    this.id = id;  
} 

public void setFirstName(String firstName) {  
    this.firstName = firstName;  
}


public void setLastName(String lastName) {  
    this.lastName = lastName;  
} 

public void setDepartmentId(Department deptId) {  
    this.departmentId = deptId;  
}


}
