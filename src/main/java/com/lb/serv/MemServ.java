package com.lb.serv;

import java.util.HashMap;
import java.util.List;

import com.lb.entities.Member;

public interface MemServ {

	void createMember(Member member);

	List<Member> getMemberDetails();

	public HashMap<Long, Member> display();

	boolean isCacheEmpty();
}
