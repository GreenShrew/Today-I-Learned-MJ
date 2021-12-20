create table customer(
	num number(3),
	name varchar2(10),
	email varchar2(20),
	tel varchar2(15)
);

insert into customer values (1, '홍길동', 'abc1@abc.com', '010-1234-5234');
insert into customer values (2, '홍길서', 'abc2@abc.com', '010-2234-4234');
insert into customer values (3, '홍길남', 'abc3@abc.com', '010-3234-3234');
insert into customer values (4, '홍길북', 'abc4@abc.com', '010-4234-2234');
insert into customer values (5, '아무개', 'abc5@abc.com', '010-5234-1234');

select * from customer;

create sequence num_seq start with 7 increment by 1;	-- 테이블에 6번까지 만들어져있는 상황에서 만들었으므로 7부터 시작하도록 시퀀스를 제작했다.

