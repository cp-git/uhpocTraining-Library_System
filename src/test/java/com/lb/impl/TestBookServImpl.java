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

//	@Test
//	public List<Book> getBookDetails() {
//		Book book = new Book("harry", "potter");
//
//		bookList = bookServ.getBookDetails();
//
//		Book bk = bookList.get(0);
//		assertEquals(bk.getBk_name(), bk.getBk_author());
//		// equals(bk.getBk_id());
//		assertEquals(bk.getBk_id());
//
//	}

	@Test
	public void testBookHash() {

		HashMap<String, Book> bookHash = bookServ.display1();
		Book bk = bookHash.get("harry");
		assertEquals(bk.getBk_name(), bk.getBk_author());

	}

	@After
	public void tearDown() throws Exception {
		dbm.closeConnection(con);
	}

}
