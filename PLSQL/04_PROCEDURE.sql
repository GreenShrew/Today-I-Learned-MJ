-- 프로시져
-- 함수와 비슷한 구조이다.
-- 함수는 결과 리턴이 있지만, 프로시져는 결과 리턴이 없는것이 특징이다. (리턴을 위한 별도의 코드(변수)가 있다.)

-- 참고로 [ ] 이건 생략 가능, [ a | b ] 는 a, b 둘중에 하나 선택을 의미한다.

-- 프로시져의 생성
-- CREATE OR REPLACE PROCEDURE 프로시져이름(
--      매개변수명1 [IN | OUT | IN OUT] 데이터타입[:=디폴트 값],
--      매개변수명2 [IN | OUT | IN OUT] 데이터타입[:=디폴트 값],
--      ...
-- )
-- IS[AS]
--      변수, 상수 선언
-- BEGIN
--      실행부
-- [ EXCEPTION
--      예외처리부 ]
-- END [프로시져이름];

-- CREATE OR REPLACE PROCEDURE : 프로시져를 생성하는 구문이다.
-- 매개변수명1 [IN | OUT | IN OUT] : 매개변수를 만들되 전달되는 전달인수를 받는 IN 변수와
--      리턴역할을 할 수 있는 OUT 변수를 만들때 사용한다. 입력변수와 출력변수의 역할이 동시에 부여되려면
--      IN OUT 을 같이 기술한다.
--      프로시져는 기본적으로 리턴값이 없지만(실제 RETURN 명령을 사용하지 않음) 변수의 속성에 OUT 속성 하나를
--      부여함으로서 리턴의 역할을 흉내낼수 있게는 사용이 가능하다.
--      변수 속성이 IN 인 경우 생략이 가능하다.


-- 프로시져 예시
-- JOBS 테이블에 레코드를 추가하는 프로시져
select * from JOBS;
CREATE OR REPLACE PROCEDURE my_new_job_proc (
    p_job_id JOBS.JOB_ID%TYPE,  -- IN을 쓰지 않아도 된다.
    p_job_title IN JOBS.JOB_TITLE%TYPE,
    p_min_salary IN JOBS.MIN_SALARY%TYPE,
    p_max_salary IN JOBS.MAX_SALARY%TYPE
)
IS
-- 이번에는 IS에 쓸 내용이 없다...
BEGIN
    INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY, CREATE_DATE, UPDATE_DATE)
    VALUES(p_job_id, p_job_title, p_min_salary, p_max_salary, SYSDATE, SYSDATE);
    COMMIT;
END;

-- 위에서 만든 프로시저의 호출은 아래와 같이 한다.
EXEC my_new_job_proc ('SM_JOB1', 'Sample JOB1', 1000, 5000);


-- EXEC 명령으로 레코드가 추가되었는지 확인
select * from jobs where job_id = 'SM_JOB1';



-- 예제 두번째
-- JOBS 테이블에 레코드를 추가하되, 추가할 내용의 JOB_ID 가 이미 존재하는 값이면, 해당 내용들로 수정을,
-- 없으면 레코드를 INSERT 하는 프로시저를 생성하자.
-- 실행할 구문은 아래와 같다.
EXEC my_new_job_proc ('SM_JOB1', 'Sample JOB2', 2000, 6000);
EXEC my_new_job_proc ('SM_JOB2', 'Sample JOB2', 2500, 6500);

select * from jobs where job_id like '%SM_JOB%';

CREATE OR REPLACE PROCEDURE my_new_job_proc(
    p_job_id IN JOBS.JOB_ID%TYPE,
    p_job_title IN JOBS.JOB_TITLE%TYPE,
    p_min_salary IN JOBS.MIN_SALARY%TYPE,
    p_max_salary IN JOBS.MAX_SALARY%TYPE
)
IS
    vn_cnt NUMBER(10);
BEGIN
    select count(*) into vn_cnt from jobs where job_id=p_job_id;    -- 동일한 값의 job_id가 있는지 체크
    
    if vn_cnt = 0 THEN  -- 조회된 레코드가 0개면 insert, 아니면 update
        INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY, CREATE_DATE, UPDATE_DATE)
        VALUES(p_job_id, p_job_title, p_min_salary, p_max_salary, SYSDATE, SYSDATE);
    ELSE
        UPDATE JOBS set JOB_TITLE = p_job_title, MIN_SALARY = p_min_salary, MAX_SALARY = p_max_salary, update_date = SYSDATE
        where JOB_ID = p_job_id;
    END IF;
    COMMIT;
END;



-- OUT, IN OUT 매개변수 사용
CREATE OR REPLACE PROCEDURE my_new_job_proc2(
    p_job_id IN JOBS.JOB_ID%TYPE,
    p_job_title IN JOBS.JOB_TITLE%TYPE,
    p_min_salary IN JOBS.MIN_SALARY%TYPE,
    p_max_salary IN JOBS.MAX_SALARY%TYPE,
    p_upd_date OUT JOBS.UPDATE_DATE%TYPE        -- OUT 매개변수 추가
)
IS
    vn_cnt NUMBER(10);
    vn_cur_date JOBS.UPDATE_DATE%TYPE := SYSDATE;   -- 변수 추가
BEGIN
    select count(*) into vn_cnt from jobs where job_id=p_job_id;    -- 동일한 값의 job_id가 있는지 체크
    
    if vn_cnt = 0 THEN  -- 조회된 레코드가 0개면 insert, 아니면 update
        INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY, CREATE_DATE, UPDATE_DATE)
        VALUES(p_job_id, p_job_title, p_min_salary, p_max_salary, SYSDATE, SYSDATE);
    ELSE
        UPDATE JOBS set JOB_TITLE = p_job_title, MIN_SALARY = p_min_salary, MAX_SALARY = p_max_salary, update_date = SYSDATE
        where JOB_ID = p_job_id;
    END IF;
    COMMIT;
    p_upd_date := vn_cur_date;  -- OUT 변수에 저장
END;

SET SERVEROUTPUT ON

-- 위의 my_new_job_proc2에서 저장한 OUT 변수를 아래 익명 함수에서 가져다 쓴다.
DECLARE
    vd_cur_date JOBS.UPDATE_DATE%TYPE;
BEGIN
    -- 익명블록에서 프로시져를 호출할때는 exec를 사용하지 않는다.
    my_new_job_proc2 ('SM_JOB1', 'Sample JOB2', 2000, 6000, vd_cur_date);
    -- 다섯번째 인수로 넣어준 현재 익명블록의 변수에,
    -- 프로시져의 OUT 변수가 연결되어 그 값을 돌려받듯이 받아서 사용이 가능하다.
    -- 프로시져 내에서 OUT 변수에 값을 대입하면, 현재 위치의 전달인수로 넣어준 vd_cur_date 변수에 넣은것과 같은 효과를 갖는다.
    DBMS_OUTPUT.PUT_LINE(vd_cur_date);
END;





-- 디폴트 밸류
-- 미리 값을 집어넣는 방법
CREATE OR REPLACE PROCEDURE my_new_job_proc3(
    p_job_id IN JOBS.JOB_ID%TYPE,
    p_job_title IN JOBS.JOB_TITLE%TYPE,
    p_min_salary IN JOBS.MIN_SALARY%TYPE := 100,
    p_max_salary IN JOBS.MAX_SALARY%TYPE := 800
)
IS
    vn_cnt NUMBER(10);
BEGIN
    select count(*) into vn_cnt from jobs where job_id=p_job_id;
    
    if vn_cnt = 0 THEN
        INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY, CREATE_DATE, UPDATE_DATE)
        VALUES(p_job_id, p_job_title, p_min_salary, p_max_salary, SYSDATE, SYSDATE);
    ELSE
        UPDATE JOBS set JOB_TITLE = p_job_title, MIN_SALARY = p_min_salary, MAX_SALARY = p_max_salary, update_date = SYSDATE
        where JOB_ID = p_job_id;
    END IF;
    COMMIT;
END;

exec my_new_job_proc3 ('SM_JOB1', 'Sample JOB1');
select * from jobs where job_id = 'SM_JOB1';


-- 매개변수 인수 전달시, 순서 변경
exec my_new_job_proc( p_min_sal => 5000, p_job_id => 'SM_JOB1', p_max_sal => 10000, p_job_title => 'Sample JOB1');
select * from jobs where job_id = 'SM_JOB1';



-- IN 변수와 OUT 변수와 IN OUT 변수
CREATE OR REPLACE PROCEDURE my_parameter_test_proc (
    p_var1 IN    VARCHAR2,
    p_var2 OUT   VARCHAR2,
    p_var3 IN OUT VARCHAR2
)
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('p_var1 value = ' || p_var1);
    DBMS_OUTPUT.PUT_LINE('p_var2 value = ' || p_var2);  -- OUT 변수는 전달된 값이 있어도 적용이 되지 않는다.
    DBMS_OUTPUT.PUT_LINE('p_var3 value = ' || p_var3);
    -- OUT 변수에 넣어준 값은 호출에 사용된 전달인수로서의 변수 (익명블럭의 v_var2, v_var3) 에 적용된다.
    
    -- p_var1 := 'A2';  -- IN 변수는 전달인수에 의해 값이 정해질뿐 임의로 값을 넣지 못한다.
    p_var2 := 'B2';
    p_var3 := 'C2';
END;

declare
    v_var1 VARCHAR2(10) := 'A';
    v_var2 VARCHAR2(10) := 'B';     -- B를 넣어서 보내지만, OUT 변수이므로 아무 의미 없다...
    v_var3 VARCHAR2(10) := 'C';
begin
    -- 변수가 저장한 값이 전달인수로 잘 전달될것 같지만, 프로시져의 OUT 변수(p_var2)에는 전달되지 않는다.
    my_parameter_test_proc (v_var1, v_var2, v_var3);
    
    -- 프로시져에 OUT 변수로 전달된 변수는 프로시
end;


-- IN OUT 변수의 사용 규칙
-- 1. IN 변수는 전달인수로 전달되어 저장된 값을 참조만 할 수 있고, 값을 할당할 수 없다.
-- 2. OUT 변수에는 전달인수로 값을 전달할 수는 있지만, 참조할 수 없으므로 의미가 없는 전달이다.
-- 3. OUT 변수와 IN OUT 변수는 디폴트값을 지정할 수 없다.
-- 4. IN 변수에는 변수, 상수, 각 데이터형에 따른 값을 전달인수로 전달할 수 있지만, OUT 변수와 IN OUT 변수는
--      반드시 변수 형태로 전달인수를 넣어줘야한다.




-- RETURN 문: 프로시져에서 RETURN은 값을 리턴하겠다는 명령이 아니고, 현 시점에서 프로시져를 끝내겠다는 뜻이다.
--      자바에서 void 메서드 실행중에, return 명령으로 중간에 메소드를 종료하는것과 비슷하다.
CREATE OR REPLACE PROCEDURE my_new_job_proc4(
    p_job_id IN JOBS.JOB_ID%TYPE,
    p_job_title IN JOBS.JOB_TITLE%TYPE,
    p_min_salary IN JOBS.MIN_SALARY%TYPE := 10,
    p_max_salary IN JOBS.MAX_SALARY%TYPE := 100
)
IS
    vn_cnt NUMBER := 0;
BEGIN
    -- 1000 보다 작으면 메세지 출력 후 빠져나간다.
    IF p_min_sal < 1000 THEN
        DBMS_OUTPUT.PUT_LINE('최소 급여값은 1000 이상이어야 합니다');
        RETURN;
    END IF;
    -- IF문 조건이 참이면 아래 명령은 실행되지 않고 프로시져는 종료하게 된다.
    -- 조건이 거짓일때는 아래의 명령을 실행한다.
END;
