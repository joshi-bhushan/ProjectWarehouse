package com.nt.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.warehouse.model.OrderMethod;

public interface OrderMethodRepository  extends JpaRepository<OrderMethod, Integer>{

}
