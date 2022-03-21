-- CURSOR
-- �ַ� ���ν��� ������ SQL ����� SELECT ����� ����� �ټ��� ������ ������� �� ����ϴ�,
-- ����� �����ϴ� �޸� ������ ��Ī�Ѵ�.

SET SERVEROUTPUT ON;

-- ����1
declare
    vs_job_id varchar2(30);
begin
    select job_id into vs_job_id from employees where department_id = 30;
    DBMS_OUTPUT.PUT_LINE(vs_job_id);
end;    -- �μ���ȣ�� 30�� �μ����� ���� ����� �ִµ�, 
-- ���� ����� ���(job_id)�� �ϳ��� ���� vs_job_id�� �������� �ϴ� ������ �߻��Ѵ�.


-- ���� �͸���� select ����� ����� 1��(row)�̹Ƿ� ������ ����������, select ����� ����� 2�� �̻��̶��
-- ������ �߻��Ѵ�. 2�� �̻��� ����� ���� �� �ִ� �޸𸮿���(�Ǵ� ����)���� ����ϴ� ���� CURSOR�̸�,
-- �ڹ��� ����Ʈ�� ����� ������ ���� �ִ�.
-- �Ǵ� �ݺ����๮�� �̿��Ͽ� �� ������ �����ϰ� ����ϰ� ������ �� �ִ�.




-- CURSOR�� ����ܰ�

-- 1. CURSOR�� ���� (����)
------------------------------------------------------------
-- CURSOR ����� Ŀ���� �̸�[ (�Ű�����1, �Ű�����2, ...) ]
-- IS
-- SELECT ....SQL ���� (������ select�� ����� Ŀ���� ����ȴ�)
------------------------------------------------------------
-- �Ű������� ���� : select ��ɿ��� ����� ����(�ַ� where ������ ����� ����)
-- select ....SQL ���� : CURSOR�� ���Ǿ� ����� �Ȱ��� SQL ���


-- 2. CURSOR �� OPEN  (ȣ��)
------------------------------------------------------------
-- OPEN Ŀ���̸�[ (�����μ�1, �����μ�2, ...) ]
------------------------------------------------------------
-- ������ �����μ��� �����Ͽ� Ŀ���� �����ϰ� ����� ����


-- 3. ����� �ݺ� ���๮�� �Բ� �ʿ信 �°� ó��
------------------------------------------------------------
-- LOOP
--      FETCH Ŀ���̸� INTO ����;
--      EXIT WHEN Ŀ���̸�%NOTFOUND;    <-- select �� ���� ����� ���ڵ尡 �� �����Ǿ� ���������� �ݺ� ���
--      �ʿ信 �´� ó�� ����
-- END LOOP;
------------------------------------------------------------
-- FETCH Ŀ���̸� INTO ����;  Ŀ���� ��� �����͵� �� ���پ� ������ ������ �ִ� �����̴�.
-- EXIT WHEN Ŀ���̸�%NOTFOUND;     ���´µ� �����Ͱ� ������ �����Ѵ�.
-- LOOP �ȿ��� �ʿ信 �´� ó���� �����Ͱ� ������ ���� �ݺ��Ѵ�.

-- 4. CURSOR �ݱ�
------------------------------------------------------------
-- close Ŀ����
------------------------------------------------------------





-- cursor�� ���
-- �����μ��� �μ���ȣ�� ������ ��, �� �μ��� ��� �̸����� ������ Ŀ��

SET SERVEROUTPUT ON;


declare
    vs_emp_name employees.emp_name%type;    -- ������� �����ϱ� ���� ����
    vs_employee_id employees.employee_id%type;  -- ��� ��ȣ�� �����ϱ� ���� ����
    
    -- 1. CURSOR ����(����, ����)
    -- �μ���ȣ�� Ŀ���� �����ؼ� �� �μ� ��ȣ�� ���� ����� �����ȣ�� �̸��� ���� Ŀ�� ����
    CURSOR cur_emp_dep(cp_department_id employees.department_id%type)
    IS
    SELECT employee_id, emp_name FROM employees WHERE department_id = cp_department_id; -- ���� sql ���� ����Ȱ� �ƴϴ�.
begin
    -- 2. Ŀ���� �����Ѵ�.(ȣ��)
    OPEN cur_emp_dep(90);   -- �����μ��� �μ���ȣ 90�� �־��ش�.
    
    -- 3. �ݺ� ���๮���� Ŀ���� ����� �����͸� ������ ����Ѵ�.
    LOOP
        -- �ݺ��� ����Ǵ� ���� Ŀ���� ����� �����͸� �� �྿ ������ vs_employee_id, vs_emp_name ������ �����Ѵ�.
        FETCH cur_emp_dep INTO vs_employee_id, vs_emp_name;
        EXIT WHEN cur_emp_dep%NOTFOUND;  -- ���� ���ڵ尡 ���������� �ݺ�
        DBMS_OUTPUT.PUT_LINE(vs_employee_id || ' - ' || vs_emp_name);    -- ���� ������ ���
    END LOOP;
    CLOSE cur_emp_dep;  -- Ŀ�� �ݱ�
    
end;





-- Ŀ���� for ��
-- ������ FOR�� -----------------------------
-- FOR �ε������� IN [REVERSE] ó���� .. ����
-- LOOP
--      ���๮
-- END LOOP;
--------------------------------------------


-- Ŀ���� �Բ� ����ϴ� for �� --------------------
-- FOR ���ڵ庯�� IN Ŀ���̸�(�����μ�1, �����μ�2 ... )
-- LOOP
--      ���๮
-- END LOOP;
-------------------------------------------------

-- FOR ���ڵ庯�� IN Ŀ���̸�(�����μ�1, �����μ�2 ... )  :  OPEN ���� ����(ȣ��)�ϴ� ������ FOR���� IN �������� �̵�
-- ���� ����� �ϳ���(1��, 1���ڵ�) ���ڵ� ������ ����Ǿ� �ݺ�����ȴ�.
-- �ڵ����� �������� ������ŭ �ݺ� ����ȴ�.
declare
    -- ���ڵ� ������ ����ϱ� ������ �� �ʵ尪�� ������ ������ ������ �ʴ´�.
    CURSOR cur_emp_dep(cp_department_id employees.department_id%type)
    IS
    SELECT employee_id, emp_name FROM employees WHERE department_id = cp_department_id;
begin
    FOR emp_rec IN cur_emp_dep(90)
    LOOP
        DBMS_OUTPUT.PUT_LINE(vs_employee_id || ' - ' || vs_emp_name);
    END LOOP;
end;

-- OPEN�� FETCH�� For ���� �ϳ��� ��ģ ���...
-- CLOSE�� �������!
-- �ռ� ������� �� �����ϴ�.



-- ���� �� ������ FOR ���� Ŀ���� ���
declare

begin
    FOR emp_rec IN (SELECT employee_id, emp_name    -- CURSOR�� ������ �ƿ� ���� ����.
                    FROM employees 
                    WHERE department_id = 90)
    LOOP
        DBMS_OUTPUT.PUT_LINE(employee_id || ' - ' || emp_name);
    END LOOP;
end;




-- ��������
-- �μ���ȣ�� 30���� ����� �̸�, �μ���, �޿�, �޿�(����, ����, ����)�� �������.
-- �޿�(salary)�� 5000 �̸� ����, 10000 �̸� ����, ������ �������� �������.
-- �̸� - �μ��� - �޿� - ���� ������ ����Ѵ�.
select * from employees;
select * from departments;
declare
    level varchar2(10); -- �޿��� ����, ����, ���� �� ǥ���� ����
begin
    FOR emp_rec IN (select a.emp_name, b.department_name, a.salary
                    from employees a, departments b
                    where a.department_id = 30 and a.department_id = b.department_id)
    LOOP
        if emp_rec.salary <= 5000 then
            level := '����';
        elsif emp_rec.salary <= 10000 then
            level := '����';
        else
            level := '����';
        end if;
        DBMS_OUTPUT.PUT_LINE(emp_rec.emp_name || ' - ' || emp_rec.department_name || ' - ' || emp_rec.salary || ' - ' || level);
    END LOOP;
end;



-- Ŀ�� ����
-- �տ��� ������ Ŀ���� �̸��� �Լ�ó�� ȣ��Ǵ� �̸��̱⵵ �ϰ�, Ŀ���� ��ǥ�ϴ� �̸��� �ִ�.
-- �׷��� Ŀ���� �̸����� �ٸ� Ŀ���� �������� ���Ѵ�.
-- ������ ġ�� �տ��� ���� Ŀ���� �̸��� ��� ������ ǥ���� �����ϴ�.
-- ������ ���� �̸��� �����μ� ���ǰ�, �ٸ� Ŀ���� ������ �� �ְ� ����ϰ��� �Ѵ�.

-- Ŀ�� ������ ����
-- TYPE ����� Ŀ���� �̸� IS REF CURSOR [ RETURN ��ȯŸ�� ];   --> ������ Ŀ��Ÿ���� �̸����� Ŀ�� ������ ������ �����̴�.
-- Ŀ�������̸� Ŀ��Ÿ���̸�;
-- Ŀ�� Ÿ���� ���鋚 RETRUN ���� �����ϸ� ����Ŀ��Ÿ���� �����Ǵ°��̰�, RETURN�� ������ ���� Ŀ��Ÿ���̶�� ��Ī�Ѵ�.

TYPE dep_curtype1 IS REF CURSOR RETURN departments%ROWTYPE; -- ���� Ŀ�� Ÿ�� (select�� ����� departments ���̺�� �ڷ����� ���ƾ� �Ѵ�)
TYPE dep_curtype2 IS REF CURSOR; -- ���� Ŀ�� Ÿ��
-- �� ������ ����� Ŀ���� �̸��� �����Ѱ��� �ƴ϶�, Ŀ���� ������ �� �ִ� Ŀ���ڷ����� �����Ѱ��̴�.
-- ������ Ŀ�� �ڷ������� Ŀ�� ������ ������ �� �ִ�.
-- ���� Ŀ�� Ÿ���� ���� Ư���� ��찡 �ƴ϶�� �� ����!

cursor1 dep_curtype1;
cursor2 dep_curtype2;
-- cursor1�� cursor2 �������� select ����� ��Ƽ� Ŀ���� �ϼ��� �� �ִ�.
-- ����, Ŀ������(select ��)�� ���������� �ʰ� �ٲ� �� �ִ�.
-- �ٸ� cursor1�� ���� Ŀ�� Ÿ���̹Ƿ�, ���ǵǾ� �ִµ��� (RETURN departments%ROWTYPE) ���ڵ� ��ü�� ����� ��� select�� ������ �� �ִ�.

-- Ŀ�� ������ Ŀ���� ������ ����.
OPEN cursor1 FOR SELECT employee_id, emp_name FROM employees WHERE department_id = 90;  -- X �Ұ���! ���� Ŀ�� Ÿ������ return Ÿ���� �����Ǿ������Ƿ�
OPEN cursor1 FOR SELECT * FROM departments WHERE department_id = 90;  -- o ����!

OPEN cursor2 FOR SELECT employee_id, emp_name FROM employees WHERE department_id = 90;  -- o ����!
OPEN cursor2 FOR SELECT * FROM departments WHERE department_id = 90;  -- o ����!



-- Ŀ�� ������ ���� �ʿ��Ҷ����� Ŀ�� ������ �����ϰ� ȣ���ؼ� �� ����� ����Ϸ��� ������ �����.
declare
    vs_emp_name employees.emp_name%TYPE;    -- �Ϲ� ���� ����
    vs_dep_id employees.department_id%TYPE;    -- �Ϲ� ���� ����
    TYPE emp_dep_curtype IS REF CURSOR;     -- ���� Ŀ�� Ÿ�� ����
    emp_dep_curvar emp_dep_curtype;         -- ������ Ŀ�� Ÿ������ Ŀ������ ����
begin
    OPEN emp_dep_curvar FOR select emp_name, department_id
                            from employees
                            where department_id = 90;   -- Ŀ�������� select �� ����
    LOOP
        FETCH emp_dep_curvar INTO vs_emp_name, vs_dep_id;  -- select�� ����� �ϳ��� ������ vs_emp_name, vs_dep_id �� �ִ´�.
        EXIT WHEN emp_dep_curvar%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(vs_emp_name || ' - ' || vs_dep_id);
    END LOOP;
end;





-- ������ ���� ���� ����ϰԵ� Ŀ��! �ý��ۿ��� �������ִ� Ŀ�� Ÿ��! ( �ռ� ������ CURSOR ���� �̰� ���� ������)
dep_curtype3 SYS_REFCURSOR; -- �ý��ۿ��� �������ִ� Ŀ�� Ÿ��

-- SYS_REFCURSOR �� ����ϸ�
-- TYPE emp_dep_curtype IS REF CURSOR; -- Ŀ��Ÿ�� ���� ��������
-- emp_dep_curvar emp_dep_curtype;      -- ���� ���� SYS_REFCURSOR ���·� ����

declare
    vs_emp_name employees.emp_name%TYPE;
    vs_salary employees.salary%TYPE;
    emp_dep_curvar SYS_REFCURSOR;   -- SYS_REFCURSOR Ÿ���� Ŀ������ ����
begin
    OPEN emp_dep_curvar FOR SELECT emp_name, salary
                            FROM employees
                            WHERE department_id = 90;
    LOOP
        FETCH emp_dep_curvar INTO vs_emp_name, vs_salary;  -- select�� ����� �ϳ��� ������ vs_emp_name, vs_salary �� �ִ´�.
        EXIT WHEN emp_dep_curvar%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(vs_emp_name || ' - ' || vs_salary);
    END LOOP;
end;


-- ���� ����!
-- 1. SYS_REFCURSOR ���� ����
-- 2. ������ select�� ����
-- 3. FETCH�� ������ ó��(�ݺ�����)



-- ���ν��������� Ŀ�� ��� ��
-- select�� ����� cursor�� ��Ƽ� ���ν����� ȣ���� ������ �����ַ��� �Ѵ�.
CREATE OR REPLACE PROCEDURE testCursorArg(
    p_curvar OUT SYS_REFCURSOR  -- ������ �����̴� OUT, �������� ������ temp_curvar�̹Ƿ� �ڷ����� SYS_REFCURSOR
)
IS
    temp_curvar SYS_REFCURSOR;  -- ���ν������� ����� Ŀ�� ����
BEGIN
    OPEN temp_curvar FOR SELECT emp_name, salary FROM employees WHERE department_id=90;
    -- ���� ��ġ���� Ŀ���� ������ fetch �Ͽ� ���� ���� �ƴϱ� ������, �ݺ����൵ fetch�� ���� �ʴ´�.
    p_curvar := temp_curvar;    -- OUT ������ �����͸� �־��ִ°��� ���𰡸� return ��Ű�°Ͱ� ����.
END;

-- ������ ���� testCursorARG ���ν����� ����Ѵ�.
DECLARE
    out_curvar SYS_REFCURSOR;   -- Ŀ�� ���� ����
    vs_emp_name employees.emp_name%TYPE;    -- �Ϲ� ���� ����
    vs_salary employees.salary%TYPE;
BEGIN
    testCursorARG( out_curvar );    -- select�� ����� out_curvar �� �����Ѵ�.
    LOOP
        FETCH out_curvar INTO vs_emp_name, vs_salary;
        EXIT WHEN out_curvar%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(vs_emp_name || ' - ' || vs_salary);
    END LOOP;
END;

-- mybatis ���� ���ν��� ����� ��ȸ �����͸� �����ϴ� �߿��� ������ �ϴ°��� cursor�̴�.
-- ���� ���� ������ Ŀ���� �����μ��� �����ؼ� ��ȸ����� ��� �� �� �ִ� �������� �̷������ ���ÿ�
-- mybatis ���� ����ϱ� �� ���� �����̹Ƿ� �߿��� ������ ����صΰ� �ʿ�� �����ϴ°��� ����.
