package com.lb.impl;

import java.util.HashMap;
import java.util.List;

import com.lb.entities.Book;
import com.lb.repo.BookRepo;
import com.lb.serv.BookServ;

public class BookServImpl implements BookServ {

	BookRepo bookRepo = new BookRepo();
	HashMap <String ,Book> bookHash = new HashMap<String ,Book>();

	public HashMap<String, Book> display() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isCacheEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public int createBook(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Book> getBookDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	
}