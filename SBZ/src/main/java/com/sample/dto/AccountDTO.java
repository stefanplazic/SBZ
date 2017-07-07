package com.sample.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.sample.model.Account;

public class AccountDTO {

	private Long id;
	private Date dateCreateAccount;
	private Double originalPrice;
	private Double newPrice;
	private int setPoint;
	private int getPoint;
	private UserDTO userDTO;
	private Set<ItemsAccountDTO> itemsAccountDTO = new HashSet<>();

	public AccountDTO() {
	}

	public AccountDTO(Long id, Date dateCreateAccount, Double originalPrice, Double newPrice, int setPoint,
			int getPoint, UserDTO userDTO, Set<ItemsAccountDTO> itemsAccountDTO) {
		super();
		this.id = id;
		this.dateCreateAccount = dateCreateAccount;
		this.originalPrice = originalPrice;
		this.newPrice = newPrice;
		this.setPoint = setPoint;
		this.getPoint = getPoint;
		this.userDTO = userDTO;
		this.itemsAccountDTO = itemsAccountDTO;
	}

	public AccountDTO(Account account) {
		super();
		this.id = account.getId();
		this.dateCreateAccount = account.getCreationDate();
		this.originalPrice = account.getOriginalPrice();
		this.newPrice = account.getNewPrice();
		this.setPoint = account.getUsedPoints();
		this.getPoint = account.getEarnedPoints();
		if(account.getUser() != null)
			this.userDTO = new UserDTO(account.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreateAccount() {
		return dateCreateAccount;
	}

	public void setDateCreateAccount(Date dateCreateAccount) {
		this.dateCreateAccount = dateCreateAccount;
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

	public int getSetPoint() {
		return setPoint;
	}

	public void setSetPoint(int setPoint) {
		this.setPoint = setPoint;
	}

	public int getGetPoint() {
		return getPoint;
	}

	public void setGetPoint(int getPoint) {
		this.getPoint = getPoint;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public Set<ItemsAccountDTO> getItemsAccountDTO() {
		return itemsAccountDTO;
	}

	public void setItemsAccountDTO(Set<ItemsAccountDTO> itemsAccountDTO) {
		this.itemsAccountDTO = itemsAccountDTO;
	}

}
