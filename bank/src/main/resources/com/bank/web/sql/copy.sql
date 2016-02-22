create table emp_copy as 
select employee_id as 사원번호, last_name 성, salary 연봉
from employees;

select *
from emp_copy;