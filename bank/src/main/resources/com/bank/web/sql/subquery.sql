-- 직원의 평균 연봉보다 더 많이 받는 직원 수
select count(*)
from emp
where sal>=(select avg(sal) from emp);

select eid 직원번호, ename 직원명, jid 업무번호
from emp
where(eid, jid) in (select eid, jid from job_his);
