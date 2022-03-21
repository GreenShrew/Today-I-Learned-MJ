-- CURSOR
-- 주로 프로시져 내부의 SQL 명령중 SELECT 명령의 결과가 다수의 행으로 얻어졌을 때 사용하는,
-- 결과를 저장하는 메모리 영역을 지칭한다.

SET SERVEROUTPUT ON;

-- 예시1
declare
    vs_job_id varchar2(30);
begin
    select job_id into vs_job_id from employees where department_id = 30;
    DBMS_OUTPUT.PUT_LINE(vs_job_id);
end;    -- 부서번호가 30인 부서에는 여러 사원이 있는데, 
-- 여러 사원의 결과(job_id)를 하나의 변수 vs_job_id에 넣으려고 하니 에러가 발생한다.


-- 위의 익명블럭은 select 명령의 결과가 1행(row)이므로 실행이 가능하지만, select 명령의 결과가 2행 이상이라면
-- 에러가 발생한다. 2행 이상의 결과를 담을 수 있는 메모리영역(또는 변수)으로 사용하는 것이 CURSOR이며,
-- 자바의 리스트와 비슷한 구조를 갖고 있다.
-- 또는 반복실행문을 이용하여 그 값들을 참조하고 출력하고 리턴할 수 있다.




-- CURSOR의 실행단계

-- 1. CURSOR의 생성 (정의)
------------------------------------------------------------
-- CURSOR 사용할 커서의 이름[ (매개변수1, 매개변수2, ...) ]
-- IS
-- SELECT ....SQL 문장 (여기의 select의 결과가 커서에 저장된다)
------------------------------------------------------------
-- 매개변수의 역할 : select 명령에서 사용할 값들(주로 where 절에서 사용할 값들)
-- select ....SQL 문장 : CURSOR에 사용되어 결과를 안겨줄 SQL 명령


-- 2. CURSOR 의 OPEN  (호출)
------------------------------------------------------------
-- OPEN 커서이름[ (전달인수1, 전달인수2, ...) ]
------------------------------------------------------------
-- 실제로 전달인수를 전달하여 커서를 실행하고 결과를 저장


-- 3. 결과를 반복 실행문과 함께 필요에 맞게 처리
------------------------------------------------------------
-- LOOP
--      FETCH 커서이름 INTO 변수;
--      EXIT WHEN 커서이름%NOTFOUND;    <-- select 에 의해 얻어진 레코드가 다 소진되어 없을때까지 반복 계속
--      필요에 맞는 처리 실행
-- END LOOP;
------------------------------------------------------------
-- FETCH 커서이름 INTO 변수;  커서에 담긴 데이터들 중 한줄씩 꺼내서 변수에 넣는 동작이다.
-- EXIT WHEN 커서이름%NOTFOUND;     꺼냈는데 데이터가 없으면 종료한다.
-- LOOP 안에서 필요에 맞는 처리를 데이터가 없을때 까지 반복한다.

-- 4. CURSOR 닫기
------------------------------------------------------------
-- close 커서명
------------------------------------------------------------





-- cursor의 사용
-- 전달인수로 부서번호를 전달한 후, 그 부서의 사원 이름들을 얻어오는 커서

SET SERVEROUTPUT ON;


declare
    vs_emp_name employees.emp_name%type;    -- 사원명을 저장하기 위한 변수
    vs_employee_id employees.employee_id%type;  -- 사원 번호를 저장하기 위한 변수
    
    -- 1. CURSOR 선언(생성, 정의)
    -- 부서번호를 커서에 전달해서 그 부서 번호와 같은 사원의 사원번호와 이름을 얻어내는 커서 선언
    CURSOR cur_emp_dep(cp_department_id employees.department_id%type)
    IS
    SELECT employee_id, emp_name FROM employees WHERE department_id = cp_department_id; -- 아직 sql 문이 실행된건 아니다.
begin
    -- 2. 커서를 실행한다.(호출)
    OPEN cur_emp_dep(90);   -- 전달인수로 부서번호 90을 넣어준다.
    
    -- 3. 반복 실행문으로 커서에 저장된 데이터를 꺼내서 출력한다.
    LOOP
        -- 반복이 실행되는 동안 커서의 저장된 데이터를 한 행씩 꺼내서 vs_employee_id, vs_emp_name 변수에 저장한다.
        FETCH cur_emp_dep INTO vs_employee_id, vs_emp_name;
        EXIT WHEN cur_emp_dep%NOTFOUND;  -- 다음 레코드가 없을때까지 반복
        DBMS_OUTPUT.PUT_LINE(vs_employee_id || ' - ' || vs_emp_name);    -- 꺼낸 내용을 출력
    END LOOP;
    CLOSE cur_emp_dep;  -- 커서 닫기
    
end;





-- 커서와 for 문
-- 기존의 FOR문 -----------------------------
-- FOR 인덱스변수 IN [REVERSE] 처음값 .. 끝값
-- LOOP
--      실행문
-- END LOOP;
--------------------------------------------


-- 커서와 함께 사용하는 for 문 --------------------
-- FOR 레코드변수 IN 커서이름(전달인수1, 전달인수2 ... )
-- LOOP
--      실행문
-- END LOOP;
-------------------------------------------------

-- FOR 레코드변수 IN 커서이름(전달인수1, 전달인수2 ... )  :  OPEN 으로 실행(호출)하던 동작이 FOR문의 IN 다음으로 이동
-- 실행 결과는 하나씩(1행, 1레코드) 레코드 변수에 저장되어 반복실행된다.
-- 자동으로 실행결과의 갯수만큼 반복 실행된다.
declare
    -- 레코드 변수를 사용하기 때문에 각 필드값을 저장할 변수는 만들지 않는다.
    CURSOR cur_emp_dep(cp_department_id employees.department_id%type)
    IS
    SELECT employee_id, emp_name FROM employees WHERE department_id = cp_department_id;
begin
    FOR emp_rec IN cur_emp_dep(90)
    LOOP
        DBMS_OUTPUT.PUT_LINE(vs_employee_id || ' - ' || vs_emp_name);
    END LOOP;
end;

-- OPEN과 FETCH를 For 문에 하나로 합친 모습...
-- CLOSE도 사라졌다!
-- 앞선 방법보다 더 간단하다.



-- 조금 더 간결한 FOR 문과 커서의 사용
declare

begin
    FOR emp_rec IN (SELECT employee_id, emp_name    -- CURSOR의 내용이 아예 직접 들어갔다.
                    FROM employees 
                    WHERE department_id = 90)
    LOOP
        DBMS_OUTPUT.PUT_LINE(employee_id || ' - ' || emp_name);
    END LOOP;
end;




-- 연습문제
-- 부서번호가 30번인 사원의 이름, 부서명, 급여, 급여(높음, 보통, 낮음)을 출력하자.
-- 급여(salary)는 5000 미만 낮은, 10000 미만 보통, 나머지 높음으로 출력하자.
-- 이름 - 부서명 - 급여 - 높음 순으로 출력한다.
select * from employees;
select * from departments;
declare
    level varchar2(10); -- 급여의 높음, 보통, 낮음 을 표현할 변수
begin
    FOR emp_rec IN (select a.emp_name, b.department_name, a.salary
                    from employees a, departments b
                    where a.department_id = 30 and a.department_id = b.department_id)
    LOOP
        if emp_rec.salary <= 5000 then
            level := '낮음';
        elsif emp_rec.salary <= 10000 then
            level := '보통';
        else
            level := '높음';
        end if;
        DBMS_OUTPUT.PUT_LINE(emp_rec.emp_name || ' - ' || emp_rec.department_name || ' - ' || emp_rec.salary || ' - ' || level);
    END LOOP;
end;



-- 커서 변수
-- 앞에서 생성한 커서의 이름은 함수처럼 호출되는 이름이기도 하고, 커서를 대표하는 이름이 있다.
-- 그러나 커서의 이름으로 다른 커서를 만들지는 못한다.
-- 변수로 치면 앞에서 만든 커서의 이름은 상수 정도로 표현이 가능하다.
-- 앞으로 나올 이름은 변수로서 사용되고, 다른 커서도 저장할 수 있게 사용하고자 한다.

-- 커서 변수의 선언
-- TYPE 사용할 커서의 이름 IS REF CURSOR [ RETURN 반환타입 ];   --> 생성된 커서타임의 이름으로 커서 변수를 선언할 예정이다.
-- 커서변수이름 커서타입이름;
-- 커서 타입을 만들떄 RETRUN 값을 지정하면 강한커서타입이 생성되는것이고, RETURN이 없으면 약한 커서타입이라고 지칭한다.

TYPE dep_curtype1 IS REF CURSOR RETURN departments%ROWTYPE; -- 강한 커서 타입 (select의 결과가 departments 테이블과 자료형이 같아야 한다)
TYPE dep_curtype2 IS REF CURSOR; -- 약한 커서 타입
-- 위 두줄의 명령은 커서의 이름을 생성한것이 아니라, 커서를 선언할 수 있는 커서자료형을 생성한것이다.
-- 생성된 커서 자료형으로 커서 변수를 생성할 수 있다.
-- 강한 커서 타입은 정말 특별한 경우가 아니라면 안 쓴다!

cursor1 dep_curtype1;
cursor2 dep_curtype2;
-- cursor1과 cursor2 변수에는 select 명령을 담아서 커서를 완성할 수 있다.
-- 또한, 커서내용(select 문)이 고정적이지 않고 바뀔 수 있다.
-- 다만 cursor1은 강한 커서 타입이므로, 정의되어 있는데로 (RETURN departments%ROWTYPE) 레코드 전체의 결과를 얻는 select만 저장할 수 있다.

-- 커서 변수로 커서를 만들어보는 예시.
OPEN cursor1 FOR SELECT employee_id, emp_name FROM employees WHERE department_id = 90;  -- X 불가능! 강한 커서 타입으로 return 타입이 고정되어있으므로
OPEN cursor1 FOR SELECT * FROM departments WHERE department_id = 90;  -- o 가능!

OPEN cursor2 FOR SELECT employee_id, emp_name FROM employees WHERE department_id = 90;  -- o 가능!
OPEN cursor2 FOR SELECT * FROM departments WHERE department_id = 90;  -- o 가능!



-- 커서 변수를 만들어서 필요할때마다 커서 내용을 저장하고 호출해서 그 결과를 사용하려고 변수를 만든다.
declare
    vs_emp_name employees.emp_name%TYPE;    -- 일반 변수 선언
    vs_dep_id employees.department_id%TYPE;    -- 일반 변수 선언
    TYPE emp_dep_curtype IS REF CURSOR;     -- 약한 커서 타입 선언
    emp_dep_curvar emp_dep_curtype;         -- 생성한 커서 타입으로 커서변수 선언
begin
    OPEN emp_dep_curvar FOR select emp_name, department_id
                            from employees
                            where department_id = 90;   -- 커서변수에 select 문 설정
    LOOP
        FETCH emp_dep_curvar INTO vs_emp_name, vs_dep_id;  -- select의 결과를 하나씩 꺼내서 vs_emp_name, vs_dep_id 에 넣는다.
        EXIT WHEN emp_dep_curvar%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(vs_emp_name || ' - ' || vs_dep_id);
    END LOOP;
end;





-- 앞으로 가장 많이 사용하게될 커서! 시스템에서 제공해주는 커서 타입! ( 앞서 설명한 CURSOR 들은 이걸 배우기 위함임)
dep_curtype3 SYS_REFCURSOR; -- 시스템에서 제공해주는 커서 타입

-- SYS_REFCURSOR 를 사용하면
-- TYPE emp_dep_curtype IS REF CURSOR; -- 커서타입 생성 생략가능
-- emp_dep_curvar emp_dep_curtype;      -- 변수 선언 SYS_REFCURSOR 형태로 선언

declare
    vs_emp_name employees.emp_name%TYPE;
    vs_salary employees.salary%TYPE;
    emp_dep_curvar SYS_REFCURSOR;   -- SYS_REFCURSOR 타입의 커서변수 선언
begin
    OPEN emp_dep_curvar FOR SELECT emp_name, salary
                            FROM employees
                            WHERE department_id = 90;
    LOOP
        FETCH emp_dep_curvar INTO vs_emp_name, vs_salary;  -- select의 결과를 하나씩 꺼내서 vs_emp_name, vs_salary 에 넣는다.
        EXIT WHEN emp_dep_curvar%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(vs_emp_name || ' - ' || vs_salary);
    END LOOP;
end;


-- 순서 정리!
-- 1. SYS_REFCURSOR 변수 생성
-- 2. 변수에 select를 연결
-- 3. FETCH로 꺼내서 처리(반복실행)



-- 프로시져에서의 커서 사용 예
-- select의 결과를 cursor에 담아서 프로시져를 호출한 지점에 보내주려고 한다.
CREATE OR REPLACE PROCEDURE testCursorArg(
    p_curvar OUT SYS_REFCURSOR  -- 내보낼 예정이니 OUT, 내보내는 변수가 temp_curvar이므로 자료형은 SYS_REFCURSOR
)
IS
    temp_curvar SYS_REFCURSOR;  -- 프로시져에서 사용할 커서 변수
BEGIN
    OPEN temp_curvar FOR SELECT emp_name, salary FROM employees WHERE department_id=90;
    -- 현재 위치에서 커서의 내용을 fetch 하여 꺼내 쓸게 아니기 때문에, 반복실행도 fetch도 쓰지 않는다.
    p_curvar := temp_curvar;    -- OUT 변수에 데이터를 넣어주는것은 무언가를 return 시키는것과 같다.
END;

-- 위에서 만든 testCursorARG 프로시져를 사용한다.
DECLARE
    out_curvar SYS_REFCURSOR;   -- 커서 변수 생성
    vs_emp_name employees.emp_name%TYPE;    -- 일반 변수 선언
    vs_salary employees.salary%TYPE;
BEGIN
    testCursorARG( out_curvar );    -- select의 결과를 out_curvar 에 저장한다.
    LOOP
        FETCH out_curvar INTO vs_emp_name, vs_salary;
        EXIT WHEN out_curvar%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(vs_emp_name || ' - ' || vs_salary);
    END LOOP;
END;

-- mybatis 에서 프로시져 실행시 조회 데이터를 전달하는 중요한 역할을 하는것이 cursor이다.
-- 따라서 위의 예제는 커서를 전달인수로 전달해서 조회결과를 담아 올 수 있는 형식으로 이루어짐과 동시에
-- mybatis 에서 사용하기 딱 좋은 형식이므로 중요한 예제로 기억해두고 필요시 참고하는것이 좋다.
