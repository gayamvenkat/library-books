package com.org.library.books.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.org.library.books.dto.BookDTO;
import com.org.library.books.model.Book;
import com.org.library.books.model.Tags;

public class BookMapper {

	private BookMapper() {
		throw new IllegalStateException("Mapper class");
	}

	public static List<BookDTO> convertEntityToDTO(List<Book> books) {

		List<BookDTO> booksDTOList = new ArrayList<>();
		for (Book book : books) {
			booksDTOList.add(convertEntityToDTO(book));
		}
		return booksDTOList;

	}

	public static BookDTO convertEntityToDTO(Book book) {
		return new BookDTO(book.getIsbn(), book.getTitle(), book.getAuthor(),
				book.getTags().stream().map(Tags::getName).collect(Collectors.toList()));

	}

	public static Book convertDTOToEntity(BookDTO bookDTO) {

		return new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthor(),
				bookDTO.getTags().stream().map(Tags::new).collect(Collectors.toList()));
	}

	public static List<Book> convertDTOToEntity(List<BookDTO> bookDTOs) {
		List<Book> books = new ArrayList<>();
		for (BookDTO bookDTO : bookDTOs) {
			books.add(convertDTOToEntity(bookDTO));
		}
		return books;

	}
}
