package com.bookito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookito.domain.Author;
import com.bookito.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping()
	public List<Author> getAllAuthors() {
		
		return authorService.getAllAuthors();  
	}
	
	@GetMapping("/{id}")
	public Author getAuthorById(@PathVariable(value = "id") Long id) {
		
		return authorService.getAuthorById(id);
	}
	
	@GetMapping("/{firstName}")
	public Author getAuthorByFirstName(@PathVariable(value = "firstName") String firstName) {
		
		return authorService.getAuthorByFirstName(firstName);
	}

	@PostMapping()
	public Author createAuthor(@RequestBody Author author) {
		
		return authorService.createAuthor(author);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") Long id, @RequestBody Author authorUpdated) {
		
		Author author = authorService.getAuthorById(id);
		
		if (null == author) {
			throw new RuntimeException("Author not found on :: " + id);
		}
		
		authorUpdated.setId(id);
		
		authorUpdated = authorService.updateAuthor(authorUpdated);
		
		return ResponseEntity.ok(authorUpdated);
	}
	
}
