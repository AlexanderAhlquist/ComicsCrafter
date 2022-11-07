package com.ahlquist.comics_crafter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahlquist.comics_crafter.model.Printing;
import com.ahlquist.comics_crafter.repository.PrintingRepository;

/*
 * this is the implementation of Printing Service. It allows the controller to 
 * use all of the CRUD operations, and describes the methods laid out in the printing service 
 * interface.
 */
@Service
public class PrintingServiceImpl implements PrintingService{
	@Autowired
	private PrintingRepository printingRepository;
	
	@Override
	public List<Printing> getAllPrinting() {
		return printingRepository.findAll();
	}
	@Override
	public void savePrinting(Printing printing) {
		this.printingRepository.save(printing);
	}
	@Override
	public Printing getPrintingById(Long printing_id) {
		Optional<Printing> optional = printingRepository.findById(printing_id);
		Printing printing = null;
		if(optional.isPresent()) {
			printing = optional.get();
		} else {
			throw new RuntimeException("Printing method not found.");
		}
		return printing;
	}
	@Override
	public void deletePrintingById(Long printing_id) {
		this.printingRepository.deleteById(printing_id);
		
	}
	

}
