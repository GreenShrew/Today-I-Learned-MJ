-- 세개의 테이블에 각 필드의 자료형과 제약사항에 맞게 각 10개의 레코드를 insert하라.
-- MySQL은 Oracle과는 달리 AutoIncrement를 사용하기 때문에 따로 Sequence를 사용하지 않는다.

insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values ('좀비아이', 2020, 16000, 800, '20');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values ('일곱해의 마지막', 2015, 12000, 2000, 'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values ('오은영의 화해', 2019, 18000, 900, 'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values ('사랑의 역사', 2021, 13000, 500, '12');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values ('부자 아빠 가난한 아빠', 2018, 14000, 700, 'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values ('질서 너머', 2013, 30000, 1500, '20');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values ('어린이라는 세계', 2020, 13500, 750, '12');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values ('달러구트 꿈 백화점', 2020, 12420, 600, 'all');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values ('중학수학 1일 1개념', 2021, 15300, 900, '20');
insert into scott.booklist(subject, makeyear, inprice, rentprice, grade) values ('달까지 가자', 2000, 12600, 700, 'all');


insert into scott.memberlist(name, phone, birth, bpoint, joindate, gender, age) values('추신수','010-5656-1234','84/07/07',240,'18/03/15','M',28);
insert into scott.memberlist(name, phone, birth, bpoint, joindate, gender, age) values('류현진','010-3333-1234','83/08/08',142,'21/1/01','F', 27);
insert into scott.memberlist(name, phone, birth, bpoint, joindate, gender, age) values('손흥민','010-4444-1234','82/09/23',220,'20/10/01','M',23);
insert into scott.memberlist(name, phone, birth, bpoint, joindate, gender, age) values('이청용','010-6666-1234','81/06/14',440,'19/05/13','F', 36);
insert into scott.memberlist(name, phone, birth, bpoint, joindate, gender, age) values('이영표','010-2580-1234','82/03/16',140,'20/12/30','M', 31);
insert into scott.memberlist(name, phone, birth, bpoint, joindate, gender, age) values('최지만','010-7777-1234','83/04/14',340,'19/08/16','F', 29);
insert into scott.memberlist(name, phone, birth, bpoint, joindate, gender, age) values('홍길동','010-5556-1111','88/05/02',180,'11/11/11','M',34);
insert into scott.memberlist(name, phone, birth, bpoint, joindate, gender, age) values('홍길서','010-2222-2222','90/09/17',300,'12/12/22','M',32);
insert into scott.memberlist(name, phone, birth, bpoint, joindate, gender, age) values('홀길남','010-3333-3333','95/11/06',500,'13/03/23','M',27);
insert into scott.memberlist(name, phone, birth, bpoint, joindate, gender, age) values('홍길북','010-4444-4444','99/08/22',200,'14/04/14','M',23);




insert into scott.rentlist(booknum, membernum, discount) values(3 , 1 , 100);
insert into scott.rentlist(booknum, membernum, discount) values(4 , 6 , 100);
insert into scott.rentlist(booknum, membernum, discount) values(5 , 4 , 200);
insert into scott.rentlist(booknum, membernum, discount) values(6 , 1 , 100);
insert into scott.rentlist(booknum, membernum, discount) values(7 , 2 , 200);
insert into scott.rentlist(booknum, membernum, discount) values(8 , 3 , 300);
insert into scott.rentlist(booknum, membernum, discount) values(9 , 7 , 100);
insert into scott.rentlist(booknum, membernum, discount) values(10 , 8 , 300);
insert into scott.rentlist(booknum, membernum, discount) values(1 , 9 , 100);
insert into scott.rentlist(booknum, membernum, discount) values(2 , 10 , 200);
