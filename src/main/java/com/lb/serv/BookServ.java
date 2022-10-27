package com.lb.serv;

import java.util.HashMap;
import java.util.List;

import com.lb.entities.Book;

public interface BookServ {

	int createBook(Book book);

	List<Book> getBookDetails();

	HashMap<String, Book> display1();

	public int getLastBookId();

	public Book getBookNameById(int bookId);

	boolean isCacheEmpty();
	// void create(Book book);

}
