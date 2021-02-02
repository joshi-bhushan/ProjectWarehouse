package com.nt.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.warehouse.model.OrderMethod;

public interface OrderMethodRepository  extends JpaRepository<OrderMethod, Integer>{

	@Query("SELECT COUNT(om.orderCode) FROM OrderMethod om where om.orderCode=:orderCode")
	public Integer getOrderMethodCountByCode(String orderCode);
	
	
}
