package com.lb.controller;

import java.util.Scanner;

import com.lb.exception.CPException;
import com.lb.jdbc.DBManager;

public class MainController {

//	private HashMap<String, Customer> custCache = null;
//	private HashMap<String, Customer> deptCache = null;
//	private HashMap<String, Customer> prodCache = null;

//	public MainMenu() {
////		initCache();
//	}

	public static void main(String[] args) throws CPException {

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
				
				
				break;
			case 2:
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
