--사원의 이름과 급여와 입사일자만을 출력하기
select ename, sal, hiredate from emp;
--컬럼 이름에 별칭을 지정하기
select deptno 부서번호, dname as 부서명 from dept;
-- 직급이 중복되지 않고 한 번씩 나열되도록 SQL문을 작성
select distinct job from emp;

-- 급여가 300 이하인 사원의 사원번호, 사원 이름, 급여를 출력하시오
select empno, ename, sal from emp where sal <= 300;
-- 이름이 "오지호"인 사원의 사원번호, 사원명, 급여를 출력하시오
select empno, ename, sal from emp where ename like '오지호';
-- 급여가 250이거나, 300이거나, 500인 사원들의 사원번호와 사원명과 급여를 검색하시오
select empno, ename, sal from emp where sal in(250, 300, 500);
