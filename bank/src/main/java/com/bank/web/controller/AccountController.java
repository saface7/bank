package com.bank.web.controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import com.bank.web.service.AccountService;
import com.bank.web.service.AdminService;
import com.bank.web.serviceImpl.AccountServiceImpl;
import com.bank.web.serviceImpl.AdminServiceImpl;

import sun.print.resources.serviceui;
@Controller
public class AccountController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AccountService service = new AccountServiceImpl();
		AdminService admin = new AdminServiceImpl(100);
		while (true) {
			System.out.println("업무선택 : \n"
										+"1. 계좌개설\n"
					                    +"2. 입금 \n"
					                    +"3. 출금 \n"
					                    +"4. 잔액조회 \n"
					                    +"5. 종료");			
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("이름,  비번");				
				System.out.println(admin.open(scanner.next(), scanner.nextInt()));
				break;
				
			case 2:
				System.out.println("입금할 금액");
				System.out.println(service.deposit(scanner.nextInt()));
				break;
			case 3:
				System.out.println("출금할 금액");
				System.out.println(service.widthdraw(scanner.nextInt()));
				break;
			case 4:break;
			case 5:return;
			
			default:
				System.out.println("1~5번 사이에서 선택가능합니다.");
				System.out.println("다시 선택해 주세요");
				break;
			}
		}
	}
}
