package com.ahlquist.comics_crafter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahlquist.comics_crafter.model.Printing;
import com.ahlquist.comics_crafter.service.PrintingService;
/*
 * This controller deals with the Printing table in the Comics Crafter database. 
 * It allows for front end interaction with the database, with each of the 
 * four CRUD operations represented. 
 */
@Controller
public class PrintingController {
	
	@Autowired
	private PrintingService printingService;
//Read operation for the Printing table.
	@GetMapping("/printing_list")
	public String viewPrintingList(Model model) {
		model.addAttribute("printingList", printingService.getAllPrinting());
		return "printing_list";
	}
//Create operation for the Printing table.
	@GetMapping("/new_printing")
	public String createPrinting(Model model) {
		Printing printing = new Printing();
		model.addAttribute("printing", printing);
		return "new_printing";
	}
//Saves the printing object to the database.
	@PostMapping("/save_printing")
	public String savePrinting(@ModelAttribute("printing")Printing printing) {
		printingService.savePrinting(printing);
		return "redirect:/printing_list";
	}
//Update operation for the Printing table.
	@GetMapping("/printing_update/{id}")
	public String printingUpdate(@PathVariable(value="id") Integer printing_id, Model model) {
		Printing printing = printingService.getPrintingById(printing_id);
		model.addAttribute("printing", printing);
		return "update_printing";
	}
//Delete operation for the Printing table.	
	@GetMapping("/printing_delete/{id}")
	public String deletePrinting(@PathVariable(value="id") Integer printing_id) {
		this.printingService.deletePrintingById(printing_id);
		return "redirect:/printing_list";
	}
}
