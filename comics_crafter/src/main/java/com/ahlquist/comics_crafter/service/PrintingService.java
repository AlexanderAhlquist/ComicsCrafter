package com.ahlquist.comics_crafter.service;

import java.util.List;

import com.ahlquist.comics_crafter.model.Printing;

public interface PrintingService {
	List<Printing> getAllPrinting();
	void savePrinting(Printing printing);
	Printing getPrintingById(Integer printing_id);
	void deletePrintingById(Integer printing_id);
}
