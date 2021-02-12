package com.nt.warehouse.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.warehouse.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
	
	@Query("SELECT docId,docName FROM Document")
	List<Object[]> getDocIdAndName();

}
