/*
 * package com.org.library.books.controller;
 * 
 * import static org.junit.jupiter.api.Assertions.assertTrue; import static
 * org.mockito.Mockito.doNothing; import static org.mockito.Mockito.when; import
 * static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import java.util.Arrays; import java.util.List; import java.util.Optional;
 * 
 * import org.junit.jupiter.api.Test; import org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.data.domain.Example; import
 * org.springframework.data.domain.ExampleMatcher; import
 * org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MockMvc;
 * 
 * import com.fasterxml.jackson.databind.ObjectMapper; import
 * com.org.library.books.model.Book; import
 * com.org.library.books.repository.BookRepository;
 * 
 * @WebMvcTest class BookControllerTests {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean BookRepository mockBooksService;
 * 
 * @Autowired ObjectMapper objectMapper;
 * 
 * @Test void getBookByIsbnTest() throws Exception {
 * 
 * Book book = new Book(123, "testTitle", "testAuthor", "testtags"); List<Book>
 * booksList = Arrays.asList(book);
 * when(mockBooksService.saveAll(booksList)).thenReturn(booksList);
 * 
 * Optional<Book> opt = Optional.of(book);
 * when(mockBooksService.findById(Mockito.anyLong())).thenReturn(opt);
 * this.mockMvc.perform(get("/books/123")).andExpect(status().is2xxSuccessful())
 * .andExpect(result ->
 * assertTrue(result.getResponse().getContentAsString().contains("testtags")));
 * }
 * 
 * @Test void addBooks() throws Exception { Book book = new Book(123,
 * "testTitle", "testAuthor", "testtags"); List<Book> booksList =
 * Arrays.asList(book);
 * when(mockBooksService.saveAll(booksList)).thenReturn(booksList);
 * 
 * this.mockMvc
 * .perform(post("/addBooks").content(objectMapper.writeValueAsString(booksList)
 * ) .contentType(MediaType.APPLICATION_JSON_VALUE))
 * .andExpect(status().is2xxSuccessful()) .andExpect(result ->
 * assertTrue(result.getResponse().getContentAsString().contains("testtags")));
 * }
 * 
 * @Test void updateBookById() throws Exception { Book book = new Book(123,
 * "updatedTitle", "testAuthor", "testtags");
 * when(mockBooksService.save(book)).thenReturn(book);
 * 
 * this.mockMvc
 * .perform(put("/books/123").content(objectMapper.writeValueAsString(book))
 * .contentType(MediaType.APPLICATION_JSON_VALUE))
 * .andExpect(status().is2xxSuccessful()) .andExpect(result ->
 * assertTrue(result.getResponse().getContentAsString().contains("updatedTitle")
 * ));
 * 
 * }
 * 
 * @Test void deleteBookByIsbn() throws Exception {
 * 
 * doNothing().when(mockBooksService).deleteById(Mockito.anyLong());
 * 
 * this.mockMvc.perform(delete("/books/123")).andExpect(status().is2xxSuccessful
 * ()) .andExpect(result ->
 * assertTrue(result.getResponse().getContentAsString().contains("true")));
 * 
 * }
 * 
 * @Test void searchBooks() throws Exception { Book book = new Book(123, null,
 * null, null); List<Book> booksList = Arrays.asList(book); Example<Book>
 * example = Example.of(book,
 * ExampleMatcher.matchingAny().withIgnoreCase().withMatcher("tags",
 * GenericPropertyMatcher::contains));
 * when(mockBooksService.findAll(example)).thenReturn(booksList);
 * 
 * this.mockMvc.perform(get("/searchBooks?isbn=123")).andExpect(status().
 * is2xxSuccessful()) .andExpect(result ->
 * assertTrue(result.getResponse().getContentAsString().contains("123")));
 * 
 * } }
 */