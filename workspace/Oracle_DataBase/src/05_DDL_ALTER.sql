-- 테이블의 수정(ALTER)

-- 1. 필드명의 변경
-- ALTER TABLE 테이블이름 RENAME COLUMN 변경전이름 TO 변경후이름
-- 테이블이름 : 변경하고자하는 필드명이 있는 테이블의 이름


-- booklist 테이블의 subject 필드명을 title로 수정하라.
ALTER table booklist rename column subject to title;

-- 반대로 title 필드명을 sbuject 필드명으로 수정하라.
alter table booklist rename column title to subject;

-- memberlist 테이블의 membername 필드를 name으로 변경하라.
alter table memberlist rename column membername to name;

-- rentlist 테이블의 rent_date 필드를 rentdate로 변경하라.
alter table rentlist rename column rent_date to rentdate;

-- rentlist의 idx를 numseq로 변경하라.
alter table rentlist rename column idx to numseq;

-- rentlist의 numseq를 num으로 변경하라.
alter table rentlist rename column numseq to num;

-- booklist의 booknum을 num으로 변경하라.
alter table booklist rename column booknum to num;

-- memberlist의 membernum을 num으로 변경하라
alter table memberlist rename column membernum to num;

select * from booklist;
select * from memberlist;
select * from rentlist;

-- 테이블을 만들며 생성한 기본기와 외래키 등등은 필드명이 바뀌면, 바뀐 이름으로 자동 적용된다.

-- 외래키는 잠초하는 필드의 자료형과, 참조되는 필드의 자료형이 일치해야 생성도 되고 유지도 된다.
-- 따라서 아래의 필드의 자료형 변경을 연결된 외래키에서 하려고 한다면 에러이다.

-- 2. 필드 자료형의 변경
-- ALTER TABLE 테이블명 MODIFY 필드명 자료형;

-- varchar2(12)였던 memberlist 테이블의 name 필드를 varchar2(30)으로 변경
alter table memberlist modify name varchar2(50);		-- 수정 성공

-- booklist의 num 필드를 varchar2(5)로 자료형 변경
alter table booklist modify num varchar2(5);		-- 수정 실패
-- column type imcompatible with referenced column type
-- 참조되는 컬럼(필드)의 자료형이 현재 수정하려는 컬럼(필드) 자료형과 호환되지 않음

-- 외래키로 연결되어서 참조되고, 참조하고 있는 필드들은 위의 명령으로 수정이 바로 불가능하다.
-- 가능하게 하려면, 외래키 제약 조건을 수정하여 없애버리고, 참조되는 필드와 참조하는 필드를 모두 수정한 뒤 외래키 제약 조건을 다시 설정한다.
-- alter 명령에 의해서 제약조건을 수정하는 명령을 아래에서 학습한다.


-- 3. 필드의 추가
-- ALTER TABLE 테이블명 ADD 필드명 자료명

-- booklist에 구매등급을 저장할 수 있는 grade 필드를 varchar2(15)로 추가
alter table booklist add grade varchar2(15);

-- memberlist에 성별(gender) 필드를 varchar2(3)으로 추가
alter table memberlist add gender varchar2(3);

-- memberlist에 나이(age) 필드를 number(2)로 추가
alter table memberlist add age number(2);




-- 4. 필드의 삭제
-- ALTER TABLE 테이블명 DROP COLUMN 필드명
-- memberlist 테이블에서 성별 필드 제거
alter table memberlist drop column gender;

-- booklist에 grade 필드 삭제
alter table booklist drop column grade;

-- memberlist에 나이(age) 필드 삭제
alter table memberlist drop column age;


-- 다음 항목을 위해 삭제됐던 필드를 다시 생성
alter table booklist add grade varchar2(15);
alter table memberlist add gender varchar2(3);
alter table memberlist add age number(2);




-- 5. 제약 조건(Constraint)의 추가/제거
-- 삭제 : ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명
-- rentlist 테이블의 booknum에 걸려있는 외래키 제약조건 제거
alter table rentlist drop constraint fk1;
-- rentlist 테이블의 membernum에 걸려있는 외래키 제약조건 제거
alter table rentlist drop constraint fk2;
-- rentlist 테이블의 기본키 제거
alter table rentlist drop constraint rent_pk;


-- 위에서 실패했던 필드의 자료형 수정 재실행
-- booklist의 num을 varchar2(5)로 수정
alter table booklist modify num varchar2(5);
-- memberlist의 num을 varchar2(5)로 수정
alter table memberlist modify num varchar2(5);
-- rentlist의 booknum을 varchar2(5)로 수정
alter table rentlist modify booknum varchar2(5);
-- rentlist의 membernum을 varchar2(5)로 수정
alter table rentlist modify membernum varchar2(5);


-- 이후의 학습을 위해 원래대로 복원
alter table booklist modify num number(5);
alter table memberlist modify num number(5);
alter table rentlist modify booknum number(5);
alter table rentlist modify membernum number(5);


-- 추가 : ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건식

-- 필드LEVEL(수준)의 제약조건은 필드를 modify 하면서 같이 수정 생성한다.
-- 테이블 LEVEL의 제약조건은 위의 명령 형식으로 제약조건 이름과 함께 추가한다.

-- memberlist 테이블의 성별(gender) 필드에 'F', 'M' 두글자만 입력되도록 제약조건을 추가하라.
alter table memberlist add constraint check_gender check(gender in('F', 'M'));
-- in( ) 함수 : 괄호안의 항목 중 하나에 해당하면 true가 리턴되는 함수. 위의 내용은 check 함수에 의해
--		gender 필드의 들어갈 값이 in( ) 함수 안의 항목 중 하나와 같아면 입력 허용, 아니면 불허하는 제약조건이다.

-- memberlist 테이블의 나이(age) 필드에 10살이 초과되는 나이는 입력되지 못하게 제약조건을 추가
alter table memberlist add constraint check_age check(age<100);


-- 위에 삭제되었던 fk1, fk2, rent_pk 제약조건을 다시 설정하라.
-- rent_pk 는 num 필드로만 설정하자.
alter table rentlist add constraint fk1
foreign key(booknum) references booklist(num);
alter table rentlist add constraint fk2
foreign key(membernum) references memberlist(num);
alter table rentlist add constraint rent_pk
primary key(num);




-- 테이블 생성 연습 문제

-- 테이블명 : ORDERS1
-- 필드 : ORDER_ID NUMBER(12,0)		ORDER_DATE DATE
--		ORDER_MODE VARCHAR2(8)		CUSTOMER_ID NUMBER(6,0)
--		ORDER_STATUS NUMBER(2,0)	ORDER_TOTAL NUMBER(8,2)
--		SALES_REP_ID NUMBER(6,0)	PROMOTION_ID NUMBER(6,0)
-- 제약사항 : 기본키는 ORDER_ID	- 테이블레벨
--				ORDER_MODE에는 'direct', 'online'만 입력 가능	- 테이블 레벨
--				ORDER_TOTAL의 디폴트 값은 0		- 필드 레벨

create table orders1(
	ORDER_ID NUMBER(12,0),
	ORDER_DATE DATE,
	ORDER_MODE VARCHAR2(8),
	CUSTOMER_ID NUMBER(6,0),
	ORDER_STATUS NUMBER(2,0),
	ORDER_TOTAL NUMBER(8,2) default 0,
	SALES_REP_ID NUMBER(6,0),
	PROMOTION_ID NUMBER(6,0),
	constraint pk_order_id primary key(order_id),
	constraint ck_order_mode check(order_mode in('direct', 'online'))
);


-- 테이블 수정 연습문제
-- CUSTOMER_ID 필드명을 CUSTOMER_NUMBER로 수정
alter table orders1 rename column customer_id to customer_number;

-- Promotion_ID 값은 10000~99999 사이의 값만 저장 가능
-- 작성 tip! : promotion_id between 10000 and 99999
alter table orders1 add constraint ck_promotion_id check(promotion_id between 10000 and 99999);



-- (추가사항!)
-- 테이블의 복사
create table orders2 as select * from orders1;
-- as select 구문은 select 구문 이후에 다시 학습한다.

-- 테이블의 제거
drop table orders2 purge;	-- purge는 생략이 가능
-- purge가 없이 삭제된 테이블은 나중에 휴지통과 같이 복구가 가능하다.
-- purge를 사용하면 완전 삭제가 된다.