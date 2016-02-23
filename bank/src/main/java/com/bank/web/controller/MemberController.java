package com.bank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.web.domain.MemberVO;
import com.bank.web.service.MemberService;
@Controller

public class MemberController {
	
	@Autowired MemberVO member;
	@Autowired MemberService service;
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm(Model model){
		return "member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		member.setUserid("KIM");
		member.setPassword("1");
		member = service.login(member);
		System.out.println("로그인 후 이름 : "+ member.getName());
		model.addAttribute("name", member.getName() );
		
		return "global/home";
	}
}
