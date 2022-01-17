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



-- orders와 order_detail 추가
insert into orders(oseq, id) values(orders_seq.nextval, 'one');
select * from orders;
select max(oseq) from orders;	-- 추가되다보면 oseq가 어디까지 늘어있을지 모른다. 그때 사용하는 조회 방법.
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 1, 1, 1);
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 1, 2, 2);


insert into orders(oseq, id) values(orders_seq.nextval, 'two');
select max(oseq) from orders;
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 2, 4, 3);
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 2, 5, 2);

insert into orders(oseq, id) values(orders_seq.nextval, 'one');
select max(oseq) from orders;
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 3, 3, 1);
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 3, 2, 1);





-- QnA 추가
insert into qna (qseq, subject, content, id)
values(qna_seq.nextval, '배송관련 문의입니다', '현재 배송상태와 예상 배송일을 답변 부탁합니다.', 'one');
insert into qna (qseq, subject, content, id)
values(qna_seq.nextval, '환불관련', '환불절차 안내부탁드립니다. 배송사 선택은 어떻게 하는지도 부탁드립니다.', 'one');
insert into qna (qseq, subject, content, id)
values(qna_seq.nextval, '사이즈 교환 하고 싶어요', '사이즈가 예상보다 작습니다. 교환절차가 어떻게 되나요?', 'two');
insert into qna (qseq, subject, content, id)
values(qna_seq.nextval, '배송이 많이 지연대고 있습니다', '언제 받을 수 있나요.', 'scott');
insert into qna (qseq, subject, content, id)
values(qna_seq.nextval, '불량품 교환 문의', '교환 또는 환불이 필요합니다. 유선안내 부탁드려요.', 'scott');



-- (참고)view를 케이크자르듯 만드는 방법
create or replace view 이름	-- view의 이름
as
select 컬럼들		-- 보여질 컬럼들
from 테이블들		-- 보여질 컬럼들의 데이터를 가지는 테이블들 '테이블 as 별칭' 으로 별칭을 붙일 수 있다. 
where 조건;		-- 보여질 컬럼들의 조건
-- order by ~~ desc; 를 붙일 수 있다.







-- cart 안의 상품번호와 사용자 아이디로 상품의 이름과 사용자 이름을 함께 조회하는 view를 생성한다.
-- 나중에 장바구니 페이지에 cart의 내용을 보여주기 위해 만드는 것이다.
select * from cart;	-- 이 안에는 주문 번호나 수량만 담겨있다..

create or replace view cart_view
as
select c.cseq, c.id, m.name as mname, c.pseq, p.name as pname, c.quantity, p.price2, c.result, c.indate
from cart c, product p, member m
where c.pseq = p.pseq and c.id = m.id

select * from cart_view;	-- 이제 누가 어떤 상품을 얼마나 샀고 카트에 담겨있는지 등등을 나타낸다




-- orders와 order_detail 의 join 으로...
-- 1. 주문번호(oseq)에 따른 주문 상품들의 표시를 위해 만든다.
-- 2. 상품 번호에 따른 상품 이름과 가격 등의 정보 표시를 위해 만든다.
-- 3. 아이디에 따른 고객 이름과 배송주소 등의 정보 표시를 위해 만든다.
create or replace view order_view
as
select d.odseq, o.oseq, o.id, m.name as mname, m.zip_num, m.address, m.phone,
d.pseq, p.name as pname, d.quantity, d.result
from orders o, order_detail d, member m, product p
where o.oseq = d.oseq and o.id = m.id and d.pseq = p.pseq

select * from order_view;







-- 신상품 view 생성
create or replace view new_pro_view
as
select * from
(select rownum, pseq, name, price2, image
from product
where useyn='y'
order by indate desc )
where rownum <= 4;

select * from new_pro_view;
select * from product;



update product set bestyn='y' where pseq=11;		-- bestyn 값이 y인 제품을 하나 더 추가
update product set bestyn='y' where pseq=4;	

-- 베스트 상품 view 생성
create or replace view best_pro_view
as
select * from
(select rownum, pseq, name, price2, image
from product
where bestyn='y'
order by indate desc)
where rownum <=4;

select * from best_pro_view;



-- cmd로 주소(구 주소)를 추가하고 address 테이블을 조회
select * from address;	-- 이클립스의 SQL Results가 나타낼 수 있는 Result의 갯수는 500개이다.
select count(*) from address;	-- 26455 개의 레코드를 가지고 있다!





