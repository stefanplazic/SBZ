package com.sample.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;
	private Date createProfile;

	@OneToOne(fetch = FetchType.LAZY)
	private ProfileUser profilUser; //

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private UserRola userRola;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Account> account = new HashSet<Account>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<RModel> rModel = new HashSet<RModel>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<OrderArticle> orders = new HashSet<OrderArticle>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Cart> cart = new HashSet<Cart>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateProfile() {
		return createProfile;
	}

	public void setCreateProfile(Date createProfile) {
		this.createProfile = createProfile;
	}

	public ProfileUser getProfilUser() {
		return profilUser;
	}

	public void setProfilUser(ProfileUser profilUser) {
		this.profilUser = profilUser;
	}

	public UserRola getUserRola() {
		return userRola;
	}

	public void setUserRola(UserRola userRola) {
		this.userRola = userRola;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}

	public Set<RModel> getrModel() {
		return rModel;
	}

	public void setrModel(Set<RModel> rModel) {
		this.rModel = rModel;
	}

	public Set<OrderArticle> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderArticle> orders) {
		this.orders = orders;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

}
