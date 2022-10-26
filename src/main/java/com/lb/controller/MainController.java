package com.lb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	private static HashMap<String, Book> bookHash = new HashMap<String, Book>();
	private static HashMap<Long, Member> memHash = new HashMap<Long, Member>();
	private static List<Transaction> transHash = new ArrayList<>();

	private static void loadCache() {
		BookServ bookServ = new BookServImpl();
		MemServ memServ = new MemServImpl();
		TransServ transserv = new TransServImpl();

		memHash = memServ.display();
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(memHash);

		bookHash = bookServ.display1();
//		System.out.println(bookHash);
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
						// bookHash = bookServ.display1();
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

							int bookId = bookServ.createBook(book);
							System.out.println(book);
							System.out.println(bookId);
							book.setBk_id(bookId);
//							 
//							 book.setBk_id(bk_id);
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

							System.out.println("Member inserted successfully");
							// System.out.println(prodCache);
						}

					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
					System.out.println(" [Y]es or [N]o?\n Press any other key for main menu");
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

//						TransServ transserv = new TransServImpl();
//						transHash = transserv.display("MEM006");
//						System.out.println(transHash);
						BookServ bookServ = new BookServImpl();
						System.out.println("Enter Member ID");
						String memId = sc1.next();
						System.out.println("Enter Member PhoneNumber");
						long memPhno = sc1.nextLong();

						System.out.println(memId + "  " + memPhno);
						Member member = memHash.get(memPhno);
						java.util.Date today = new java.util.Date();
						java.sql.Date sqlDate = new java.sql.Date(today.getTime());
						System.out.println(sqlDate);
						if (memHash.containsKey(memPhno)) {

							TransServ transserv = new TransServImpl();
							transHash = transserv.display(memId);

							System.out.println("kaushik" + transHash);
							if (transHash.isEmpty()) {

								System.out.println("Enter Book Name");
								String bookName = sc1.next();

								// book exist
								if (bookHash.containsKey(bookName)) {

									Book book = bookHash.get(bookName);

									int bookId = book.getBk_id();

									System.out.println("Book is exist");

									String memberId = member.getMem_id();

									Transaction trans = new Transaction(bookId, memberId, "Lending");
									transserv.CreateTrans(trans);

									transHash.add(trans);
								}
								// book not exist
								else {
									System.out.println("book not exist");
									continue;
								}
							}
							// transaction cache not empty
							else {

								Transaction trans = null;
								for (Transaction transaction : transHash) {
									trans = transaction;
								}
								System.out.println(trans);
								String status = trans.getMem_status();
								if (status.equals("Return")) {
									// book exist
									System.out.println("Enter Book Name");
									String bookName = sc1.next();
									if (bookHash.containsKey(bookName)) {

										Book book = bookHash.get(bookName);
										int bookId = book.getBk_id();
										System.out.println("Book is exist");

										String memberId = member.getMem_id();

										Transaction transaction = new Transaction(bookId, memberId, "Lending");
										transserv.CreateTrans(transaction);
										transHash.add(transaction);

									}
									// book not exist
									else {
										System.out.println("Book is not available");
									}
								} else if (status.equals("Lending")) {
									System.out.println("Do you want to return a book?");
									String ch = sc1.next();
									if (ch.equals("Y") || ch.equals("y")) {
										System.out.println("inside");
										int bookId = trans.getBk_id();
										String memberId = member.getMem_id();

										Transaction transaction = new Transaction(bookId, memberId, "Return");
										transserv.CreateTrans(transaction);
										transHash.add(transaction);
										System.out.println(transHash);
									} else {
										break;
									}
								}

							}

						} else {

							System.out.println("Member Does not Exist");

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
