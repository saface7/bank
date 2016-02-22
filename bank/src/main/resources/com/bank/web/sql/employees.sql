--0. 사원 테이블 전체 ㅈ검색
select *
from employees
--employee_id, first_name last_name, email, phone_number, hire_date, job_id
--salary, commission_pct, manager_id, department_id
select *
from departments
-- department_id, department_name, manager_id, location_id

--1. 사원번호, 패밀리네임, 연봉출력
select employee_id as 사원번호, last_name 성, salary 연봉
from employees
--2.연봉 3천 이상인 사원
select employee_id as 사원번호, last_name 성, salary 연봉
from employees
where 1=1
and salary >= 3000;
--3. 부서번호(DEPARTMENT_id)이 100번인 사원
select *
from EMPLOYEES
where 1=1
and DEPARTMENT_id = 100;
--4. 입사일이 2000년 1월 1일 이후인 사원
select employee_id as 사원번호, last_name 성, salary 연봉, hire_date 입사일
from employees
where 1=1
and hire_date >= '20000101';
--and hire_date >= '00/01/01';
--and hire_date >= to_date('YYYYMMDD', '20000101');

--5,부서가 100번이 아닌 사원
select *
from EMPLOYEES
where 1=1
--and DEPARTMENT_id <> 100;
and DEPARTMENT_id !=100;
--6. 연봉이 2000~3000(이상, 이하)인 사원
select employee_id as 사원번호, last_name 성, salary 연봉
from employees
where 1=1
--and salary >=2000
--and salary < 3000;
and salary between 2000 and 3000;
--7. 연봉이 2000~3000(이상, 이하) 범위에 속하지 않는 사원
select employee_id as 사원번호, last_name 성, salary 연봉
from employees
where 1=1
--and salary >=2000
--and salary < 3000;
and salary not between 2000 and 3000;
--8. 커미션이 0.2, 0.3, 0.4인 사원
select employee_id as 사원번호, last_name 성, salary 연봉, commission_pct 커미션
from employees
where 1=1
--and commission_pct = 0.2
--or commission_pct = 0.3
--or commission_pct = 0.4
and commission_pct in (0.2, 0.3, 0.4);
--9. 커미션이 0.2, 0.3, 0.4인이 아닌 사원
select employee_id as 사원번호, last_name 성, salary 연봉, commission_pct 커미션
from employees
where 1=1
--and commission_pct = 0.2
--or commission_pct = 0.3
--or commission_pct = 0.4
and commission_pct not in (0.2, 0.3, 0.4);

--10. 패밀리 네임중에 알파벳이 k인 사원
select employee_id as 사원번호, last_name 성, salary 연봉, commission_pct 커미션
from employees
where 1=1
and last_name like '%k%'

--11. 패밀리 네임중에 알파벳이 a인 사원
select employee_id as 사원번호, last_name 성, salary 연봉, commission_pct 커미션
from employees
where 1=1
and last_name like '__a%'


--13. 구글 계정을 사용하는 직원
select employee_id as 사원번호, last_name 성, salary 연봉, commission_pct 커미션
from employees
where 1=1
and email like '%\@gmail.com%';

--14. 커미션을 받지 않는 직원
select employee_id as 사원번호, last_name 성, salary 연봉, commission_pct 커미션
from employees
where 1=1
and commission_pct is null;

--15. 커미션을 받는 직원=영업직인 직원
select employee_id as 사원번호, last_name 성, salary 연봉, commission_pct 커미션
from employees
where 1=1
and commission_pct is not null;

--16. 연봉을 적게 받는 순으로 해서 오름차순 정렬
select employee_id as 사원번호, last_name 성, salary 연봉, commission_pct 커미션
from employees
where 1=1
order by salary asc;

--16. 연봉을 적게 받는 순으로 해서 내림차순 정렬
select employee_id as 사원번호, last_name 성, salary 연봉, commission_pct 커미션
from employees
where 1=1
order by salary desc;

--17. 고액 연봉순 직원 리스트(만일 통일한 연봉을 받으면 패밀리네임에 따라 오름차순
select employee_id as 사원번호, last_name 성, salary 연봉, commission_pct 커미션
from employees
where 1=1
order by salary desc, last_name asc;

--18. exist 문법 부서번호가 30, 60, 90인 사원정보
select e.employee_id 사원번호, e.last_name 이름, e.salary 연봉, e.department_id 부서번호
from employees e
where 1=1
and exists(select d.department_id from departments d where d.department_id in(30, 60, 90) and d.department_id = e.department_id);