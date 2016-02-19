select *
from test;

select *
from member;
-- 실행단축키 : alt + x
create table member(userid varchar2(30) primary key,
					name varchar2(30),
					password varchar2(30),
					addr varchar2(30),
					birth number);
					
insert into member(userid, name, password, addr, birth)
values('KIM', '김유신', '1', '서울', 2000);
insert into member(userid, name, password, addr, birth)
values('LEE', '이순신', '1', '안양', 1995);
insert into member(userid, name, password, addr, birth)
values('kang', '강감찬', '1', '인천', 2005);

insert into member values('jang', '장민호', '1', '서울', 2000);