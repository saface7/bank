	private int ;
	private String name;
	private int money;
	private int password;
create sequence seq 
--increment by 1 증감 숫자이며 1씩 증가시킬때는 생략이 가능하다
start with 1;

select *
from account;

--drop table account;

create table account(
	seq number primary key,
	accountNo number,
	money number,
	password number,
	userid varchar2(30),
	constraint account_member_fk foreign key(userid)
	references member(userid)
);
--DROP TABLE account;
SELECT * FROM account;

insert into account values(seq.NEXTVAL, 1000, 10000, 1, 'KIM');
insert into account values(seq.NEXTVAL, 1001, 20000, 1, 'LEE');
insert into account values(seq.NEXTVAL, 1002, 50000, 1, 'kang');
