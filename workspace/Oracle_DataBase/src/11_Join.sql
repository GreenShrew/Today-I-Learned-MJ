-- Join
-- 두개 이상의 테이블에 나눠져있는 관련 데이터들을 하나의 테이블로 모아서 조회하고자 할 때 사용하는 명령어.

-- [1] 이름 Douglas Grant가 근무하는 부서명, 상급부서의 이름을 출력하고자 한다면... 
select * from employees;
select * from departments

select department_id from employees where emp_name = 'Douglas Grant';
-- 위 명령을 실행 후 얻어진 부서번호로 아래와 같이 부서번호를 검색하여 부서명과 상급부서 이름을 알아낸다.
select department_name, parent_id from departments where department_id=50;
select department_name from departments where department_id=10;

-- 위의 두개의 명령을 하나의 명령으로 합하는 역할을 join 명령이 실행한다.

-- cross join : 두개 이상의 테이블이 조인될때 where 절에 의해 공통되는 컬럼에 의한 결합이 발생하지 않는 경우

-- * 가장 최악의 결과를 얻는 조인 방식
-- A 테이블과 B 테이블의 cross join이 된다면
-- A 테이블의 1번 레코드와 B 테이블의 모든 레코드가 하나하나 모두 조합
-- A 테이블의 2번 레코드와 B 테이블의 모든 레코드가 하나하나 모두 조합
-- A 테이블의 3번 레코드와 B 테이블의 모든 레코드가 하나하나 모두 조합

select * from dept	-- 레코드 4, 필드 3 가 있는 테이블
select * from emp	-- 레코드 14, 필드 8 가 있는 테이블
-- 크로스 조인
select * from dept, emp	-- 레코드 56, 필드 11 가 있는 테이블로 조인했으나, 4*14개의 레코드와 3+8개의 필드가 만들어진다.


-- equi join : 조인 대상이 되는 두 테이블에서 공통적으로 존재하는 컬럼의 값이 일치하는 행을 연결하여 결과를 생성
select * from dept, emp where emp.deptno = dept.deptno;
-- 여기서는 cross join처럼 조인한 뒤 DEPTNO가 같은 대상만 선택해서 JOIN한다.


-- 연습
-- 각 사원의 이름, 부서번호, 부서명, 지역을 출력하자.
select * from emp.ename, emp.deptno, dept.dname, dept.loc from dept, emp where emp.deptno = dept.deptno;


-- 시험문제!
-- 이름 Douglas Grant 가 근무하는 부서명을 출력해보자!
-- 출력내용 : 사원이름, 부서번호, 부서명, 월 급여
select emp.ename, emp.deptno, dept.dname, emp.sal from dept, emp
where emp.deptno = dept.deptno and dept.dname = 'Douglas Grant'

-- 힌트
-- 이름이 SCOTT인 사원의 이름, 부서번호, 부서명, 위치 출력
select ename, emp.deptno, dept.dname, dept.loc from dept, emp
where emp.deptno = dept.deptno and emp.ename='SCOOT'
-- 필드명 앞에 테이블 이름을 기술하여 컬럼의 소속을 명확히 해주어야 오류가 없다.