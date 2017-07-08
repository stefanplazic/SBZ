package com.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.CategoryArticleDTO;
import com.sample.dto.MessagesDTO;
import com.sample.dto.PodCategoryDTO;
import com.sample.model.CategoryArticle;
import com.sample.model.SubCategory;
import com.sample.repository.CategoryArticleRepository;
import com.sample.repository.SubCategoryRepository;

@RestController
@RequestMapping(value = "api/category")
public class CategoryController {

	@Autowired
	private CategoryArticleRepository categoryRepositry;
	
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	/*
	 * Get all category
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ResponseEntity<List<CategoryArticleDTO>> getAllCategory() {
		
		List<CategoryArticle> category = categoryRepositry.findAll();
		
		List<CategoryArticleDTO> categoryDTO = new ArrayList<>();
		for(CategoryArticle ca: category){
			categoryDTO.add(new CategoryArticleDTO(ca));
		}
		
		return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/subCategory", method = RequestMethod.GET)
	public ResponseEntity<List<PodCategoryDTO>> getAllPodCategory() {
		
		List<SubCategory> podCategory = subCategoryRepository.findAll();
		
		List<PodCategoryDTO> podCategoryDTO = new ArrayList<>();
		for(SubCategory pc: podCategory){
			podCategoryDTO.add(new PodCategoryDTO(pc));
		}
		
		return new ResponseEntity<>(podCategoryDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/subCategory/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<PodCategoryDTO>> getPodcategoryByCategory(@PathVariable Long id) {
		
		CategoryArticle categoryArticle = categoryRepositry.findOne(id);
		
		List<SubCategory> podCategory = subCategoryRepository.findByCategoryArticle(categoryArticle);
		
		List<PodCategoryDTO> podCategoryDTO = new ArrayList<>();
		for(SubCategory pc: podCategory){
			podCategoryDTO.add(new PodCategoryDTO(pc));
		}
		
		return new ResponseEntity<>(podCategoryDTO, HttpStatus.OK);
	}
	
	
	/*
	 * Get 4 category
	 */
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ResponseEntity<List<CategoryArticleDTO>> getForCategory() {
		
		Page<CategoryArticle> category = categoryRepositry.findAll(new PageRequest(0, 4));
		
		List<CategoryArticleDTO> categoryDTO = new ArrayList<>();
		for(CategoryArticle ca: category){
			categoryDTO.add(new CategoryArticleDTO(ca));
		}
		
		return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
	}
	
	
	
	
	
	@RequestMapping(value = "/creat/subcategory", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MessagesDTO> setArticle(@RequestBody PodCategoryDTO podCategoryDTO) {
		
		
		
		MessagesDTO messageDTO = new MessagesDTO();
		
		CategoryArticle category = categoryRepositry.findOne(podCategoryDTO.getCategoryArticleDTO().getId());
		
		SubCategory podCategory = new SubCategory();
		podCategory.setName(podCategoryDTO.getNamePodCateogry());
		podCategory.setCategoryArticle(category);
		
		subCategoryRepository.save(podCategory);

		messageDTO.setMessage("save");
		return new ResponseEntity<>(messageDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/create/category", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MessagesDTO> setCategory(@RequestBody CategoryArticleDTO categoryArticleDTO) {
		
		
		
		MessagesDTO messageDTO = new MessagesDTO();
		
		CategoryArticle categoryArticle = new CategoryArticle();
		categoryArticle.setNameCategory(categoryArticleDTO.getNameCategory());
		
		categoryRepositry.save(categoryArticle);
		
		messageDTO.setMessage("save");
		return new ResponseEntity<>(messageDTO, HttpStatus.OK);
	}
}
