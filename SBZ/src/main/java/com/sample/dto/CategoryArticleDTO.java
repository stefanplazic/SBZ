package com.sample.dto;

import java.util.HashSet;
import java.util.Set;

import com.sample.model.CategoryArticle;
import com.sample.model.ListActionCategory;

public class CategoryArticleDTO {

	private Long id;
	private String nameCategory;
	private Set<ArticleDTO> articleDTO = new HashSet<ArticleDTO>();
	private Set<ListActionCategoryDTO> listActionCategoryDTO = new HashSet<ListActionCategoryDTO>();

	public CategoryArticleDTO() {
	}

	public CategoryArticleDTO(Long id, String nameCategory, PodCategoryDTO podCategoryDTO, Set<ArticleDTO> articleDTO,
			Set<ListActionCategoryDTO> listActionCategoryDTO) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
		this.articleDTO = articleDTO;
		this.listActionCategoryDTO = listActionCategoryDTO;
	}

	public CategoryArticleDTO(CategoryArticle categoryArticle) {
		this.id = categoryArticle.getId();
		this.nameCategory = categoryArticle.getNameCategory();
		if (categoryArticle.getListActionCategory() != null) {
			this.listActionCategoryDTO = new HashSet<ListActionCategoryDTO>();
			for (ListActionCategory lac : categoryArticle.getListActionCategory()) {
				this.listActionCategoryDTO.add(new ListActionCategoryDTO(lac));
			}
		}
	}

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

	public Set<ArticleDTO> getArticleDTO() {
		return articleDTO;
	}

	public void setArticleDTO(Set<ArticleDTO> articleDTO) {
		this.articleDTO = articleDTO;
	}

	public Set<ListActionCategoryDTO> getListActionCategoryDTO() {
		return listActionCategoryDTO;
	}

	public void setListActionCategoryDTO(Set<ListActionCategoryDTO> listActionCategoryDTO) {
		this.listActionCategoryDTO = listActionCategoryDTO;
	}

}
