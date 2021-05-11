package com.org.library.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.library.books.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {


	@Query("SELECT distinct  b FROM Book b  join b.tags tag WHERE (:isbn is null or b.isbn = :isbn ) and"
			+ " (:author is null or b.author = :author)  and (:title  is null or  b.title = :title) "
			+ "and (:tags is null or  tag.name = :tags)")
	List<Book> findAllBooks(@Param("isbn") Long isbn, @Param("author") String author, @Param("title") String title,
			@Param("tags") String tags);

}
