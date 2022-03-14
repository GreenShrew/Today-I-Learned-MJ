create table myuser(
	id varchar2(15),
	name varchar2(30)
);

insert into myuser values('hong1', '홍길동1');
insert into myuser values('hong2', '홍길동2');
insert into myuser values('hong3', '홍길동3');
insert into myuser values('hong4', '홍길동4');
insert into myuser values('hong5', '홍길동5');

select  * from myuser;