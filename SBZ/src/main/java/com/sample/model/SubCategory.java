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
 * Podkategorija naseg artikla na primer ASUS, HP,...
 * @author X
 *
 */

@Entity
public class SubCategory {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "podCategory", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Article> article = new HashSet<Article>();

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private CategoryArticle categoryArticle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String namePodCateogry) {
		this.name = namePodCateogry;
	}

	public CategoryArticle getCategoryArticle() {
		return categoryArticle;
	}

	public void setCategoryArticle(CategoryArticle categoryArticle) {
		this.categoryArticle = categoryArticle;
	}

}
