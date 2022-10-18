package com.lb.serv;

import java.util.HashMap;
import java.util.List;

import com.lb.entities.Book;

public interface BookServ {
	
	void createBook(Book book);
	List<Book>  getBookDetails();
	HashMap<String, Book> display();
	boolean isCacheEmpty();
	//void create(Book book);
	

}
