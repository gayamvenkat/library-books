package com.org.library.books.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.springframework.web.multipart.MultipartFile;

import com.org.library.books.exception.ParseException;
import com.org.library.books.model.Book;
import com.org.library.books.model.Tags;

public class CSVUtils {

	private CSVUtils() {
		throw new IllegalStateException("Utility class");
	}

	static final String[] CSV_HEADER = { "ISBN", "Title", "Author", "Tags" };

	public static List<Book> getCSVRecords(MultipartFile file) {

		try (BufferedReader fileReader = new BufferedReader(
				new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));) {

			return CSVFormat.DEFAULT.withHeader(CSV_HEADER).withSkipHeaderRecord().parse(fileReader)
					.getRecords().stream()
					.map(e -> new Book(Long.parseLong(e.get("ISBN")), e.get("Title"), e.get("Author"),
							Arrays.asList(e.get("Tags").split(",")).stream().map(Tags::new)
									.collect(Collectors.toList())))
					.collect(Collectors.toList());

		} catch (IOException e) {
			throw new ParseException("Fail to parse CSV file " + e.getMessage());
		}
	}

}
