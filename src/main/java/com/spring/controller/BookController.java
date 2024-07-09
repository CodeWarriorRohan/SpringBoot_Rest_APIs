package com.spring.controller;

import java.awt.print.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Entity.Books;
import com.spring.Services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// get all books handler
	
	@GetMapping("/books")
	public List<Books> getBooks() {
		
		System.out.println("All available books");
		return this.bookService.getAllBooks();
	}

	// get single book handler
	
	@GetMapping("/books/{id}")
	public Books getBookById(@PathVariable("id") int id) {
		
		return bookService.getBookById(id);
	}
	
	// adding new book handler
	
	@PostMapping("/books")
	public Books addBook(@RequestBody Books book) {
		
		Books b = this.bookService.addBook(book);
		System.out.println("Book is added");
		return b;
	}
	
	// delete book handler
	
	@DeleteMapping("/books/{bookid}")
	public void deleteBook(@PathVariable("bookid") int bookid) {
		
		this.bookService.deleteBook(bookid);
		System.out.println("Book is deleted");

	}
	
	// update book handler
	
	@PutMapping("/books/{bookid}")
	public Books updateBook(@RequestBody Books book , @PathVariable("bookid") int bookid) {
		
		this.bookService.updateBook(book, bookid);
		return book;
	}
}
