package com.ahlquist.comics_crafter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahlquist.comics_crafter.model.Paper;
//This is the Paper repository.
@Repository
public interface PaperRepository extends JpaRepository<Paper, Long>{

}
