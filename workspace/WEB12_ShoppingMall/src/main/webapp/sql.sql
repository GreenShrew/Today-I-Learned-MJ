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
	zip_num varchar2(10) NOT NULL,		-- 우편번호
	address varchar2(100) NOT NULL,		-- 상세주소
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





-- order_detail 테이블
alter table order_detail drop primary key cascade;
drop table order_detail purge;

create table order_detail(
	odseq number(10) primary key,	-- 주문 상세번호
	oseq number(10) references orders(oseq),	-- 주문번호
	pseq number(5) references product(pseq),		-- 상품번호
	quantity number(5) default 1,		-- 주문 수량
	result char(1) default '1'		-- 1:미처리 2:처리
);
drop sequence order_detail_seq;
create sequence order_detail_seq start with 1;

select * from order_detail;






-- 상세 주소 정보를 담은 테이블(구 주소)
alter table address drop primary key cascade;
drop table address purge;
create table address(
	zip_num varchar2(7) not null,
	sido varchar2(30) not null,
	gugun varchar2(30) not null,
	dong varchar(100) not null,
	zip_code varchar2(30),
	bunji varchar2(30)
);

select * from address;





alter table qna drop primary key cascade;
drop table qna purge;

create table qna (
	qseq number(5) primary key,	-- 글번호
	subject varchar2(300),		-- 제목
	content varchar2(1000),		-- 문의내용
	reply varchar2(1000),		-- 답변내용
	id varchar2(20),					-- 작성자(FK : member.id)
	rep char(1) default '1',		-- 1:답변 무 2:답변 유
	indate date default sysdate	-- 작성일
);

drop sequence qna_seq;
create sequence qna_seq start with 1;

select * from qna;



--------------------------------------------- 샘플 데이터 입력

-- 관리자 입력
insert into worker values('admin', 'admin', '관리자', '010-7777-7777');
insert into worker values('scott', 'tiger', '홍길동', '010-6400-6068');


-- 회원 입력
insert into member(id, pwd, name, zip_num, address, phone, email) values 
('one', '1111', '김나리', '133-110', '서울시 성동구 성수동1가 1번지21호', '017-777-7777', 'acc@abc.com');
insert into member(id, pwd, name, zip_num, address, phone, email) values 
('two', '2222', '김길동', '130-120', '서울시 송파구 잠실2동 리센츠 아파트 201동 505호', '011-123-4567', 'asd@abc.com');



-- 상품 입력 (10개만)
insert into product(pseq, name, kind, price1, price2, price3, content, image)
values(product_seq.nextval, '크로그다일부츠', '2', 40000, 50000, 10000, '오리지날 크로그다일부츠 입니다.', 'w2.jpg');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '롱부츠', '2', 40000, 50000, 10000, '따듯한 롱부츠 입니다.', 'w-28.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '힐', '1', 10000, 12000, 2000, '여성 전용 힐 입니다.', 'w-26.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '슬리퍼', '4', 5000, 5500, 500, '편안한 슬리퍼입니다.', 'w-25.jpg', 'y');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '회색힐', '1', 10000, 12000, 2000, '여성 전용 힐 입니다.', 'w9.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image)
values(product_seq.nextval, '여성부츠', '2', 12000, 18000, 6000, '여성 전용 부츠 입니다.', 'w4.jpg');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '핑크샌달', '3', 5000, 5500, 500, '사계절용 샌달입니다.', 'w-10.jpg', 'y');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '슬리퍼', '3', 5000, 5500, 500, '편안한 슬리퍼입니다.', 'w11.jpg', 'y');
insert into product(pseq, name, kind, price1, price2, price3, content, image)
values(product_seq.nextval, '스니커즈', '4', 15000, 20000, 5000, '활동성이 좋은 스니커즈입니다.', 'w1.jpg');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '샌달', '3', 5000, 5500, 500, '사계절용 샌달입니다.', 'w-09.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '스니커즈', '5', 15000, 20000, 5000, '활동성이 좋은 스니커즈입니다.', 'w-05.jpg', 'n');



-- 카트 추가
insert into cart(cseq, id, pseq, quantity) values(cart_seq.nextval, 'one', 1, 1);		-- id:one 사용자가 1번 상품 1개를 카트에 추가
insert into cart(cseq, id, pseq, quantity) values(cart_seq.nextval, 'two', 2, 1);		






