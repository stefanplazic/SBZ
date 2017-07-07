package com.sample.dto;

import com.sample.model.Account;
import com.sample.model.ListItemsAccount;

public class ListItemsAccountDTO {

	private Long id;
	private ItemsAccountDTO itemsAccountDTO;
	private Account account;

	public ListItemsAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListItemsAccountDTO(Long id, ItemsAccountDTO itemsAccountDTO, Account account) {
		super();
		this.id = id;
		this.itemsAccountDTO = itemsAccountDTO;
		this.account = account;
	}

	public ListItemsAccountDTO(ListItemsAccount itemsAccount) {
		this.id = itemsAccount.getId();
		if (itemsAccount.getItemsAccount() != null)
			this.itemsAccountDTO = new ItemsAccountDTO(itemsAccount.getItemsAccount());
		this.account = itemsAccount.getAccount();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemsAccountDTO getItemsAccountDTO() {
		return itemsAccountDTO;
	}

	public void setItemsAccountDTO(ItemsAccountDTO itemsAccountDTO) {
		this.itemsAccountDTO = itemsAccountDTO;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
