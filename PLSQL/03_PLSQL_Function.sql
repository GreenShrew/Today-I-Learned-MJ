-- 함수
-- PL/SQL 코드 작성시에는 지금까지 사용하던 익명블럭은 잘 사용하지 않는다.
-- 일반적으로 이름이 있는 서브 프로그램(함수) 또는 프로시저를 사용하는 것이 대부분이다.
-- 익명 블럭은 한번 사용하고 나면 없어져버리는 휘발성 블럭이지만,
-- 함수 또는 프로시저는 컴파일을 거쳐 데이터베이스에 저장되어 재사용이 가능한 구조이다.


-- 함수의 형태
-- CREATE OR REPLACE FUNCTION 함수이름(매개변수1, 매개변수2 ... )
-- RETURN 리턴될 데이터타입;
-- IS[AS]
--      변수, 상수 선언
-- BEGIN
--      실행부

--      RETURN 리턴값;
-- [ EXCEPTION
--      예외처리부 ]
-- END [함수이름];  <- 함수이름 생략 가능!

-- 상세내용
-- CREATE OR REPLACE FUNCTION : CREATE OR REPLACE FUNCTION 라는 구문을 이용하여 함수를 생성한다.
--      함수를 만들고 수정하더라도 이 구문을 계속 컴파일 할 수 있고, 마지막으로 컴파일 한 내용이
--      함수의 내용과 이름으로 사용된다.
-- 매개변수 : 전달인수를 저장하는 변수로, "변수이름 변수자료형" 형태로 작성한다.
-- 첫번째 RETURN 구분 바음에는 리턴될 자료의 자료형을 쓰고, 아래쪽 두번째 RETURN 구문 옆에는
--      그 자료형으로 실제 리턴될 값 또는 변수 이름을 써준다.


-- 두개의 정수를 전달해서 첫번쨰 값을 두번째 값으로 나눈 나머지를 구해서 리턴해주는 함수
-- 아래 myMod 를 실행하면 'Function MYMOD이(가) 컴파일되었습니다.' 라는 문구가 나온다.
-- 그리고 SQL 문으로 컴파일된 해당 함수를 사용할 수 있게 된다!

CREATE OR REPLACE FUNCTION myMod( num1 NUMBER, num2 NUMBER )
    RETURN NUMBER
IS
    vn_remainder NUMBER := 0;   -- 나머지를 저장할 변수
    vn_mok NUMBER := 0;    -- 몫을 저장할 변수
BEGIN
    vn_mok := FLOOR( num1/num2 );   -- 나눈 몫에서 정수만 저장(소수점 절사)
    vn_remainder := num1 - (num2*vn_mok);   -- 몫*젯수로 피젯수 빼고 나머지 계산
    RETURN vn_remainder;    -- 나머지 반환
END;

select myMod(14, 3) from dual;

select * from countries;
-- 함수 내에 SQL 문을 사용할 수도 있다!
-- countries 테이블에서 id를 받아서 나라 이름을 출력하는 함수를 제작
CREATE OR REPLACE FUNCTION fn_getCountryName( p_country_id NUMBER )
    RETURN VARCHAR2
IS
    vs_country_name COUNTRIES.COUNTRY_NAME%TYPE;    -- 나라 이름을 저장할 변수
BEGIN
    select country_name
    into vs_country_name
    from countries
    where country_id = p_country_id;
    
    RETURN vs_country_name;
END;

select fn_getCountryName(52777), fn_getCountryName(10000) from dual;
-- 위 select 명령 실행시 10000번 id는 null로 출력된다.
-- 이를 "해당국가 없음" 이라고 출력되도록 fn_getCountryName 함수를 수정하자.

CREATE OR REPLACE FUNCTION fn_getCountryName( p_country_id NUMBER )
    RETURN VARCHAR2
IS
    vs_count NUMBER(10);
    vs_country_name COUNTRIES.COUNTRY_NAME%TYPE;    -- 나라 이름을 저장할 변수
BEGIN
    -- 전달받은 아이디에 해당하는 국가의 갯수를 조회하고,
    -- 갯수가 0이면 "해당국가 없음", 0이 아니면 해당국가의 이름을 다시 조회해서 리턴
    
    select count(*)
    into vs_count
    from countries
    where country_id = p_country_id;
    
    IF vs_count >=1 THEN
        select country_name
        into vs_country_name
        from countries
        where country_id = p_country_id;
        
        RETURN vs_country_name;
    ELSE
        RETURN '해당국가 없음';
END;





















































































































































































