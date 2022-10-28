package com.lb.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
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
		// TransServ transserv = new TransServImpl();

		memHash = memServ.display();
		// System.out.println(memHash);

		bookHash = bookServ.display1();
//		System.out.println(bookHash);
	}

	public static void main(String[] args) throws CPException, Exception {

		loadCache();

		while (true) {
			System.out.println("============= Main Menu ============");
			System.out.println("1. Add Book Details");
			System.out.println("2. Add Library Member");
			System.out.println("3. Book Transaction");
			System.out.println("4. Display Member Record");
			System.out.println("5. Exit");
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

							// int bookId = bookServ.createBook(book);
//							System.out.println(book);
//							System.out.println(bookId);
//							book.setBk_id(bookId);
//							 
//							 book.setBk_id(bk_id);
							// bookHash.put(book.getBk_name(), book.getBk_author());
							bookHash.put(bookName, book);
//								bookHash.put(bookName, book);

							System.out.println("Book inserted successfully");

						}

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

//						System.out.println(memId + " " + memName + " " + memAddrs + " " + memAddrs + " " + memCity + " "
//								+ memPhno + " ");
//						

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
					System.out.println(
							" Do you want add another member[Y]es or [N]o?\n Press any other key for main menu");
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

						BookServ bookServ = new BookServImpl();
						System.out.println("Enter Member ID");

						String memId = sc1.next();
						System.out.println("Enter Member PhoneNumber");
						long memPhno = sc1.nextLong();

						// System.out.println(memId + " " + memPhno);
						Member member = memHash.get(memPhno);
						java.util.Date today = new java.util.Date();
						java.sql.Date sqlDate = new java.sql.Date(today.getTime());
						System.out.println(sqlDate);
						if (memHash.containsKey(memPhno)) {

							TransServ transserv = new TransServImpl();
							transHash = transserv.display(memId);

							if (transHash.isEmpty()) {

								System.out.println("Enter Book Name");
								String bookName = sc1.next();

								// book exist
								if (bookHash.containsKey(bookName)) {

									Book book = bookHash.get(bookName);

									int bookId = book.getBk_id();

									System.out.println("book allotted successfully");

									String memberId = member.getMem_id();

									Transaction trans = new Transaction(bookId, memberId, "Lending");
									transserv.CreateTrans(trans);

									transHash.add(trans);
								}
								// book not exist
								else {
									System.out.println("book not exist");

								}
							}
							// transaction cache not empty
							else {

								Transaction trans = null;
								for (Transaction transaction : transHash) {
									trans = transaction;
								}
								// System.out.println(trans);
								String status = trans.getMem_status();
								if (status.equals("Return")) {
									// book exist
									System.out.println("Enter Book Name");
									String bookName = sc1.next();
									if (bookHash.containsKey(bookName)) {

										Book book = bookHash.get(bookName);
										int bookId = book.getBk_id();
										System.out.println("book allotted successfully");

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
									System.out.println(
											"Do you want to return a book? [Y]es or [N]o?\\n Press any other key for main menu");
									String ch = sc1.next();
									if (ch.equals("Y") || ch.equals("y")) {

										int bookId = trans.getBk_id();
										String memberId = member.getMem_id();

										Transaction transaction = new Transaction(bookId, memberId, "Return");
										transserv.CreateTrans(transaction);
										transHash.add(transaction);
										// System.out.println(transHash);
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
							" Do you want to create another transaction[Y]es or [N]o?\n Press any other key for main menu");
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
				while (true) {

					try {
						MemServ memServ = new MemServImpl();
						memHash = memServ.display();
						BookServ bookServ = new BookServImpl();
						System.out.println("Enter Member ID");
						String memId = sc1.next();
						System.out.println("Enter Member PhoneNumber");
						long memPhno = sc1.nextLong();

						// System.out.println(memId + " " + memPhno + " ");

						if (memHash.containsKey(memPhno)) {
							FileReader fr = new FileReader("src/main/resources/LibraryInfo.properties");
							Properties props = new Properties();
							props.load(fr);
							/// Member cache
							Member member = memHash.get(memPhno);
							member.getMem_name();

							// Transaction cache
							TransServ trans = new TransServImpl();
							transHash = trans.display(memId);

							// System.out.println(transHash);

							System.out.println(member.getMem_name());

							System.out.println();

							System.out.println(
									"--------------------------------------------------------------------------------------------------");
							System.out.println("                             " + props.getProperty("libraryName")
									+ "										     ");
							System.out.println("				 	" + props.getProperty("libraryCity")
									+ "											 ");
							System.out.println("			  	     " + props.getProperty("libraryState")
									+ "											 ");
							System.out.println(" ");
							System.out.println("Name 	   :" + member.getMem_name());
							System.out.println("Member ID   :" + member.getMem_id());
							System.out.println("Address     :" + member.getMem_addrs());
							System.out.println("Address 2   :" + member.getMem_addrs2());
							System.out.println("City        :" + member.getMem_city());
							System.out.println("Phone       :" + member.getMem_phno());
							System.out.println();

							for (Transaction transaction : transHash) {
								int bookId = transaction.getBk_id();

								System.out.println();
								Book book = bookServ.getBookNameById(bookId);

								System.out.println("Status :" + transaction.getMem_status());
								System.out.println("Name of the book :" + book.getBk_name());
								System.out.println("Author of the book :" + book.getBk_author());
								System.out.println("Book ID :" + transaction.getBk_id());
								System.out.println("Date  :" + transaction.get_date());

							}

							break;
						} else {

							System.out.println("Member in not exist");
							// System.out.println(prodCache);
						}

					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
					System.out.println(" Do you want to continue [Y]es or [N]o?\n Press any other key for main menu");
					String ch = sc1.next();
					sc1.nextLine();
					if (ch.equals("Y") || ch.equals("y")) {
						continue;
					} else {
						break;
					}
				}
				break;

			case 5:

				System.out.println("Please enter options between 1 to 4 ");
				break;
			}
		}

	}

}
