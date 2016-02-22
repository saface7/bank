select
d.did 부서번호,
d.dname 부서명,
j.jid 업무번호,
j.did 부서번호
from
dep d, job_his j
where d.did = j.did(+);