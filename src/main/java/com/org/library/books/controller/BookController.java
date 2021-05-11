package com.org.library.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.org.library.books.dto.BookDTO;
import com.org.library.books.exception.RequestValidationException;
import com.org.library.books.service.BooksService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

	@Autowired
	private BooksService booksService;

	@PostMapping("/uploadBooks")
	public String uploadCSV(@RequestPart("file") MultipartFile file) {
		return booksService.uploadCSV(file);

	}

	@GetMapping("/{isbn}")
	public BookDTO getBookByIsbn(@PathVariable("isbn") long isbn) {
		return booksService.getBookByIsbn(isbn);

	}

	@PostMapping("/addBooks")
	public ResponseEntity<String> addBooks(@RequestBody List<BookDTO> bookDTOs) {
		return new ResponseEntity<>(booksService.addBooks(bookDTOs), HttpStatus.CREATED);

	}

	@PutMapping("/{isbn}")
	public String updateBookById(@RequestBody BookDTO bookDTO, @PathVariable("isbn") long isbn) {
		return booksService.updateBookById(bookDTO, isbn);

	}

	@DeleteMapping("/{isbn}")
	public String deleteBookByIsbn(@PathVariable("isbn") long isbn) {
		return booksService.deleteBookByIsbn(isbn);

	}

	@GetMapping("/searchBooks")
	public List<BookDTO> searchBooks(@RequestParam(required = false) Long isbn,
			@RequestParam(required = false) String author, @RequestParam(required = false) String title,
			@RequestParam(required = false) String tags) {

		if (!(StringUtils.hasText(author) || StringUtils.hasText(title) || StringUtils.hasText(tags) || isbn != null)) {
			log.error("Search attributes are not provided");
			throw new RequestValidationException("Please provide at least one parameter");
		}

		return booksService.searchBooks(isbn, author, title, tags);

	}

}
