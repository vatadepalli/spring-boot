package com.mdt.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdt.pma.dto.ChartData;
import com.mdt.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "select stage label, count(*) value " + 
			"from project " + 
			"group by stage")
	public List<ChartData> getProjectStatus();
}
