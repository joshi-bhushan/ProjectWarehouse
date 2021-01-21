package com.nt.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.warehouse.model.ShipmentType;

public interface ShipmentTypeRepo extends JpaRepository<ShipmentType, Integer> {

}
