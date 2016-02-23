package com.bank.web.domain;

import org.springframework.stereotype.Component;

@Component
public class MemberVO {
	private String userid;
	private String name;
	private String password;
	private String addr;
	private int birth;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "회원정보 [id=" + userid + ", 이름=" + name + ", 비번=" + password + ", 주소=" + addr
				+ ", 생년월일=" + birth + "]";
	}
	
}
