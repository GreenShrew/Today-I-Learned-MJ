drop table member cascade constraints;

create table member(
	name varchar2(10),
	userid varchar2(10),
	pwd varchar2(10),
	email varchar2(20),
	phone varchar2(15),
	admin number(1) default 0,		-- 0 : 일반 사용자, 1 : 관리자
	primary key(userid)
);


insert into member values('이소미', 'somi', '1234', 'gmd@naver.com', '010-1234-5678', 0);
insert into member values('하상오', 'sang12', '1234', 'h12@naver.com', '010-5555-6666', 0);
insert into member values('김윤승', 'light', '1234', 'yoon1@daum.net', '010-6543-9876', 0);

select * from member;


update member set admin=1 where userid='somi';