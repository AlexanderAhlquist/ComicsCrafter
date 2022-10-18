package com.ahlquist.comics_crafter.service;

import java.util.List;

import com.ahlquist.comics_crafter.model.Printing;

public interface PrintingService {
	List<Printing> getAllPrinting();
	void savePrinting(Printing printing);
	Printing getPrintingById(Long printing_id);
	void deletePrintingById(Long printing_id);
}
