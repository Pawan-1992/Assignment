package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Employee;
import com.example.demo.repository.Repository;
import com.example.demo.service.HomeService;

public class HomeServiceImpl implements HomeService {

	@Autowired
	Repository re;
	
	@Override
	public void savedata(Employee emp) {
		re.save(emp);
		
	}

	@Override
	public List<Employee> log(String uname, String pass) {
		
		return re.finduser(uname, pass);
	}

	@Override
	public List<Employee> getlldata() {
		
		return (List<Employee>) re.findAll();
	}

	@Override
	public void deletedata(Employee emp) {
		re.delete(emp);
		
	}

	@Override
	public Employee edit(int id) {
		
		return re.findby(id).get(id);
	}

}
