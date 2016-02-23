-- 직원의 평균 연봉보다 더 많이 받는 직원 수
select count(*)
from emp
where sal>=(select avg(sal) from emp);

select eid 직원번호, ename 직원명, jid 업무번호
from emp
where(eid, jid) in (select eid, jid from job_his);

select
j.eid 사원번호,
(select e.ename from emp e where e.eid = j.eid) 사원명, 
j.did 부서번호,
(select d.dname from dep d where j.did = d.did) 부서명
from job_his j;


update emp e
set e.sal = (
   select sal 
   from ( select d.did, avg(e2.sal) as sal 
         from dep d, emp e2 where d.did=90
         and d.did = e2.did
         group by d.did) t
   where e.did = t.did)
where e.did in (select d2.did from dep d2 where d2.did=90);



select sal 
   from ( select d.did, avg(e2.sal) as sal 
         from dep d, emp e2 where d.did=90
         and d.did = e2.did
         group by d.did) t, emp e
   where e.did = t.did;
   
--인라인뷰 : from절에 정의된 subquery
select e.eid 사원번호, e.ename 사원명, d.did 부서번호, d.dname 부서명
from emp e, dep d, (
	select avg(e2.sal) as avg_sal
	from dep d2, emp e2
	where d2.did = 90 and d2.did = e2.did
) t
where e.did = d.did
and e.sal > t.avg_sal;

--전체 직원의 평균 연봉
select avg(e.sal) as avg_sal
from emp e
--기획부서 직원의 평균연봉
select avg(e.sal) as avg_sal
from emp e, dep d
where d.did = 90, and d.did = e.did;
--기획부서(90)에서 근무하는 직원
select *
from emp
where did = 90;

select *
from emp

select eid, ename, email
from emp
group by eid

select department_id, first_name
from employees
group by department_id