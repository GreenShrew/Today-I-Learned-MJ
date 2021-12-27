CREATE TABLE `scott`.`booklist` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(100) NOT NULL,
  `makeyear` INT NOT NULL,
  `inprice` INT NOT NULL,
  `rentprice` INT NOT NULL,
  `grade` VARCHAR(6) NULL DEFAULT 'all',		-- Null값이 허용된다.
  PRIMARY KEY (`num`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '도서 목록';

select * from scott.booklist;

-- AUTO_INCREMENT : 오라클의 sequence를 대신하는 자동 숫자 증가 옵션
-- VARCHAR2 는 없고, VARCHAR가 가변 길이 문자를 나타낸다.
-- CONSTRAINT 없이 제약 사항을 표시한다.
-- 테이블 이름 앞에 `스키마이름`. 을 반드시 붙여서 사용한다.

-- 자주 쓰는 자료형
-- INT : 정수 자료형(FLOAT, DOUBLE은 실수)
-- VARCHAR : 문자열 자료형, 가변길이(CHAR은 고정길이)
-- TEXT : 긴 문자열은 TEXT로 별도 저장
-- DATETIME : 날짜 자료형 저장
-- TINYINT : -128에서 127까지 저장하지만 여기서는 1 또는 0만 저장해 boolean 값을 표현

-- 자주 쓰는 제약조건
-- NOT NULL : 빈 값은 받지 않는다는 뜻(NULL은 빈 값 허용)
-- AUTO_INCREMENT : 숫자 자료형인 경우 다음 로우가 저장될 때 자동으로 1 증가
-- UNSIGNED : 0과 양수만 허용
-- ZEROFILL : 숫자의 자리 수가 고정된 경우 빈 자리에 0을 넣음
-- DEFAULT now() : 날짜 컬럼의 기본값을 현재 시간으로


-- 연습문제.
-- 아래의 필드명을 담은 memberlist 테이블을 생성하라.
-- 필드명 : num(Int, 자동 증가, 기본키), name(varchar(30), not null),
--			Birth(date, not null), bpoint(int), joindate(date, 기본값 now()),
--			age(int), gender(varchar(3))
-- 테이블 comment : 회원 목록
-- 기본 문자set : utf-8mb4
-- 워크 벤치에서 테이블 생성하는 명령을 복사해서 이클립스에 붙여넣고 생성하라.

-- Birth와 joindate를 만들 때 DATE를 쓰면 테이블 생성에 실패한다.
-- DATETIME을 선택해서 넣어야한다.

CREATE TABLE `scott`.`memberlist` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `Birth` DATETIME NOT NULL,
  `bpoint` INT NOT NULL,
  `joindate` DATETIME NOT NULL DEFAULT now(),
  `gender` VARCHAR(3) NULL,
  `age` INT NULL,
  PRIMARY KEY (`num`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '회원 목록';

select * from scott.memberlist


-- MySQL에서 Alter를 사용하여 테이블을 수정할 수 있다.
-- 전부 수정하고 Apply를 누르면 테이블을 만들때와 마찬가지로 아래와 같이 실행될 코드가 나온다.

ALTER TABLE `scott`.`memberlist` 
ADD COLUMN `phone` VARCHAR(45) NOT NULL AFTER `name`,
CHANGE COLUMN `bpoint` `bpoint` INT NOT NULL DEFAULT 0 ;



-- 연습문제
-- 테이블 이름 : rentlist
-- 필드 : rentdate(datetime, default now()), numseq(int, AI), booknum(int)
--			membernum(int), discount(int)

-- 테이블 comment : 매출 목록
-- 기본 문자set : utf-8mb4
-- 워크 벤치에서 테이블 생성하는 명령을 복사해서 이클립스에 붙여넣고 생성하라.

CREATE TABLE `scott`.`rentlist` (
  `rentdate` DATETIME NOT NULL DEFAULT now(),
  `numseq` INT NOT NULL AUTO_INCREMENT,
  `booknum` INT NULL,
  `membernum` INT NULL,
  `discount` INT NULL,
  PRIMARY KEY (`numseq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '매출 목록';

-- 약간 수정할것들 수정함

ALTER TABLE `scott`.`rentlist` 
CHANGE COLUMN `booknum` `booknum` INT NOT NULL ,
CHANGE COLUMN `membernum` `membernum` INT NOT NULL ,
CHANGE COLUMN `discount` `discount` INT NULL DEFAULT 0 ;





-- 외래키 설정!

ALTER TABLE `scott`.`rentlist` 
ADD INDEX `fk1_idx` (`booknum` ASC) VISIBLE,
ADD INDEX `fk2_idx` (`membernum` ASC) VISIBLE;
;
ALTER TABLE `scott`.`rentlist` 
ADD CONSTRAINT `fk1`
  FOREIGN KEY (`booknum`)
  REFERENCES `scott`.`booklist` (`num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk2`
  FOREIGN KEY (`membernum`)
  REFERENCES `scott`.`memberlist` (`num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;