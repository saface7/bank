package com.bank.web.domain;

import org.springframework.stereotype.Component;

import com.bank.web.util.Constants;
@Component
public class AccountVO {
	//멤버필드(멤버변수를 정의한 영역)
	//멤변은 초기화를 하지 않는다. 지변과의 차이점
	//멤변은 메소드 밖에 위치하며 메소드들 사이에서 값을 공유한다.
	//POJO plain old java object

	private int accountNo;
	private String name;
	private int money;
	private int password;
	private String msg;
	//멤버메소드 에어리어(멤버 메소드를 정의한 영역)
	public AccountVO() {
		//4자리 수의 랜덤한 숫자
		//0.0 <= Math.random() < 1.0
		this.accountNo = (int)((Math.random() * 9999)+1000);
	}
	// 멤변에 값을 입력하고, 조회할 수 있는 메소드인 getter/setter 생성
	//단축키 ALT + SHIFT+S
	public int getAccountNo() {
		return accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money += money;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	@Override
	public String toString() {

	 return  "["+Constants.Bank+"]" + "이름 : "+this.getName() + ":" +"계좌번호" +  this.getAccountNo() +"비번" + this.getPassword() +"잔액" + this.getMoney();
	}
}
