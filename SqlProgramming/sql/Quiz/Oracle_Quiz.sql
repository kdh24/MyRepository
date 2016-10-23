------------------------ch02 -------------------------------------------------
-- 2�� ����
select * from emp
where sal between 400 and 500;
-- 7�� ����
select disempno, ename
from emp
order by empno desc;

------------------------ch03 -------------------------------------------------
-- 1�� ����
select * from emp
where mod(empno, 2)=1;
-- 2�� ����
select hiredate, to_char(hiredate, 'yyyy') �⵵,
        substr(hiredate, 4, 2) ��,
        substr(hiredate, 7, 2) ��
from emp;
-- 3�� ����
select hiredate, round((sysdate-hiredate)) �ٹ��ϼ�
from emp;
-- 4�� ����
select empno, ename, nvl(TO_CHAR(mgr, '9999'), 'C E O') as "���ӻ��"
from emp
where mgr is null;
-- 6�� ����
select sysdate+100
from dual;
-- 7�� ����
select last_day(sysdate)
from dual;

------------------------ch04 -------------------------------------------------

-- 7�� ����
select count(*) �����
from emp
where comm is not null 
      and deptno=30
group by deptno;
-- 8�� ����
select max(to_char(hiredate, 'YYYY-MM-DD HH:MI:SS')) as �Ի���, min(to_char(hiredate, 'YYYY-MM-DD HH:MI:SS')) as �Ի���
from emp;
-- 9�� ����
select job, sum(sal)
from emp
group by job
having sum(sal) > 300;

------------------------ch04 -------------------------------------------------

-- 2�� ����
insert into dept
values(90, '��ȹ��', '');
-- 3��
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