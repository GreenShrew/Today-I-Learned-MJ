select * from member;
select * from board;
select * from reply;

-- G16 에서 자꾸 회원가입이 안 되어서 not null 인 컬럼 지워버렸다...
ALTER TABLE member DROP COLUMN ZIP_NUM;
ALTER TABLE member DROP COLUMN address;
ALTER TABLE member DROP COLUMN address2;
