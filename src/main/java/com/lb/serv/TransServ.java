package com.lb.serv;

import java.util.List;

import com.lb.entities.Transaction;

public interface TransServ {

	void CreateTrans(Transaction trans);

	List<Transaction> getalltransDetailsbyId(String memId);

	public List<Transaction> display(String memId);

	boolean isCacheEmpty();

}
