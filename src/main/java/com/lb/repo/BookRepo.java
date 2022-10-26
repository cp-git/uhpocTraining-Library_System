package com.lb.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lb.entities.Book;
import com.lb.exception.CPException;
import com.lb.jdbc.DBManager;

public class BookRepo {
	DBManager dbm = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static void main(String args[]) {

		BookRepo bookRepo = new BookRepo();
		System.out.println(bookRepo.getLastBookId());
	}

	public int insertBook(Book book) {
		System.out.println("inside insertbook in bookrepo");
		DBManager dbm = null;
		int bookId = 0;
		try {
			dbm = DBManager.getDBManager();
		} catch (CPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		String insertQuery = "INSERT INTO book ( bk_name , bk_author) VALUES (?,?)";
		PreparedStatement ps = null;
		try {
			con = dbm.getConnection();
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, book.getBk_name());
			ps.setString(2, book.getBk_author());

			ps.execute();
			bookId = getLastBookId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbm.closeConnection(con);
		}
		return bookId;
	}

//public int getBookId(int bk_id) throws CPException, SQLException {
//	
//		dbm = DBManager.getDBManager();
//		con = dbm.getConnection();
//		stmt = con.createStatement();
//		
//		rs = stmt.executeQuery("select bk_id from book " );
//	
//	while(rs.next())
//	{
//			int BookId = rs.getInt("bk_id");
//
///
//
//			
//		return BookId;
//	}
//	return 0;

	public int getLastBookId() {
		int bkId;
		String insertQuery = "select max(bk_id) from book";
		try {
			dbm = DBManager.getDBManager();
			con = dbm.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(insertQuery);
			while (rs.next()) {
				return bkId = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			dbm.closeConnection(con);
		}
		return 0;
	}

	public List<Book> getBookDetails() {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<Book>();
		String DataQuery = "Select * from book";
		try {
			dbm = DBManager.getDBManager();
		} catch (CPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			con = dbm.getConnection();
			ps = con.prepareStatement(DataQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				int bkId = rs.getInt("bk_id");
				String bookName = rs.getString("bk_name");
				String bookAuthor = rs.getString("bk_author");

				Book bk = new Book(bkId, bookName, bookAuthor);

				bookList.add(bk);
				// System.out.println(customer);

			} // while--Loop Close

		} // try block close
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbm.closeConnection(con);

		}
		return bookList;
	}

}