package com.nt.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.warehouse.model.Document;
import com.nt.warehouse.repo.DocumentRepository;
import com.nt.warehouse.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository repo;
	@Override
	public void saveDocument(Document doc) {

		repo.save(doc);

	}

	@Override
	public List<Object[]> getDocIdAndName() {



		return repo.getDocIdAndName();
	}

	@Override
	public Optional<Document> getDocumentById(Integer id) {

		return repo.findById(id);
	}

}
