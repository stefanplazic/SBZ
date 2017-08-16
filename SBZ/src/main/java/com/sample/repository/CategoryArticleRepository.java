package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.CategoryArticle;

public interface CategoryArticleRepository extends JpaRepository<CategoryArticle, Long> {
	
	CategoryArticle findByCodeCategory(String codeCategory);
}
