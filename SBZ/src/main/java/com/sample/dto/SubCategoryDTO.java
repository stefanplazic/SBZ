package com.sample.dto;

import java.util.HashSet;
import java.util.Set;

import com.sample.model.Article;
import com.sample.model.SubCategory;

public class SubCategoryDTO {

	private Long id;
	private String namePodCateogry;
	private CategoryArticleDTO categoryArticleDTO;
	private Set<Article> article = new HashSet<Article>();
	private String subCode;

	public SubCategoryDTO() {
	}

	public SubCategoryDTO(Long id, String namePodCateogry, CategoryArticleDTO categoryArticleDTO, String subCode) {
		super();
		this.id = id;
		this.namePodCateogry = namePodCateogry;
		this.categoryArticleDTO = categoryArticleDTO;
		this.subCode = subCode;
	}

	public SubCategoryDTO(SubCategory podCategory) {
		this.id = podCategory.getId();
		this.namePodCateogry = podCategory.getName();
		if (podCategory.getCategoryArticle() != null)
			this.categoryArticleDTO = new CategoryArticleDTO(podCategory.getCategoryArticle());
		this.subCode = podCategory.getSubCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamePodCateogry() {
		return namePodCateogry;
	}

	public void setNamePodCateogry(String namePodCateogry) {
		this.namePodCateogry = namePodCateogry;
	}

	public CategoryArticleDTO getCategoryArticleDTO() {
		return categoryArticleDTO;
	}

	public void setCategoryArticleDTO(CategoryArticleDTO categoryArticleDTO) {
		this.categoryArticleDTO = categoryArticleDTO;
	}

	public Set<Article> getArticle() {
		return article;
	}

	public void setArticle(Set<Article> article) {
		this.article = article;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

}
