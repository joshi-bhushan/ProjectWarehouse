package com.nt.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.warehouse.model.Uom;
import com.nt.warehouse.repo.UomRepo;
import com.nt.warehouse.service.UomService;

@Service
public class UomServiceImpl implements UomService {

	@Autowired
	private UomRepo repo;
	@Override
	public Integer saveUom(Uom uom) {
		
		 Uom uom1 = repo.save(uom);
		Integer id= uom1.getId();
		return id;
	}
	
	@Override
	public List<Uom> getAllUom() {
		List<Uom> listAll = repo.findAll();
		
		return listAll;
	}
	@Override
	public void deleteUom(Integer id) {
	
		repo.deleteById(id);
		
	}
	@Override
	public boolean isUomExit(Integer id) {
		repo.existsById(id);
		return true;
	}
	@Override
	public Optional<Uom> getOneUom(Integer id) {

Optional<Uom> opt = repo.findById(id);
		return opt;
	}
	@Override
	public void updateUom(Uom uom) {
		repo.save(uom);
		
	}
	 

}
