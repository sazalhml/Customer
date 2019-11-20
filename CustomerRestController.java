package com.web.MyRestWebservice;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerRestController {
	dsdsd
	
ArrayList<Employee> list = new ArrayList<Employee>();
	

DataBaseUtility db = new DataBaseUtility();

	
	@GetMapping("/customer")
	public Customer getCustomer(@PathParam("acctNum") int acctNum)
	{
		
		
		db.connect();
		
		Customer c = db.selectCustomer("select * from customer where acctNum='"+acctNum+"'");
		
		
		
		db.closeConnection();
		return  c;
		
		
	}
	@GetMapping("/customers")
	public ArrayList<Customer> getManyCustomers()
	{
		
			db.connect();	
			ArrayList<Customer> list= db.selectCustomers("select * from customer");
			db.closeConnection();
		return list;
		

		
	}
	
	   @PostMapping("/customer")
	   public String saveEmployee(@RequestBody Employee e)
	   {
		   list.add(e);
		   
		   return "Posted employee saved to Db successfully "+e.name;
	   }
			
	   
	   @PutMapping("/customer")
	   public String updateEmployee( @RequestBody Employee e)
	   {
		   Employee foundEmployeeObject = list.stream().filter(emp->emp.id==e.id).findFirst().orElse(null);
		   
		   int index=list.indexOf(foundEmployeeObject);
		   
		   list.set(index, e);
		   
		   return "Employee Data Updated to Db successfully "+e.name;
	   }
	
	   
	   @DeleteMapping("/customer")
	   public String deleteEmployee(@PathParam("id") int id)
	   {
		   	Employee foundEmployeeObject = list.stream().filter(emp->emp.id==id).findFirst().orElse(null);
		   
		   int index=list.indexOf(foundEmployeeObject);
		   
		   list.remove(index);
		   
		   return "Employee Delete ";
	   }
	
	
	
	
	
	

}
