package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Employee;

import com.example.demo.service.HomeService;

@Controller
public class HomeController {
	@Autowired
	HomeService hs;
	
	@RequestMapping("/")
	public String preloginPage()
	{
		return "index";
	}
	
	@RequestMapping("/log")
	public String login(@RequestParam("uname") String unm,@RequestParam("pass") String ps,Model m)
	{
		
		List<Employee> l=hs.log(unm, ps);
		
		if(unm.equals("admin") && ps.equals("admin"))
		{
			List<Employee> list=hs.getlldata();
		 System.out.println("BACK");
		 m.addAttribute("data",list);
	    }
		
		else 
		    if(unm.equals(unm) &&ps.equals(ps))
			{
				//List<Model> list=hs.log(unm, ps);
				System.out.println("USER");
			   m.addAttribute("data",l);
		}
		return "success";
}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("id") int id, Model m1)
	{
		
	  	
	  	Employee emp=hs.edit(id);
	  	
	  	m1.addAttribute("edit", emp);
	  	return "edit";
	}
	
	@RequestMapping("/update")
	public String updatedata(@ModelAttribute("Employee") Employee emp, Model m1)
	{
		hs.savedata(emp);
		List<Employee> list=hs.getlldata();
		m1.addAttribute("data", list);
		return "success";
	}
	
	@RequestMapping("/del")
	public String delete(@ModelAttribute("Employee")Employee emp,Model m1)
	{
		
		
		hs.deletedata(emp);
		
			List<Employee> list=hs.getlldata();
			m1.addAttribute("data", list);
			return "success";
	   }

}
