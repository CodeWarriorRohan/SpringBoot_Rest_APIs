package com.spring.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.Entity.Books;
import com.spring.Repository.BookRepository;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	
//	private static List<Books> list = new ArrayList<>();
//	
//	static {
//		list.add(new Books(2, "Advance Java", "ABC"));
//		list.add(new Books(3, "C++", "ABC"));
//		list.add(new Books(4, "Think Java", "ABC"));
//		list.add(new Books(5, "Python", "ABC"));
//
//	}
	
	// get all books
	
	public List<Books> getAllBooks(){
		List<Books> list = (List<Books>)this.bookRepo.findAll();
		return list;
	}
	
	// get single book by Id
	
	public Books getBookById(int id) {
		Books book = null;
		
		// book = list.stream().filter(e->e.getId()==id).findFirst().get();
		
		book = this.bookRepo.findById(id);
		
		return book;
	}
	
	
	// adding the book test can be only on Postman
	
	public Books addBook(Books b) {
		// list.add(b);
		
		Books book = bookRepo.save(b);
		return book;
	}
	
	// delete book by id test can be only on Postman
	
	public void deleteBook(int bid) {
		
		//list = list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		bookRepo.deleteById(bid);
	}
	
	// update the book test can be only on Postman
	
	public void updateBook(Books book, int bookid) {
		
//		list = list.stream().map(b->{
//			
//			if(b.getId() == bookid) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookid);
		
		bookRepo.save(book);
	}
}
