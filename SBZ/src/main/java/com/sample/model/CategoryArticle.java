package com.sample.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Ovde je definisana kategorija nase artikle treba proveriti oko definisanja
 * maksimalno dozvoljenog popusta za artikle date kategorije
 * 
 * @author X
 *
 */

@Entity
public class CategoryArticle {

	@Id
	@GeneratedValue
	private Long id;
	private String codeCategory;
	private String nameCategory;
	private double maxDiscount;

	@OneToMany(mappedBy = "categoryArticle", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<SubCategory> subCategory = new HashSet<SubCategory>();

	@OneToMany(mappedBy = "categoryArticle", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<ListActionCategory> listActionCategory = new HashSet<ListActionCategory>();

	@OneToMany(mappedBy = "categoryArticle", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<RModel> rModel = new HashSet<RModel>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public Set<ListActionCategory> getListActionCategory() {
		return listActionCategory;
	}

	public void setListActionCategory(Set<ListActionCategory> listActionCategory) {
		this.listActionCategory = listActionCategory;
	}

	public Set<RModel> getrModel() {
		return rModel;
	}

	public void setrModel(Set<RModel> rModel) {
		this.rModel = rModel;
	}

	public String getCodeCategory() {
		return codeCategory;
	}

	public void setCodeCategory(String codeCategory) {
		this.codeCategory = codeCategory;
	}

	public Set<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Set<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	public double getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

}
