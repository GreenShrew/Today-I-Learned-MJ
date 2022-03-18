-- IF ��

-- ����� ���� ���� �ϳ��̰�, �ܵ� if�� ����� ��,
-- if ���� then
--      ���๮1
-- end if

-- ����� ���� ���� �ϳ��̰�, else�� �Բ� ����Ҷ�
-- if ���� then
--      ���๮1
-- else
--      ���๮2
-- end if

-- ����� ���� �� �̻��϶�
-- if ����1 then
--      ���๮1
-- elsif ����2 then   <- elsif ��Ÿ�� �ƴϴ�.
--      ���๮2
-- else
--      ���๮3
-- end if


SET SERVEROUTPUT ON

DECLARE
    vn_num1 NUMBER := 1;
    vn_num2 NUMBER := 2;
BEGIN
    IF vn_num1 >= vn_num2 THEN
        DBMS_OUTPUT.PUT_LINE(vn_num1 || '�� ū ��');
    ELSE
        DBMS_OUTPUT.PUT_LINE(vn_num2 || '�� ū ��');
    END IF;
END;


-- employees ���̺��� ��� �Ѹ��� �����Ͽ�, �� ����(salary)�� �ݾ׿� ���� ����, �߰�, ���� �̶�� �ܾ ����ϴ�
-- �͸� ���̺��� �����Ѵ�.    (1~3000 ����, 3001~6000 ����, 6000~10000 ����)
-- ����� �����ϴ� ����� RANDOM.VALUE �Լ��� �̿��Ѵ�. ������ �μ���ȣ�� ��ȸ�ϵ�
-- �� �μ��� ����� �����̸� ù��° ������� �����Ѵ�.


DECLARE
    -- ���õ� ����� �޿�-����(salary)�� ������ ����
    vn_salary NUMBER := 0;
    -- �������� �߻��� �μ���ȣ�� ������ ����
    vn_department_id NUMBER := 0;
BEGIN
    -- �����ϰ� �μ���ȣ�� �߻�
    -- DBMS_RANDOM.VALUE(���ۼ���, ������) : ���� ���ں��� �� ���� ������ ���� ���ڸ� �߻��Ѵ�.
    -- ROUND( ����, �ݿø��ڸ��� ) : ���ڸ� ������ �ݿø� �ڸ����� �ݿø��Ѵ�.
    -- �ݿø� �ڸ����� 1�̸� �Ҽ��� ��°�ڸ����� �ݿø��ؼ� ù°�ڸ����� ����
    -- �ݿø� �ڸ����� 2�̸� �Ҽ��� ��°�ڸ����� �ݿø��ؼ� ��°�ڸ����� ����
    -- �ݿø� �ڸ����� -1�̸� 1�� �ڸ����� �ݿø��ؼ� 10�� �ڸ����� ����
    vn_department_id := ROUND( DBMS_RANDOM.VALUE(10, 120) , -1 );
    
    select salary
    into vn_salary
    from employees
    where department_id = vn_department_id and rownum=1;
    
    DBMS_OUTPUT.PUT_LINE(vn_salary);
    
    IF vn_salary BETWEEN 1 AND 3000 THEN
        DBMS_OUTPUT.PUT_LINE('����');
    ELSIF vn_salary BETWEEN 3001 AND 6000 THEN
        DBMS_OUTPUT.PUT_LINE('�߰�');
    ELSIF vn_salary BETWEEN 6001 AND 10000 THEN
        DBMS_OUTPUT.PUT_LINE('����');
    ELSE
        DBMS_OUTPUT.PUT_LINE('�ֻ���');
    END IF;
END;



-- ��ø IF��
DECLARE
    vn_salary NUMBER := 0;
    vn_department_id NUMBER := 0;
    vn_commission NUMBER := 0;
BEGIN
    vn_department_id := ROUND( DBMS_RANDOM.VALUE(10, 120) , -1 );
    
    select salary, nvl(commission_pct, 1)   -- commission_pct �� null ���� �ڲ� ���ͼ�...
    -- nvl(a, b) : a�� null ���̸� b ���� �ȴ�.
    into vn_salary, vn_commission
    from employees
    where department_id = vn_department_id and ROWNUM = 1;
    
    IF vn_commission > 0 THEN
        IF vn_commission < 0.15 THEN
            DBMS_OUTPUT.PUT_LINE(vn_salary * vn_commission);
        ELSE
            DBMS_OUTPUT.PUT_LINE(vn_salary);
        END IF;
    END IF;
END;






-- CASE ��, ���ô� ���� IF�� ���ø� �ܾ�Դ�.
DECLARE
    vn_salary NUMBER := 0;
    vn_department_id NUMBER := 0;
BEGIN
    vn_department_id := ROUND( DBMS_RANDOM.VALUE(10, 120) , -1 );
    
    select salary
    into vn_salary
    from employees
    where department_id = vn_department_id and rownum=1;

    CASE WHEN vn_salary BETWEEN 1 AND 3000 THEN
            DBMS_OUTPUT.PUT_LINE('����');
        WHEN vn_salary BETWEEN 3001 AND 6000 THEN
            DBMS_OUTPUT.PUT_LINE('����');
        WHEN vn_salary BETWEEN 6001 AND 10000 THEN
            DBMS_OUTPUT.PUT_LINE('����');
        ELSE
            DBMS_OUTPUT.PUT_LINE('�ֻ���');
    END CASE;
END;




-- CASE ����1
-- CASE WHEN ���ǽ�1 THEN
--          ���๮1
--      WHEN ���ǽ�2 THEN
--          ���๮2
--      ...
--      ELSE
--          ���๮3
-- END CASE;


-- CASE ����2 - ǥ������ ��� �� �Ǵ� ������ ������ ����� ���� �б��Ѵ�.
-- �̰� ������ case:1 ~~~ case:2 ~~~ ... �̷��� ���� ����̴�!

-- CASE ���ǽ� �Ǵ� ǥ���� �Ǵ� ����
--      WHEN ��1 THEN
--          ���๮1
--      WHEN ��2 THEN
--          ���๮2
--      ...
--      ELSE
--          ���๮3
-- END CASE;





-- �ݺ����๮

-- LOOP ��

-- �ݺ����� ����1
-- LOOP
--      ���๮;
--      EXIT [WHEN ����];
-- END LOOP;

-- ����
DECLARE
    vn_base_num NUMBER := 4;    -- ��
    vn_cnt NUMBER := 1;         -- �ݺ� ���� ���� �� �¼�
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || vn_cnt || '=' || vn_base_num*vn_cnt );
        vn_cnt := vn_cnt+1;
        EXIT WHEN vn_cnt > 9;
    END LOOP;
END;



-- �ݺ����� ����2
-- WHILE ����
-- LOOP
--      ���๮
-- END LOOP;

DECLARE
    vn_base_num NUMBER := 6;    -- ��
    vn_cnt NUMBER := 1;         -- �ݺ� ���� ���� �� �¼�
BEGIN
    WHILE vn_cnt <= 9   -- vn_cnt�� 9���� �۰ų� ���� ��쿡�� �ݺ�ó��
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || vn_cnt || '=' || vn_base_num*vn_cnt );
        vn_cnt := vn_cnt+1; -- vn_cnt ���� 1�� ����
    END LOOP;
END;



-- WHELE �� EXIT WHEN �� ȥ�ջ��
-- �Ʒ� �ݺ����๮�� �ټ���° �ݺ����� �����.
DECLARE
    vn_base_num NUMBER := 7;    -- ��
    vn_cnt NUMBER := 1;         -- �ݺ� ���� ���� �� �¼�
BEGIN
    WHILE vn_cnt <= 9   -- vn_cnt�� 9���� �۰ų� ���� ��쿡�� �ݺ�ó��
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || vn_cnt || '=' || vn_base_num*vn_cnt );
        EXIT WHEN vn_cnt = 5;
        vn_cnt := vn_cnt+1; -- vn_cnt ���� 1�� ����
    END LOOP;
END;


-- �ݺ����� ����3
-- FOR ��

-- FOR ������ IN [REVERSE]���۰�..����
-- LOOP
--      ���๮
-- END LOOP;
-- ���۰����� �������� �ݺ������Ѵ�. REVERSE�� ������ ���, �ݴ������ ���� �������� �ݺ������Ѵ�.

DECLARE
    vn_base_num NUMBER := 8;
BEGIN
    FOR i IN 1..9
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || i || '=' || vn_base_num*i );
    END LOOP;
END;

-- REVERSE �� ����� ���
DECLARE
    vn_base_num NUMBER := 8;
BEGIN
    FOR i IN REVERSE 1..9
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || i || '=' || vn_base_num*i );
    END LOOP;
END;



-- CONTINUE ��
-- �ش� ��ɿ� ���� ������ �ݺ����� �������� �ʰ� ���� �ݺ����� �Ѿ��.
DECLARE
    vn_base_num NUMBER := 9;
BEGIN
    FOR i IN 1..9
    LOOP
        CONTINUE WHEN i=5;  -- ������ �����ϸ� �ݺ����� ������ ������ ����� �������� �ʰ� ���� �ݺ����� �����Ѵ�.
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || i || '=' || vn_base_num*i );
    END LOOP;
END;



-- GOTO �� (���α׷��� ���� ���� ����� ����Ǵ� �����̴�...)
DECLARE
    vn_base_num NUMBER := 5;
BEGIN
    <<fifth>>   -- ���̶�� �θ���. GOTO ���� �̵� �������� ���ǰ� �Ѵ�.
    FOR i IN 1..9
    LOOP
        DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || i || '=' || vn_base_num*i );
        IF i = 3 THEN
            GOTO sixth;
        END IF;
    END LOOP;
    
    <<sixth>>
        vn_base_num := 6;
        FOR i IN 1..9
        LOOP
            DBMS_OUTPUT.PUT_LINE( vn_base_num || 'x' || i || '=' || vn_base_num*i );
        END LOOP;
END;



-- NULL �� : if �� �Ǵ� case when ��� �ش� ��쿡 �����ؾ� �� ����� �ϳ��� ������ ���� �����̴�.

-- IF vn_variable = 'A' THEN
--      ó������1;
-- ELSIF vn_variable = 'B' THEN
--      ó������2;
--      ...
-- ELSE 
--      NULL;
-- END IF;

-- CASE WHEN vn_variable = 'A' THEN
--          ó������1;
--      WHEN vn_variable = 'B' THEN
--          ó������2;
--          ...
--      ELSE
--          NULL;
-- END CASE;
