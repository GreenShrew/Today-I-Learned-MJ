CREATE OR REPLACE PROCEDURE getBestNewProduct(
    p_cur1 OUT SYS_REFCURSOR,
    p_cur2 OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_cur1 FOR
        SELECT * FROM new_pro_view;
    OPEN p_cur2 FOR
        SELECT * FROM best_pro_view;
END;



create or replace PROCEDURE getMember_s(
    p_userid IN member.userid%TYPE,
    p_curvar OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_curvar FOR SELECT * FROM member WHERE userid=p_userid;
END;




create or replace PROCEDURE getAddress_s(
    p_dong IN member.address%TYPE,
    p_curvar OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_curvar FOR SELECT * FROM address WHERE dong LIKE '%'||p_dong||'%';
END;




create or replace PROCEDURE join_s(
    p_dong IN member.address%TYPE
)
IS
BEGIN
    OPEN p_curvar FOR SELECT * FROM address WHERE dong LIKE '%'||p_dong||'%';
END;

