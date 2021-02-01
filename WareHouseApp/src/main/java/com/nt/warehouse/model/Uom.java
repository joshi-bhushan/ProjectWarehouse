package com.nt.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Uom_tab")
@Data
public class Uom {
	
	@Id
	@Column(name="uom_id")
	@GeneratedValue
	private Integer id;
	@Column(name="uom_model")
	private  String uomModel;
	@Column(name="uom_type")
	private String uomType;
	@Column(name="uom_desc")
	private String uomDesc;
	

}
