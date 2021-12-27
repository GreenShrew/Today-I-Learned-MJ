-- MySQL의 내장함수

-- #1 숫자 관련 함수
-- abs(숫자) : 절대값 계산
-- CEILING(숫자) : 값보다 큰 정수 중 가장 작은 작은 수
-- FLOOR(숫자) : 값보다 작은 정수 중 가장 큰 수[실수를 무조건 버림(음수일 경우는 제외)]
-- round(숫자, 자리수) : 소수점 자리수만큼 남기고 아래서 반올림
-- truncate(숫자, 자리수) : round와 같은 동작이지만 반올림이 아닌 버림
-- pow(x, y) : x의 y 자승
-- mod(x, y) : x를 y로 나눈 나머지 계산
-- greatest(x, y, z, ...) : 주어진 숫자 중에서 가장 큰 숫자
-- least(x, y, z, ...) : 주어진 숫자 중에서 가장 작은 숫자.

select greatest(201,84,0,546,31,74,963) from dual;
select floor(123.1234) from dual;
-- 특정 테이블을 대상으로 하면서 필드값이 함수의 입력값이 아니라면 from 뒤에 dual을 써서
-- 함수의 결과를 볼 수 있다.



-- #2 문자 관련 함수
-- ascii(문자) : 해당 문자의 아스키 코드값
select ascii('A') from dual;

-- concat(문자열1, 문자열2, 문자열3 ...) : 주어진 문자열들을 이어붙이는 연산
select concat('abcd', 'EFG', 'hijk') from dual;
--> 만약 Oracle에서 concat을 썼다면 아래와 같을것이다.
--> select 'abcd' || 'EFG' || 'hijk' from dual;

-- insert(문자열, 시작위치, 길이, 바꿀문자열) : 문자열의 시작위치부터 길이 만큼 바꿀 문자열로 대치
select insert('나는 버스를 타고 갑니다', 4, 3, '승용차를') from dual;

-- replace(문자열, 기본문자열, 바꿀 문자열) : 문자열 안에 있는 기본 문자열을 바꿀 문자열로 대치
select replace('나는 버스를 타고 갑니다', '버스를', '승용차를') from dual;

-- INSTR('문자열', '찾는문자열') : 문자열 중 찾는 문자열의 위치값을 출력
select instr('나는 버스를 타고 갑니다', '버스를') from dual;

-- LEFT('문자열', 개수) : 문자열 중 왼쪽에서 개수만큼을 추출
select left('나는 버스를 타고 갑니다', 5) from dual;

-- RIGHT('문자열', 개수) : 문자열 중 오른쪽에서 개수만큼을 추출
select right('나는 버스를 타고 갑니다', 5) from dual;

-- MID('문자열', 시작위치, 개수) : 문자열 중 시작 위치부터 개수만큼을 출력
select mid('나는 버스를 타고 갑니다', 8, 2) from dual;

-- SUBSTRING('문자열', 시작위치, 개수) - 문자열 중 시작 위치부터 개수만큼을 출력
select substring('나는 버스를 타고 갑니다', 8, 2) from dual;

-- LTRIM('문자열') : 문자열 중 왼쪽의 공백을 없앤다.
-- RTRUM('문자열') : 문자열 중 오른쪽의 공백을 없앤다.
-- TRIM('문자열') : 양쪽 모두의 공백을 없앤다.
-- LCASE('문자열') or LOWER('문자열') : 소문자로 바꾼다.
-- UCASE('문자열') or UPPER('문자열') : 대문자로 바꾼다.
-- REVERSE('문자열') : 문자열을 반대로 나열한다.



-- #3 집계 함수
-- COUNT(필드명) : NULL 값이 아닌 레코드 수를 구한다.
-- COUNT(*) : 모든 레코드 갯수를 구한다.
-- SUM(필드명) : 필드명의 합계를 구한다.
-- AVG(필드명) : 각각의 그룹 안에서 필드명의 평균값을 구한다.
-- MAX(필드명) : 최대값을 구한다.
-- MIN(필드명) : 최소값을 구한다.



-- #4 날짜 관련 함수
-- now() : 현재 날짜와 시간 (datetime 형식)
-- curdate() or current_date() : 현재 날짜 (date 형식)
-- curtime() or current_time() : 현재 시간 (time 형식)
-- DATE_ADD(날짜, INTERVAL 기준값 더할숫자) : 날짜에서 기준값만큼 더한다.
-- 기준값 : YEAR, MONTH, DAY, HOUR, MINUTE, SECOND
select date_add(now(), interval 2 day) from dual;
select date_add(now(), interval 3 month) from dual;
-- DATE_SUB(날짜, INTERVAL 기준값 뺄숫자) : 날짜에서 기준값만큼 뺀다.
-- 기준값 : YEAR, MONTH, DAY, HOUR, MINUTE, SECOND
select date_sub(now(), interval 1 month) from dual;



-- YEAR(날짜) : 날짜의 연도 출력
-- MONTH(날짜) : 날짜의 월 출력
-- MONTHNAME(날짜) : 날짜의 월을 영어로 출력
-- DAYNAME(날짜) : 날짜의 요일을 영어로 출력
-- DAYOFMONTH(날짜) : 날짜의 월별 일자 출력
-- DAYOFWEEK(날짜) : 날짜의 주별 일자 출력(일요일(1), 월요일(2) ... 토요일(7))
-- WEEKDAY(날짜) : 날짜의 주별 일자 출력(월요일(0), 화요일(1) ... (일요일(6))
-- DAYOFYEAR(날짜) : 일년을 기준으로 한 날짜까지의 날 수.
-- WEEK(날짜) : 일년 중 몇번째 주
-- FROM_DAYS(날 수) : 00년 00월 00일 부터 날 수 만큼 경과한 날의 날짜 출력
-- TO_DAYS(날짜) : 00년 00월 00일 부터 날짜까지의 일자 수 출력
-- DATE_FORMAT(날짜, '형식') : 날짜를 형식에 맞게 출력


-- 예시)
-- 오라클의 to_char() 날짜 -> 문자
date_format(now(), '%Y%m%d')
-- 오라클의 to_date() 문자 -> 날짜
str_to_date ('20211013', '%Y%m%d')

select date_format(now(), '%Y%m%d') from dual;
select str_to_date ('20211013', '%Y%m%d') from dual;


-- #4-1 날짜관련 함수에 쓰일 수 있는 형식지정자들
-- %a	일 (Sun ~ Sat)
-- %b	월 (Jan ~ Dec)
-- %c		월 (01 ~ 12)
-- %d	일 (01 ~ 31)
-- %e	일 (0 ~ 31)
-- %f		Microseconds (000000 to 999999)
-- %H	시간 (00 ~ 23)
-- %h	시간 (00 ~ 12)
-- %I		시간 (00 ~ 12)
-- %i		분 (00 ~ 59)
-- %j		Day of the year (001 to 366)
-- %k	시간 (0 ~ 23)
-- %l		시간 (1 ~ 12)
-- %M	월 (January ~ December)
-- %m	월 (00 ~ 12)
-- %p	AM or PM
-- %r		시간(12시)을 hh:mm:ss AM/PM 형식으로
-- %S	초(00 ~ 59)
-- %s		초(00 ~ 59)
-- %T	시간(24시)을 hh:mm:ss 형식으로



