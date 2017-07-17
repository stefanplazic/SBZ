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
 * Podaci o artiklu jednom, za artikl vezemo podkategoriju koja u sebi ima
 * kategoriju tako postizemo da artikl vezemo i za kategoriju i za podkategoriju
 * 
 * @author X
 *
 */

@Entity
public class Article {

	@Id
	@GeneratedValue
	private Long id;
	private String productCode;
	private String nameArticle; // naziv artikla
	private Double price; // cena artikla
	private int amount; // raspoloziva kolicina
	private Date creationDate; // datum dodavanja artikla
	private boolean complement; // potrebna dopuna T F
	private boolean statusRecord; // status zapisa T F (aktivan neaktivan)
	private int minState; // Minimalno na lageru dozvoljeno

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private SubCategory podCategory;

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<ItemsAccount> atemsAccount = new HashSet<ItemsAccount>();

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<OrderArticle> orders = new HashSet<OrderArticle>();

	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<CartItem> cartItems = new HashSet<CartItem>();

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getNameArticle() {
		return nameArticle;
	}

	public void setNameArticle(String nameArticle) {
		this.nameArticle = nameArticle;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isComplement() {
		return complement;
	}

	public void setComplement(boolean complement) {
		this.complement = complement;
	}

	public boolean isStatusRecord() {
		return statusRecord;
	}

	public void setStatusRecord(boolean statusRecord) {
		this.statusRecord = statusRecord;
	}

	public int getMinState() {
		return minState;
	}

	public void setMinState(int minState) {
		this.minState = minState;
	}

	public SubCategory getPodCategory() {
		return podCategory;
	}

	public void setPodCategory(SubCategory podCategory) {
		this.podCategory = podCategory;
	}

	public Set<ItemsAccount> getAtemsAccount() {
		return atemsAccount;
	}

	public void setAtemsAccount(Set<ItemsAccount> atemsAccount) {
		this.atemsAccount = atemsAccount;
	}

	public Set<OrderArticle> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderArticle> orders) {
		this.orders = orders;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

}
