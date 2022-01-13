drop table bookproduct purge;	-- 테이블 삭제

create table bookproduct(
	code number(5) primary key,
	name varchar2(100),	-- 파일 이름만 저장되는거지, 파일 자체가 테이블에 저장되는것이 아니다. 또한, 변경된 파일의 이름이 저장된다.
	price number(8),
	pictureurl varchar2(50),
	description varchar2(1000)
);

create sequence bookproduct_seq start with 1 increment by 1;

insert into bookproduct values(bookproduct_seq.nextval, 'JQuery and JQuery mobile : 이해하기 쉽게 풀어쓴', 25000, 'jquery.jpg', '소스하나로 데스크탑과 모바일까지 HTML5와 함께 사용...');
insert into bookproduct values(bookproduct_seq.nextval, '자바의 신', 30000, 'java.gif', '자바프로그래밍의 정석, 기초부터 실무 예제까지...');

select * from bookproduct;