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



