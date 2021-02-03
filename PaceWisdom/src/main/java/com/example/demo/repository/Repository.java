package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Employee;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Employee, Integer> {
	
	 @Query("from Employee where uname=?1 and pass=?2 ")
		List<Employee> finduser(String uname,String pass);
	    
	    @Query("from Employee where id=?1 ")
	    List<Employee> findby(int id);

}
