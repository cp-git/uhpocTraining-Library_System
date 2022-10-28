package com.lb.repo;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lb.entities.Book;
import com.lb.impl.BookServImpl;
import com.lb.jdbc.DBManager;
import com.lb.serv.BookServ;

public class TestBookRepo {

	static BookRepo bookRepo;
	static BookServ bookServ;
	static HashMap<String, Book> BookHash = null;
	static DBManager dbm = null;
	static Connection con = null;
	static List<Book> bookList = null;
	List<Book> consumerList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
		bookRepo = new BookRepo();
		bookServ = new BookServImpl();
		BookHash = new HashMap<String, Book>();
		dbm = DBManager.getDBManager();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		con = dbm.getConnection();
	}

	@After
	public void tearDown() throws Exception {
		dbm.closeConnection(con);
	}

//
	@Test

	public void getBookDetails() {
		Book book = new Book("harry", "potter");
		book.getBk_name();
		bookList = bookServ.getBookDetails();
		Book Bk = bookList.get(0);
		// assertEquals(book.getBk_id());

	}

	@Test
	public void TestBookHash() {

		Book book = new Book("harry", "potter");
		book.getBk_name();
		book.getBk_author();
		System.out.println(book);
		HashMap<String, Book> bookHash = bookServ.display1();

		Book bk = bookHash.get("harry");
		assertEquals(bk.getBk_name(), bk.getBk_id(), bk.getBk_author());

	}
}
