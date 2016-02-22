-- synonym 동의어 : 스키마 오브젝트의 별칭(alias)
-- synonym 제한 사항
-- 1. 스키마에 대한 select 권한이 있어야 함
-- 2. synonym 에는 public 과 private 두가지가 있다.
--       공개용 시노님에는 모든 사용자가 접근 가능하고, private 은
--      생성한 스키마 내부에서만 사용 가능하다.
-- 3. 반드시 최상위 스키마인 sys에서 생성 및 삭제 가능
create or replace public synonym cnt for hr.cnt;
grant select on cnt to bank;
create or replace public synonym emp_detail for hr.emp_detail;
grant select on emp to bank;
create or replace public synonym dep for hr.dep;
grant select on dep to bank;
create or replace public synonym jobs for hr.job;
grant select on jobs to bank;
create or replace public synonym job_his for hr.job_his;
grant select on job_his to bank;
create or replace public synonym loc for hr.loc;
grant select on loc to bank;
create or replace public synonym reg for hr.reg;
grant select on reg to bank;
create or replace public synonym emp for hr.employees;
grant select on emp to bank;

drop public synonym emp;

select * from emp_detail;

select *
from emp;

select *
from reg;

insert into reg values(5, 'Korea');

select eid 직원번호, sal 연봉
from emp
where sal =  any(2000,3000,4000)
order by eid;

--any는 조건중에서 하나라도 일치하면 출력 즉 or의 의미
select eid 직원번호, sal 연봉
from emp
where sal =  any(2000,3000,4000)
order by eid;
--all은 직원이 2000에도 해당, 3000에도 해당, 4000에도 해당
--따라서 논리적으로 잘못되었으므로 null값 출력
select eid 직원번호, sal 연봉
from emp
where sal =  any(2000,3000,4000)
order by eid;

select *
from emp;
--group by 문법
select 
*
from reg
group by did
order by did desc;

did 부서번호,
sum(sal) 부서별 직원연봉합
--ansi조인 : dbms 공통 쿼리로 개발
--마치 utf-8과 같은 존재