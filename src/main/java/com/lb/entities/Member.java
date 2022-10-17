package com.lb.entities;

public class Member {

	private String mem_id;
	private String mem_name;
	private String mem_addrs;
	@Override
	public String toString() {
		return "Member [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_addrs=" + mem_addrs + ", mem_addrs2="
				+ mem_addrs2 + ", mem_city=" + mem_city + ", mem_phno=" + mem_phno + "]";
	}
	public Member(String mem_id, String mem_name, String mem_addrs, String mem_addrs2, String mem_city, int mem_phno) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_addrs = mem_addrs;
		this.mem_addrs2 = mem_addrs2;
		this.mem_city = mem_city;
		this.mem_phno = mem_phno;
	}
	private String mem_addrs2;
	private String mem_city;
	private int mem_phno;
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_addrs() {
		return mem_addrs;
	}
	public void setMem_addrs(String mem_addrs) {
		this.mem_addrs = mem_addrs;
	}
	public String getMem_addrs2() {
		return mem_addrs2;
	}
	public void setMem_addrs2(String mem_addrs2) {
		this.mem_addrs2 = mem_addrs2;
	}
	public String getMem_city() {
		return mem_city;
	}
	public void setMem_city(String mem_city) {
		this.mem_city = mem_city;
	}
	public int getMem_phno() {
		return mem_phno;
	}
	public void setMem_phno(int mem_phno) {
		this.mem_phno = mem_phno;
	}
}
