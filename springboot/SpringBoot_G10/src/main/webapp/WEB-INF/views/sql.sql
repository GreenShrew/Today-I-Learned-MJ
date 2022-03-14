drop table bbs purge;

create table bbs(
	id number(3),
	writer varchar2(30),
	title varchar2(30),
	content varchar2(1000)
);

drop sequence bbs_seq;
create sequence bbs_seq start with 1;

insert into bbs values(bbs_seq.nextVal, 'Gildong', 
'반갑습니다.', '반갑습니다 반갑습니다 반갑습니다 반갑습니다 반갑습니다.');
insert into bbs values(bbs_seq.nextVal, 'Gilnam', 
'안녕하세요.', '안녕하세요 안녕하세요 안녕하세요 안녕하세요 안녕하세요.');
insert into bbs values(bbs_seq.nextVal, 'Gilbook', 
'어서오세요.', '어서오세요 어서오세요 어서오세요 어서오세요 어서오세요.');

select * from bbs;