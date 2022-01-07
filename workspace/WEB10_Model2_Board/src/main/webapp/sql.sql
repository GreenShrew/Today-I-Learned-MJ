select * from member;

drop table board purge;	-- 만약 board 테이블이 이미 있으면 이 명령으로 삭제하고 다시 만들자.

create table board(
	num number(5) primary key,
	pass varchar2(30),		-- 게시물의 수정 삭제를 위한 비밀번호
	userid varchar2(30),
	email varchar2(30),
	title varchar2(50),
	content varchar2(1000),
	redcount number(4) default 0,		-- 조회수
	writedate date default sysdate		-- 작성일자
);

create sequence board_seq start with 1 increment by 1;

insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hong', 'abc@naver.com', '1234','첫방문입니다',
'반갑습니다. 앞으로 잘 부탁드립니다.');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'somi', 'addd@naver.com', '1234','게시판 개설',
'축하드립니다. 무궁한 발전 기원합니다.');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'light', 'bnbn@naver.com', '1234','돼지골마을',
'고기는 역시 삽겹살!');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234','2021년 겨울',
'감기 조심하세요~');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234','코로나 바이러스',
'사회적 거리두기 2단계....백신 접종이....');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hong', 'abc@naver.com', '1234','오늘 방문한 맛집',
'맛집이라고 해서 갔는데 속았습니다...');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'light', 'bnan@naver.com', '1234','올해 들어 최저기온이라고 합니다',
'그래서 저는 반팔티를 입고 나왔습니다.');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'somi', 'addd@naver.com', '1234','감기에 걸렸습니다',
'여러분은 따듯하게 입고 나가세요');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'light', 'bnbn@naver.com', '1234','탕수육은 역시',
'부먹 아닐까요?');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hong', 'abc@naver.com', '1234','오늘은 진짜 맛집 방문',
'또다시 속아버렸습니다...');

select * from board;