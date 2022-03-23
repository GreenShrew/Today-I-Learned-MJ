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


-- ȣ��
-- exec getMember ( �����μ��μ��� ���̵� );



CREATE OR REPLACE PROCEDURE selectBoard(
    p_startNum IN NUMBER,
    p_endNum IN NUMBER,
    p_curvar OUT SYS_REFCURSOR
)
IS
    temp_cur SYS_REFCURSOR;     -- �߰���� ����� Ŀ��
    vs_num NUMBER;              -- �˻��� �Խù��� �Խù� ��ȣ �����
    vs_rownum NUMBER;           -- �˻��� �Խù��� �� ��ȣ
    vs_cnt NUMBER;              -- �Խù��� ��� ���� �����
BEGIN
    -- �Խñ��� �Խñ� ��ȣ, �׸��� ����¡ó���� �ʿ�
    OPEN temp_cur FOR 
        SELECT * FROM ( 
        SELECT * FROM ( 
        SELECT b.num, rownum as rn from ((SELECT * FROM board ORDER BY num DESC) b)
        ) WHERE rn >= p_startNum
        ) WHERE rn <= p_endNum;
        
    -- temp_cur �� ������ �ϳ��� ���� vs_num, vs_rownum�� ������ ���̴�.
    LOOP
        FETCH temp_cur INTO vs_num, vs_rownum;
        EXIT WHEN temp_cur%NOTFOUND;
        select count(*) into vs_cnt from reply where boardnum = vs_num; -- �Խù� ��ȣ�� ��� ���̺��� ���� �˻�
        update board set replycnt = vs_cnt where num=vs_num;          -- �ش� �Խù��� replycnt�� ������Ʈ
    END LOOP;
    COMMIT;
    
    OPEN p_curvar FOR -- �̰� OUT �����̹Ƿ�, ���⿡ ����Ǿ� ��������. ���⿡�� board ���̺��� �ܾ�� �Խù��� ����, ��� �������� ������ ����ִ�.
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
-- ������ ������ �ʿ� ����...
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