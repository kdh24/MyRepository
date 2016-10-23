------------------------ch02 -------------------------------------------------
-- 2번 문제
select * from emp
where sal between 400 and 500;
-- 7번 문제
select disempno, ename
from emp
order by empno desc;

------------------------ch03 -------------------------------------------------
-- 1번 문제
select * from emp
where mod(empno, 2)=1;
-- 2번 문제
select hiredate, to_char(hiredate, 'yyyy') 년도,
        substr(hiredate, 4, 2) 월,
        substr(hiredate, 7, 2) 일
from emp;
-- 3번 문제
select hiredate, round((sysdate-hiredate)) 근무일수
from emp;
-- 4번 문제
select empno, ename, nvl(TO_CHAR(mgr, '9999'), 'C E O') as "직속상관"
from emp
where mgr is null;
-- 6번 문제
select sysdate+100
from dual;
-- 7번 문제
select last_day(sysdate)
from dual;

------------------------ch04 -------------------------------------------------

-- 7번 문제
select count(*) 사원수
from emp
where comm is not null 
      and deptno=30
group by deptno;
-- 8번 문제
select max(to_char(hiredate, 'YYYY-MM-DD HH:MI:SS')) as 입사일, min(to_char(hiredate, 'YYYY-MM-DD HH:MI:SS')) as 입사일
from emp;
-- 9번 문제
select job, sum(sal)
from emp
group by job
having sum(sal) > 300;

------------------------ch04 -------------------------------------------------

-- 2번 문제
insert into dept
values(90, '기획부', '');
-- 3번
update emp
set sal = sal * 1.1;

------------------------ch09 -------------------------------------------------
drop table test;
create table test(
  id number(4) default 1 primary key,
  name varchar(20) null unique
);
insert 
into test(name) values ( hm);

------------------------ch10 -------------------------------------------------
select *
from emp, dept;
where emp.deptno = dept.deptno;