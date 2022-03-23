CREATE OR REPLACE PROCEDURE getMember(
    p_userid IN member.userid%TYPE,
    p_curvar OUT SYS_REFCURSOR
)
IS
    result_cur SYS_REFCURSOR;
BEGIN
    OPEN result_cur FOR SELECT * FROM member WHERE userid=p_userid;
    p_curvar := result_cur;
END;


-- 호출
-- exec getMember ( 전달인수로서의 아이디 );



CREATE OR REPLACE PROCEDURE selectBoard(
    p_startNum IN NUMBER,
    p_endNum IN NUMBER,
    p_curvar OUT SYS_REFCURSOR
)
IS
    temp_cur SYS_REFCURSOR;     -- 중간결과 저장용 커서
    vs_num NUMBER;              -- 검색된 게시물의 게시물 번호 저장용
    vs_rownum NUMBER;           -- 검색된 게시물의 행 번호
    vs_cnt NUMBER;              -- 게시물의 댓글 갯수 저장용
BEGIN
    -- 게시글의 게시글 번호, 그리고 페이징처리가 필요
    OPEN temp_cur FOR 
        SELECT * FROM ( 
        SELECT * FROM ( 
        SELECT b.num, rownum as rn from ((SELECT * FROM board ORDER BY num DESC) b)
        ) WHERE rn >= p_startNum
        ) WHERE rn <= p_endNum;
        
    -- temp_cur 의 내용을 하나씩 꺼내 vs_num, vs_rownum에 저장할 것이다.
    LOOP
        FETCH temp_cur INTO vs_num, vs_rownum;
        EXIT WHEN temp_cur%NOTFOUND;
        select count(*) into vs_cnt from reply where boardnum = vs_num; -- 게시물 번호로 댓글 테이블에서 갯수 검색
        update board set replycnt = vs_cnt where num=vs_num;          -- 해당 게시물에 replycnt를 업데이트
    END LOOP;
    COMMIT;
    
    OPEN p_curvar FOR -- 이건 OUT 변수이므로, 여기에 저장되어 꺼내진다. 여기에는 board 테이블에서 긁어온 게시물의 제목, 댓글 갯수등의 정보가 담겨있다.
        SELECT * FROM ( 
        SELECT * FROM ( 
        SELECT b.*, ROWNUM AS rn from ((SELECT * FROM board ORDER BY num DESC) b)
        ) WHERE rn >= p_startNum
        ) WHERE rn <= p_endNum;
END;



CREATE OR REPLACE PROCEDURE getAllCount(
    p_cnt OUT NUMBER
)
IS
    v_cnt NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_cnt FROM board;
    p_cnt := v_cnt;
END;



CREATE OR REPLACE PROCEDURE insertMember(
    p_userid IN member.userid%TYPE,
    p_pwd IN member.pwd%TYPE,
    p_name IN member.name%TYPE,
    p_email IN member.email%TYPE,
    p_phone IN member.phone%TYPE
)
IS
-- 별도의 변수는 필요 없다...
BEGIN
    insert into member(userid, pwd, name, email, phone) values(p_userid, p_pwd, p_name, p_email, p_phone);
    commit;
END;



CREATE OR REPLACE PROCEDURE updateMember(
    p_userid IN member.userid%TYPE,
    p_pwd IN member.pwd%TYPE,
    p_name IN member.name%TYPE,
    p_email IN member.email%TYPE,
    p_phone IN member.phone%TYPE
)
IS

BEGIN
    update member set pwd=p_pwd, name=p_name, email=p_email, phone=p_phone where userid=p_userid;
    commit;
END;



CREATE OR REPLACE PROCEDURE plusReadCount(
    p_num IN board.num%TYPE
)
IS
BEGIN
    update board set readcount = readcount + 1 where num = p_num;
    commit;
END;



CREATE OR REPLACE PROCEDURE boardView(
    p_num IN board.num%TYPE,
    p_cur1 OUT SYS_REFCURSOR,
    p_cur2 OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_cur1 FOR select * from board where num = p_num ORDER BY num DESC;
    OPEN p_cur2 FOR select * from reply where boardnum = p_num ORDER BY replynum DESC;
END;



CREATE OR REPLACE PROCEDURE insertReply(
    p_boardnum IN reply.boardnum%TYPE,
    p_userid IN reply.userid%TYPE,
    p_content IN reply.content%TYPE
)
IS
BEGIN
    insert into reply(replynum, boardnum, userid, content) values(reply_seq.nextVal, p_boardnum, p_userid, p_content);
    commit;
END;



CREATE OR REPLACE PROCEDURE deleteReply(
    p_replynum IN reply.replynum%TYPE
)
IS
BEGIN
    delete from reply where replynum = p_replynum;
    commit;
END;





CREATE OR REPLACE PROCEDURE getBoard(
    p_num IN board.num%TYPE,
    p_cur OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_cur FOR
        select * from board where num = p_num ORDER BY num DESC;
END;





CREATE OR REPLACE PROCEDURE updateBoard(
    p_num IN board.num%TYPE,
    p_userid IN board.userid%TYPE,
    p_pass IN board.pass%TYPE,
    p_email IN board.email%TYPE,
    p_title IN board.title%TYPE,
    p_content IN board.content%TYPE,
    p_imgfilename IN board.imgfilename%TYPE
)
IS
BEGIN
    UPDATE board SET pass = p_pass, userid = p_userid, email = p_email,
    title = p_title, content = p_content, imgfilename = p_imgfilename where num = p_num;
    commit;
END;




CREATE OR REPLACE PROCEDURE removeBoard(
    p_num IN board.num%TYPE
)
IS
BEGIN
    DELETE FROM board WHERE num = p_num;
    commit;
END;




CREATE OR REPLACE PROCEDURE insertBoard(
    p_userid IN board.userid%TYPE,
    p_pass IN board.pass%TYPE,
    p_email IN board.email%TYPE,
    p_title IN board.title%TYPE,
    p_content IN board.content%TYPE,
    p_imgfilename IN board.imgfilename%TYPE
)
IS
BEGIN
    INSERT INTO board(num, userid, pass, email, title, content, imgfilename)
    values(board_seq.nextVal, p_userid, p_pass, p_email, p_title, p_content, p_imgfilename);
    commit;
END;