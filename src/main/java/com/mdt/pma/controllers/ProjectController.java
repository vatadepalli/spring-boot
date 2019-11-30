package com.mdt.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mdt.pma.entities.Project;
import com.mdt.pma.services.EmployeeService;
import com.mdt.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayProjects(Model model) {
				
		model.addAttribute("projects", proService.getAll());
		
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		model.addAttribute("project", new Project());
		model.addAttribute("allEmployees", empService.getAll());
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		// handle saving to database
		proService.save(project);

		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";
	}
}
