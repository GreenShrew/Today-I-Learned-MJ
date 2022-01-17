-- 테이블이 있다면 삭제
drop table member cascade constraints;
drop table product cascade constraints;
drop table worker cascade constraints;

-- member : 상품을 구매하기 위해서 회원으로 가입한 구매자들 테이블.
create table member (
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	email varchar2(20) NOT NULL,
	zip_num varchar2(10) NOT NULL,
	address varchar2(100) NOT NULL,
	phone varchar2(20) NOT NULL,
	useyn char(1) DEFAULT 'y',	-- 휴면계정 여부
	indate date DEFAULT sysdate,
	PRIMARY KEY (id)
);
select * from member;


-- product : 판매할 상품 테이블.
create table product(
	pseq number(5) NOT NULL,
	name varchar2(100) NOT NULL,
	kind char(1) NOT NULL,
	price1 number(7),	-- 원가
	price2 number(7),	-- 판매가
	price3 number(7),	-- 마진
	content varchar2(1000),
	image varchar2(50),
	useyn char(1) DEFAULT 'y',	-- 상품 판매 유효 여부
	bestyn char(1) DEFAULT 'n',	-- 베스트상품 진열 여부
	indate date DEFAULT sysdate,	-- 등록일
	PRIMARY KEY (pseq)
);

drop sequence product_seq;	-- 혹시 시퀸스가 있었다면 삭제
create sequence product_seq start with 1;

select * from product;





-- worker : 쇼핑몰 관리자 테이블.
create table worker(
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20) NOT NULL,
	PRIMARY KEY (id)
);

select * from worker;



-- cart : 장바구니 테이블
alter table cart drop primary key cascade;	-- 기본키를 삭제하되, 다른 테이블에서 참조하고 있다면 그 레코드도 같이 삭제
drop table cart purge;

create table cart(
	cseq number(10) primary key,	-- 장바구니 일련번호
	id varchar2(16) references member(id),	-- 주문자 아이디(FK : member.id)
	pseq number(5) references product(pseq),	-- 주문 상품번호(FK : product.pseq)
	quantity number(5) default 1,	-- 주문 수량
	result char(1) default '1',		-- 1:미처리(카트에 옮긴 상태, 주문전) 2:처리(주문완료)
	indate date default SYSDATE		-- 주문일
);

drop sequence cart_seq;
create sequence cart_seq start with 1;

select * from cart;






-- 주문 테이블
-- orders 테이블과 order_detail 테이블로 나뉘어진다.

-- orders 테이블에는 한번의 주문에 필요한 주문자 이이디와 시퀀스에서 부여받은 주문번호, 그리고 주문일자만 저장된다.
-- 한번의 주문에 두개 이상의 상품을 같이 주문할 수 있기 떄문이다.
-- 자세한 상품의 주문 내역은 order_detail에 저장된다. 이때 orders에 있는 주문번호(oseq)가 각 주문 상품에 같이 저장된다.
alter table orders drop primary key cascade;
drop table orders purge;

create table orders(
	oseq number(10) primary key,	-- 주문번호
	id varchar2(16) references member(id),	-- 주문자 아이디
	indate date default sysdate	-- 주문일
);

drop sequence orders_seq;
create sequence orders_seq start with 1;

select * from orders;