package com.lb.repo;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.lb.entities.Book;
import com.lb.impl.MemServImpl;
import com.lb.jdbc.DBManager;
import com.lb.serv.MemServ;

public class TestMemRepo {
	private static MemRepo memRepo;
	private static MemServ memServ;
	static HashMap<String, Book> memHash = null;
	static DBManager dbm = null;
	static Connection con = null;
	static List<Book> bookList = null;
	List<Book> consumerList = null;

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

	@After
	public void tearDown() throws Exception {
		dbm.closeConnection(con);
	}

//	@Test
//	
//	public List<Member> getMemberDetails()
//	{
//		Book book=new Book("abhi","");
//		try {
//			int LastConsumerId=consumerRepo.getlastConsumerId();
//			List<Member> MemberDetails = memRepo.getMemberDetails();
//			
//		
//			
//			
//		} catch (CPException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

//	@Test
//	public void MemberCache() {
//		
//		Member mem = new Member("MEM009", "kaushik", "kharadi", " vimannagar", " pune", 7038956565);
//
//		HashMap<Long, Member> memHash = memServ.display();
//
//		Member member = memHash.get(0);
//		assertEquals(member.getMem_id());
//		assertEquals(member.getMem_name());
//		assertEquals(member.getMem_phno(), member.getMem_addrs(),member.getMem_addrs2());
//	
//		
//		
//	}

}
