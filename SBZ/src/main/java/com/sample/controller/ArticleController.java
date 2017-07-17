package com.sample.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sample.dto.ArticleDTO;
import com.sample.dto.MessagesDTO;
import com.sample.dto.SearchArticleDTO;
import com.sample.model.Article;
import com.sample.model.SubCategory;
import com.sample.model.User;
import com.sample.repository.ArticleRepository;
import com.sample.repository.SubCategoryRepository;
import com.sample.repository.UserRepository;
import com.sample.service.ArticleService;

@RestController
@RequestMapping(value = "api/article")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ArticleService articleService;

	/*
	 * Get new article
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ResponseEntity<List<ArticleDTO>> getAllCategory() {

		Page<Article> article = articleRepository.findAll(new PageRequest(0, 10));

		List<ArticleDTO> articleDTO = new ArrayList<>();
		for (Article a : article) {
			articleDTO.add(new ArticleDTO(a));
		}
		return new ResponseEntity<>(articleDTO, HttpStatus.OK);
	}

	/*
	 * Get one article
	 */
	@RequestMapping(value = "/new/{id}", method = RequestMethod.GET)
	public ResponseEntity<ArticleDTO> getArticle(@PathVariable Long id) {

		Article article = articleRepository.findOne(id);

		return new ResponseEntity<>(new ArticleDTO(article), HttpStatus.OK);
	}

	/*
	 * Get new article
	 */
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<ArticleDTO>> getArticlCategory(@PathVariable Long id) {

		SubCategory subCategory = subCategoryRepository.findOne(id);

		List<Article> article = articleRepository.findByPodCategory(subCategory);

		List<ArticleDTO> articleDTO = new ArrayList<>();
		for (Article a : article) {
			articleDTO.add(new ArticleDTO(a));
		}
		return new ResponseEntity<>(articleDTO, HttpStatus.OK);
	}

	/*
	 * Vraca broj svih artikala
	 */
	@RequestMapping(value = "/length", method = RequestMethod.GET)
	public ResponseEntity<MessagesDTO> getAllLength() {
		MessagesDTO messageDTO = new MessagesDTO();
		List<Article> article = articleRepository.findAll();

		messageDTO.setSize(article.size());
		return new ResponseEntity<>(messageDTO, HttpStatus.OK);
	}

	/*
	 * Get article discount
	 */
	@RequestMapping(value = "/discount", method = RequestMethod.GET)
	public ResponseEntity<String> getAllDiscount() {

		// List<ArticleDiscount> articleDiscount =
		// articleDiscountRepository.findAll();
		//
		// List<ArticleDiscountDTO> articleDiscountDTO = new ArrayList<>();
		// for(ArticleDiscount ad: articleDiscount) {
		// articleDiscountDTO.add(new ArticleDiscountDTO(ad));
		// }

		return new ResponseEntity<>(HttpStatus.OK);
	}

	/*
	 * Add new article
	 */
	@RequestMapping(value = "/add/article", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MessagesDTO> setArticle(@RequestBody ArticleDTO articleDTO) {

		MessagesDTO messageDTO = new MessagesDTO();

		Date date = new Date();

		SubCategory podCategory = subCategoryRepository.findOne(articleDTO.getPodCategoryDTO().getId());

		Article artikle = new Article();
		artikle.setNameArticle(articleDTO.getNameArticle());
		artikle.setPrice(articleDTO.getPrice());
		artikle.setAmount(articleDTO.getAmount());
		artikle.setCreationDate(date);
		artikle.setComplement(true);
		artikle.setStatusRecord(true);
		artikle.setMinState(articleDTO.getMinState());
		artikle.setPodCategory(podCategory);

		articleRepository.save(artikle);

		messageDTO.setMessage("save");
		return new ResponseEntity<>(messageDTO, HttpStatus.OK);
	}

	/**
	 * Dodavanje nove slike
	 */
	@RequestMapping(value = "/slika/{id}", method = RequestMethod.POST)
	public ResponseEntity<MessagesDTO> addImageByArticle(@RequestParam("file") MultipartFile file,
			@PathVariable Long id) throws IOException {

		String nameArticle = file.getOriginalFilename();
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();

			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("static/data/" + id + "/" + nameArticle)));
			stream.write(bytes);
			stream.close();
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	/**
	 * custemor search articles by hashCOde, category,name, and price range
	 * 
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<List<ArticleDTO>> searchArticle(Principal principal,
			@RequestBody SearchArticleDTO searchArticleDTO) {

		// check if user is logged
		User user = userRepository.findByUsername(principal.getName());
		if (user == null)
			return new ResponseEntity<List<ArticleDTO>>(HttpStatus.UNAUTHORIZED);

		List<ArticleDTO> articlesDto = new ArrayList<ArticleDTO>();
		List<Article> articles = articleService.searchFor(searchArticleDTO);
		for (Article a : articles)
			articlesDto.add(new ArticleDTO(a));

		return new ResponseEntity<List<ArticleDTO>>(articlesDto, HttpStatus.OK);
	}

}
