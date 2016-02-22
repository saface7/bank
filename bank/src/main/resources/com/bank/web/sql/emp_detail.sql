-- 복합뷰
create or replace view emp_detail as
select
e.eid as eid,
e.ename as ename,
e.email as email,
e.phone_no as phone,
e.sal as sal,
e.hire_dt as hire_dt,
e.did as did,
d.dname as dname, 
j.jname as jname,
e.mid as mid
from emp e, dep d, job j
where e.did=d.did and e.jid=j.jid and e.mid=d.mid
order by eid desc;