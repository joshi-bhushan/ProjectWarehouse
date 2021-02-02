package com.nt.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Uom_tab")
@Data
public class Uom {
	
	@Id
	@GeneratedValue(generator ="uom_seq")
	@SequenceGenerator(name="uom_seq",sequenceName = "uom_seq_test")
	@Column(name="uom_id")
	private Integer id;
	@Column(name="uom_model")
	private  String uomModel;
	@Column(name="uom_type")
	private String uomType;
	@Column(name="uom_desc")
	private String uomDesc;
	

}
