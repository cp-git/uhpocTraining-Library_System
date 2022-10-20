package com.lb.impl;

import java.util.HashMap;
import java.util.List;

import com.lb.entities.Member;
import com.lb.repo.MemRepo;
import com.lb.serv.MemServ;

public class MemServImpl implements MemServ {

	MemRepo memRepo = new MemRepo();
	HashMap<Long, Member> memHash = new HashMap<Long, Member>();

	public void createMember(Member member) {
		// TODO Auto-generated method stub
		MemRepo memRepo = new MemRepo();
		memRepo.insertMember(member);

	}

	public List<Member> getMemberDetails() {
		// TODO Auto-generated method stub
		memRepo.getMemberDetails();

		return null;
	}

	public HashMap<Long, Member> display() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		for (Member member : memRepo.getMemberDetails()) {

//			Long map_ph_no = Long.valueOf(member.getMem_phno());
			memHash.put(member.getMem_phno(), member);

		}

		return memHash;
	}

	public boolean isCacheEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
