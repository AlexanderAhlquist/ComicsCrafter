package com.ahlquist.comics_crafter.service;

import java.util.List;

import com.ahlquist.comics_crafter.model.Printing;

/*
 * This is the printing service class which allows for CRUD operations at the 
 * service level.
 */
public interface PrintingService {
	List<Printing> getAllPrinting();
	void savePrinting(Printing printing);
	Printing getPrintingById(Long printing_id);
	void deletePrintingById(Long printing_id);
}
