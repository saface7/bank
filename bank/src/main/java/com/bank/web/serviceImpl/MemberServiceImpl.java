package com.bank.web.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.web.domain.MemberVO;
import com.bank.web.mapper.MemberMapper;
import com.bank.web.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
	MemberVO[] members = new MemberVO[100];
	// 필드
	@Autowired MemberVO member;
	private MemberVO[] memberList;
	private Map<String, MemberVO> map;
//	@Autowired MemberMapper mapper;
	@Autowired private SqlSession sqlSession;

	public MemberServiceImpl() {
		// 생성자
		//member = new MemberVO();
		// memberList = new MemberBean[];
		map = new HashMap<String, MemberVO>();
	}

	public void AdminServiceImpl() {
		
	}

	public int join(MemberVO member) {
		// 회원가입
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.insertMember(member);
	}

	@Override
	public MemberVO searchById(String id) {
		// 아이디로 회원정보 검색
		return map.get(id);
	}

	@Override
	public List<MemberVO> searchByName(String name) {
		// 이름으로 회원정보 검색
		List<MemberVO> temp = new ArrayList<MemberVO>();
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
	public int remove(String id) {
		// 회원탈퇴
		//return map.remove(id) != null ? "탈퇴성공" : "탈퇴실패";
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.deleteMember(id);
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
	public MemberVO login(MemberVO member) {
		// 로그인
		System.out.println("서비스 진입아이디 : "+member.getUserid());
		System.out.println("서비스 진입패스워드 : "+member.getPassword());
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		member = mapper.selectMember(member);
		System.out.println("서비스 멤버 결과 : "+member.getName());
		//String result = "로그인 실패";
/*		if (map.containsKey(id)) {
			result = (map.get(id)).getPassword().equals(pass) ? "로그인 성공" : "로그인 실패";
		}*/
		// 메소드 체인 기법
		/*
		 * if (map.containsKey(id)) { // 맵에 id가 존재하는지를 먼저 체크한다.
		 * 
		 * if (( map.get(id)).getPassword().equals(pass)) { result = "로그인 성공";
		 * }else{ result = "비밀번호가 일치하지 않습니다"; } } else { result =
		 * "아이디가 존재하지 않거나, 잘못된 아이디 입니다"; }
		 */
		return member;
	}

	@Override
	public int update(MemberVO member) {
		// 정보수정
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		//map.replace(member.getUserid(), member);

		return mapper.update(member);
	}
	@Override
	public String existCheck(String userid){
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.selectMemberid(userid);
		
	}

}
