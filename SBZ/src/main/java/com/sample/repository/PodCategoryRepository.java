package com.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.CategoryArticle;
import com.sample.model.SubCategory;

public interface PodCategoryRepository extends JpaRepository<SubCategory, Long> {

	List<SubCategory> findByCategoryArticle(CategoryArticle categoryArticle);

}
