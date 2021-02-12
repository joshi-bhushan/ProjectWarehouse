package com.nt.warehouse.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nt.warehouse.model.ShipmentType;
import com.nt.warehouse.service.ShipmentTypeService;
import com.nt.warehouse.util.ShipmentTypeUtil;
import com.nt.warehouse.view.ShipmentTypeExcelView;
import com.nt.warehouse.view.ShipmentTypeOneExcelView;
import com.nt.warehouse.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/st")
public class ShipmentTypeController {


	@Autowired
	private ShipmentTypeService service;
	
	@Autowired
	private ShipmentTypeUtil util;
	
	@Autowired
	private ServletContext sc;

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


	//delete student byId

	@GetMapping("/delete")
	public String deleteShipmentType(@RequestParam("id") Integer sid, Model model)
	{
		if(service.isShipmentExit(sid))
		{
			service.deleteShipmentType(sid);

			// create messege
			String message = new StringBuffer()
					.append("Shipment Type '")
					.append(sid)
					.append("' Deleted!")
					.toString();

			//send to UI
			model.addAttribute("message", message);
		} else {
			model.addAttribute("message", sid+ " not found!!");
		}
		//latest data
		model.addAttribute("list",
				service.getAllShipmentType());
		return "ShipmentTypeData";
	}


	//  show shipmentType Edit
	@GetMapping("/edit")
	public String showShipmentTypeEdit(@RequestParam("id") Integer sid, Model model)
	{
		String page= null;
		Optional<ShipmentType> opt=  service.getOneShipmentType(sid);
		if(opt.isPresent())
		{
			model.addAttribute("shipmentType", opt.get());
			page= "ShipmentTypeEdit";
		}
		else
		{
			page="redirect:all";

		}
		return page;
	}
	
	// update shipment type
	@PostMapping("/update")
	public String doUpdateShipmentType(@ModelAttribute ShipmentType shipmentType ,Model model)
	{ 
		//call service update method
		
		 	service.updateShipmentType(shipmentType);
		 	
		 	//return "redirect:all";
			
			//send message to UI
			model.addAttribute("message", "Shipment Type '"+shipmentType.getId()+"' Updated!!");

			// call service layer for latest data
			List<ShipmentType> list = service.getAllShipmentType();

			//send data to UI for HTML table
			model.addAttribute("list", list);

			//Go back to UI page
			return "ShipmentTypeData";
			
	}
	
	
	// EXCEL EXPORT
	
	@GetMapping("/excel")
	public ModelAndView showExcelExport()
	{
		//fetch all rows from DB
		
		List<ShipmentType> list = service.getAllShipmentType();
		
		// create ModelAndView
		ModelAndView m = new ModelAndView();
		m.addObject("list",list);
		m.setView(new ShipmentTypeExcelView());
		return m;
	}
	
	@GetMapping("/excelone")
	public ModelAndView showExcelOneExport(@RequestParam("id")Integer sid)
	{
		// fetch all rows from DB
		
		Optional<ShipmentType> opt = service.getOneShipmentType(sid);
		
		//create modelAndView
		ModelAndView m = new ModelAndView();
		m.addObject("st",opt.get());
		
		m.setView(new ShipmentTypeOneExcelView());
		return m;
	}
	
	
	
	// PDf EXPORT
	@GetMapping("/pdf")
	public ModelAndView exportToPdf()
	{
		// fetch all rows from DB
		List<ShipmentType> list =service.getAllShipmentType();
		
		// create ModelAndView
		
		ModelAndView m = new ModelAndView();
		m.addObject("list",list);
		m.setView(new ShipmentTypePdfView());
		return m;
	}
	
	
	
	// charts
	
	@GetMapping("/charts")
	public String showCharts() {
		
		// call service for data
		List<Object[]> list = service.getShipmentTypeModeCount();
		
	
		// dynamic path inside server(runtime location)
				String path = sc.getRealPath("/"); //root location
				System.out.println("Runtime location=>" + path);
				
				// call util method for generation
				util.generatePieChart(path, list);
				util.generateBarChart(path, list);
				return "ShipmentTypeCharts.html";

	}

}

