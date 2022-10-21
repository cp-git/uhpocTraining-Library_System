package com.lb.impl;

import java.util.HashMap;
import java.util.List;

import com.lb.entities.Member;
import com.lb.entities.Transaction;
import com.lb.exception.CPException;
import com.lb.repo.TransRepo;
import com.lb.serv.TransServ;

public class TransServImpl implements TransServ {

	HashMap<String, Transaction> transHash = new HashMap<String, Transaction>();
	TransRepo transRepo = new TransRepo();

	public void CreateTrans(Transaction trans) {

		TransRepo transRepo = new TransRepo();
		try {
			transRepo.insertTrans(trans);
		} catch (CPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Transaction> getalltransDetailsbyId(String memId) {

		List<Transaction> translist = transRepo.getalltransDetailsbyId(memId);
		return translist;
	}
	// HashMap<Integer, Invoice> display();

	public boolean isCacheEmpty() {
		return false;
	}

	public void createMember(Member member) {
		// TODO Auto-generated method stub

	}

	public List<Member> getMemberDetails() {
		// TODO Auto-generated method stub
		return null;
	}

//	public HashMap<String, Transaction> display() {
//		// TODO Auto-generated method stub
//
//		for (Transaction trans : transRepo.getalltransDetailsbyId(memId)) {
//			List<Transaction> allTransDetails = transRepo.getalltransDetailsbyId(memId);
//			// memHash.put(member.getMem_phno(), member);
//
//		}
//		return null;
//	}
}
