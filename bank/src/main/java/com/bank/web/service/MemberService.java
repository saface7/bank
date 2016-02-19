package com.bank.web.service;

import java.util.List;

import com.bank.web.domain.MemberBean;

public interface MemberService {
	public String join(MemberBean member);
	public MemberBean searchById(String id);
	public List<MemberBean> searchByName(String name);
	public String remove(String id);
	public int countAll();
	public int searchCountByName(String Name);
	public String login(String id, String pass);
	public String update(MemberBean member);
}
