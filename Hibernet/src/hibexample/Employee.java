package hibexample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/* 
@NamedQueries(  
	{  
		@NamedQuery(  
	        name = "findEmployeeByName",  
	        query = "from Employee e where e.firstName = :name"  
	    )  
	}  
)
*/  

//@Entity  
//@Table(name="emp1")  
public class Employee {  
private int id;  
private String firstName,lastName;  

//@Id  
//@GeneratedValue(strategy=GenerationType.AUTO)  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
public String getFirstName() {  
    return firstName;  
}  
public void setFirstName(String firstName) {  
    this.firstName = firstName;  
}  
public String getLastName() {  
    return lastName;  
}  
public void setLastName(String lastName) {  
    this.lastName = lastName;  
}  
  
  
}  
