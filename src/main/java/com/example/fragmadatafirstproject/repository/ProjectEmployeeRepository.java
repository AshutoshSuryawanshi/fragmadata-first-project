package com.example.fragmadatafirstproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fragmadatafirstproject.model.ProjectEmployee;

public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, Integer> {

	public Optional<ProjectEmployee> findByStartDate(String startDate);

}
