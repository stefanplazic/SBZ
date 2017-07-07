package com.sample.dto;

import java.util.HashSet;
import java.util.Set;

import com.sample.model.ItemsAccount;
import com.sample.model.ListItemsAccount;

public class ItemsAccountDTO {

	private Long id;
	private Double originalPrice;
	private int count;
	private int discountPrecentage;
	private Double newPrice;
	private ArticleDTO articleDTO;
	private Set<ListItemsAccount> listItemsAccount = new HashSet<ListItemsAccount>();

	public ItemsAccountDTO() {
	}

	public ItemsAccountDTO(Long id, Double originalPrice, int count, int discountPrecentage, Double newPrice,
			ArticleDTO articleDTO, Set<ListItemsAccount> listItemsAccount) {
		super();
		this.id = id;
		this.originalPrice = originalPrice;
		this.count = count;
		this.discountPrecentage = discountPrecentage;
		this.newPrice = newPrice;
		this.articleDTO = articleDTO;
		this.listItemsAccount = listItemsAccount;
	}

	public ItemsAccountDTO(ItemsAccount itemsAccount) {
		super();
		this.id = itemsAccount.getId();
		this.originalPrice = itemsAccount.getOriginalPrice();
		this.count = itemsAccount.getCount();
		this.discountPrecentage = itemsAccount.getDiscountPrecentage();
		this.newPrice = itemsAccount.getNewPrice();
		if (itemsAccount.getArticle() != null)
			this.articleDTO = new ArticleDTO(itemsAccount.getArticle());
	}

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

	public ArticleDTO getArticleDTO() {
		return articleDTO;
	}

	public void setArticleDTO(ArticleDTO articleDTO) {
		this.articleDTO = articleDTO;
	}

	public Set<ListItemsAccount> getListItemsAccount() {
		return listItemsAccount;
	}

	public void setListItemsAccount(Set<ListItemsAccount> listItemsAccount) {
		this.listItemsAccount = listItemsAccount;
	}

}
