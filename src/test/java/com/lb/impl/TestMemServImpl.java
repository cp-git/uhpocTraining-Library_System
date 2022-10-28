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

import com.lb.entities.Member;
import com.lb.jdbc.DBManager;
import com.lb.serv.MemServ;

public class TestMemServImpl {

	private static MemServ memServ = null;
	static HashMap<String, Member> memHash = null;
	static DBManager dbm = null;
	static Connection con = null;
	static List<Member> memList = null;
//	List<Book> bookList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
		memServ = new MemServImpl();
		// memHash = new HashMap<Long, Member>();
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
	public void display() {

		Member mem = new Member("MEM009", "kaushik", "kharadi", " vimannagar", " pune", 7038956565L);

		memList = memServ.getMemberDetails();

		Member member = memList.get(0);
		assertEquals(member.getMem_id(), mem.getMem_id());
		assertEquals(member.getMem_phno(), mem.getMem_phno());
		assertEquals(member.getMem_addrs(), mem.getMem_addrs());

	}

	@Test
	public void testmemHash() {

		HashMap<Long, Member> memHash = memServ.display();

		Member mem = memHash.get(0);
		assertEquals(mem.getMem_id(), mem.getMem_name(), mem.getMem_phno());

	}

	@After
	public void tearDown() throws Exception {
		dbm.closeConnection(con);
		System.gc();
	}

}
