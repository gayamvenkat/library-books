package com.org.library.books.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/*@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor*/

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class Book {
	@Id
	private long isbn;
	private String title;
	private String author;

	@OneToMany(targetEntity = Tags.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "book_isbn")
	private List<Tags> tags = new ArrayList<>();

}
