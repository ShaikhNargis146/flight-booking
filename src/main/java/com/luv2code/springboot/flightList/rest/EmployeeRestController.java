package com.luv2code.springboot.flightList.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.flightList.entity.Employee;
import com.luv2code.springboot.flightList.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService){
		this.employeeService=employeeService;
	}
	
	@GetMapping("/employee")
	public List<Employee> firdAll(){
		System.out.println("EmployeeRestController ---->employee");
		List<Employee> employeeList=employeeService.findAll();
		System.out.println(employeeList);
		return employeeList;
	}
	 
	
	@GetMapping("/employee/{employeeId}")
	public Employee  getById(@PathVariable int employeeId) { 
		
		 Employee theEmployee=employeeService.findById(employeeId);
		
		if(theEmployee==null) {
			throw new RuntimeException("Emp is not found "+employeeId);
		}
		return theEmployee;
		
	}
	
	
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		System.out.println("employeeId"+employeeId);
		employeeService.deleteById(employeeId);
		
		return null;
	}	
}
