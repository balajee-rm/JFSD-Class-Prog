package hibexample;    

import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
  
    
public class StoreData {    
public static void main(String[] args) {    
        
    //Create typesafe ServiceRegistry object    
    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
          
   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
  
SessionFactory factory = meta.getSessionFactoryBuilder().build();  
Session session = factory.openSession();  
Transaction t = session.beginTransaction();   
    
	//Insert Example
    Employee e1=new Employee();    
    e1.setId(101);    
    e1.setFirstName("Data");    
    e1.setLastName("Store");  
    session.save(e1);
    
	//Update Example
	/*Query q=session.createQuery("update Employee set firstName=:n, lastName=:m where id=:i");  
    q.setParameter("n","Udit");  
    q.setParameter("m", "Kumar");
    q.setParameter("i",103);  
    int status=q.executeUpdate();  
    System.out.println(status);*/

	//Delete Example
	/*Query query=session.createQuery("delete from Employee where id=103");  
	query.executeUpdate();*/

	//Retrieve Data
	/*Query query=session.createQuery("from Employee");  
	query.setFirstResult(1);  
	query.setMaxResults(3);  
	List<Employee> list=query.list(); 
	System.out.println(list.get(0).getId());*/

	//Retrieve Data of ID - Similarly max, min, count, avg
	/*Query q=session.createQuery("select sum(id) from Employee");  
	List<Integer> list=q.list();  
	System.out.println(list.get(0));*/
    
	//Cretieria for condition based retrieval
	/*Criteria c=session.createCriteria(Employee.class);  
	c.add(Restrictions.gt("id",102));//salary is the propertyname  
	List<Employee> list=c.list();  
	System.out.println(list.get(0).getId());*/
	
	//c.addOrder(Order.asc("id"));  
	//c.setProjection(Projections.property("firstName"));  
	//c.setFirstResult(10);  
	//c.setMaxResult(20);  

	/*TypedQuery query = session.getNamedQuery("findEmployeeByName");    
	query.setParameter("name","Balajee");   
        
	List<Employee> employees=query.getResultList();   

	Iterator<Employee> itr=employees.iterator();    
	while(itr.hasNext()){    
		Employee e=itr.next();    
		System.out.println(e.getId());    
	}*/   
	
    t.commit();  
    System.out.println("successfully done");    
    factory.close();  
    session.close();    
        
}    
}   