package com.org.library.books;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.LinkedMultiValueMap;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestMethodOrder(OrderAnnotation.class)
class LibraryBooksApplicationTests {


	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Order(1)
	void testUpload() {
		LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		parameters.add("file", new org.springframework.core.io.ClassPathResource("book.csv"));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
				parameters, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/books/uploadBooks",
				HttpMethod.POST, entity, String.class);

		assertTrue(response.getBody().contains("Books imported successfully"));

	}

	@Test
	@Order(2)
	void testGetBookByIsbn() throws Exception {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/books/123", String.class)).contains("123");
	}

	@Test
	@Order(3)
	void testUpdateBookByIsbn() throws Exception {
		String response = restTemplate.getForObject("http://localhost:" + port + "/books/123", String.class);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity<>(response, headers);

		ResponseEntity<String> updateResponse = restTemplate.exchange("http://localhost:" + port + "/books/123",
				HttpMethod.PUT, entity, String.class);
		// System.out.println(updateResponse.getBody());

		assertTrue(updateResponse.getBody().contains("success"));

	}

	@Test
	@Order(4)
	void testSearchBooks() throws Exception {
		String response = restTemplate.getForObject("http://localhost:" + port + "/books/searchBooks?isbn=123",
				String.class);

		assertTrue(response.contains("123"));

	}

	@Test
	@Order(5)
	void testDeleteBookByIsBn() throws Exception {

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/books/123",
				HttpMethod.DELETE, new HttpEntity<>(""), String.class);

		assertTrue(response.getBody().contains("Successfully deleted"));

	}

}
