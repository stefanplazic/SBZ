package com.sample.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.Article;
import com.sample.model.CategoryArticle;
import com.sample.model.SubCategory;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	List<Article> findByPodCategory(SubCategory podCategory);

}
