-- ���ν���
-- �Լ��� ����� �����̴�.
-- �Լ��� ��� ������ ������, ���ν����� ��� ������ ���°��� Ư¡�̴�. (������ ���� ������ �ڵ�(����)�� �ִ�.)

-- ����� [ ] �̰� ���� ����, [ a | b ] �� a, b ���߿� �ϳ� ������ �ǹ��Ѵ�.

-- ���ν����� ����
-- CREATE OR REPLACE PROCEDURE ���ν����̸�(
--      �Ű�������1 [IN | OUT | IN OUT] ������Ÿ��[:=����Ʈ ��],
--      �Ű�������2 [IN | OUT | IN OUT] ������Ÿ��[:=����Ʈ ��],
--      ...
-- )
-- IS[AS]
--      ����, ��� ����
-- BEGIN
--      �����
-- [ EXCEPTION
--      ����ó���� ]
-- END [���ν����̸�];

-- CREATE OR REPLACE PROCEDURE : ���ν����� �����ϴ� �����̴�.
-- �Ű�������1 [IN | OUT | IN OUT] : �Ű������� ����� ���޵Ǵ� �����μ��� �޴� IN ������
--      ���Ͽ����� �� �� �ִ� OUT ������ ���鶧 ����Ѵ�. �Էº����� ��º����� ������ ���ÿ� �ο��Ƿ���
--      IN OUT �� ���� ����Ѵ�.
--      ���ν����� �⺻������ ���ϰ��� ������(���� RETURN ����� ������� ����) ������ �Ӽ��� OUT �Ӽ� �ϳ���
--      �ο������μ� ������ ������ �䳻���� �ְԴ� ����� �����ϴ�.
--      ���� �Ӽ��� IN �� ��� ������ �����ϴ�.


-- ���ν��� ����
-- JOBS ���̺� ���ڵ带 �߰��ϴ� ���ν���
select * from JOBS;
CREATE OR REPLACE PROCEDURE my_new_job_proc (
    p_job_id JOBS.JOB_ID%TYPE,  -- IN�� ���� �ʾƵ� �ȴ�.
    p_job_title IN JOBS.JOB_TITLE%TYPE,
    p_min_salary IN JOBS.MIN_SALARY%TYPE,
    p_max_salary IN JOBS.MAX_SALARY%TYPE
)
IS
-- �̹����� IS�� �� ������ ����...
BEGIN
    INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY, CREATE_DATE, UPDATE_DATE)
    VALUES(p_job_id, p_job_title, p_min_salary, p_max_salary, SYSDATE, SYSDATE);
    COMMIT;
END;

-- ������ ���� ���ν����� ȣ���� �Ʒ��� ���� �Ѵ�.
EXEC my_new_job_proc ('SM_JOB1', 'Sample JOB1', 1000, 5000);


-- EXEC ������� ���ڵ尡 �߰��Ǿ����� Ȯ��
select * from jobs where job_id = 'SM_JOB1';



-- ���� �ι�°
-- JOBS ���̺� ���ڵ带 �߰��ϵ�, �߰��� ������ JOB_ID �� �̹� �����ϴ� ���̸�, �ش� ������ ������,
-- ������ ���ڵ带 INSERT �ϴ� ���ν����� ��������.
-- ������ ������ �Ʒ��� ����.
EXEC my_new_job_proc ('SM_JOB1', 'Sample JOB2', 2000, 6000);
EXEC my_new_job_proc ('SM_JOB2', 'Sample JOB2', 2500, 6500);

select * from jobs where job_id like '%SM_JOB%';

CREATE OR REPLACE PROCEDURE my_new_job_proc(
    p_job_id IN JOBS.JOB_ID%TYPE,
    p_job_title IN JOBS.JOB_TITLE%TYPE,
    p_min_salary IN JOBS.MIN_SALARY%TYPE,
    p_max_salary IN JOBS.MAX_SALARY%TYPE
)
IS
    vn_cnt NUMBER(10);
BEGIN
    select count(*) into vn_cnt from jobs where job_id=p_job_id;    -- ������ ���� job_id�� �ִ��� üũ
    
    if vn_cnt = 0 THEN  -- ��ȸ�� ���ڵ尡 0���� insert, �ƴϸ� update
        INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY, CREATE_DATE, UPDATE_DATE)
        VALUES(p_job_id, p_job_title, p_min_salary, p_max_salary, SYSDATE, SYSDATE);
    ELSE
        UPDATE JOBS set JOB_TITLE = p_job_title, MIN_SALARY = p_min_salary, MAX_SALARY = p_max_salary, update_date = SYSDATE
        where JOB_ID = p_job_id;
    END IF;
    COMMIT;
END;



-- OUT, IN OUT �Ű����� ���
CREATE OR REPLACE PROCEDURE my_new_job_proc2(
    p_job_id IN JOBS.JOB_ID%TYPE,
    p_job_title IN JOBS.JOB_TITLE%TYPE,
    p_min_salary IN JOBS.MIN_SALARY%TYPE,
    p_max_salary IN JOBS.MAX_SALARY%TYPE,
    p_upd_date OUT JOBS.UPDATE_DATE%TYPE        -- OUT �Ű����� �߰�
)
IS
    vn_cnt NUMBER(10);
    vn_cur_date JOBS.UPDATE_DATE%TYPE := SYSDATE;   -- ���� �߰�
BEGIN
    select count(*) into vn_cnt from jobs where job_id=p_job_id;    -- ������ ���� job_id�� �ִ��� üũ
    
    if vn_cnt = 0 THEN  -- ��ȸ�� ���ڵ尡 0���� insert, �ƴϸ� update
        INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY, CREATE_DATE, UPDATE_DATE)
        VALUES(p_job_id, p_job_title, p_min_salary, p_max_salary, SYSDATE, SYSDATE);
    ELSE
        UPDATE JOBS set JOB_TITLE = p_job_title, MIN_SALARY = p_min_salary, MAX_SALARY = p_max_salary, update_date = SYSDATE
        where JOB_ID = p_job_id;
    END IF;
    COMMIT;
    p_upd_date := vn_cur_date;  -- OUT ������ ����
END;

SET SERVEROUTPUT ON

-- ���� my_new_job_proc2���� ������ OUT ������ �Ʒ� �͸� �Լ����� ������ ����.
DECLARE
    vd_cur_date JOBS.UPDATE_DATE%TYPE;
BEGIN
    -- �͸��Ͽ��� ���ν����� ȣ���Ҷ��� exec�� ������� �ʴ´�.
    my_new_job_proc2 ('SM_JOB1', 'Sample JOB2', 2000, 6000, vd_cur_date);
    -- �ټ���° �μ��� �־��� ���� �͸����� ������,
    -- ���ν����� OUT ������ ����Ǿ� �� ���� �����޵��� �޾Ƽ� ����� �����ϴ�.
    -- ���ν��� ������ OUT ������ ���� �����ϸ�, ���� ��ġ�� �����μ��� �־��� vd_cur_date ������ �����Ͱ� ���� ȿ���� ���´�.
    DBMS_OUTPUT.PUT_LINE(vd_cur_date);
END;





-- ����Ʈ ���
-- �̸� ���� ����ִ� ���
CREATE OR REPLACE PROCEDURE my_new_job_proc3(
    p_job_id IN JOBS.JOB_ID%TYPE,
    p_job_title IN JOBS.JOB_TITLE%TYPE,
    p_min_salary IN JOBS.MIN_SALARY%TYPE := 100,
    p_max_salary IN JOBS.MAX_SALARY%TYPE := 800
)
IS
    vn_cnt NUMBER(10);
BEGIN
    select count(*) into vn_cnt from jobs where job_id=p_job_id;
    
    if vn_cnt = 0 THEN
        INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY, CREATE_DATE, UPDATE_DATE)
        VALUES(p_job_id, p_job_title, p_min_salary, p_max_salary, SYSDATE, SYSDATE);
    ELSE
        UPDATE JOBS set JOB_TITLE = p_job_title, MIN_SALARY = p_min_salary, MAX_SALARY = p_max_salary, update_date = SYSDATE
        where JOB_ID = p_job_id;
    END IF;
    COMMIT;
END;

exec my_new_job_proc3 ('SM_JOB1', 'Sample JOB1');
select * from jobs where job_id = 'SM_JOB1';


-- �Ű����� �μ� ���޽�, ���� ����
exec my_new_job_proc( p_min_sal => 5000, p_job_id => 'SM_JOB1', p_max_sal => 10000, p_job_title => 'Sample JOB1');
select * from jobs where job_id = 'SM_JOB1';



-- IN ������ OUT ������ IN OUT ����
CREATE OR REPLACE PROCEDURE my_parameter_test_proc (
    p_var1 IN    VARCHAR2,
    p_var2 OUT   VARCHAR2,
    p_var3 IN OUT VARCHAR2
)
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('p_var1 value = ' || p_var1);
    DBMS_OUTPUT.PUT_LINE('p_var2 value = ' || p_var2);  -- OUT ������ ���޵� ���� �־ ������ ���� �ʴ´�.
    DBMS_OUTPUT.PUT_LINE('p_var3 value = ' || p_var3);
    -- OUT ������ �־��� ���� ȣ�⿡ ���� �����μ��μ��� ���� (�͸���� v_var2, v_var3) �� ����ȴ�.
    
    -- p_var1 := 'A2';  -- IN ������ �����μ��� ���� ���� �������� ���Ƿ� ���� ���� ���Ѵ�.
    p_var2 := 'B2';
    p_var3 := 'C2';
END;

declare
    v_var1 VARCHAR2(10) := 'A';
    v_var2 VARCHAR2(10) := 'B';     -- B�� �־ ��������, OUT �����̹Ƿ� �ƹ� �ǹ� ����...
    v_var3 VARCHAR2(10) := 'C';
begin
    -- ������ ������ ���� �����μ��� �� ���޵ɰ� ������, ���ν����� OUT ����(p_var2)���� ���޵��� �ʴ´�.
    my_parameter_test_proc (v_var1, v_var2, v_var3);
    
    -- ���ν����� OUT ������ ���޵� ������ ���ν�
end;


-- IN OUT ������ ��� ��Ģ
-- 1. IN ������ �����μ��� ���޵Ǿ� ����� ���� ������ �� �� �ְ�, ���� �Ҵ��� �� ����.
-- 2. OUT �������� �����μ��� ���� ������ ���� ������, ������ �� �����Ƿ� �ǹ̰� ���� �����̴�.
-- 3. OUT ������ IN OUT ������ ����Ʈ���� ������ �� ����.
-- 4. IN �������� ����, ���, �� ���������� ���� ���� �����μ��� ������ �� ������, OUT ������ IN OUT ������
--      �ݵ�� ���� ���·� �����μ��� �־�����Ѵ�.




-- RETURN ��: ���ν������� RETURN�� ���� �����ϰڴٴ� ����� �ƴϰ�, �� �������� ���ν����� �����ڴٴ� ���̴�.
--      �ڹٿ��� void �޼��� �����߿�, return ������� �߰��� �޼ҵ带 �����ϴ°Ͱ� ����ϴ�.
CREATE OR REPLACE PROCEDURE my_new_job_proc4(
    p_job_id IN JOBS.JOB_ID%TYPE,
    p_job_title IN JOBS.JOB_TITLE%TYPE,
    p_min_salary IN JOBS.MIN_SALARY%TYPE := 10,
    p_max_salary IN JOBS.MAX_SALARY%TYPE := 100
)
IS
    vn_cnt NUMBER := 0;
BEGIN
    -- 1000 ���� ������ �޼��� ��� �� ����������.
    IF p_min_sal < 1000 THEN
        DBMS_OUTPUT.PUT_LINE('�ּ� �޿����� 1000 �̻��̾�� �մϴ�');
        RETURN;
    END IF;
    -- IF�� ������ ���̸� �Ʒ� ����� ������� �ʰ� ���ν����� �����ϰ� �ȴ�.
    -- ������ �����϶��� �Ʒ��� ����� �����Ѵ�.
END;
