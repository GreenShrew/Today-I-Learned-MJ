-- command 창에서 운영되는 프로그램 접속

-- mysql -h localhost -u root -p
-- -h는 호스트, -u는 사용자, -p는 비밀번호를 의미한다.

-- mysql 종료는 quit 또는 exit


-- Schema 생성 (여기서 실행할 수 있지만, 학습중에는 cmd를 이용해서 만들 것이다.)
create schema scott default charcter set utf8mb4;

-- 아래는 cmd에서 명령하는 내용
-- 사용하려는 스키마로 이동
use scott;

-- 현재 스키마의 테이블들 보기
show tables;

-- 테이블의 구조 보기
desc 테이블이름;




-- LIMIT
-- select로 데이터를 조회할 때 조회할 레코드의 갯수를 조절 및 제한할 수 있다.
select * from memberlist order by num desc limit 5;
-- 회원 정보를 조회하여 5개의 레코드만 리턴한다.

-- OFFSET
-- select로 데이터를 조회할 때, 맨 위에서부터 offset에 지정한 번째까지는 뛰어넘고 그 다음부터 리턴
select * from memberlist order by num desc limit 3 offset 5;
-- 6번째 데이터부터 3개의 레코드 리턴 - 개수가 모자르면 있는곳까지 리턴

-- limit 와 offset의 동시사용
select * from memberlist order by num desc limit 5 offset 5;
-- 6번째 데이터부터 5개의 레코드 리턴
-- offset과 limit는 게시판이나 상품 진열시에 페이지를 표시하기 위한 용도로 가장 많이 사용한다.



