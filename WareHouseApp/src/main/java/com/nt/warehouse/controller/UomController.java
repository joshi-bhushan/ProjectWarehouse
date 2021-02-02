package com.nt.warehouse.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.nt.warehouse.model.Uom;
import com.nt.warehouse.service.UomService;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	
	private UomService service;
	// show register
	@GetMapping("/register")
	public String showReg()
	{
		return "UomRegister";
	}
	
	
	@PostMapping("/save")
	public String saveUom(@ModelAttribute Uom uom,Model model)
	{
		Integer id = service.saveUom(uom);
		
		// create message
		
		String message ="Uom" +id+"Saved";
		
		// send message to Ui
		model.addAttribute("message", message);
		
		return "UomRegister";
		


		
		
	}
	
	// find All Data

		@GetMapping("/all")
		public String findAll(Model model) {

			//call service
			List<Uom> list = service.getAllUom();

			//send Data to UI
			model.addAttribute("list", list);

			// Go back to UI page
			return "UomData";
		}


		//delete student byId

		@GetMapping("/delete")
		public String deleteUom(@RequestParam("id") Integer sid, Model model)
		{
			if(service.isUomExit(sid))
			{
				service.deleteUom(sid);

				// create messege
				String message = new StringBuffer()
						.append("Uom '")
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
					service.getAllUom());
			return "UomData";
		}


		//  show shipmentType Edit
		@GetMapping("/edit")
		public String showUomEdit(@RequestParam("id") Integer sid, Model model)
		{
			String page= null;
			Optional<Uom> opt=  service.getOneUom(sid);
			if(opt.isPresent())
			{
				model.addAttribute("uom", opt.get());
				page= "UomEdit";
			}
			else
			{
				page="redirect:all";

			}
			return page;
		}
		
		// update shipment type
		@PostMapping("/update")
		public String doUpdateUom(@ModelAttribute Uom uom ,Model model)
		{
			//call service update method
			
			 	service.updateUom(uom);
			 	
			 	//return "redirect:all";
				
				//send message to UI
				model.addAttribute("message", "Uom '"+uom.getId()+"' Updated!!");

				// call service layer for latest data
				List<Uom> list = service.getAllUom();

				//send data to UI for HTML table
				model.addAttribute("list", list);

				//Go back to UI page
				return "UomData";
				
		}

	
}
 