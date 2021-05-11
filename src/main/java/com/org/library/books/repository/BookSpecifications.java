package com.org.library.books.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.org.library.books.model.Book;
import com.org.library.books.model.Tags;

public final class BookSpecifications {

	public static Specification<Book> hasAuthor(String author) {
		return (Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> cb.equal(root.get("author"), author);
	}

	public static Specification<Book> hasTags(String tag) {
		return (Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> root.join("tags").in(new Tags(tag));
	}

}
