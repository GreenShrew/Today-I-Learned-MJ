-- * 오라클 - 뷰(View)
--	- 물리적인 테이블에 근거한 논리적인 가상 테이블.
--	- 가상이란 단어는 실질적으로 데이터를 저장하고 있지 않기 떄문에 붙인 것이고,
--	  테이블이란 단어는 실질적으로 데이터를 저장하고 있지 않더라도 사용 계정자는
--	  마치 테이블을 사용하는 것과 동일하게 뷰를 사용할 수 있기 때문에 붙인 것이다.
--	- 뷰는 기본 테이블에서 파생된 객체로서 기본 테이블에 대한 하나의 쿼리문이다.
--	- 실제 테이블에 저장된 데이터를 뷰를 통해서 볼 수 있도록 한다.
--	- 사용자에게 주어진 뷰를 통해서 기본 테이블을 제한적으로 사용할 수 있다.
--	- 뷰는 이미 존재하고 있는 테이블에 제한적으로 접근하도록 한다.
--	- 뷰를 생성하기 위해서는 실질적으로 데이터를 저장하고 있는 물리적인 테이블이
--	  존재해야 되는데, 이 테이블은 기본 테이블이라고 한다.
--	- 두개 이상의 테이블 또는 한개의 테이블이나 또 다른 뷰를 참조하는 객체이다.
--	- 저장된 테이블이라기 보다 공식 또는 select 문을 갖고 있다가 명령데로 불러와 그때그때
--	  구성하는 형식이다.
--	- 원본의 데이터 변화가 실시간으로 반영된다.

-- 생성방법
-- Create or Replace View 뷰이름 as (select 구문)
-- select 명령 : 실제 테이블의 부분집합(행 일부 또는 전부, 열 일부 또는 전부)
-- select 명령과 Join 명령 학습 후 다시 상세하게 공부할 내용이다.



-- * 오라클 - 시퀀스(Sequence)
--		: 테이블 내의 유일한 숫자를 자동으로 생성하는 자동 번호 발생기.
--		: 테이블 생성 후 시퀀스(일련번호)를 따로 만들어야 한다.
-- 생성 방법
-- create sequence 시퀀스이름 start with 시작숫자 increment by 증가량;

-- 주로 number 형식에 기본키값으로 사용한다.
-- 일련번호정도로 이해해도 무방하다.
-- number(자리수) : 자료형의 자리수가 몇자리냐에 따라 그 만큼 숫자가 증가할 수 있다.

drop sequence member_seq;
-- [1] 시퀀스의 생성
create sequence member_seq start with 1 increment by 1;
insert into memberlist(num, name, phone) values (member_seq.nextVal, '홍길서', '010-3333-4444');
insert into memberlist(num, name, phone) values (member_seq.nextVal, '홍길남', '010-5555-6666');
insert into memberlist(num, name, phone) values (member_seq.nextVal, '홍길북', '010-7777-8888');
-- birth : not null이 아니므로 공백이어도 상관 없다. bpoint : default 값으로 0이 되어있다.
select * from memberlist;


-- [2] 현재 시퀸스가 어디까지 증가되어져 있는지 확인. <- 계속 실행하면 숫자가 계속 늘어난다
select member_seq.currval, member_seq.nextVal from dual;


-- 아래 주석처리 이유는 실행하지 말라고 해둔것임...

-- [3] 시퀸스 수정 : 최대 증가값을 14(바꿀 수 있다)까지로 제한하는 방법.
-- alter sequence member_seq maxvalue 14;


-- [4] 시퀸스 삭제
-- drop sequence member_seq;


-- [5] 시퀸스 재생성 : 다음 숫자부터 시작하게 하여 기존 레코드와 중복되지 않게 한다.
-- create sequence member_seq start with 15 increment by 1;


-- 1부터 1씩 늘어나는 book_seq, rent_seq를 생성하라.
create sequence book_seq start with 1 increment by 1;
create sequence rent_seq start with 1 increment by 1;

-- member_seq를 삭제했다가 4부터 늘어나도록 다시 생성하라.
drop sequence member_seq;
create sequence member_seq start with 4 increment by 1;

