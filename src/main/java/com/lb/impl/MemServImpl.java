package com.lb.impl;

import java.util.HashMap;
import java.util.List;

import com.lb.entities.Book;
import com.lb.entities.Member;
import com.lb.repo.BookRepo;
import com.lb.repo.MemRepo;
import com.lb.serv.MemServ;

public class MemServImpl implements MemServ {

	MemRepo memRepo = new MemRepo();
	HashMap <String ,Member> memHash = new HashMap<String ,Member>();
	public void createMember(Member member) {
		// TODO Auto-generated method stub
		MemRepo memRepo = new MemRepo();
		memRepo.insertMember(member);
		
		
	}

	public List<Member> getMemberDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, Member> display() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isCacheEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
