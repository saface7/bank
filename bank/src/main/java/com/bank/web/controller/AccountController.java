package com.bank.web.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.web.domain.AccountVO;
import com.bank.web.domain.MemberVO;
import com.bank.web.serviceImpl.AccountServiceImpl;

@Controller
@RequestMapping("/account")
public class AccountController{
	@Autowired AccountServiceImpl accountService;
	//내 계좌 페이지 이동
	@RequestMapping(value="/myAccount/{userid}", method = RequestMethod.GET)
	public String myAccount(Model model,
			@PathVariable("userid")String userid,
			HttpSession session){
		MemberVO temp = new MemberVO();
		AccountVO acc = new AccountVO();
		temp = (MemberVO) session.getAttribute(temp.getUserid());
		acc = accountService.getAccount(temp.getUserid());
		System.out.println("내 계좌정보 : "+acc.getAccountNo());
		System.out.println("내 계좌잔액 : "+acc.getMoney());
		System.out.println("내 계좌비번 : "+acc.getPassword());
		
		model.addAttribute("message", temp.getName());
		model.addAttribute("userid", temp.getUserid());
		model.addAttribute("account", acc);
		return "account/myAccount";
	}
	//계좌 개설하기
	@RequestMapping(value="/openAccount", method = RequestMethod.GET)
	public String loginForm(Model model, HttpSession session){
		
		return "account/myAccount";
	}
	//입금하기
	@RequestMapping(value="/deposit", method = RequestMethod.GET)
	public String deposit(Model model, HttpSession session){
	
		return "account/myAccount";
	}
	//출금하기
	@RequestMapping(value="/widthdraw", method = RequestMethod.GET)
	public String widthdraw(Model model, HttpSession session){

		return "account/myAccount";
	}
	//계좌해지
	@RequestMapping(value="/remove", method = RequestMethod.GET)
	public String remove(Model model, HttpSession session){
		MemberVO temp = new MemberVO();
		temp = (MemberVO) session.getAttribute("member");
		model.addAttribute("message", temp.getName());
		model.addAttribute("userid", temp.getUserid());
		return "account/myAccount";
	}
}
