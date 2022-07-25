package com.bookito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookito.domain.Author;
import com.bookito.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findByName(String name);
	
	List<Book> findByAuthor(Author author);
}
