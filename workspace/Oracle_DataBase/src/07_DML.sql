-- DML  (Data Management Language)
-- 데이터 조작 언어

-- 테이블에 레코드를 조작(추가, 수정, 삭제, 조회)하기 위한 명령어들
-- INSERT (추가)
-- UPDATE(수정)
-- DELETE(삭제)
-- SELECT(조회 및 선택)


--[1] 샘플 테이블 생성
create table exam01(
deptno  number(2),   -- 부서번호
dname  varchar2(14),  -- 부서명
loc  varchar2(14)   -- 위치
);



--[2] 레코드 추가
-- 레코드 추가 명령 사용1
-- insert into 테이블이름( 필드명1, 필드명2, .... )  values(값1, 값2, ...)
-- 값은 문자('123')와 숫자(123)를 구분하여 입력합니다

-- 레코드 추가 명령 사용2
--insert into 테이블이름 values (전체 column(필드, 열)에  넣을 값들);

-- 첫번째 방식은 필드명과 입력되어야 하는 값을 1:1 로 매핑하여 입력합니다
-- 널값이 있어도 되는 필드는 필드명, 또는 기본값이 있는 필드명은 필드명과 값을 생략하고 입력가능합니다
-- 두번째 방식은 모든 필드에 해당하는 데이터를 모두 입력하는 경우로서 필드명들을 명령어 속에 
-- 나열하지 않아도 되지만, 필드의 순서데로 빠짐없이 데이터가 나열되어야 하는 불편함도 있습니다.

-- 첫번째 방식의 레코드 추가
insert into exam01(deptno, dname, loc) values(10, 'ACCOUNT', 'NEW YORK');

-- 두번째 방식의 레코드 추가
insert into exam01 values(30, 'SALES', 'CHICHAGO');


-- 두가지 방법 모두 null 값을 입력할 수 있습니다
insert into exam01(deptno, dname) values(20, 'MARKETING'); -- 첫번째방법
insert into exam01 values(40, 'OPERATION', null); -- 두번째 방법

select * from exam01;

-- 두가지 방법중 자유롭게 선택하여서, booklist 테이블에 10개의 레코드를 추가해주세요. 
-- num 은 시퀀스를 이용합니다 book_seq
-- grade  는 'all'   '13'  '20' 세가지만 골라서 입력해주세요

insert into booklist( num, subject, makeyear, inprice, rentprice, grade )
values(book_seq.nextVal , '좀비아이',  2020, 12000, 2500, 'all');

insert into booklist values( book_seq.nextVal , '일곱해의 마지막',  2020, 12150, 2000, 'all');
insert into booklist values( book_seq.nextVal , '봉제인형 살인사건',  2020, 12000, 2500, '13');
insert into booklist values( book_seq.nextVal , '쇼코의 미소',  2019, 10800, 2500, '18');
insert into booklist values( book_seq.nextVal , '가면산장 살인사건',  2018, 13320, 1500, '13');
insert into booklist values( book_seq.nextVal , '나미야 잡화점의 기적',  2017, 13320, 2000, '18');
insert into booklist values( book_seq.nextVal , '유튜브영상편집',  2020, 20700, 2500, 'all');
insert into booklist values( book_seq.nextVal , '이것이자바다',  2017, 30000, 3000, '18');
insert into booklist values( book_seq.nextVal , 'JSP웹프로그래밍',  2016, 25000, 2500, '13');
insert into booklist values( book_seq.nextVal , '오라클데이터베이스',  2020, 30000, 3000, 'all');
select * from booklist;

-- 같은 방식으로 memberlist 에 7명의 데이터를 추가해주세요.  member_seq 를 이용해주세요

insert into memberlist
values(member_seq.nextVal,'추신수','010-5656-1234','84/07/07',240,'20/10/01','M',28);
insert into  memberlist
values(member_seq.nextVal, '류현진','010-3333-1234','83/08/08',142,'20/10/01','F', 27 );
insert into  memberlist
values(member_seq.nextVal, '손흥민','010-4444-1234','82/09/23',220,'20/10/01','M',23 );
insert into  memberlist
values(member_seq.nextVal, '이청용','010-6666-1234','81/06/14',440,'20/10/01','F', 36);
insert into  memberlist
values(member_seq.nextVal,'이영표','010-2580-1234','82/03/16',140,'20/10/01','M', 31);
insert into  memberlist
values(member_seq.nextVal,'최지만','010-7777-1234','83/04/14',340,'20/10/01','F', 29);
select * from memberlist;

--rentlist 테이블도 rent_seq 를 이용해서 10개의 데이터를 추가해주세요
insert into rentlist values( '2021/12/01', rent_seq.nextVal, 15, 15, 100);  -- 실패
--  integrity constraint (SCOTT.FK2) violated - parent key not found
insert into  rentlist values('2021/12/01', rent_seq.nextVal,  3 , 1 , 100);  -- 성공
insert into  rentlist values('2021/12/01', rent_seq.nextVal,  4 , 11 , 100);
insert into  rentlist values('2021/12/02', rent_seq.nextVal,  5 , 12 , 200);
insert into  rentlist values('2021/12/02', rent_seq.nextVal,  6 , 1 , 100);
insert into  rentlist values('2021/12/03', rent_seq.nextVal,  7 , 2 , 200);
insert into  rentlist values('2021/12/03', rent_seq.nextVal,  8 , 3 , 300);
insert into  rentlist values('2021/12/04', rent_seq.nextVal,  9 , 7 , 100);
insert into  rentlist values('2021/12/04', rent_seq.nextVal,  10 , 8 , 300);
insert into  rentlist values('2021/12/05', rent_seq.nextVal,  11 , 9 , 100);
insert into  rentlist values('2021/12/05', rent_seq.nextVal,  12 , 10 , 200);
select * from rentlist;



--[3] 데이터 변경- 수정(UPDATE)
--UPDATE  테이블명  SET 변경내용 WHERE 검색 조건
-- update memberlist set age=30 where membernum=10;

-- 명령문에 WHERE 이후 구문은 생략이 가능합니다.
-- 다만 이부분을 생략하면 모든 레코드를 대상으로해서 UPDATE 명령이 실행되어 모든 레코드가 
-- 수정됩니다.
-- 검색조건 : 필드명 (비교-관계연산자) 조건값   으로 이루어진 조건연산이며, 흔히 자바에서 if() 
-- 괄호안에 사용했던 연산을 그데로 사용하는게 보통입니다.
-- 나이가 29세 이상 -> WHERE AGE>=29

--  데이터 수정의 실예
-- exam01  테이블에서 deptno 값을 모두 30으로 수정
update exam01 set deptno=30;
-- exam01 테이블에서 dname이 'ACCOUNT' 인 레코드의 deptno 를 10으로 수정
update exam01 set deptno=10 where dname='ACCOUNT';

-- exam01 테이블에서 dname이 'SALES' 인 레코드의 deptno 를 20으로 수정 하세요
update exam01 set deptno=20 where dname='SALES';
-- exam01 테이블에서 dname이 'OPERATION' 인 레코드의 deptno 를 30으로 수정하세요
update exam01 set deptno=30 where dname='OPERATION';
-- exam01 테이블에서 dname이 'MARKETING' 인 레코드의 deptno 를 40으로 수정하세요
update exam01 set deptno=50 where dname='MARKETING';
-- exam01 테이블에서 deptno이 30 인 레코드의 loc 를 'BOSTON' 으로 수정하세요
update exam01 set loc='BOSTON' where deptno=30;
-- exam01 테이블에서 deptno이 40 인 레코드의 loc 를 'LA' 으로 수정하세요
update exam01 set loc='LA' where deptno=40;

select * from exam01;

select * from booklist;
-- booklist 테이블의 제목 '봉제인형 살인사건' 도서의 grade 를 '20' 으로 수정
update booklist set grade='20' where subject = '봉제인형 살인사건';

-- emp 테이블의 모든 사원의 sal 값을 10% 씩 인상
update emp set sal = sal + (sal * 0.1) ;
update emp set sal = sal * 1.1;

-- emp 테이블에서 sal 값이 3000 이상인 사원의 급여 10% 삭감
update emp set sal = sal*0.9 where sal >= 3000;
-- emp 테이블의 hiredate 가 2002년 이전인 사원의 급여를  + 2000  
-- (2001-12-31 보다 작거나 같은)
update emp set sal = sal + 2000 where hiredate <= '2001-12-31';
update emp set sal = sal + 2000 where hiredate < '2002-01-01';

-- emp 테이블의 ename 이 j로 시작하는 사원의 job을  manager 로 변경
update emp set job='manager' where ename like 'J%';
update emp set job='manager' where ename like '%J';  -- j로 끝나는 이름 검색
update emp set job='manager' where ename like '%J%' ; -- j를 포함하는 이름 검색

-- memberlist 테이블에서 bpoint 가 200이 넘는 사람만 bpoint*100 으로 변경
update memberlist set bpoint = bpoint*100 where bpoint>=200;

-- rentlist 테이블에서  할인금액이 100원이 넘으면 모두 할인 금액을 90으로 변경
update rentlist set discount = 90 where discount>=100;

-- 등급이 '20' 인 책은 rentprice 을 10% 인상 , 책 제목에 끝에 20+ 를 추가...
update booklist set rentprice = rentprice * 1.1 ,  subject = subject || '20+'  
where grade='20';
select * from booklist;
--  오라클의 문자 이어붙이기 연산 : ||
select * from emp;

-- booklist 에   grade 가 '18' 인 레코드의 grade  를 '20' 으로 변경, rentprice 을 10% 인상 , 
-- 책 제목에 끝에 20+ 를 추가해주세요
update booklist 
set rentprice = rentprice * 1.1 ,  subject = subject || '20+' , grade='20'
where grade = '18';
-- value too large for column "SCOTT"."BOOKLIST"."SUBJECT"

alter table booklist modify subject varchar2(100); 



-- [4]레코드의 삭제
-- delete from 테이블명 where  조건식
-- rentlist 테이블에서 discount가 100이하이 레코드를 삭제	
delete  from rentlist where discount<100;	
-- where 절이 없으면 테이블 내의 모든 레코드를 삭제합니다
select * from rentlist;





















