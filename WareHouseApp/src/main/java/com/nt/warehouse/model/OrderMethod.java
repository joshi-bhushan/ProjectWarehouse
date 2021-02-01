package com.nt.warehouse.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="order_method_tab")
@Data
public class OrderMethod {
	@Id
	@GeneratedValue(generator ="order_method_seq")
	@SequenceGenerator(name="order_method_seq",sequenceName = "order_method_seq_test")
	@Column(name="order_id_col")
	 private Integer id;
	@Column(name="order_mode_col")
	 private String orderMode;
	@Column(name="orderd_code_col")
	 private String orderCode;
	@Column(name="order_type_col")
	 private String orderType;
	@ElementCollection
	@CollectionTable(name="order_acpt_tab",joinColumns = @JoinColumn(name="order_id_col"))
	@Column(name="order_acpt_col")
	 private Set<String> orderAcpt;
	@Column(name="order_desc_col")
	 private String orderDesc;

}
