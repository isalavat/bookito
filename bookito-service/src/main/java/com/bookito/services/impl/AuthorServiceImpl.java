package com.bookito.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookito.domain.Author;
import com.bookito.repositories.AuthorRepository;
import com.bookito.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public Author getAuthorByFirstName(String name) {
		
		return authorRepository.findByFirstName(name);
	}

	@Override
	public Author getAuthorById(Long id) {
		
		return authorRepository.findById(id).get();
	}

	@Override
	public List<Author> getAllAuthors() {
		
		return authorRepository.findAll();
	}

	@Override
	public Author createAuthor(Author author) {
		
		return authorRepository.save(author);
	}

	@Override
	public Author updateAuthor(Author author) {

		return authorRepository.save(author);
	}
	
}
