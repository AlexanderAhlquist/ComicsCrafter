package com.ahlquist.comics_crafter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahlquist.comics_crafter.model.Paper;
import com.ahlquist.comics_crafter.model.Project;
import com.ahlquist.comics_crafter.service.PaperService;
import com.ahlquist.comics_crafter.service.ProjectService;
/*
 * This controller deals with the Paper table in the Comics Crafter database. 
 * It allows for front end interaction with the database, with each of the 
 * four CRUD operations represented. 
 */
@Controller
public class PaperController {

	@Autowired
	private PaperService paperService;
	@Autowired
	private ProjectService projectService;
//Read operation for the Paper table.
	@GetMapping("/paper_list")
	public String viewPaperList(Model model) {
		model.addAttribute("paperList", paperService.getAllPapers());
		return "paper_list";
	}
//Create operation for the Paper table.
	@GetMapping("/new_paper")
	public String newPaper(Model model) {
		Paper paper = new Paper();
		model.addAttribute("paper", paper);
		return "new_paper";
	}
//Saves the paper object to the paper table.
	@PostMapping("/save_paper")
	public String savePaper(@ModelAttribute("paper") Paper paper) {
		paperService.savePaper(paper);
		return "redirect:/paper_list";
	}
//Update operation for the Paper table.
	@GetMapping("/paper_update/{id}")
	public String paperUpdate(@PathVariable(value = "id") Long id, Model model) {
		Paper paper = paperService.getPaperById(id);
		List<Project> listProject = projectService.getAllProjects();
		model.addAttribute("listProject", listProject);
		model.addAttribute("paper", paper);
		return "update_paper";
	}
//Delete operation for the Paper table.
	@GetMapping("/paper_delete/{id}")
	public String deletePaper(@PathVariable(value = "id") Long id) {
		this.paperService.deletePaperById(id);
		return "redirect:/paper_list";
	}
}
