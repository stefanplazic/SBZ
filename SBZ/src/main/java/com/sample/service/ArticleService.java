package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sample.dto.SearchArticleDTO;
import com.sample.model.Article;
import com.sample.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository repository;

	public Article save(Article a) {
		return repository.save(a);
	}

	public Article findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Article> findAll() {
		return repository.findAll();
	}

	public Page<Article> findAll(Pageable page) {
		return repository.findAll(page);
	}

	public void remove(Long id) {
		repository.delete(id);
	}

	public List<Article> searchFor(SearchArticleDTO searchArticleDTO) {

		List<Article> articles = repository.searchFor(searchArticleDTO.getProductCode(), searchArticleDTO.getName(),
				searchArticleDTO.getMinPrice(), searchArticleDTO.getMaxPrice(), searchArticleDTO.getCategoryId());

		return articles;
	}

	public Article findByProductCode(String productCode) {
		return repository.findByProductCode(productCode);
	}
}
