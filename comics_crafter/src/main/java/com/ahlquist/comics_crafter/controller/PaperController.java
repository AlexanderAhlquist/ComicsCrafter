package com.ahlquist.comics_crafter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahlquist.comics_crafter.model.Paper;
import com.ahlquist.comics_crafter.service.PaperService;

@Controller
public class PaperController {

	@Autowired
	private PaperService paperService;

	@GetMapping("/paper_list")
	public String viewPaperList(Model model) {
		model.addAttribute("paperList", paperService.getAllPapers());
		return "paper_list";
	}

	@GetMapping("/new_paper")
	public String newPaper(Model model) {
		Paper paper = new Paper();
		model.addAttribute("paper", paper);
		return "new_paper";
	}

	@PostMapping("/save_paper")
	public String savePaper(@ModelAttribute("paper") Paper paper) {
		paperService.savePaper(paper);
		return "redirect:/paper_list";
	}

	@GetMapping("/paper_update/{id}")
	public String paperUpdate(@PathVariable(value = "id") Integer id, Model model) {
		Paper paper = paperService.getPaperById(id);
		model.addAttribute("paper", paper);
		return "update_paper";
	}

	@GetMapping("/paper_delete/{id}")
	public String deletePaper(@PathVariable(value = "id") Integer id) {
		this.paperService.deletePaperById(id);
		return "redirect:/paper_list";
	}
}
