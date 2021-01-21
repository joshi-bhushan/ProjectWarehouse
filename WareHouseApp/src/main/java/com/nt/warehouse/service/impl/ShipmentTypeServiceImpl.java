package com.nt.warehouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.warehouse.model.ShipmentType;
import com.nt.warehouse.repo.ShipmentTypeRepo;
import com.nt.warehouse.service.ShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements ShipmentTypeService {
	
	@Autowired
	private ShipmentTypeRepo repo;

	@Override
	public Integer saveShipmentType(ShipmentType ShipmentType) {
		
		ShipmentType =repo.save(ShipmentType);
		Integer id = ShipmentType.getId();
		return id;
	}

	@Override
	public List<ShipmentType> getAllShipmentType() {

		List<ShipmentType> listAll = repo.findAll();
		
		return listAll;
	}
	
	

}
