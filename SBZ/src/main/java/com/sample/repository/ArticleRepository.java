package com.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sample.model.Article;
import com.sample.model.SubCategory;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	List<Article> findByPodCategory(SubCategory podCategory);

	// @Query("Select a from Article as a where a.productCode LIKE
	// %:productCode%")
	// List<Article> searchFor(@Param("productCode") String productCode,
	// @Param("nameArticle") String nameArticle,
	// @Param("maxPrice") double maxPrice, @Param("minPrice") double minPrice);

	@Query("Select a from Article as a where a.productCode LIKE %:productCode% AND a.nameArticle LIKE %:name% AND (a.price >= :minPrice AND a.price <= :maxPrice)")
	List<Article> searchFor(@Param("productCode") String productCode, @Param("name") String name,
			@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);

}
