package com.sample.model;

import java.util.Date;
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
 * Ceo racun koji ne mora biti kupljne ima tri stanja poruceno, otkazano uspesno
 * realizovana u porucenom stanju on dodaje u korpu otkazano on je odustao o
 * kupovine a realizovano znaci da je potvrdio kupovinu i racun se kopira u novu
 * tabelu koja ce cuvati sve kupovine za odredjenog korisnika treba to
 * realizovati kasnije
 * 
 * @author X
 *
 */

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	private Date creationDate;
	private Double originalPrice;
	private Double newPrice;
	private int usedPoints;
	private int earnedPoints;
	private double procentDiscount;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private User user;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<ListItemsAccount> listItemsAccount = new HashSet<ListItemsAccount>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date dateCreateAccount) {
		this.creationDate = dateCreateAccount;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}

	public int getUsedPoints() {
		return usedPoints;
	}

	public void setUsedPoints(int setPoint) {
		this.usedPoints = setPoint;
	}

	public int getEarnedPoints() {
		return earnedPoints;
	}

	public void setEarnedPoints(int getPoint) {
		this.earnedPoints = getPoint;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ListItemsAccount> getListItemsAccount() {
		return listItemsAccount;
	}

	public void setListItemsAccount(Set<ListItemsAccount> listItemsAccount) {
		this.listItemsAccount = listItemsAccount;
	}

	public double getProcentDiscount() {
		return procentDiscount;
	}

	public void setProcentDiscount(double procentDiscount) {
		this.procentDiscount = procentDiscount;
	}

}
