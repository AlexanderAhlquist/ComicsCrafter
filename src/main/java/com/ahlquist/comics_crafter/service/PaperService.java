package com.ahlquist.comics_crafter.service;

import java.util.List;

import com.ahlquist.comics_crafter.model.Paper;
/*
 * This is the paper service class which allows for CRUD operations at the 
 * service level.
 */
public interface PaperService {
	List<Paper> getAllPapers();
	void savePaper(Paper paper);
	Paper getPaperById(Long paper_id);
	void deletePaperById(Long paper_id);
}
