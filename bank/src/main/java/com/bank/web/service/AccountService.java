package com.bank.web.service;

public interface AccountService {
	//Database에서 CRUD
	//create
	//read
	//update
	//delete

	//2. 예금
	public String deposit(int money);
	//3. 출금
	public String widthdraw(int money);
	//4. 잔액조회
	public String search();
}
