package com.bank.web.serviceImpl;

import com.bank.web.domain.AccountBean;
import com.bank.web.service.AccountService;

public class AccountServiceImpl implements AccountService{
	AccountBean account = new AccountBean();

	@Override
	public String deposit(int money) {
		// 2. 입금
		account.setMoney(account.getMoney() + money);	
		return "잔액 :" + account.getMoney();
	}

	@Override
	public String widthdraw(int money) {
		// 3. 출금
			return (account.getMoney() >= money) ? this.saveMoney(money): "잔액 부족";
	}

	private String saveMoney(int money) {
		String result;
		account.setMoney(account.getMoney() - money);			
		result =   "잔액 :" + account.getMoney();
		return result;
	}

	@Override
	public String search() {
		//4.  잔액조회
		return "잔액 : " + account.getMoney();
	}
}
