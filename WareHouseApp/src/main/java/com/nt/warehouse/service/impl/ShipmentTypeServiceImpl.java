package com.nt.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public void deleteShipmentType(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public boolean isShipmentExit(Integer id) {

		repo.existsById(id);
		return true;
	}

	@Override
	public Optional<ShipmentType> getOneShipmentType(Integer id) {
		Optional<ShipmentType> opt= repo.findById(id);
		return opt;
	}

	@Override
	public void updateShipmentType(ShipmentType st) {

		repo.save(st);

	}

	@Override
	public List<Object[]> getShipmentTypeModeCount() {
		List<Object[]> list = repo.getShipmentTypeModeCount();
		
		return list;
	}





}
