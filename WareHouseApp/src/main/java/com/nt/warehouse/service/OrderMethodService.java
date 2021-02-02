package com.nt.warehouse.service;

import java.util.List;
import java.util.Optional;

import com.nt.warehouse.model.OrderMethod;

public interface OrderMethodService {

	Integer saveOrderMethod(OrderMethod om);
	List<OrderMethod> getAllOrderMethods();
	void deleteOrderMethod(Integer id);
	boolean isOrderMethodExist(Integer id);
	Optional<OrderMethod> getOneOrderMethod(Integer id);
	void updateOrderMethod(OrderMethod om); 
	boolean isOrderMethodExistByCode(String orderCode);
}
