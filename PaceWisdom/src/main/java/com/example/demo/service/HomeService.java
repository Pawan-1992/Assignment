package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;



@Service

public interface HomeService {
	public void savedata(Employee emp);
	public List<Employee> log(String uname,String pass);
	public List<Employee> getlldata();
	public void deletedata(Employee emp);
	public Employee edit(int id);

}
