package com.example.fragmadatafirstproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fragmadatafirstproject.model.Project;
import com.example.fragmadatafirstproject.model.ProjectEmployee;

public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, Integer> {

//	@Query(value = "SELECT project_employee.id, project_employee.employee_id_employee_id, "
//			+ "Employee.created_date, Employee.created_by, project_employee.project_id_project_id,"
//			+ " Project.end_date, Project.start_date, Project.status " + "FROM ((project_employee "
//			+ "INNER JOIN Employee ON project_employee.employee_id_employee_id = Employee.employee_id) "
//			+ "INNER JOIN Project ON project_employee.project_id_project_id = Project.project_id) "
//			+ "where Project.start_date = ?1", nativeQuery = true)
//	public List<ProjectEmployee> innerJoinedProjEmp2(String Date);
//
//	@Query(value = "SELECT project_employee.id, project_employee.employee_id_id, "
//			+ "Employee.created_date, Employee.created_by, project_employee.project_id_project_id,"
//			+ " Project.end_date, Project.start_date, Project.status " + "FROM ((project_employee "
//			+ "INNER JOIN Employee ON project_employee.employee_id_id = Employee.id) "
//			+ "INNER JOIN Project ON project_employee.project_id_project_id = Project.project_id) ", nativeQuery = true)
//	public List<ProjectEmployee> innerJoinedProjEmp();

	public Optional<ProjectEmployee> findByStartDate(String startDate);

//	public Optional<ProjectEmployee> findById(Project projectId);

	public Optional<ProjectEmployee> findByProjectId(Project projectId);
}
