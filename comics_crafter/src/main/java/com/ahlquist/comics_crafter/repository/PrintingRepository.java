package com.ahlquist.comics_crafter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahlquist.comics_crafter.model.Printing;

@Repository
public interface PrintingRepository extends JpaRepository<Printing, Integer>{

}
