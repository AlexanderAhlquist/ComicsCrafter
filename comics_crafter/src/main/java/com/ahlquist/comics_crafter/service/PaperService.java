package com.ahlquist.comics_crafter.service;

import java.util.List;

import com.ahlquist.comics_crafter.model.Paper;

public interface PaperService {
	List<Paper> getAllPapers();
	void savePaper(Paper paper);
	Paper getPaperById(Integer paper_id);
	void deletePaperById(Integer paper_id);
}
