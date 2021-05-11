package com.org.library.books.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.library.books.dto.BookDTO;
import com.org.library.books.service.BooksService;

@WebMvcTest
class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BooksService mockBooksService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void uploadCSV() throws Exception {

		String content = "123, testTitl, testAuthor, testtags";
		MockMultipartFile file = new MockMultipartFile("file", content.getBytes());
		when(mockBooksService.uploadCSV(Mockito.any())).thenReturn("success");
		this.mockMvc.perform(multipart("/books/uploadBooks").file(file)).andExpect(status().is2xxSuccessful())
				.andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("success")));

	}

	@Test
	void getBookByIsbnTest() throws Exception {

		BookDTO bookDTO = getBookDTO();
		when(mockBooksService.getBookByIsbn(Mockito.anyLong())).thenReturn(bookDTO);
		this.mockMvc.perform(get("/books/123")).andExpect(status().is2xxSuccessful())
				.andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("testtags")));
	}



	@Test
	void addBooks() throws Exception {

		List<BookDTO> booksList = Arrays.asList(getBookDTO());
		when(mockBooksService.addBooks(booksList)).thenReturn("success");

		this.mockMvc
				.perform(post("/books/addBooks")
						.content(objectMapper.writeValueAsString(booksList))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is2xxSuccessful())
				.andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("success")));
	}

	@Test
	void updateBookById() throws Exception {

		BookDTO bookDTO = new BookDTO(123, "updatedTitle", "testAuthor", Arrays.asList("testtags", "tes"));
		when(mockBooksService.updateBookById(Mockito.any(), Mockito.anyLong()))
				.thenReturn("success");
		this.mockMvc
				.perform(put("/books/123").content(objectMapper.writeValueAsString(bookDTO))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is2xxSuccessful())
				.andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("success")));

	}

	@Test
	void deleteBookByIsbn() throws Exception {

		when(mockBooksService.deleteBookByIsbn(Mockito.anyLong())).thenReturn("success");
		this.mockMvc.perform(delete("/books/123")).andExpect(status().is2xxSuccessful())
				.andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("success")));

	}

	@Test
	void searchBooks() throws Exception {
		List<BookDTO> booksList = Arrays.asList(getBookDTO());

		when(mockBooksService.searchBooks(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(booksList);

		this.mockMvc.perform(get("/books/searchBooks?isbn=123")).andExpect(status().is2xxSuccessful())
				.andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("testAuthor")));

	}

	private BookDTO getBookDTO() {
		return new BookDTO(123, "testTitle", "testAuthor", Arrays.asList("testtags", "tes"));
	}
}
