drop table channels;
drop table countries;
drop table customers;
drop table departments;
drop table employees;
drop table job_history;
drop table jobs;
drop table kor_loan_status;
drop table products;

commit;


select * from tab;

-- PL/SQL
-- 다수의 SQL 명령이 모여서 하나의 작업모듈 또는 트랜젝션을 이룰때, 이를 하나의 블럭으로 묶어서
-- 한번에 실행하게 하는 단위실행명령이다.

-- 예를 들어, Shoes Shop 쇼핑몰 예제의 경우, 장바구니에 있던 상품들을 주문하려고 할때
-- Orders 테이블에 새로운 레코트 insert
-- Orders 테이블에서 가장 큰 oseq 조회
-- 장바구니에서 상품목록을 조회
-- 조회된 oseq와 상품 목록을 order_detail에 insert
-- 장바구니에서 방금 주문한 상품 삭제

-- 다섯개의 명령을 하나의 단위요소로 묶어서 실행하는 것이다!
-- 위 동작을 오라클이 제공하는 프로그래밍 요소와 함게 SQL 명령 그룹(블럭)을 만들어 한번에 실행할수 있게 한다.
-- 그렇게 만들어진 PL/SQL 블럭은 MyBatis에서 활용된다.





-- 블럭
-- PL/SQL은 여러 블럭으로 구성되어 있는데, 쉽게 짐작할수 있는 실행할 SQL 명령이 모여있는 블럭 등이 있으며,
-- 이는 명령의 실행단위가 된다.
-- 이외 익명 블럭, 이름이 있는 블럭 등도 있고,
-- 기능별로 이름부, 선언부, 실행부, 예외처리부로도 나누기도 한다.


-- PL/SQL 문의 구성에
-- PL/SQL 로 하나의 단위 명령을 실행할때 아래와 같이 각 위치, 기능별 구성이 이루어진다.
IS(AS)
--      이름부, 해당 블럭의 이름을 나타낸다.
DECLARE
--      선언부, 변수를 선언할 수 있다!
BEGIN
--      실행부, 실제 SQL 명령이 들어간다.
EXCEPTION
--      예외처리부, 실행 예외 처리시 어떻게 처리할지 내용이 들어간다.
END;

-- BEGIN, END 를 제외한 나머지는 필요에 의해 생략이 가능하다.


-- 익명 블럭 예시
DECLARE
    num NUMBER; -- 변수 선언, 변수를 앞에 쓰고 변수 형태를 뒤로 놓는다.
BEGIN
    num := 100; -- 실행 명령 1, num에 값 100을 넣으라는 명령.
    DBMS_OUTPUT.PUT_LINE(num);  -- 실행 명령 2, 화면에 출력하는 명령.
END;

-- 화면 출력을 하기 위한 기능을 ON 하는 명령
SET SERVEROUTPUT ON
-- 실행시간을 출력하기 위한 기능을 ON 하는 명령
SET TIMING ON
SET TIMING OFF

-- 현재 목표는 웹 사이트에서 전달받은 전달인수로 연산(SQL)하고, 결과를 웹사이트로 다시 리턴해주는 것이지만,
-- 현재는 그 상황까지 공부하지 못했으므로 내가 값을 넣어주고(num := 100;), 결과를 화면으로 출력한다(DBMS_OUTPUT.PUT_LINE(num);).





-- 변수 : 첫번째 SQL에서 Orders 테이블에 레코드를 삽입하고, 가장 큰 oseq를 조회한 다음 그 값을 order_detail의
--      입력값으로 사용하려면 변수를 선언하고 값을 저장해서 활용한다.
-- 변수 선언방법
-- 변수명 변수자료타입 := 초기값;   <- SQL 명령내의 '='와 구분하기 위해 ':='으로 사용한다.


-- PL/SQL 의 자료형
-- 기존의 SQL 자료형은 모두 포함하며, 자유롭게 사용이 가능하다(NUMBER, VARCHAR2 등...)
-- BOOLEAN : TRUE, FALSE, NULL을 가질 수 있는 자료형
-- PLS_INTEGER : -2147483648 ~ 2147483647 값을 갖는 정수 NUMBER 형에 비해 저장공간을 덜 차지한다.
-- BINARY_INTEGER : PLS_INTEGER 과 같은 용량, 같은 용도로 사용한다.
-- NATRAL : PLS_INTEGER 중 양수(0 포함)
-- NATRALN : NATRAL과 같지만, NULL 허용이 없고 선언과 동시에 초기화가 필요하다.
-- POSITIVE : PLS_INTEGER 중 음수(0 미포함)
-- POSITIVEN : POSITIVE와 같지만, NULL 허용이 없고 선언과 동시에 초기화가 필요하다.
-- SIGNTYPE : -1, 0, 1
-- SIMPLE_INTEGER : PLS_INTEGER 중 NULL이 아닌 모든 값, 선언과 동시에 초기화가 필요하다.



-- 연산자
-- ** : 제곱 (자승) 연산  --> 3**4 는 3의 4승
-- +, - : 양수 음수 구분 연산
-- 사칙연산 +, -, *, /, ||(문자열 연결)
-- 비교 연산 =, >, <, >=, <=, <>, !=, IS NULL, LIKE, BETWEEN, IN
-- 논리 연산 NOT AND OR

-- PL/SQL 블럭에 연산자를 사용한 예
DECLARE
    a INTEGER := 2**2*3**2;
BEGIN
    DBMS_OUTPUT.PUT_LINE('a = ' || TO_CHAR(a));
END;

-- DECLARE, BEGIN 등의 각 영역은 한 문장의 SQL 문도 하나의 명령어로, 
-- 연산자를 포함한 일반 명령어도 하나의 명령어로 인식해서 맨 뒤에 ';'이 있는곳까지 실행한다.




-- SQL 명령과 같이 실행되는 PL/SQL
-- employees 테이블의 사원번호가 100인 사원의 이름을 변수에 저장하는 예시
select emp_name from employees where employee_id=100;
-- 이걸 이대로 실행하면 하단의 '질의 결과'에 나온다.
-- 이를 스크립트로 출력하고 싶다면 아래와 같이 만든다.

DECLARE
    e_name varchar2(30);
BEGIN
    select emp_name
    into e_name     -- select 해서 emp_name을 얻어오고, 이를 e_name이라는 변수로 저장하는 방법
    from employees
    where employee_id=100;
    
    DBMS_OUTPUT.PUT_LINE(e_name);
END;



-- select 문에 의해서 도출되는 결과가 두개 이상이라면, SQL 실행결과를 담을 변수를 담을 갯수만큼 만들고
-- INTO 절에 결과 필드의 순서에 맞게 위치시킨다.
-- employees 테이블의 사원번호가 100인 사원의 이름과 부서번호를 변수에 저장하는 예시
select emp_name, department_id from employees where employee_id=100;

DECLARE
    e_name varchar2(80);   -- 사원명 변수
    d_id varchar2(80);   -- 부서명 변수
BEGIN
    select emp_name, department_id
    INTO e_name, d_id  
    from employees
    where employee_id=100;
    
    DBMS_OUTPUT.PUT_LINE(e_name || ' - ' || d_id);
END;




-- 변수의 갯수가 많은 경우 자료형을 일일히 맞춰서 선언하기가 번거로워진다.
-- 따라서 매칭할 필드의 이름과 %Type을 이용하여 자동으로 자료형이 맞춰지도록 한다.


DECLARE
    e_name employees.emp_name%TYPE; -- 테이블과 필드명을 쓰고 그 자료형을 맞추겠다는 의미.
    d_id employees.department_id%TYPE;
BEGIN
    select emp_name, department_id
    INTO e_name, d_id  
    from employees
    where employee_id=100;
    
    DBMS_OUTPUT.PUT_LINE(e_name || ' - ' || d_id);
END;




-- 연습문제 1
-- DBMS_OUPPUT.PUT_LINE() 을 9번 사용하여 구구단 3단을 출력하는 익명 블럭을 제작하자.
-- 이어붙이기 연산도 사용한다.
-- 현재는 변수가 필요하지 않기 때문에 DECLARE는 쓰지 않아도 된다.
-- 3x1=3  3x2=6  3x3=9  ...  에서 3, 6, 9, 는 계산에 의해 출력되게 만든다.



BEGIN
    DBMS_OUTPUT.PUT_LINE('3x1= ' || 3*1);
    DBMS_OUTPUT.PUT_LINE('3x2= ' || 3*2);
    DBMS_OUTPUT.PUT_LINE('3x3= ' || 3*3);
    DBMS_OUTPUT.PUT_LINE('3x4= ' || 3*4);
    DBMS_OUTPUT.PUT_LINE('3x5= ' || 3*5);
    DBMS_OUTPUT.PUT_LINE('3x6= ' || 3*6);
    DBMS_OUTPUT.PUT_LINE('3x7= ' || 3*7);
    DBMS_OUTPUT.PUT_LINE('3x8= ' || 3*8);
    DBMS_OUTPUT.PUT_LINE('3x9= ' || 3*9);
END;


-- 연습문제 2
-- 사원테이블(employees) 에서 id(employee_id)가 201번인 사원의 이름(emp_name)과 이메일(emp_email) 주소를 출력하는 익명 블록을 만들자.
-- 이름 - 이메일 형식으로 스크립트 출력창에 출력하자.

DECLARE
    e_name employees.emp_name%TYPE;
    e_email employees.email%TYPE;
BEGIN
    select emp_name, email
    INTO e_name, e_email
    from employees
    where employee_id=201;
    
    DBMS_OUTPUT.PUT_LINE(e_name || ' - ' || e_email);
END;


-- 연습문제 3
-- select 로 얻어낸 값을 insert 명령에 사용한다.
-- 사원테이블(employees) 테이블에서 가장 큰 사원번호로 조회하고,
-- 그 사원번호보다 1 만큼 큰 숫자를 새로운 입력 레코드의 사원번호로 하여 레코드를 추가하자.
-- 나머지 입력사항 :
-- 사원명 : Harrison Ford
-- 이메일 : HARRISON
-- 입사일자 : 현재 날짜
-- 부서번호 : 50
-- 실행부에서 마지막 명력 commit; 을 넣어주어야 한다.


DECLARE
    max_num employees.employee_id%TYPE;
BEGIN
    select MAX(employee_id)
    INTO max_num
    from employees;

    insert into employees(employee_id, emp_name, email, hire_date, department_id)
    values(max_num+1, 'Harrison Ford', 'HARRISON', sysdate, 50);
    
    commit; -- insert, update, delete 명령을 적용한 뒤에는 반드시 commit; 을 사용하자!
END;




