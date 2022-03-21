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



