package com.lb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.lb.entities.Book;
import com.lb.entities.Member;
import com.lb.exception.CPException;
import com.lb.impl.BookServImpl;
import com.lb.impl.MemServImpl;
import com.lb.jdbc.DBManager;
import com.lb.jdbc.MessageBundle;
import com.lb.serv.BookServ;
import com.lb.serv.MemServ;

public class MainController {

//	private HashMap<String, Customer> custCache = null;
//	private HashMap<String, Customer> deptCache = null;
//	private HashMap<String, Customer> prodCache = null;
	
	private static HashMap<String , Book> bookHash = new HashMap<String, Book>();
	private static HashMap<String ,Member> memHash = new HashMap<String , Member>();
	
	private static void loadCache()
	{
		BookServ bookServ = new BookServImpl();
		MemServ memServ = new MemServImpl();
		memHash = memServ.display();
		System.out.println(memServ);
		
		bookHash = bookServ.display();
		System.out.println(bookHash);
	}
//	public MainMenu() {
////		initCache();
//	}

	public static void main(String[] args) throws CPException {
		//MessageBundle mb = MessageBundle.getBundle();
		
		if ( (bookHash != null || bookHash.size() == 0)) {
			loadCache();
		}
		while (true) {
			System.out.println("============= Main Menu ============");
			System.out.println("1. Add Book Details");
			System.out.println("2. Add Library Member");
			System.out.println("3. Book Transaction");
			System.out.println("3. Display Member Record");
			System.out.println("4. Exit");
			Scanner sc1 = new Scanner(System.in);
			int option = sc1.nextInt();
			switch (option) {
			case 1:
				
				BookServ bookServ = new BookServImpl();
				bookHash = bookServ.display();
				//System.out.println(bookHash);
				
				System.out.println("Enter Book Name");
				String bookName = sc1.next();
				System.out.println("Enter Book Author");
				String bookAuthor = sc1.next();
				
			
				System.out.println(bookName + " " + bookAuthor);

				
				Book book = new Book(bookName, bookAuthor);
				bookServ.createBook(book);
//				book.setBk_id(12);
				System.out.println(book.toString());
////			
////				book.setBk_id(bk_id);
//			//	bookHash.put(book.getBk_name(), book.getBk_author());
//				bookHash.put(bookName, book);
//				
				break;
			case 2:
				
				MemServ memServ = new MemServImpl();
				memHash = memServ.display();
				
				System.out.println("Enter Member ID");
				String memId = sc1.next();
				System.out.println("Enter Member Name");
				String memName = sc1.next();
				System.out.println("Enter Member Address");
				String memAddrs = sc1.next();
				System.out.println("Enter Member Second Address");
				String memAddrs2 = sc1.next();
				System.out.println("Enter Member City");
				String memCity = sc1.next();
				System.out.println("Enter Member PhoneNumber");
				String memPhno = sc1.next();
				
			
				
				
				break;

			case 3:
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("Please enter options between 1 to 4 ");
				break;
			}
		}

	}

}
