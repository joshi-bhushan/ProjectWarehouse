package com.nt.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.warehouse.model.ShipmentType;
import com.nt.warehouse.service.ShipmentTypeService;

@Controller
@RequestMapping("/st")
public class ShipmentTypeController {
	
	
	  @Autowired
	  private ShipmentTypeService service;
	 
	  // show register page
	@GetMapping("/register")
	public String showReg()
	
	
	{
		return "ShipmentTypeRegister";
	}
	
	
	
	// on submit button clickForm
	@PostMapping("/save")
	public String saveShipmentType( 
			// Reading form Data
			@ModelAttribute ShipmentType shipmentType, Model model) {
		
		// call service method
		 Integer id = service.saveShipmentType(shipmentType);
		 
		 // create message
		  String message= "Shipment Type "+id+" saved";
		  
		  // send message to UI
		  model.addAttribute("message", message);
		
		  // go back to same  page
		return "ShipmentTypeRegister";
	}
	
	// find All Data
	
	@GetMapping("/all")
	public String findAll(Model model) {
		
		//call service
		List<ShipmentType> list = service.getAllShipmentType();
		
		//send Data to UI
		model.addAttribute("list", list);
		
		// Go back to UI page
		return "ShipmentTypeData";
	}
	

}
