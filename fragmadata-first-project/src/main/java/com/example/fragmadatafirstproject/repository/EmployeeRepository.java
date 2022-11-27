package com.example.fragmadatafirstproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fragmadatafirstproject.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findByStatus(String status);

//	@Query("Select * from A a  left join B b on a.id=b.id")
//	public List<Employee> FindAllWithDescriptionQuery();
}
