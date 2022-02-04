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



-- rentlist 의 booknum  에 해당하는 도서제목을 rentlist 의 rentdate, num, booknum 과 함께 출력하세요
select * from rentlist;
select * from rentlist, booklist;
select * from rentlist, booklist where rentlist.booknum = booklist.num;
select rentlist.rentdate, rentlist.num, rentlist.booknum, booklist.subject 
from rentlist, booklist where rentlist.booknum = booklist.num;

-- rentlist 의 membernum 에 해당하는 회원의 이름과 전화번호를  rentlist 의 rentdate, num, 
-- membernum 과 함께 출력하세요
select rentlist.rentdate, rentlist.num, rentlist.membernum, memberlist.name, 
			memberlist.phone
from rentlist, memberlist
where rentlist.membernum = memberlist.num;



--테이블 명에 별칭을 부여한 후 컬럼앞에 소속테이블을 지정  
-- 테이블 명으로 소속을 기술할때는 한쪽에 만 있는 필드에 생략이 가능하지만 아래와 같이 
-- 별칭 부여시에는 모든 필드 앞에 반드시 별칭을 기술해야함
select a.ename, b.dname, b.loc, a.deptno  from emp a, dept b
where a.deptno = b.deptno and a.ename='SCOTT';


--non-equi join
--동일 컬럼이 없어서  다른 조건을 사용하여 조인
--조인 조건에 특정 범위내에 있는지를 조사하기 위해 조건절에 조인 조건을 '=' 연산자 이외의 비교
select * from emp;
select * from salgrade;

--연산자를 이용
select a.ename, a.sal, b.grade from emp a, salgrade b
where a.sal>=b.losal and a.sal<=b.hisal;

select a.ename, a.sal, b.grade from emp a, salgrade b
where  a.sal between b.losal and b.hisal;




--세개의 테이블을 하나로 JOIN(equi , nonequi 조인 의 조합)
select a.ename, a.sal, c.grade, b.dname from emp a, dept b, salgrade c
where a.deptno = b.deptno and  a.sal between c.losal and c.hisal;


-- 연습 문제
-- rentlist 테이블의 rentdate, booknum, membernum 을 조회하되,
-- booklist 와 memebrlist 테이블을 조인해서   책제목과 대여가격, 회원 이름과 사은 포인트를 출력하세요
-- 출력순서 -  대여일자, 도서제목,  회원이름, 포인트
-- 테이블의 별칭은  a,b,c 로 하세요
select a.rentdate as "대여 일자", b.subject as "도서 제목", c.name as "회원 성명", 
		  c.bpoint as "사은포인트" 
from rentlist a, booklist b, memberlist c
where a.booknum = b.booknum and a.membernum = c.membernum;

-- 조인된 테이블에 계산식으로 필드를 생성할수도 있습니다
select a.rentdate as "대여 일자", b.subject as "도서 제목", c.name as "회원 성명", 
		  c.bpoint as "사은포인트" , b.rentprice - a.discount  as "매출금액" 
from rentlist a, booklist b, memberlist c
where a.booknum = b.booknum and a.membernum = c.membernum;



--outer join
--조인 조건에 만족하지 못해서 해당 결과를 출력시에 누락이 되는 문제점이 발생할때 해당 레코드를출력하는 조인
select a.num, a.subject, b.rentdate from booklist a, rentlist b 
where a.num(+)=b.booknum;

select * from emp a, dept b 
where a.deptno(+)=b.deptno;





--[3] ANSI join
--   (1) Ansi Cross join
select * from emp, dept  -- 일반크로스 조인 표현 
select * from emp cross join dept     -- ansi Cross join -> 일반 크로스 조인과 같은 효과


--  (2) Ansi inner join -- 일반 equi 조인과 같은 효과
-- 일반 equi 조인 표현 방식
select  ename, dname from emp a, dept b where a.deptno = b.deptno 
-- Ansi 이너 조인의 표현 방식
select  ename, dname from emp inner join dept on emp.deptno = dept.deptno;
-- Ansi 이너 조인의  다른 표현 방식 : 두테이블의 조인 기준이 되는 필드명이 똑같을때만 사용가능
select  ename, dname from emp inner join dept using (deptno); 



-- (3) Ansi Outer Join  -- 기존 아우터 조인의 표현방식
select * from emp, dept where emp.deptno = dept.deptno(+);
select * from emp, dept where emp.deptno(+) = dept.deptno;
-- Ansi Outer Join 표현방식
select * from emp left outer join dept on  emp.deptno = dept.deptno;
select * from emp right outer join dept on  emp.deptno = dept.deptno;
-- 기준이 되는 필드명중 A 테이블의 필드에는 있으나 B테이블 필드에는 해당값이 없는 경우에 대한 표현여부결정