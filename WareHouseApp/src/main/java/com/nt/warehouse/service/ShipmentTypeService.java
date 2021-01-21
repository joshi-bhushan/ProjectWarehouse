package com.nt.warehouse.service;

import java.util.List;

import com.nt.warehouse.model.ShipmentType;

public interface ShipmentTypeService {
	
	Integer saveShipmentType(ShipmentType ShipmentType);
	List<ShipmentType> getAllShipmentType();

}
