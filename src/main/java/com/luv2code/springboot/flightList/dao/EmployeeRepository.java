package com.luv2code.springboot.flightList.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.flightList.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
