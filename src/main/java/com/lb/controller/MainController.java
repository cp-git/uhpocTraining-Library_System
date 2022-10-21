package com.lb.controller;

import java.util.HashMap;
import java.util.Scanner;

import com.lb.entities.Book;
import com.lb.entities.Member;
import com.lb.entities.Transaction;
import com.lb.exception.CPException;
import com.lb.impl.BookServImpl;
import com.lb.impl.MemServImpl;
import com.lb.impl.TransServImpl;
import com.lb.serv.BookServ;
import com.lb.serv.MemServ;
import com.lb.serv.TransServ;

public class MainController {

//	private HashMap<String, Customer> custCache = null;
//	private HashMap<String, Customer> deptCache = null;
//	private HashMap<String, Customer> prodCache = null;

	private static HashMap<String, Book> bookHash = new HashMap<String, Book>();
	private static HashMap<Long, Member> memHash = new HashMap<Long, Member>();
	private static HashMap<String, Transaction> transHash = new HashMap<String, Transaction>();

	private static void loadCache() {
		BookServ bookServ = new BookServImpl();
		MemServ memServ = new MemServImpl();
		TransServ transserv = new TransServImpl();

		memHash = memServ.display();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(memHash);

		bookHash = bookServ.display1();
		System.out.println(bookHash);
	}
//	public MainMenu() {
////		initCache();
//	}

	public static void main(String[] args) throws CPException {
		// MessageBundle mb = MessageBundle.getBundle();

		loadCache();

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
				while (true) {

					try {

						BookServ bookServ = new BookServImpl();
						bookHash = bookServ.display1();
						// System.out.println(bookHash);

						System.out.println("Enter Book Name");
						String bookName = sc1.next();
						System.out.println("Enter Book Author");
						String bookAuthor = sc1.next();

						// System.out.println(bookName + " " + bookAuthor);

//				Book book = new Book(bookName, bookAuthor);
//				bookServ.createBook(book)
						// System.out.println(book.toString());

						if (bookHash.containsKey(bookName)) {
							System.out.println("Book is already available");
						} else {
							Book book = new Book(bookName, bookAuthor);

							bookServ.createBook(book);
							// book.setBkId(bkId);
							// book.setBk_id(bk_id);
							// bookHash.put(book.getBk_name(), book.getBk_author());
							bookHash.put(bookName, book);
//								bookHash.put(bookName, book);

							System.out.println("Book inserted successfully");

						}
////				
					} catch (Exception e) {
						e.printStackTrace();
						break;
					}

					System.out.println(
							"Do you want to add another book [Y]es or [N]o?\n Press any other key for main menu");
					String ch = sc1.next();
					sc1.nextLine();
					if (ch.equals("Y") || ch.equals("y")) {
						continue;
					} else {
						break;
					}

				}
				break;
			case 2:

				while (true) {

					try {
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
						long memPhno = sc1.nextLong();

						System.out.println(memId + " " + memName + " " + memAddrs + " " + memAddrs + " " + memCity + " "
								+ memPhno + " ");
//						Member member = new Member(memId, memName, memAddrs, memAddrs2, memCity, memPhno);
//						memServ.createMember(member);

						if (memHash.containsKey(memPhno)) {
							System.out.println("Member is already available");
						} else {

							Member mem = new Member(memId, memName, memAddrs, memAddrs2, memCity, memPhno);
							memServ.createMember(mem);
							mem.getMem_phno();

							memHash.put(memPhno, mem);
//								bookHash.put(bookName, book);

							System.out.println("Member inserted successfully");
							// System.out.println(prodCache);
						}

					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
					System.out.println(
							"Do you want to add another member [Y]es or [N]o?\n Press any other key for main menu");
					String ch = sc1.next();
					sc1.nextLine();
					if (ch.equals("Y") || ch.equals("y")) {
						continue;
					} else {
						break;
					}
				}
				break;

			case 3:

				while (true) {

					try {

						TransServ transserv = new TransServImpl();
						transHash = transserv.d
//					

						System.out.println("Enter Member ID");
						String memId = sc1.next();
						System.out.println("Enter Member Name");
						String memName = sc1.next();
						System.out.println("Enter Member PhoneNumber");
						long memPhno = sc1.nextLong();

						System.out.println(memId + " " + memName + " " + memPhno);
//						Member member = new Member(memId, memName, memAddrs, memAddrs2, memCity, memPhno);
//						memServ.createMember(member);
						java.util.Date today = new java.util.Date();
						java.sql.Date sqlDate = new java.sql.Date(today.getTime());
						System.out.println(sqlDate);
						if (memHash.containsKey(memPhno)) {
							System.out.println("Member is already available");
						} else {

//							Member mem = new Member(memId, memName, memAddrs, memAddrs2, memCity, memPhno);
//							memServ.createMember(mem);
//							mem.getMem_phno();

//							memHash.put(memPhno, mem);
//								bookHash.put(bookName, book);

							System.out.println("Member inserted successfully");
							// System.out.println(prodCache);
						}

					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
					System.out.println(
							"Do you want to add another member [Y]es or [N]o?\n Press any other key for main menu");
					String ch = sc1.next();
					sc1.nextLine();
					if (ch.equals("Y") || ch.equals("y")) {
						continue;
					} else {
						break;
					}
				}
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
