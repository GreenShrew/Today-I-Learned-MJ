--오라클 명령어 : select 문(검색)
--[1] scott 사용자가 관리하고 있는 테이블 목록
select * from tab;   --  단순 검색
select * from tabs;  -- 상세 검색

--[2] 특정 테이블의 구조 조회(필드 리스트/데이터 형식)
desc dept;  -- 커멘드 창(sqlplus)에서 확인 요망
desc memberlist; -- 커멘드 창(sqlplus)에서 확인 요망
desc rentlist;

-- SELECT : select 와 from 사이에 조회하고자 하는 필드명들을 ,로 구분하여 지목
	-- select booknum, subject, outprice from....
	-- 모든 필드를 한번에 지목하려면   * 을 써줍니다   	-- select * from...
	-- from 뒤에는 대상 테이블 명을 써줍니다.
	-- where 절을 붙여서 조건에 맞는 행만 골라내기도 합니다.
	-- select ... from... where ...
	
	select subject, makeyear as 출판년도 from booklist;
	select * from booklist;

	-- 아래와 같이 연산식을 써서 연산된 결과를 필드로 조회하고자 할땐 as 와 함께 만들어진 필드명을 
	-- 지어주기도 합니다
	select empno || '-' || ename as empInfo  from emp;
	-- 오라클 SL 에서  || 는 이어붙이기 연산입니다.
	-- empno || '-' || ename : empno 값과 ename 값을 '-' 와 함께 이어 붙이기 하고 그렇게 
	-- 만들어진 필드의 이름을 emp_info 로 설정합니다
	-- 필드명에 공백이 있거나 기술하기 어려운 필드명일때도 as로 별칭을 붙이기도 합니다.
	select empno as 사원번호 , ename as "사원 성명"   from emp

--[3] 특정 테이블의  모든 필드 표시
select * from rentlist
--[4] 모든 컬럼(필드명)이 아닌 , 필요한 필드만 조회
select subject, makeyear from booklist;
--[5] 각각의 필드명에 별칭을 부여해서 출력
select subject as 도서제목, makeyear as 출판년도 from booklist;


insert into rentlist values('2021/12/15', rent_seq.nextVal, 7, 9, 100);
insert into rentlist values('2021/12/15', rent_seq.nextVal, 8, 10, 100);
insert into rentlist values('2021/12/16', rent_seq.nextVal, 7, 10, 100);
insert into rentlist values('2021/12/16', rent_seq.nextVal, 8, 9, 100);

insert into rentlist values('2021/12/17', rent_seq.nextVal, 7, 1, 100);
insert into rentlist values('2021/12/17', rent_seq.nextVal, 8, 2, 100);
insert into rentlist values('2021/12/18', rent_seq.nextVal, 7, 1, 100);
insert into rentlist values('2021/12/18', rent_seq.nextVal, 8, 2, 100);
select * from rentlist;

select booknum from rentlist;

--[6] 중복 제거
select distinct booknum from rentlist
-- rentlist 에서 membernum 을 중복 제거후 조회하세요
select distinct membernum from rentlist

--[7] 검색 조건의 추가 : 입고가격이 20000원 이상인 book 목록
select * from booklist where inprice >=20000;
--[8] 이름이 '홍'으로 시작하는  회원의 모든 회원정보 출력
select * from memberlist where name like '홍%';
--[9] 1983년도 이후로 태어난 회원의 모든 회원정보
select * from memberlist where birth >= '1983-01-01';
--[10] 사은포인트(BPOINT)가 250점 이상이고 1982년 이후로 태어난회원의 
-- 모든 회원정보(and,or 연산자 사용)
select * from memberlist where bpoint>=250 and birth>='1982-01-01';


--[11] 출판년도가 2016년 이전이거나  입고가격(inprice)이 18000 이하인 book 정보
select * from booklist where makeyear<2018 or inprice<=18000;
--[12] 성명이 '이'로 시작하는 회원의 모든 정보	
select * from memberlist where name like '이%';
--[13] 이름이 '용'으로 끝나는 회원의 정보
select * from memberlist where name like '%용';
--[14] 도서 제목에 '이'가 포함되는 도서 정보
select * from booklist where subject like '%이%';
--[15] memberlist 에서 성별이 NULL 이 아닌 회원의이름과 전화번호
select * from memberlist where gender is not null
-- 성별이 널인것을 모두 M 으로 수정해주세요
update memberlist set gender='M' where gender is null

--[16] booklist 에서 도서 제목에 두번째 글자가 '것' 인 도서 정보
select * from booklist where subject like '_것%';




