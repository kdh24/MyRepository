--Section01 서브쿼리의 기본 개념
--테이블간의 데이터를 연결(Join문으로 변경가능)
--이문세 사원의 부서 이름은?
select dname
from dept
where deptno=(select deptno from emp where ename='이문세');

select dname
from emp, dept
where emp.deptno = dept.deptno
      and ename='이문세';
--Join은 같은 값끼리 연결시키는데 오래 걸린다

--1.1 단일행 서브 쿼리
--이문세 사원의 부서명은?
select dname
from dept
where deptno=(select deptno from emp where ename='이문세');
--최저 봉급을 받아가는 사원의 정보는?
select *
from emp
where sal=(select min(sal) from emp);
--평균 봉급 이상을 받아가는 사원의 수는?
select count(*)
from emp
where sal>=(select avg(sal) from emp);

--Section02 다중행 서브 쿼리
--서울에 근무하는 사원의 이름은?
select ename
from emp
where deptno in (select deptno from dept where loc='서울');

--2.4 EXISTS 연산자
--사원이 1명이라도 존재하는 부서의 이름은?
select distinct dname
from dept, emp
where dept.deptno=emp.deptno;

select distinct dname
from dept d, emp e
where d.deptno=e.deptno
group by d.dname;

select dname
from dept
where exists (select * from emp where emp.deptno=dept.deptno);

--사원이 존재하지 않는 부서의 이름은?
select dname, empno
from dept d
left outer join emp e
on  d.deptno=e.deptno
where empno is null;
      
select dname
from dept
where not dname in (
  select distinct dname
  from dept d, emp e
  where d.deptno=e.deptno
);

select dname
from dept
where not exists (select * from emp where emp.deptno=dept.deptno);

--Section03 서브쿼리를 이용하여 테이블을 생성하고 데이터를 조작하기
--emp 테이블 복제해서 emp2로 만드세요(하나의 DDL로 작성하시오)
--제약 조건은(PK, FX, Check, not null)은 복제가 되지 않습니다.)
--인덱스도 복제가 되지 않습니다.
create table emp2
as
select * from emp;