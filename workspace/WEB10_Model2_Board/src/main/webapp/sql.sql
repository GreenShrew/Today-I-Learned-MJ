drop table board purge;
create table board(
	num number(5) primary key,
	pass varchar2(30),   -- 게시물의 수정 삭제를 위한 비밀번호
	userid varchar2(30),
	email varchar2(30),
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) default 0,   --조회수
	writedate date default sysdate    -- 작성일자
);
create sequence board_seq start with 1 increment by 1;


drop table member cascade constraints;
create table member(
	name varchar2(30),
	userid varchar2(30),
	pwd varchar2(30),
	email varchar2(30),
	phone varchar2(15),
	admin number(1) default 0,  -- 0:일반사용자 , 1:관리자
	primary key(userid)
);
insert into member values('이소미', 'somi', '1234', 'gmd@anver.com', '010-1234-1234', 0);
insert into member values('하상오', 'sang12', '1234', 'h12@naver.com', '010-5555-6666', 0);
insert into member values('김윤승', 'light', '1234', 'yoon1@daum.net', '010-9999-1111', 0);

select * from board;
select * from member;

alter table board rename column redcount to readcount;

insert into board(num, userid, email, pass, title, content)
values( board_seq.nextVal, 'hong', 'abc@naver.com', '1234', '첫방문입니다', 
	'반갑습니다. 앞으로 많으 격려와 지도편달 부탁드립니다.' );
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'somi', 'adddnaver.com', '1234', '게시판 개설',
	'축하드립니다.  무궁한 발전을 기원할께요');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'light', 'bnbn@naver.com', '1234', '돼지골마을',
	'돼지 삼겹살이 맛있습니다');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '2021년 겨울' , 
	'몸시 추울꺼 같아요... 다들 건강 유의 하세요....');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '코로나바이러스' , 
	'사회적 거리두기2단계 .... 백신접종 등등등');
insert into board(num, userid, email, pass, title, content)
values( board_seq.nextVal, 'hong', 'abc@naver.com', '1234', '첫방문입니다', 
	'반갑습니다. 앞으로 많으 격려와 지도편달 부탁드립니다.' );
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'somi', 'adddnaver.com', '1234', '게시판 개설',
	'축하드립니다.  무궁한 발전을 기원할께요');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'light', 'bnbn@naver.com', '1234', '돼지골마을',
	'돼지 삼겹살이 맛있습니다');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '2021년 겨울' , 
	'몸시 추울꺼 같아요... 다들 건강 유의 하세요....');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '코로나바이러스' , 
	'사회적 거리두기2단계 .... 백신접종 등등등');
	
	
	
-- 댓글 테이블
drop table reply purge;		-- 만약 이 테이블이 있다면 지우기

create table reply(
	replynum number(7) primary key,		-- 댓글 순번
	boardnum number(5),						-- 댓글의 해당 게시물 번호, 외래키를 걸어도 된다. 나중에 지우기 귀찮아져 굳이 걸지는 않는다.
	userid varchar2(20),							-- 댓글 글쓴이
	writedate date default sysdate,			-- 작성일
	content varchar2(1000)						-- 작성 내용
);

drop sequence reply_seq;	-- 만약 있다면..
create sequence reply_seq start with 1 increment by 1;
select * from user_sequences;
SELECT reply_seq.CURRVAL FROM DUAL;

select * from reply;



select count(*) from board;	-- 레코드 갯수를 알려주는 명령



-- 예를 들어, 현재 보고자 하는 페이지의 번호가 2 페이지다.
-- 그럼 게시물의 번호는 11번부터 20번까지의 게시물이 화면에 표시되게 한다.
-- 또한 게시판 특성상 나중에 생긴 게시물이 위로 올라온다.

select rownum, num, title, content from board order by num desc;

-- select rownum, * from board order by num desc;		X

-- rownum과 *를 모두 사용하기 위해 서브쿼리를 사용한다!
select rownum as rn, b.* from (select * from board order by num desc) b
-- b : 서브쿼리로 조회된 결과 테이블을 지칭하는 별칭이다.

select * from (select rownum as rn, b.* from (select * from board order by num desc) b) where rn>=11 and rn<=20;


-- 다만, rn>=11 and rn<=20 과 같은 복합연산을 수행하면 시간이 오래 걸린다.
-- 게시물의 100개 200개면 몰라도, 100000000개가 있으면...
-- 게시물 갯수가 많아질수록 위의 명령의 실행속도가 느려진다. 그를 해결하기 위해 아래의 방법을 사용한다.
select * from (
select * from (
select rownum as rn, b.* from (select * from board order by num desc) b
)where rn>=? 
)where rn<=?

-- 이 sql 문을 BoardDao의 selectBoard 메소드에서 sql문으로 쓰인다!

select * from (
select * from (
select rownum as rn, b.* from (select * from board order by num desc) b
)where rn>=? 
)where rn<=?



-- 테이블에 댓글의 갯수를 셀 replycnt 필드 추가
alter table board add replycnt number(3) default 0;



-- 이미지 파일의 이름을 저장할 컬럼
alter table board add imgfilename varchar2(50);


