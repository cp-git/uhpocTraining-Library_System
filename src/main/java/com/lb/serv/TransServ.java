package com.lb.serv;

import java.util.HashMap;
import java.util.List;

import com.lb.entities.Transaction;

public interface TransServ {

	void CreateTrans(Transaction trans);

	List<Transaction> getalltransDetailsbyId(String memId);

	public HashMap<String, Transaction> display(String memId);

	boolean isCacheEmpty();

}
