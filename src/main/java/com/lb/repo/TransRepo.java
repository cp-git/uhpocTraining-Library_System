package com.lb.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lb.entities.Transaction;
import com.lb.exception.CPException;
import com.lb.jdbc.DBManager;

public class TransRepo {

//	DBManager dbManager = DBManager.getDBManager();
	DBManager dbm = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void addTransDetails(Transaction trans) throws CPException {
		dbm = DBManager.getDBManager();
		con = dbm.getConnection();

		// String
		String insertTrans = "INSERT INTO transaction(bk_id ,mem_id ,mem_status) VALUES(?,?,?)";

		try {

			ps = con.prepareStatement(insertTrans);
			// ps.setInt(1, trans.getTrans_id());
			ps.setInt(1, trans.getBk_id());
			ps.setString(2, trans.getMem_id());
			ps.setString(3, trans.getMem_status());

//			ps.setInt(1, trans.getTrans_id());
//			ps.setInt(2, trans.getBk_id());
//			ps.setString(3, trans.getMem_id());
//			ps.setString(4, trans.getMem_status());
//			ps.setDate(5, trans.get_date());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbm.closeConnection(con);
		}

	}

//	public List<Transaction> addtransDetails() {
//
//		List<Transaction> transaction = new ArrayList<Transaction>();
//		String DataQuery = "Select * from transaction ";
//
//		try {
//
//			con = dbm.getConnection();
//			ps = con.prepareStatement(DataQuery);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//
//				int transId = rs.getInt("trans_id");
//				int bkId = rs.getInt("bk_id");
//				String memId = rs.getString("mem_id");
//				String memStatus = rs.getString("mem_status");
//				Date transDate = rs.getDate("date");
//
//				Transaction trans = new Transaction(transId, bkId, memId, memStatus, transDate);
//				transaction.add(trans);
//
//				System.out.println(transaction);
//
//			} // while--Loop Close
//
//		} // try block close
//		catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			dbm.closeConnection(con);
//
//		}
//		return transaction;
//
//	}

	public List<Transaction> getalltransDetailsbyId(String memId) {
		List<Transaction> allTransDetails = new ArrayList<Transaction>();

		String getQuery = "SELECT * from transaction where mem_id=? ORDER BY trans_id";
		try {
			dbm = DBManager.getDBManager();
		} catch (CPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con = dbm.getConnection();

			ps = con.prepareStatement(getQuery);
			ps.setString(1, memId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int transId = rs.getInt("trans_id");
				int bkId = rs.getInt("bk_id");
				String memStatus = rs.getString("mem_status");
				Date transDate = rs.getDate("date");

				Transaction trans = new Transaction(transId, bkId, memId, memStatus, transDate);
				allTransDetails.add(trans);

				// System.out.println("@@@@@@@@@@@@@@@@@@@@@@@" + allTransDetails);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbm.closeConnection(con);
		}

		return allTransDetails;
	}

}