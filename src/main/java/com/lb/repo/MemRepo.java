package com.lb.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lb.entities.Book;
import com.lb.entities.Member;
import com.lb.exception.CPException;
import com.lb.jdbc.DBManager;

public class MemRepo {

	public void insertMember(Member member)  {
	DBManager dbm = null;
	try {
		dbm = DBManager.getDBManager();
	} catch (CPException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Connection con = null;
	String insertQuery = "INSERT INTO member ( mem_id , mem_name , mem_addrs , mem_addrs2 , mem_city, mem_phno) VALUES (?,?,?,?,?,?)";
	PreparedStatement psmt = null;
	try {
		System.out.println(member.getMem_id() + " " + member.getMem_name()+ " "+member.getMem_addrs()+" "+member.getMem_addrs2()+" "+member.getMem_city()+" "+member.getMem_phno()+" ");
		
		con = dbm.getConnection();
		psmt = con.prepareStatement(insertQuery);
		psmt.setString(1, member.getMem_id());
		psmt.setString(2, member.getMem_name());
		psmt.setString(3, member.getMem_addrs());
		psmt.setString(4, member.getMem_addrs2());
		psmt.setString(5, member.getMem_city());
		psmt.setLong(6, member.getMem_phno());
		
		psmt.execute();
		con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public List <Member> getMember() throws CPException {
		DBManager dbm = DBManager.getDBManager();
		Connection con = null;
		con = dbm.getConnection();
		String dataQuery = "select * from member ";
		Statement stmt = null;
		List<Member> listMember = new ArrayList<Member>();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(dataQuery);
			while (rs.next()) {
				//int bk_Id = rs.getInt("bk_id");
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memAddrs = rs.getString("mem_addrs");
				String memAddrs2 = rs.getString("mem_addrs2");
				String memCity = rs.getString("mem_city");
				Long memPhno = rs.getLong("mem_phno");
				
				Member mem = new Member( memId , memName , memAddrs , memAddrs2 , memCity , memPhno);
				listMember.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMember;
	}
			
		
	
}
