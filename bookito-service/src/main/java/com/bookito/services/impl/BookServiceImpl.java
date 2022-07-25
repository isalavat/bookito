package com.bookito.services.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookito.domain.Author;
import com.bookito.domain.Book;
import com.bookito.repositories.BookRepository;
import com.bookito.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book getBookByName(String name) {
		
		return bookRepository.findByName(name);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		
		return bookRepository.findById(id).get();
	}

	@Override
	public List<Book> getBookByAuthor(Long id) {
		Author author = new Author();
		author.setId(id);
		return bookRepository.findByAuthor(author);
	}

	@Override
	public Book createBook(Book book) {
		
		book.setPublishingDate(Date.valueOf( LocalDate.now()));
		
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		
		if(null == book.getPublishingDate()) {
			book.setPublishingDate(Date.valueOf(LocalDate.now()));
		}

		return bookRepository.save(book);
	}

}
