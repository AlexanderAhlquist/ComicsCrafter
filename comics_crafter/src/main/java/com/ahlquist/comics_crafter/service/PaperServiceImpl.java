package com.ahlquist.comics_crafter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahlquist.comics_crafter.model.Paper;
import com.ahlquist.comics_crafter.repository.PaperRepository;

/*
 * this is the implementation of PaperService.
 */
@Service
public class PaperServiceImpl implements PaperService {

	@Autowired
	private PaperRepository paperRepository;

	@Override
	public List<Paper> getAllPapers() {
		return paperRepository.findAll();
	}

	@Override
	public void savePaper(Paper paper) {
		this.paperRepository.save(paper);
	}

	@Override
	public Paper getPaperById(Integer paper_id) {
		Optional<Paper> optional = paperRepository.findById(paper_id);
		Paper paper = null;
		if (optional.isPresent()) {
			paper = optional.get();
		} else {
			throw new RuntimeException("Paper not found");
		}
		return paper;
	}

	@Override
	public void deletePaperById(Integer paper_id) {
		this.paperRepository.deleteById(paper_id);
	}
}
