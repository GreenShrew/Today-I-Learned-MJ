-- 기존에 만들었던 board 테이블이다... 기존에 있던걸 쓰자!
create table board(
	num number(5) primary key,
	pass varchar2(30),	-- 게시물의 수정 삭제를 위한 비밀번호
	userid varchar2(30),
	email varchar2(30),
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) default 0,	-- 조회수
	writedate date default sysdate,	-- 작성일자
	replycnt number(5),
	imgfilename varchar2(30)
);

create sequence board_seq start with 1 increment by 1;

select * from board;


create table reply(
	replynum number(7) primary key,	-- 댓글 순번
	boardnum number(5),		-- 댓글의 해당 게시물 번호
	userid varchar2(20),		-- 댓글의 글쓴이
	writedate date default sysdate,	-- 작성일
	content varchar2(1000)	-- 작성 내용
);
create sequence reply_seq start with 1 increment by 1;

select * from reply;


create table member(
	id varchar2(30) primary key,
	pw varchar2(30) not null,
	name varchar2(30) not null,
	phone varchar2(30),
	email varchar2(30),
	zip_num varchar2(30) default '000-000',
	address varchar2(100) default '00시 00구 00동',
	useyn varchar2(5) default 'y',
	indate date default sysdate
);

select * from member;