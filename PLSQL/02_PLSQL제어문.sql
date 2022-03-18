-- IF 문

-- 경우의 수가 둘중 하나이고, 단독 if로 사용할 때,
-- if 조건 then
--      실행문1
-- end if

-- 경우의 수가 둘중 하나이고, else와 함께 사용할때
-- if 조건 then
--      실행문1
-- else
--      실행문2
-- end if

-- 경우의 수가 셋 이상일때
-- if 조건1 then
--      실행문1
-- elsif 조건2 then   <- elsif 오타가 아니다.
--      실행문2
-- else
--      실행문3
-- end if


SET SERVEROUTPUT ON

DECLARE
    vn_num1 NUMBER := 1;
    vn_num2 NUMBER := 2;
BEGIN
    IF vn_num1 >= vn_num2 THEN
        DBMS_OUTPUT.PUT_LINE(vn_num1 || '이 큰 수');
    ELSE
        DBMS_OUTPUT.PUT_LINE(vn_num2 || '이 큰 수');
    END IF;
END;


-- employees 테이블에서 사원 한명을 선별하여, 그 월급(salary)의 금액에 따라 낮음, 중간, 높음 이라는 단어를 출력하는
-- 익명 테이블을 제작한다.    (1~3000 낮음, 3001~6000 보통, 6000~10000 높음)
-- 사원을 선별하는 방법은 RANDOM.VALUE 함수를 이용한다. 랜덤한 부서번호로 조회하되
-- 그 부서의 사원이 여럿이면 첫번째 사원으로 선택한다.


DECLARE
    -- 선택된 사원의 급여-월급(salary)를 저장할 변수
    vn_salary NUMBER := 0;
    -- 랜덤으로 발생한 부서번호를 저장할 변수
    vn_department_id NUMBER := 0;
BEGIN
    -- 랜덤하게 부서번호를 발생
    -- DBMS_RANDOM.VALUE(시작숫자, 끝숫자) : 시작 숫자부터 끝 숫자 사이의 임의 숫자를 발생한다.
    -- ROUND( 숫자, 반올림자리수 ) : 숫자를 지정된 반올림 자리에서 반올림한다.
    -- 반올림 자리수가 1이면 소수점 둘째자리에서 반올림해서 첫째자리까지 남김
    -- 반올림 자리수가 2이면 소수점 셋째자리에서 반올림해서 둘째자리까지 남김
    -- 반올림 자리수가 -1이면 1의 자리에서 반올림해서 10의 자리까지 남김
    vn_department_id := ROUND( DBMS_RANDOM.VALUE(10, 120) , -1 );
    
    select salary
    into vn_salary
    from employees
    where department_id = vn_department_id and rownum=1;
    
    DBMS_OUTPUT.PUT_LINE(vn_salary);
    
    IF vn_salary BETWEEN 1 AND 3000 THEN
        DBMS_OUTPUT.PUT_LINE('낮음');
    ELSIF vn_salary BETWEEN 3001 AND 6000 THEN
        DBMS_OUTPUT.PUT_LINE('중간');
    ELSIF vn_salary BETWEEN 6001 AND 10000 THEN
        DBMS_OUTPUT.PUT_LINE('높음');
    ELSE
        DBMS_OUTPUT.PUT_LINE('최상위');
    END IF;
END;



-- 중첩 IF문
DECLARE
    vn_salary NUMBER := 0;
    vn_department_id NUMBER := 0;
    vn_commission NUMBER := 0;
BEGIN
    vn_department_id := ROUND( DBMS_RANDOM.VALUE(10, 120) , -1 );
    
    select salary, nvl(commission_pct, 1)   -- commission_pct 이 null 값이 자꾸 나와서...
    -- nvl(a, b) : a가 null 값이면 b 값이 된다.
    into vn_salary, vn_commission
    from employees
    where department_id = vn_department_id and ROWNUM = 1;
    
    IF vn_commission > 0 THEN
        IF vn_commission < 0.15 THEN
            DBMS_OUTPUT.PUT_LINE(vn_salary * vn_commission);
        ELSE
            DBMS_OUTPUT.PUT_LINE(vn_salary);
        END IF;
    END IF;
END;






-- CASE 문, 예시는 위의 IF문 예시를 긁어왔다.
DECLARE
    vn_salary NUMBER := 0;
    vn_department_id NUMBER := 0;
BEGIN
    vn_department_id := ROUND( DBMS_RANDOM.VALUE(10, 120) , -1 );
    
    select salary
    into vn_salary
    from employees
    where department_id = vn_department_id and rownum=1;

    CASE WHEN vn_salary BETWEEN 1 AND 3000 THEN
            DBMS_OUTPUT.PUT_LINE('낮음');
        WHEN vn_salary BETWEEN 3001 AND 6000 THEN
            DBMS_OUTPUT.PUT_LINE('보통');
        WHEN vn_salary BETWEEN 6001 AND 10000 THEN
            DBMS_OUTPUT.PUT_LINE('높음');
        ELSE
            DBMS_OUTPUT.PUT_LINE('최상위');
    END CASE;
END;




-- CASE 유형1
-- CASE WHEN 조건식1 THEN
--          실행문1
--      WHEN 조건식2 THEN
--          실행문2
--      ...
--      ELSE
--          실행문3
-- END CASE;


-- CASE 유형2 - 표현식의 결과 값 또는 변수의 값들의 경우의 수로 분기한다.
-- 이건 예전에 case:1 ~~~ case:2 ~~~ ... 이렇게 쓰던 방법이다!

-- CASE 조건식 또는 표현식 또는 변수
--      WHEN 값1 THEN
--          실행문1
--      WHEN 값2 THEN
--          실행문2
--      ...
--      ELSE
--          실행문3
-- END CASE;





-- 반복실행문

-- LOOP 문

-- 반복실행 유형1
-- LOOP
--      실행문;
--      EXIT [WHEN 조건];
-- END LOOP;

-- 예시
DECLARE
    vn_base_num NUMBER := 4;    -- 단
    vn_cnt NUMBER := 1;         -- 반복 제어 변수 겸 승수
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || vn_cnt || '=' || vn_base_num*vn_cnt );
        vn_cnt := vn_cnt+1;
        EXIT WHEN vn_cnt > 9;
    END LOOP;
END;



-- 반복실행 유형2
-- WHILE 조건
-- LOOP
--      실행문
-- END LOOP;

DECLARE
    vn_base_num NUMBER := 6;    -- 단
    vn_cnt NUMBER := 1;         -- 반복 제어 변수 겸 승수
BEGIN
    WHILE vn_cnt <= 9   -- vn_cnt가 9보다 작거나 같을 경우에만 반복처리
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || vn_cnt || '=' || vn_base_num*vn_cnt );
        vn_cnt := vn_cnt+1; -- vn_cnt 값을 1씩 증가
    END LOOP;
END;



-- WHELE 과 EXIT WHEN 의 혼합사용
-- 아래 반복실행문은 다섯번째 반복에서 멈춘다.
DECLARE
    vn_base_num NUMBER := 7;    -- 단
    vn_cnt NUMBER := 1;         -- 반복 제어 변수 겸 승수
BEGIN
    WHILE vn_cnt <= 9   -- vn_cnt가 9보다 작거나 같을 경우에만 반복처리
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || vn_cnt || '=' || vn_base_num*vn_cnt );
        EXIT WHEN vn_cnt = 5;
        vn_cnt := vn_cnt+1; -- vn_cnt 값을 1씩 증가
    END LOOP;
END;


-- 반복실행 유형3
-- FOR 문

-- FOR 변수명 IN [REVERSE]시작값..끝값
-- LOOP
--      실행문
-- END LOOP;
-- 시작값부터 끝값까지 반복실행한다. REVERSE가 쓰여진 경우, 반대방향의 숫자 진행으로 반복실행한다.

DECLARE
    vn_base_num NUMBER := 8;
BEGIN
    FOR i IN 1..9
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || i || '=' || vn_base_num*i );
    END LOOP;
END;

-- REVERSE 를 사용한 경우
DECLARE
    vn_base_num NUMBER := 8;
BEGIN
    FOR i IN REVERSE 1..9
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || i || '=' || vn_base_num*i );
    END LOOP;
END;



-- CONTINUE 문
-- 해당 명령에 오면 나머지 반복문을 실행하지 않고 다음 반복으로 넘어간다.
DECLARE
    vn_base_num NUMBER := 9;
BEGIN
    FOR i IN 1..9
    LOOP
        CONTINUE WHEN i=5;  -- 조건이 충족하면 반복실행 영역중 나머지 명령을 실행하지 않고 다음 반복으로 진행한다.
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || i || '=' || vn_base_num*i );
    END LOOP;
END;



-- GOTO 문 (프로그래밍 언어에서 쓰지 말라고 권장되는 문법이다...)
DECLARE
    vn_base_num NUMBER := 5;
BEGIN
    <<fifth>>   -- 라벨이라고 부른다. GOTO 문의 이동 목적지로 사용되곤 한다.
    FOR i IN 1..9
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || i || '=' || vn_base_num*i );
        IF i = 3 THEN
            GOTO sixth;
        END IF;
    END LOOP;
    
    <<sixth>>
        vn_base_num := 6;
        FOR i IN 1..9
        LOOP
            DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || i || '=' || vn_base_num*i );
        END LOOP;
END;



-- NULL 문 : if 문 또는 case when 등에서 해당 경우에 실행해야 할 명령이 하나도 없을때 쓰는 구문이다.

-- IF vn_variable = 'A' THEN
--      처리로직1;
-- ELSIF vn_variable = 'B' THEN
--      처리로직2;
--      ...
-- ELSE 
--      NULL;
-- END IF;

-- CASE WHEN vn_variable = 'A' THEN
--          처리로직1;
--      WHEN vn_variable = 'B' THEN
--          처리로직2;
--          ...
--      ELSE
--          NULL;
-- END CASE;
