DROP TABLE member CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE worker CASCADE CONSTRAINTS;

select * from best_pro_view;
select * from cart_view;
select * from order_view;

DROP VIEW cart_view;
DROP VIEW order_view;



-- member 테이블 : 상품을 구매하기위해서 회원으로 가입한 구매자들.
CREATE TABLE member (
	userid varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	email varchar2(40) NOT NULL,
	zip_num varchar2(10) NOT NULL,
	address varchar2(100) NOT NULL,
	address2 varchar2(100) NOT NULL,
	phone varchar2(20) NOT NULL,
	useyn char(1) DEFAULT 'y',    -- 휴면 계정 여부
	indate date DEFAULT sysdate,
	PRIMARY KEY (userid)
);

select * from member;



CREATE TABLE product(
	pseq number(5) NOT NULL,
	name varchar2(100) NOT NULL,
	kind char(1) NOT NULL,
	price1 number(7),   -- 원가
	price2 number(7),   -- 판매가
	price3 number(7),   -- 마진 
	content varchar2(1000),
	image varchar2(50),
	useyn char(1) DEFAULT 'y',     -- 상품 판매 유효 여부
	bestyn char(1) DEFAULT 'n',   -- 베스트상품 진열 여부
	indate date DEFAULT sysdate,    -- 등록일
	PRIMARY KEY (pseq)
);

drop sequence product_seq;
create sequence product_seq start with 1;



select * from product;
select * from product order by pseq desc
update product set kind='2' where pseq=201;



-- 쇼핑몰 관리자 테이블
CREATE TABLE worker (
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20) NOT NULL,
	PRIMARY KEY (id)
);

select * from worker;




alter table cart drop primary key cascade;   -- 기본키를 삭제하되, 다른 테이블에서 참조하고 있다면 그 레코드도 같이 삭제합니다
drop table cart purge;

create table cart (
  cseq         number(10)    primary key,  -- 장바구니 일련번호
  id             varchar2(16)   references member(id),   -- 주문자 아이디(FK :　member.id) 
  pseq        number(5)     references product(pseq),  -- 주문 상품번호(FK :product.pseq) 
  quantity   number(5)     default 1,        -- 주문 수량
  result       char(1)       default '1',      -- 1:미처리(카트에 담김 상태, 주문전)   2:처리(주문완료)
  indate       date          default SYSDATE   -- 장바구니에 담은 날짜
);

drop sequence cart_seq;
create sequence cart_seq start with 1;

select * from cart;






-- 주문 테이블
-- orders 테이블과 order_detail 테이블로 나뉘어 집니다.

-- orders 테이블에는 한번에 주문에 필요한 주문자 아이디와 시쿼스에서 부여받은 주문번호 그리고 주문 일자만 저장됩니다
-- 한번의 주문에 두개이상의 상품을 같이 주문할 수 있기때문입니다
-- 자세한 상품변 주문 내역은 order_detail 에 저장됩니다. 이때 orders 에 있는 주문번호(oseq) 가 각 주문 상품에 같이 저장됩니다.
alter table orders drop primary key cascade;
drop table orders purge;

create table orders(
  oseq        number(10)    primary key,           -- 주문번호  
  id          varchar2(16)   references member(id), -- 주문자 아이디
  indate      date          default  sysdate       -- 주문일
);

drop sequence orders_seq;
create sequence orders_seq start with 1;

select * from orders;





-- order_detail 테이블
alter table order_detail drop primary key cascade;
drop table order_detail purge;

create table order_detail(
  odseq       number(10)   primary key,        -- 주문상세번호
  oseq        number(10)   references orders(oseq),   -- orders 테이블에 추가된 주문번호  
  pseq        number(5)    references product(pseq),  -- 상품번호
  quantity    number(5)    default 1,                 -- 주문수량
  result      char(1)      default '1'                -- 1: 미처리 2: 처리     
);
drop sequence order_detail_seq;
create sequence order_detail_seq start with 28;

select * from order_detail;







alter table address drop primary key cascade;
drop table address purge;
CREATE TABLE address (
       zip_num              VARCHAR2(7) NOT NULL,
       sido                 VARCHAR2(30) NOT NULL,
       gugun                VARCHAR2(30) NOT NULL,
       dong                 VARCHAR2(100) NOT NULL,
       zip_code             VARCHAR2(30) ,
       bunji                VARCHAR2(30) 
);

select * from address;





alter table qna drop primary key cascade;
drop table qna purge;

create table qna (
  qseq        number(5)    primary key,  -- 글번호 
  subject     varchar2(300),            -- 제목
  content     varchar2(1000),          -- 문의내용
  reply       varchar2(1000),           -- 답변내용
  id          varchar2(20),                 -- 작성자(FK : member.id) 
  rep         char(1)       default '1',        --1:답변 무  2:답변 유  
  indate      date default  sysdate     -- 작성일
); 

drop sequence qna_seq;
create sequence qna_seq start with 1;

select * from qna;



------------------------------------------------ 샘플 데이터 입력------------------------------------

-- 관리자 입력
insert into worker values('admin', 'admin', '관리자', '010-7777-7777');
insert into worker values('scott', 'tiger', '홍길동', '010-6400-6068');


-- 회원 입력
insert into member(userid, pwd, name, zip_num, address, phone, email) values
('one', '1111', '김나리', '133-110', '서울시 성동구 성수동1가 1번지21호', '017-777-7777','acc@abc.com');
insert into member(userid, pwd, name, zip_num, address, phone, email)values
('two', '2222', '김길동', '130-120', '서울시 송파구 잠실2동 리센츠 아파트 201동 505호', '011-123-4567','acc@abc.com');
insert into member(userid, pwd, name, zip_num, address, address2, phone, email) values
('scott', '1234', '김나리', '133-110', '서울시 성동구 성수동1가', '1번지21호', '017-777-7777','acc@abc.com');



-- 상품 입력
insert into product(pseq, name, kind, price1, price2, price3, content, image) 
values(product_seq.nextval, '크로그다일부츠', '2', 40000, 50000, 10000, '오리지날 크로그다일부츠 입니다.', 'w2.jpg');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) 
values(product_seq.nextval, '롱부츠', '2', 40000, 50000, 10000, '따뜻한 롱부츠 입니다.', 'w-28.jpg', 'n');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn) 
values(product_seq.nextval, '힐', '1', 10000, 12000, 2000, '여성용전용 힐', 'w-14.jpg', 'n');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '슬리퍼', '4', 5000, 5500, 500, '편안한 슬리퍼입니다.', 'w-25.jpg', 'y');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '회색힐', '1', 10000, 12000, 2000, '여성용전용 힐', 'w-23.jpg', 'n');
insert into product(pseq,  name, kind, price1, price2, price3, content, image) 
values(product_seq.nextval, '여성부츠', '2', 12000, 18000, 6000, '여성용 부츠', 'w4.jpg');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval,  '핑크샌달', '3', 5000, 5500, 500, '사계절용 샌달입니다.', 'w-24.jpg', 'y');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '슬리퍼', '3', 5000, 5500, 500, '편안한 슬리퍼입니다.', 'w11.jpg', 'y');
insert into product(pseq,  name, kind, price1, price2, price3, content, image) 
values( product_seq.nextval,  '스니커즈', '4', 15000, 20000, 5000, '활동성이 좋은 스니커즈입니다.', 'w-13.jpg');
insert into product(pseq,  name, kind, price1, price2, price3, content, image, bestyn)
values( product_seq.nextval,  '샌달', '3', 5000, 5500, 500,'사계절용 샌달입니다.', 'w-09.jpg','n');
insert into product(pseq,  name, kind, price1, price2, price3, content, image,bestyn)
values( product_seq.nextval,  '스니커즈', '5', 15000, 20000, 5000,'활동성이 좋은 스니커즈입니다.', 'w-05.jpg','n');


-- 카트 추가
insert into cart(cseq,id, pseq, quantity) values(cart_seq.nextval, 'one', 1, 1);   -- id:one 사용자가 1번 상품 1개를 카트에 추가
insert into cart(cseq,id, pseq, quantity) values(cart_seq.nextval, 'two', 2, 1); 



-- orders 와 order_detail 추가
insert into orders( oseq, id) values(orders_seq.nextVal, 'one');
select * from orders;
select max(oseq)  from orders;
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 1, 1, 1);
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 1, 2, 2);


insert into orders(oseq, id) values(orders_seq.nextval, 'two');
select max(oseq)  from orders;
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 2, 4, 3);
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 2, 5, 2);

insert into orders(oseq, id) values(orders_seq.nextval, 'one');
select max(oseq)  from orders;
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 3, 3, 1);
insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, 3, 2, 1);





-- Qna 추가
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '배송관련 문의입니다', '현재 배송상태와 예상 배송일을 답변 부탁합니다', 'hong5');
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '환불관련', '환불절차 안내부탁드려요.... 배송사 선택은 어떻게 되는지도...', 'one');
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '사이즈 교환 하고 싶어요', '사이즈가 예상보다 작습니다. 교환절차를 안내부탁드려요', 'two');
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '배송이 많이 지연되고 있습니다', '언제 받을 수 있나요', 'scott');
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '불량품 교환 문의', '교환 또는 환불 등의 안내가 필요합니다. 유선안내부탁드려요', 'hong7');
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '배송관련 문의입니다', '현재 배송상태와 예상 배송일을 답변 부탁합니다', 'hong5');
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '환불관련', '환불절차 안내부탁드려요.... 배송사 선택은 어떻게 되는지도...', 'one');
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '사이즈 교환 하고 싶어요', '사이즈가 예상보다 작습니다. 교환절차를 안내부탁드려요', 'two');
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '배송이 많이 지연되고 있습니다', '언제 받을 수 있나요', 'scott');
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '불량품 교환 문의', '교환 또는 환불 등의 안내가 필요합니다. 유선안내부탁드려요', 'hong7');
insert into qna (qseq, subject, content, id) 
values(qna_seq.nextval, '환불은 불가능한가요?', '알고싶어요.', 'scott');



-- cart 안의 상품번호와 사용자 아이디로  상품이름과 사용자 이름을 함꼐 조회하는  view를 생성합니다
select * from cart

create or replace view cart_view
as
select c.cseq, c.id, m.name as mname, c.pseq, p.name as pname, c.quantity, p.price2, c.result, c.indate
from cart c, product p, member m
where c.pseq = p.pseq and c.id = m.userid;

select * from cart_view;




-- orders 와 order_detail 의 join 으로 
-- 1. 주문번호(oseq)에 따른 주문상품들의 표시 
-- 2. 상품번호에 따른 상품 이름과 가격 등의 정보 표시
-- 3. 아이디에 따른 고객 이름과 배송주소 등의 정보 표시
create or replace view order_view
as
select d.odseq, o.oseq, o.indate,  o.id, 
			m.name as mname, m.zip_num, m.address, m.phone, 
			d.pseq,  p.name as pname, p.price2,  d.quantity, d.result
from orders o, order_detail d, member m, product p
where o.oseq=d.oseq and o.id=m.userid and d.pseq=p.pseq;

drop sequence order_detail_seq;
create sequence order_detail_seq start with 1;

select * from order_view;






-- 신상품  View 생성
create or replace view new_pro_view
as
select * from
( select rownum, pseq, name, price2, image 
from product
where useyn='y'
order by indate desc )
where rownum <= 4;

select * from new_pro_view;
select * from product;
update product set bestyn='y' where pseq=11;



-- 베스트 상품 view 생성
create or replace view best_pro_view
as
select * from
(select rownum, pseq, name, price2, image 
from product  
where bestyn='y'  
order by indate desc) 
where  rownum <=4;




select * from cart;

select * from cart_view;










select * from best_pro_view;
select * from address;
select count(*) from address;
select * from member


update order_detail set result='2' where oseq=21;


select distinct oseq, result from order_view where id='scott'  order by result, oseq desc;






select * from worker;
select * from member;
select * from product;
select * from cart;
select * from cart_view;
select * from orders;
select * from order_detail;
select * from order_view;
select * from qna;
select * from best_pro_view;
select * from new_pro_view;
select * from address;



alter table member add address2 varchar2(100);
delete from member where userid like '%hong%';



update member set name='홍길원' , address='서울시 서대문구 대현동', address2='은하빌딩 1층' where userid='hong1';












