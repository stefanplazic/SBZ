package com.sample.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AccountDiscount {

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getProcentDiscount() {
		return procentDiscount;
	}

	public void setProcentDiscount(double procentDiscount) {
		this.procentDiscount = procentDiscount;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public static int getBasicdiscount() {
		return basicDiscount;
	}

	public static int getExtradiscount() {
		return extraDiscount;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

}
