package com.mdt.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdt.pma.dto.ChartData;
import com.mdt.pma.services.EmployeeService;
import com.mdt.pma.services.ProjectService;

@Controller
public class HomeController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@Value("${version}")
	private String ver;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		
		model.addAttribute("projects", proService.getAll());
		
		List<ChartData> projectData =  proService.getProjectStatus();
		// convert project data obj to json structure
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectStatusCnt",jsonString);
		System.out.println(jsonString);
		
		model.addAttribute("employeesProjectCount", empService.employeeProjects());
		model.addAttribute("versionNumber", ver);
		return "main/home";
	}
	 
}
