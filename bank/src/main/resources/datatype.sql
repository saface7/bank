-- sql은 큰 데이터 타입이 총 3가지만 기억
-- 문자형 타입
-- char 고정 길이의 문자형 데이터, 최대 크기는 2000byte
-- varchar2 가변 길이의 문자형 데이터, 반드시 size값명시, 최대 크기는 4000byte
-- nchar 고정 길이의 유니코드(UTF-8) 문자형 데이터, 최대 크기는 2000byte
-- nvarchar2 가변 길이의 유니코드(UTF-8) 문자형 데이터
-- long 가변 길이의 문자형 데이터 타입, 최대 크기는 2GB

-- 숫자형 타입
-- binary_float 32bit 부동 소수
-- binary_double 64bit 부동 소수
-- number 가변 숫자 타입으로 칼럼명 NUMBER(precison, scale)
-- precision 로 설정한 값은 전체자릿수, scale 로 설정된 값은 소수점 이하 자릿수
-- 생략하면 0이므로 정수
-- price NUMBER
-- price NUMBER(8,2)

create table num(c1 NUMBER,
c2 NUMBER(9),
c3 NUMBER(9,2),
c4 NUMBER(9,1),
c5 NUMBER(7),
c6 NUMBER(7,-2),
c7 NUMBER(6),
c8 NUMBER(3,5)
);
SELECT *
FROM num

insert into num values
(1234567.89,1234567.89,1234567.89,
1234567.89,1234567.89,1234567.89,
123456,0.00123);