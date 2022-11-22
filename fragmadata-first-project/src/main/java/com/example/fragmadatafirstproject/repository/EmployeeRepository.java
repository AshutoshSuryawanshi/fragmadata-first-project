package com.example.fragmadatafirstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fragmadatafirstproject.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
