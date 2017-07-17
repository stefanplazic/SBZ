package com.sample.dto;

import com.sample.model.CartItem;

public class CartItemDTO {

	private Long id;
	private double price;
	private double discountArticle;
	private int count;
	private double newPrice;
	private ArticleDTO article;

	public CartItemDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartItemDTO(CartItem cartItem) {

		this.id = cartItem.getId();
		this.price = cartItem.getPrice();
		this.discountArticle = cartItem.getDiscountArticle();
		this.count = cartItem.getCount();
		this.newPrice = cartItem.getNewPrice();
		this.article = new ArticleDTO(cartItem.getArticle());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountArticle() {
		return discountArticle;
	}

	public void setDiscountArticle(double discountArticle) {
		this.discountArticle = discountArticle;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	public ArticleDTO getArticle() {
		return article;
	}

	public void setArticle(ArticleDTO article) {
		this.article = article;
	}

}
