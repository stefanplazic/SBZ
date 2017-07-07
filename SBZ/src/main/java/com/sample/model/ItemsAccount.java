package com.sample.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Stavka racuna sadrzi id racuna i id artikla standardno ali sadrzi i
 * originalnu cenu artikla kao i popust koji je odobren za dati artikli u
 * procentima izrazen i novu cenu smanjenu za dati procenat kao i kolicinu koja
 * se kupuje datog artikla
 * 
 * @author X
 *
 */

@Entity
public class ItemsAccount {

	@Id
	@GeneratedValue
	private Long id;
	private int serialNum;
	private double pricePerArticle;
	private Double originalPrice;
	private int count;
	private int discountPrecentage;
	private Double newPrice;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Article article;

	// Lista
	@OneToMany(mappedBy = "itemsAccount", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<ListItemsAccount> listItemsAccount = new HashSet<ListItemsAccount>();

	@OneToMany(mappedBy = "itemsAccount", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<ItemsAccountDiscount> itemsAccountDiscount = new HashSet<ItemsAccountDiscount>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getDiscountPrecentage() {
		return discountPrecentage;
	}

	public void setDiscountPrecentage(int discountPrecentage) {
		this.discountPrecentage = discountPrecentage;
	}

	public Double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Set<ListItemsAccount> getListItemsAccount() {
		return listItemsAccount;
	}

	public void setListItemsAccount(Set<ListItemsAccount> listItemsAccount) {
		this.listItemsAccount = listItemsAccount;
	}

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	public double getPricePerArticle() {
		return pricePerArticle;
	}

	public void setPricePerArticle(double pricePerArticle) {
		this.pricePerArticle = pricePerArticle;
	}

	public Set<ItemsAccountDiscount> getItemsAccountDiscount() {
		return itemsAccountDiscount;
	}

	public void setItemsAccountDiscount(Set<ItemsAccountDiscount> itemsAccountDiscount) {
		this.itemsAccountDiscount = itemsAccountDiscount;
	}

}
