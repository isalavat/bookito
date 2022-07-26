package com.bookito.services;

import java.util.List;
import com.bookito.domain.Author;

public interface AuthorService {
	
	public Author getAuthorById(Long id);
	
	public Author getAuthorByFirstName(String name);
	
	public List<Author> getAllAuthors();
	
	public Author createAuthor(Author author);
	
	public Author updateAuthor(Author author);
	
}
