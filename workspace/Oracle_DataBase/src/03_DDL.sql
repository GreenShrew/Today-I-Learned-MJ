-- DDL(Data Definition Language) 데이터 정의어

-- 데이터의 생성(Create)
-- Create Table 테이블 이름(
--		필드명1 DATATYPE [DEFAULT값 or 제약조건 및 형식],
--		필드명2 DATATYPE [DEFAULT값 or 제약조건 및 형식],
--		필드명3 DATATYPE [DEFAULT값 or 제약조건 및 형식],
--		...
-- );

-- 도서 대여점의 도서목록 테이블의 생성(예시)
-- 필드 : booknum, subject, makeyear, inprice, outprice
-- 자료형 : booknum(문자 5자리), subject(문자30), makeyear(숫자4), inprice(숫자6), rentprice(숫자6)
-- 제약조건 :  booknum(Not null), subject(Not null), makeyear(), inprice(), outprice()
-- 기본키 : booknum

drop table booklist purge;

CREATE table booklist(		-- 데이터는 이렇게 생성한다.
	booknum number(5) not null,	-- 5자리 글자
	subject varchar2(30) not null,
	makeyear number(4) default 2021,	-- number(4)는 4바이트 숫자가 아니라 4자리의 숫자를 의미한다.
	inprice number(6) default 0,
	rentprice number(6) default 0,		-- 마지막 필드를 쓰고 더 쓸 내용이 없다면 콤마 , 를 쓰지 않는다.
	-- 제약조건은 필드 옆에 기술하는 필드 레벨 제약조건이 있고, 테이블 생성 명령 마지막에 모아서 쓰는 테이블 레벨의 제약조건이 있다.
	-- 제약조건은 어디에다 써도 무관하다.
	-- 다만 필드 레벨의 제약조건은 해당 필드 옆에 써야 그 필드에 적용이 된다.
	
	constraint booknum_pk primary key(booknum)
	-- constraint : 테이블 레벨의 제약조건을 지정하는 키워드
	-- booknum_pk : 테이블 외부에서 현재 제약조건을 컨트롤하기 위한 제약조건의 고유이름
	-- primary key(booknum) : 기본키로 booknum을 지정하겠다는 뜻이다.
);

select * from booklist;	-- 테이블의 내용 전체를 조회하는 명령

-- Create Table 명령의 세부 규칙
-- 테이블의 이름은 객체를 의미할 수 있는 적절한 이름을 사용한다. (자바 변수 이름 규칙과 거의 동일)
-- 다른 테이블과 중복되지 않게 테이블 이름을 지정한다.
-- 한 테이블 내에서 필드 이름도 중복되지 않게 한다.
-- 각 필드들은 ","로 구분하여 생성한다.
-- create를 비롯한 모든 sql 명령은 ";"로 끝난다.
-- 필드명 뒤에 DATATYPE은 반드시 지정하고 [] 안의 내용은 해당 내용이 있을 때 작성하며 생략 가능하다.
-- 테이블 명과 필드명은 반드시 문자로 시작해야하고, 예약어 명령어 등을 테이블명과 필드명으로 쓸 수 없다.
-- 테이블 생성시 대/소문자 구분은 하지 않는다. (기본적으로 테이블이나 컬럼명은 대문자로 만들어짐)
-- DATE 데이터 형식은 별도로 크기를 지정하지 않는다.
-- 문자 데이터의 유형은 반드시 가질 수 있는 최대 길이를 표시해야한다.
-- 문자 데이터 유형은 반드시 가질수 있는 최대 길이를 표시해야한다.
-- 컬럼과 컬럼의 구분은 콤마로 하되, 작성이 모두 종료되는 마지막 컬럼 또는 제약사항의 내용 뒤에는 콤마를 찍지 않는다.


-- 제약조건(CONSTRAINT)
-- PRIMARY KEY
--		- 테이블에 저장된 레코드를 고유하게 식별하기 위한 키, 하나의 테이블에 하나의 기본키만 정의할 수 있다.
--		- 여러 필드가 조합된 기본키 생성이 가능하다.
--		- 기본키는 중복된 값을 가질 수 없으며 빈칸도 있을 수 없다.
--		- PRIMARY KEY = UNIQUE KEY + NOT NULL
-- UNIQUE KEY
--		- 테이블에 저장된 행 데이터를 고유하게 식별하기 위한 고유키를 정의한다.
--		- 단, NULL은 고유키 제약의 대상이 아니므로, NULL값을 가진 행이 여러개가 UNIQUE KEY 제약을 위반하지는 않는다.
-- NOT NULL
--		- 비어있는 상태, 아무것도 없는 상태를 허용하지 않는다.		- 입력 필수!
-- CHECK
--		- 입력할 수 있는 값의 범위를 제한한다. CHECK 제약으로는 TRUE or FALSE 로 평가할 수 있는 논리식을 지정한다.
-- FOREIGN KEY
--		- 관계형 데이터 베이스에서 테이블간에 관계를 정의하기 위해 기본키를 다른 테이블의 외래키로 복사하는 경우 외래키가 생성된다.
--		 추가로 참조 무결성 제약 옵션이 생성된다.



-- 테이블 생성 2
-- 테이블 이름 : MemberList(회원리스트)
-- 필드 : memberNum, memberName, Phone, Birth, Bpoint, joinDate
-- 데이터 형식 : memberNum : NUMBER(5), memberName : VARCHAR2(12), Phone : VARCHAR2(13), Birth : DATE, Bpoint : NUMBER(6), joinDate : DATE
-- 제약 조건 : memberNum, memberName, Phone 세개의 필드 : Not Null - 필드 레벨로 설정
--			 	memberNum : Primary Key - 테이블 레벨로 설정
--				Bpoint : 기본값 0, joinDate 기본값 sysdate(joindate date default sysdate)


drop table memberlist purge;		-- 테이블을 지우는 명령어!

CREATE table memberlist(
	memberNum number(5) not null,
	memberName varchar2(12) not null,
	phone varchar2(13) not null,
	birth date,
	Bpoint number(6) default 0,
	joinDate date default sysdate,		-- 오늘 날짜를 표시하는 오라클의 키워드
	constraint memberNum_pk primary key (memberNum)
);

select * from booklist;
select * from memberlist;



-- 테이블 생성 3
-- 테이블 이름 : rentlist
-- 필드 : rent_date(date), idx(NUMBER(3)), booknum(NUMBER(5)), membernum(NUMBER(5)), discount(NUMBER(4))
-- 제약조건 : idx, booknum, membernum : not null
-- 기본값 : rent_date - 오늘날짜
-- 외래키 : booknum - 테이블 booklist의 booknum을 참조한다.
--			memberNum - 테이블 memberlist의 memberNum을 참조한다.
-- 기본키 : rent_date와 idx 조합에 의한 기본키 설정

create table rentlist(	-- 기본키로 만들 단일 필드가 없다! 예를 들어 memberNum을 기본키로 지정하면 손님 한명당 한번만 빌려갈 수 있다!
	rent_date date default sysdate,
	idx number(5) not null,		-- 해당 일자에 책을 대여한 고객의 순번. 다음날이 되면 다시 1번으로 초기화되어야 한다.
	bookNum number(5) not null,
	memberNum number(5) not null,
	discount number(4),
	constraint rent_pk primary key(rent_date, idx),	-- 두개의 필드를 묶어서 기본키로 만들었다!
	-- 해당 요일에 빌려간 n번째 손님이 기본키! 월요일 첫번째 손님과 월요일 두번째 손님은 중복되는 값이 아니므로 기본키가 될 수 있다!
	constraint fk1 foreign key(bookNum) references booklist(bookNum),
	constraint fk2 foreign key(memberNum) references memberlist(memberNum)
);

select * from rentlist;


-- rent_data 와 idx 를 조합하여 기본키(rent_pk)를 생성한다. 두개의 필드가 조합되어 기본키로 지정될 수 있다. 이를 슈퍼키라고 한다.
-- rentlist 테이블의 booknum은 booklist 테이블의 booknum을 참조하는 외래키로 지정
-- (제약조건이름 fk1)
-- rentlist 테이블의 membernum은 memberlist 테이블의 membernum을 참조하는 외래키로 지정
-- (제약조건이름 fk2)