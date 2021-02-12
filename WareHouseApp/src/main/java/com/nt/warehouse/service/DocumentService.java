package com.nt.warehouse.service;

import java.util.List;
import java.util.Optional;

import com.nt.warehouse.model.Document;

public interface DocumentService {
	
	public void saveDocument(Document doc);
	public List<Object[]> getDocIdAndName();
	public Optional<Document> getDocumentById(Integer id);

}
