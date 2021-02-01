package com.nt.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.warehouse.model.OrderMethod;
import com.nt.warehouse.service.OrderMethodService;

@Controller
public class OrderMethodController {

	@Autowired
	private OrderMethodService service;
	
	//1. show Register page
	@GetMapping("/register")
	public String showOrderMethodReg() {
		return "OrderMethodRegister";
	}
	
	//2. save Data
	@PostMapping("/save")
	public String saveOrderMethod(
			@ModelAttribute OrderMethod orderMethod,
			Model model
			) 
	{
		//call service
		Integer id = service.saveOrderMethod(orderMethod);
		model.addAttribute("message", "Order Method '"+id+"' saved");
		return "OrderMethodRegister";
	}
	
	//3. Data display
	@GetMapping("/all")
	public String showAllOrderMethods(Model model)
	{
		List<OrderMethod> list =  service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}
	
	//4. delete operation
	@GetMapping("/delete")
	public String doDeleteOrderMethod(
			@RequestParam("id")Integer omId,
			Model model
			) 
	{
		String message =null;
		if(service.isOrderMethodExist(omId)) {
			service.deleteOrderMethod(omId);
			message = "Order Method '"+omId+"' deleted";
		} else {
			message = "Order Method '"+omId+"' Not exist";
		}
		
		List<OrderMethod> list =  service.getAllOrderMethods();
		model.addAttribute("message", message);
		model.addAttribute("list", list);
		return "OrderMethodData";
	}
	
	
	//5. show edit
	
	
	
		//6. do update

}
