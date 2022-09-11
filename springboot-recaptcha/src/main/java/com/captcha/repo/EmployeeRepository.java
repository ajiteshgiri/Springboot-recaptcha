package com.captcha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.captcha.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
