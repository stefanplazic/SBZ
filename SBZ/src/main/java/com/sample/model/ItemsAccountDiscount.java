package com.sample.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemsAccountDiscount {

	@Id
	@GeneratedValue
	private Long id;
	private double procentDiscount;
	private String hashCode;

	public static final int basicDiscount = 1;// type of basic discount
	public static final int extraDiscount = 2; // extra discount

	private int discountType = basicDiscount;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Account account;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private ItemsAccount itemsAccount;
	
}
