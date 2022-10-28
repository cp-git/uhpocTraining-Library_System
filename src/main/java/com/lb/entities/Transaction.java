package com.lb.entities;

import java.sql.Date;

public class Transaction {

	private int bk_id;
	private int trans_id;
	private String mem_id;
	private String mem_status;
	private Date _date;
	private int bookId;
	private String memberId;
	private String memberStatus;

	@Override
	public String toString() {
		return "Transaction [bk_id=" + bk_id + ", trans_id=" + trans_id + ", mem_id=" + mem_id + ", mem_status="
				+ mem_status + ", _date=" + _date + "]";
	}

//	public Transaction(int bk_id, String mem_id, String mem_status, Date _date) {
//		super();
//		this.bk_id = bk_id;
//		this.mem_id = mem_id;
//		this.mem_status = mem_status;
//		this._date = _date;
//	}

	public int getBk_id() {
		return bk_id;
	}

	public Transaction(int trans_id, int bk_id, String mem_id, String mem_status, Date _date) {
		super();
		this.bk_id = bk_id;
		this.trans_id = trans_id;
		this.mem_id = mem_id;
		this.mem_status = mem_status;
		this._date = _date;
	}

	public Transaction(int bk_id, String mem_id, String mem_status) {
		this.bk_id = bk_id;
		this.mem_id = mem_id;
		this.mem_status = mem_status;
	}

	//////////////////////////////////////
	public Transaction(int trans_id2, int bk_id2, String mem_id2, String mem_status2, java.util.Date date) {
		// TODO Auto-generated constructor stub
	}

	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public void setBk_id(int bk_id) {
		this.bk_id = bk_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_status() {
		return mem_status;
	}

	public void setMem_status(String mem_status) {
		this.mem_status = mem_status;
	}

	public Date get_date() {
		return _date;
	}

	public void set_date(Date _date) {
		this._date = _date;
	}

}
