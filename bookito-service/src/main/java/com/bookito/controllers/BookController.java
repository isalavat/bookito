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

import com.bookito.domain.Book;
import com.bookito.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("name/{name}")
	public Book getBookByName(@PathVariable(value = "name") String name) {
		return bookService.getBookByName(name);
	}

	@GetMapping()
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("id/{id}")
	public Book getBookById(@PathVariable(value = "id") Long id) {
		return bookService.getBookById(id);
	}

	@GetMapping("/author/{id}")
	public List<Book> getBookByAuthor(@PathVariable(value = "id") Long id) {
		return bookService.getBookByAuthor(id);
	}

	@PostMapping()
	public Book createBook(@RequestBody Book book) {
		
		return bookService.createBook(book);
	}
	
	@PutMapping("id/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable(value="id") Long id, @RequestBody Book bookUpdated) {
		
		Book book = bookService.getBookById(id);
		
		if(null == book) {
			throw new RuntimeException("Author not found on :: " + id);
		}
		
		bookUpdated.setId(id);
		
		bookUpdated = bookService.updateBook(bookUpdated);
		
		return ResponseEntity.ok(bookUpdated);
	}

}
