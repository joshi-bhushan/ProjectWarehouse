package com.nt.warehouse.service;

import java.util.List;
import java.util.Optional;

import com.nt.warehouse.model.ShipmentType;

public interface ShipmentTypeService {
	
	Integer saveShipmentType(ShipmentType ShipmentType);
	List<ShipmentType> getAllShipmentType();
	void deleteShipmentType(Integer id);
	boolean isShipmentExit(Integer id);
	Optional<ShipmentType> getOneShipmentType(Integer id);
	void updateShipmentType(ShipmentType st);


}
