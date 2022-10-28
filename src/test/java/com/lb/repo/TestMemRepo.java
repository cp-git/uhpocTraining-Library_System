package com.lb.repo;

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
import com.lb.entities.Member;
import com.lb.impl.MemServImpl;
import com.lb.jdbc.DBManager;
import com.lb.serv.MemServ;

public class TestMemRepo {
	private static MemRepo memRepo;
	private static MemServ memServ;
	static HashMap<String, Book> memHash = null;
	static DBManager dbm = null;
	static Connection con = null;
	static List<Member> memList = null;
	// List<Member> memList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
		memRepo = new MemRepo();
		memServ = new MemServImpl();
		// memHash = new HashMap<Long , Member>();
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

	public void getMemberDetails() {

		// Member member = new Member(null, null, null, null, null, 0);
		memList = memServ.getMemberDetails();
		Member member = memList.get(5);
		System.out.println(member.toString());
		Member mem = new Member("MEM009", "kaushik", "kharadi", "vimannagar", "pune", 7038956565L);

		assertEquals(member.getMem_phno(), mem.getMem_phno());

	}

	@Test
	public void Display() {

		// Member mem = new Member("MEM009", "kaushik", "kharadi", " vimannagar", "
		// pune", 7038956565);

		HashMap<Long, Member> memHash = memServ.display();
		Member mem = memHash.get("kaushik");

		Member member = new Member("MEM009", "kaushik", "kharadi", "vimannagar", "pune", 7038956565L);
		assertEquals(member.getMem_id(), mem.getMem_id());
		assertEquals(member.getMem_phno(), mem.getMem_phno());
		assertEquals(member.getMem_name(), mem.getMem_name());
		// assertEquals(member.getMem_phno(),
		// member.getMem_addrs(),member.getMem_addrs2());

	}

	@After
	public void tearDown() {
		dbm.closeConnection(con);
		System.gc();
	}

}
