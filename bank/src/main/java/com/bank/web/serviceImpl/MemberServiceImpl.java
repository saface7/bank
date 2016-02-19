package com.bank.web.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.web.domain.MemberBean;
import com.bank.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	MemberBean[] members = new MemberBean[100];
	// 필드
	private MemberBean member;
	private MemberBean[] memberList;
	private Map<String, MemberBean> map;

	public MemberServiceImpl() {
		// 생성자
		member = new MemberBean();
		// memberList = new MemberBean[];
		map = new HashMap<String, MemberBean>();
	}

	public void AdminServiceImpl() {
		//
		members = new MemberBean[100];
	}

	public String join(MemberBean member) {
		// 회원가입
		map.put(member.getUserid(), member);

		return member.getName() + "회원가입을 축하드립니다";
	}

	@Override
	public MemberBean searchById(String id) {
		// 아이디로 회원정보 검색
		return map.get(id);
	}

	@Override
	public List<MemberBean> searchByName(String name) {
		// 이름으로 회원정보 검색
		List<MemberBean> temp = new ArrayList<MemberBean>();
		for (String id : map.keySet()) {
			if (map.get(id).getName().equals(name)) {
				temp.add(map.get(id));
			}
		}
		/*
		 * MemberBean[] tempList = new MemberBean[this.searchCountByName(name)];
		 * int j = 0; for (int i = 0; i < map.size(); i++) { if
		 * (map.get(i).getName().equals(name)) {// string type문자열 비교 tempList[j]
		 * = map.get(i); j++; } }
		 */
		return temp;
	}

	@Override
	public String remove(String id) {
		// 회원탈퇴
		return map.remove(id) != null ? "탈퇴성공" : "탈퇴실패";
	}

	@Override
	public int countAll() {
		// 회원수

		return map.size();
	}

	@Override
	public int searchCountByName(String name) {
		// 이름(동명)으로 회원찾기
		int tempCount = 0;
		for (int i = 0; i < map.size(); i++) {
			if (members[i].getName().equals(name)) {
				tempCount++;
			}
		}
		return tempCount;
	}

	// 에어리어
	@Override
	public String login(String id, String pass) {
		// 로그인
		String result = "";
		if (map.containsKey(id)) {
			result = (map.get(id)).getPassword().equals(pass) ? "로그인 성공" : "로그인 실패";
		}
		// 메소드 체인 기법
		/*
		 * if (map.containsKey(id)) { // 맵에 id가 존재하는지를 먼저 체크한다.
		 * 
		 * if (( map.get(id)).getPassword().equals(pass)) { result = "로그인 성공";
		 * }else{ result = "비밀번호가 일치하지 않습니다"; } } else { result =
		 * "아이디가 존재하지 않거나, 잘못된 아이디 입니다"; }
		 */
		return result;
	}

	@Override
	public String update(MemberBean member) {
		// 정보수정
		map.replace(member.getUserid(), member);
		// String result = "업데이트 실패";
		/*
		 * for (int i = 0; i < map.size(); i++) { (
		 * map.get(i)).setName(member.getName()); (
		 * map.get(i)).setAddr(member.getAddr()); (
		 * map.get(i)).setBirth(member.getBirth()); (
		 * map.get(i)).setPassword(member.getPassword()); (
		 * map.get(i)).setUserid(member.getUserid()); }
		 */
		return "업데이트 성공";
	}

}