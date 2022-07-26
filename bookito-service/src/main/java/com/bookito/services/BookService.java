package com.bookito.services;

import java.util.List;

import com.bookito.domain.Book;

public interface BookService {
	
	public Book getBookByName(String name);
	
	public List<Book> getAllBooks();
	
	public Book getBookById(Long id);
	
	public List<Book> getBookByAuthor(Long id);
	
	public Book createBook(Book book);
	
	public Book updateBook(Book book);
}
