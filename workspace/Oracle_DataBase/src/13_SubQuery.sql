-- 서브쿼리 
--   Sub Query : 하나의 select 문장의 절 안에 포함된 또하나의 select 쿼리 문

--SCOTT 이 근무하는 곳의 부서명과 지역 출력
--단일행 서브쿼리 : 서브 쿼리의 결과가 하나
select deptno from emp where ename = 'SCOTT';  -- 결과는 30
select dname , loc from dept where deptno=30;

-- 위 select 명령의 결과를 다른 select 명령에 사용(서브쿼리 사용)
select dname , loc from dept
where deptno = ( select deptno from emp where ename = 'SCOTT' );

--[연습문제] SCOTT 과 동일직 업(job)을 가진 사원의 모든 정보를 출력
select * from emp where job=( select job from emp where ename='SCOTT' )
--[연습문제] SCOTT 과 급여와 동일하거나 더 많이 받는 사원이름과 급여 출력
select ename, sal from emp
where sal>= ( select sal from emp where ename='SCOTT' );




--[서브 쿼리 & 그룹함수]
-- 전체 사원 평균 평균급여보다 더 많은 급여를 받는 사원의 이름, 급여, job
select ename, sal, job from emp  where sal >=(select avg(sal) from emp) 

--[서브쿼리 & IN , SOME, ANI, ALL 등]
-- 급여를 3000 이상 받는 사원이 소속된 부서와 소속된 부서에서 근무하는 사원들의 이름, 부서번호, job
-- 급여 3000 이상 사원의 부서번호(중복제거);
-- distinct 필드명 : 필드값의 중복된 값이 여러개라면 한번만 출력
select ename, deptno, job from emp 
where deptno in(  select distinct deptno from emp where sal>=3000  );

--[연습문제]
-- 30번 부서 소속 사원들 중에서 급여를 가장 많이 받는 사원 보다... 급여가 더 많은 사원의 이름과 job, 급여
-- 첫번째 방법
select ename, job, sal from emp 
where sal > (select max(sal) from emp where deptno=30)
-- 두번째 방법
select ename, job, sal from emp
where sal > all(select sal from emp where dept = 30)

--[연습문제]
-- 부서번호가 30번인 사원들의 급여 중에서 가장 낮은 급여보다... 높은 급여를 받는  사원의 이름과 job,  급여
-- 첫번째 방법
select ename, jon, sal from emp
where sal > (select min(sal) from emp where deptno=30)
-- 두번째 방법
select ename, job, sal from emp
where sal > any(select sal from emp where deptno=30)


--[연습문제]
-- 영업 사원(job='SALESMAN') 들의 최소 급여보다 많이 받는 사원들의 
-- 이름과 급여와 직급, 급여를 출력하되  영업사원(SALESMAN)은 출력하지 않습니다
-- 첫번째 방법
select eanem, job, sal from EMP
where sal > ( select min(sal) from emp where job='SALESMAN' ) 
		   and  job<>'SALESMAN';
-- 두번째 방법
select ename, job, sal from emp
where sal > any(select sal from emp where job='SALESMAN') 	
		   and   job<>'SALESMAN';








