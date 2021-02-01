package com.nt.warehouse.service;

import java.util.List;
import java.util.Optional;


import com.nt.warehouse.model.Uom;

public interface UomService {
	
	Integer saveUom(Uom uom);
	List<Uom> getAllUom();
	void deleteUom(Integer id);
	boolean isUomExit(Integer id);
	Optional<Uom> getOneUom(Integer id);
	void updateUom(Uom uom);


}
