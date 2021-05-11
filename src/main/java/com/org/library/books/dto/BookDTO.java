package com.org.library.books.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {

	private long isbn;
	private String title;
	private String author;

	private List<String> tags;

}
