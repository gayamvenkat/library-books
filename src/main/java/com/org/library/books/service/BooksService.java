package com.org.library.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.org.library.books.dto.BookDTO;
import com.org.library.books.exception.BookNotFoundException;
import com.org.library.books.mapper.BookMapper;
import com.org.library.books.repository.BookRepository;
import com.org.library.books.util.CSVUtils;

@Service
public class BooksService {

	@Autowired
	private BookRepository bookRepository;

	public String uploadCSV(MultipartFile file) {
		bookRepository.saveAll(CSVUtils.getCSVRecords(file));
		return "Books imported successfully";
	}

	public BookDTO getBookByIsbn(long isbn) {

		return BookMapper
				.convertEntityToDTO(bookRepository.findById(isbn).orElseThrow(() -> new BookNotFoundException(isbn)));

	}

	public String addBooks(List<BookDTO> bookDTOs) {
		bookRepository.saveAll(BookMapper.convertDTOToEntity(bookDTOs));

		return "Books created successfully";
	}

	public String updateBookById(BookDTO bookDTO, long isbn) {
		bookDTO.setIsbn(isbn);

		bookRepository.save(BookMapper.convertDTOToEntity(bookDTO));

		return "Book updated successfully";

	}

	public String deleteBookByIsbn(long isbn) {
		try {
			bookRepository.deleteById(isbn);
		} catch (EmptyResultDataAccessException e) {
			throw new BookNotFoundException(isbn);
		}

		return "Successfully deleted";

	}

	public List<BookDTO> searchBooks(Long isbn, String author, String title, String tags) {
		

		/*
		 * return BookMapper .convertEntityToDTO(bookRepository
		 * .findAll(BookSpecifications.hasAuthor(author).or(BookSpecifications.hasTags(
		 * tags))));
		 * 
		 */

		return BookMapper
				.convertEntityToDTO(bookRepository.findAllBooksAND(isbn, author, title, tags));

	}

}
