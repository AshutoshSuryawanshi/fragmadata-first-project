package com.example.fragmadatafirstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.fragmadatafirstproject.model.Project;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {


}
