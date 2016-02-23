create view emp_view as 
select employee_id as 사원번호, last_name as 성, salary as 연봉 from EMPLOYEES;

select * from emp_view;

-- hr 스키마에 있는 테이블
select * from countries; -- 나라
select * from cnt;

select * from departments; -- 부서
select * from dep;

select * from employees; -- 직원 
select * from emp;

select * from locations; -- 지역
select * from loc;

select * from jobs; -- 업무
select * from job;

select * from job_history; -- 연혁
select * from job_his;

select * from regions; -- 위치
select * from reg;
create view cnt as
select country_id as cid,
country_name as cname,
region_id as rid
from countries;

select * from cnt;

drop view cnt;

create or replace view dep as
select department_id as did,
department_name as dname,
manager_id as mid,
location_id as lid
from DEPARTMENTS;

select * from dep;


create or replace view emp as
select employee_id as eid,
first_name ||' ' || last_name as ename,
email,
phone_number as phone_no,
hire_date as hire_dt,
job_id as jid,
salary as sal,
commission_pct as cms_pt,
manager_id as mid,
department_id as did
from employees;

select *
from  employees;

select * from emp;

create or replace view job as
select
job_id as jid,
job_title as jname,
min_salary as min_sal,
max_salary as max_sal
from jobs;

select * from job;

create or replace view job_his as
select employee_id as eid,
start_date as start_dt,
end_date as end_dt,
job_id as jid,
department_id as did
from JOB_HISTORY;

select * from job_his;

create or replace view loc as
select location_id as lid,
street_address as street,
postal_code as zipcode,
city,
state_province as state,
country_id as cid
from LOCATIONS;

select * from loc;

create or replace view reg as
select region_id as rid,
region_name as rname
from REGIONS;

select * from reg;