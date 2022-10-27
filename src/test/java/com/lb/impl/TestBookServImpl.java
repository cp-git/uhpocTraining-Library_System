package com.lb.impl;

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
import com.lb.jdbc.DBManager;
import com.lb.serv.BookServ;

public class TestBookServImpl {

	private static BookServ bookServ = null;
	static HashMap<String, Book> bookHash = null;
	static DBManager dbm = null;
	static Connection con = null;
	static List<Book> bookList = null;
//	List<Book> bookList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
		bookServ = new BookServImpl();
		bookHash = new HashMap<String, Book>();
		dbm = DBManager.getDBManager();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		con = dbm.getConnection();
	}

	@Test
	public void testGetBookDetails() {

		bookList = bookServ.getBookDetails();
		Book book = bookList.get(0);

		Book bk = new Book(1, "abc", "xyz");

		assertEquals(bk.getBk_name(), book.getBk_name());
		assertEquals(bk.getBk_author(), book.getBk_author());

	}

	@Test
	public void testdisplay1() {

		HashMap<String, Book> bookHash = bookServ.display1();
		Book bk = bookHash.get("harry");

		Book book = new Book(21, "harry", "potter");
		assertEquals(bk.getBk_name(), book.getBk_name());
		assertEquals(bk.getBk_author(), book.getBk_author());

	}

	@After
	public void tearDown() throws Exception {
		dbm.closeConnection(con);
	}

}
