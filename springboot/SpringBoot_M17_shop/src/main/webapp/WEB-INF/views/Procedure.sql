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




create or replace PROCEDURE listCart(
    p_id IN cart.id%TYPE,
    p_cur OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_cur FOR SELECT * FROM cart_view WHERE id=p_id;
END;





create or replace PROCEDURE deleteCart(
    p_cseq IN cart.cseq%TYPE
)
IS
BEGIN
    delete from cart where cseq = p_cseq;
    commit;
END;




CREATE OR REPLACE PROCEDURE insertOrder(
    p_id IN orders.id%TYPE,
    p_oseq OUT orders.oseq%TYPE
)
IS
    v_oseq orders.oseq%TYPE;
    temp_cur SYS_REFCURSOR;
    v_cseq cart.cseq%TYPE;
    v_pseq cart.pseq%TYPE;
    v_quantity cart.quantity%TYPE;
BEGIN
    -- oreders ���̺� ���ڵ� �߰�
    INSERT INTO orders(oseq, id) values(orders_seq.nextVal, p_id);

    -- orders ���̺��� ���� ū oseq ��ȸ
    select max(oseq) into v_oseq from orders;
    
    -- cart ���̺��� id�� ��� ��ȸ(select * from... �̷������� �Ѳ����� �������°� �ƴ϶� ���ε��� �����;� �Ѵ�!)
    OPEN temp_cur FOR select cseq, pseq, quantity from cart where id = p_id and result = '1';
    
    -- ��ϰ� oseq�� order_detail ���̺� ���ڵ� �߰�
    LOOP
        -- ������ temp_cur�� ������ cseq, pseq, quantity�� ���� ������ ���� �����Ѵ�.
        FETCH temp_cur INTO v_cseq, v_pseq, v_quantity;  -- ��ȸ�� īƮ�� ��Ͽ��� �ϳ��� ������ ó��
        EXIT WHEN temp_cur%NOTFOUND;        -- ��ȸ�� īƮ�� ����� ��� �����Ҷ�����
        INSERT INTO order_detail(odseq, oseq, pseq, quantity)
        values(order_detail_seq.nextVal, v_oseq, v_pseq, v_quantity);       -- oreder_detail ���̺� ���ڵ� �߰�
        delete from cart where cseq = v_cseq;
    END LOOP;
    commit; -- Ŀ�� �ʼ�
    -- oseq ���� OUT ������ ����
    p_oseq := v_oseq;
END;




create or replace PROCEDURE listOrderByOseq(
    p_oseq IN orders.oseq%TYPE,
    p_cur OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_cur FOR SELECT * FROM order_view WHERE oseq = p_oseq;
END;









