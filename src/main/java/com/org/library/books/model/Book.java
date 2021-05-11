package com.org.library.books.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	private long isbn;
	private String title;
	private String author;

	@OneToMany(targetEntity = Tags.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "book_isbn")
	private List<Tags> tags = new ArrayList<>();

}
