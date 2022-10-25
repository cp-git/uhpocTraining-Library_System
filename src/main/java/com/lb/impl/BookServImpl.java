package com.lb.impl;

import java.util.HashMap;
import java.util.List;

import com.lb.entities.Book;
import com.lb.repo.BookRepo;
import com.lb.serv.BookServ;

public class BookServImpl implements BookServ {

	BookRepo bookRepo = new BookRepo();
	HashMap<String, Book> bookHash = new HashMap<String, Book>();

	public HashMap<String, Book> display1() {
		// TODO Auto-generated method stub

		for (Book book : bookRepo.getBookDetails()) {
			bookHash.put(book.getBk_name(), book);
		}
		return bookHash;
	}

	public boolean isCacheEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Book> getBookDetails() {
		return bookRepo.getBookDetails();
	}

	public void createBook(Book book) {

		BookRepo bookRepo = new BookRepo();
		bookRepo.insertBook(book);
	}

}