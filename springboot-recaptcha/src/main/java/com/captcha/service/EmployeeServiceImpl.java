package com.captcha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.captcha.model.Employee;
import com.captcha.repo.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repo;
	@Override
	public void save(Employee employee) {
	repo.save(employee);

	}

}
