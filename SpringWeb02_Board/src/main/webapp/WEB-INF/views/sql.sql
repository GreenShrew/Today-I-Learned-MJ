select * from board;

create table board(
	num number(5) primary key,
	pass varchar2(30),	-- 게시물의 수정 삭제를 위한 비밀번호
	name varchar2(30),
	email varchar2(30),
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) default 0,	-- 조회수
	writedate date default sysdate,	-- 작성일자
	replycnt number(3) default 0,
	imagfilename varchar2(50)
);


-- smallProject때 만든 member 테이블이 문제를 만들고있다.
drop table member CASCADE CONSTRAINTS;
select * from member;
create table member(
	name varchar2(30),
	userid varchar2(30) primary key,
	pwd varchar2(30),	-- 게시물의 수정 삭제를 위한 비밀번호
	email varchar2(30),
	phone varchar2(30),
	admin char(1) default 0,
	zip_num varchar2(10),	-- 조회수
	address varchar2(100)
);
insert into member values('홍길동', 'scott', '1234', 'gmd@anver.com', '010-1234-1234', 0, '서울시', '주소');

select * from reply;

create table reply(
	num number(7) primary key,		-- 댓글 순번
	boardnum number(5),					-- 댓글의 해당 게시물 번호
	userid varchar2(20),					-- 댓글 글쓴이
	writedate date default sysdate,	-- 작성일
	content varchar2(1000)				-- 작성 내용
);

create sequence board_seq start with 1 increment by 1;
create sequence reply_seq start with 1 increment by 1;