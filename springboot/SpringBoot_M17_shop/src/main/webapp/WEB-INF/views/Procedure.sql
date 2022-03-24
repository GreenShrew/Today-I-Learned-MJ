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




create or replace PROCEDURE insertMember_s(
    p_userid IN member.userid%TYPE,
    p_pwd IN member.pwd%TYPE,
    p_name IN member.name%TYPE,
    p_email IN member.email%TYPE,
    p_phone IN member.phone%TYPE,
    p_zip_num IN member.zip_num%TYPE,
    p_address IN member.address%TYPE,
    p_address2 IN member.address2%TYPE
)
IS
BEGIN
    INSERT INTO member(userid, pwd, name, email, phone, zip_num, address, address2)
    values(p_userid, p_pwd, p_name, p_email, p_phone, p_zip_num, p_address, p_address2);
    commit;
END;






create or replace PROCEDURE updateMember_s(
    p_userid IN member.userid%TYPE,
    p_pwd IN member.pwd%TYPE,
    p_name IN member.name%TYPE,
    p_email IN member.email%TYPE,
    p_phone IN member.phone%TYPE,
    p_zip_num IN member.zip_num%TYPE,
    p_address IN member.address%TYPE,
    p_address2 IN member.address2%TYPE
)
IS
BEGIN
    UPDATE member set pwd=p_pwd, name=p_name, email=p_email, phone=p_phone,
    zip_num=p_zip_num, address=p_address, address2=p_address2 where userid=p_userid;
    commit;
END;




create or replace PROCEDURE getKindList(
    p_kind IN product.kind%TYPE,
    p_cur OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_cur FOR SELECT * FROM product WHERE kind=p_kind;
END;





create or replace PROCEDURE getProduct(
    p_pseq IN product.pseq%TYPE,
    p_cur OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_cur FOR SELECT * FROM product WHERE pseq=p_pseq;
END;





create or replace PROCEDURE insertCart(
    p_id IN cart.id%TYPE,
    p_pseq IN cart.pseq%TYPE,
    p_quantity IN cart.quantity%TYPE
)
IS
BEGIN
    INSERT INTO cart(cseq, id, pseq, quantity) values(cart_seq.nextVal, p_id, p_pseq, p_quantity);
    commit;
END;

select * from cart;

