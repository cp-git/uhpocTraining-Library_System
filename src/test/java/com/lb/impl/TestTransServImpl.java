package com.lb.impl;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lb.entities.Transaction;
import com.lb.jdbc.DBManager;
import com.lb.serv.TransServ;

public class TestTransServImpl {

	private static TransServ transServ = null;

	static DBManager dbm = null;
	static Connection con = null;
	static List<Transaction> transList = null;
	List<Transaction> tranList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
		transServ = new TransServImpl();

		dbm = DBManager.getDBManager();
		// expList = new ArrayList<>();
	}

	@Before
	public void setUp() throws Exception {
		con = dbm.getConnection();
	}

	@Test
	public void getalltransDetailsbyId() {

		Transaction trans = new Transaction(0, 0, null, null, null);
		transList = transServ.getalltransDetailsbyId("MEM010");

	}

	@Test
	public void testDisplay() {
		List<Transaction> transHash = transServ.display("MEM010");

		Transaction trans = transHash.get(0);

		// Transaction trasaction = new Transaction(14, 36, "MEM006", "Lending",
		// 2022-10-26");

	}

	@After
	public void tearDown() {
		dbm.closeConnection(con);
	}
}
