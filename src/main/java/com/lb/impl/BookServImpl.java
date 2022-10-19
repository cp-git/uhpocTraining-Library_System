package com.lb.impl;

import java.util.HashMap;
import java.util.List;

import com.lb.entities.Book;
import com.lb.exception.CPException;
import com.lb.repo.BookRepo;
import com.lb.serv.BookServ;

public class BookServImpl implements BookServ {

	BookRepo bookRepo = new BookRepo();
	HashMap <String ,Book> bookHash = new HashMap<String ,Book>();

	public HashMap<String, Book> display() {
		// TODO Auto-generated method stub
		
		try {
			for (Book book : bookRepo.getBookDetails()) {
				bookHash.put(book.getBk_name(), book);
			}
		} catch (CPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookHash;
	}

	public boolean isCacheEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

//	public  createBook(Book book) {
//		// TODO Auto-generated method stub
//		BookRepo bookRepo = new BookRepo();
//		bookRepo.insertBook(book);
//		
//	}

	public List<Book> getBookDetails() {
		// TODO Auto-generated method stub
		try {
			return bookRepo.getBookDetails();
		} catch (CPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getBookDetails();
	}
	
//	public void create(Book book) {
//		BookRepo bookRepo = new BookRepo();
//		bookRepo.insert(book);
//	}

	public void createBook(Book book) {
		// TODO Auto-generated method stub
		BookRepo bookRepo = new BookRepo();
		bookRepo.insertBook(book);
	}

	
	
}