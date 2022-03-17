drop table channels;
drop table countries;
drop table customers;
drop table departments;
drop table employees;
drop table job_history;
drop table jobs;
drop table kor_loan_status;
drop table products;

commit;


select * from tab;

-- PL/SQL
-- �ټ��� SQL ����� �𿩼� �ϳ��� �۾���� �Ǵ� Ʈ�������� �̷궧, �̸� �ϳ��� ������ ���
-- �ѹ��� �����ϰ� �ϴ� �����������̴�.

-- ���� ���, Shoes Shop ���θ� ������ ���, ��ٱ��Ͽ� �ִ� ��ǰ���� �ֹ��Ϸ��� �Ҷ�
-- Orders ���̺� ���ο� ����Ʈ insert
-- Orders ���̺��� ���� ū oseq ��ȸ
-- ��ٱ��Ͽ��� ��ǰ����� ��ȸ
-- ��ȸ�� oseq�� ��ǰ ����� order_detail�� insert
-- ��ٱ��Ͽ��� ��� �ֹ��� ��ǰ ����

-- �ټ����� ����� �ϳ��� ������ҷ� ��� �����ϴ� ���̴�!
-- �� ������ ����Ŭ�� �����ϴ� ���α׷��� ��ҿ� �԰� SQL ��� �׷�(��)�� ����� �ѹ��� �����Ҽ� �ְ� �Ѵ�.
-- �׷��� ������� PL/SQL ���� MyBatis���� Ȱ��ȴ�.





-- ��
-- PL/SQL�� ���� ������ �����Ǿ� �ִµ�, ���� �����Ҽ� �ִ� ������ SQL ����� ���ִ� �� ���� ������,
-- �̴� ����� ��������� �ȴ�.
-- �̿� �͸� ��, �̸��� �ִ� �� � �ְ�,
-- ��ɺ��� �̸���, �����, �����, ����ó���ηε� �����⵵ �Ѵ�.


-- PL/SQL ���� ������
-- PL/SQL �� �ϳ��� ���� ����� �����Ҷ� �Ʒ��� ���� �� ��ġ, ��ɺ� ������ �̷������.
IS(AS)
--      �̸���, �ش� ���� �̸��� ��Ÿ����.
DECLARE
--      �����, ������ ������ �� �ִ�!
BEGIN
--      �����, ���� SQL ����� ����.
EXCEPTION
--      ����ó����, ���� ���� ó���� ��� ó������ ������ ����.
END;

-- BEGIN, END �� ������ �������� �ʿ信 ���� ������ �����ϴ�.


-- �͸� �� ����
DECLARE
    num NUMBER; -- ���� ����, ������ �տ� ���� ���� ���¸� �ڷ� ���´�.
BEGIN
    num := 100; -- ���� ��� 1, num�� �� 100�� ������� ���.
    DBMS_OUTPUT.PUT_LINE(num);  -- ���� ��� 2, ȭ�鿡 ����ϴ� ���.
END;

-- ȭ�� ����� �ϱ� ���� ����� ON �ϴ� ���
SET SERVEROUTPUT ON
-- ����ð��� ����ϱ� ���� ����� ON �ϴ� ���
SET TIMING ON
SET TIMING OFF

-- ���� ��ǥ�� �� ����Ʈ���� ���޹��� �����μ��� ����(SQL)�ϰ�, ����� ������Ʈ�� �ٽ� �������ִ� ��������,
-- ����� �� ��Ȳ���� �������� �������Ƿ� ���� ���� �־��ְ�(num := 100;), ����� ȭ������ ����Ѵ�(DBMS_OUTPUT.PUT_LINE(num);).





-- ���� : ù��° SQL���� Orders ���̺� ���ڵ带 �����ϰ�, ���� ū oseq�� ��ȸ�� ���� �� ���� order_detail��
--      �Է°����� ����Ϸ��� ������ �����ϰ� ���� �����ؼ� Ȱ���Ѵ�.
-- ���� ������
-- ������ �����ڷ�Ÿ�� := �ʱⰪ;   <- SQL ��ɳ��� '='�� �����ϱ� ���� ':='���� ����Ѵ�.


-- PL/SQL �� �ڷ���
-- ������ SQL �ڷ����� ��� �����ϸ�, �����Ӱ� ����� �����ϴ�(NUMBER, VARCHAR2 ��...)
-- BOOLEAN : TRUE, FALSE, NULL�� ���� �� �ִ� �ڷ���
-- PLS_INTEGER : -2147483648 ~ 2147483647 ���� ���� ���� NUMBER ���� ���� ��������� �� �����Ѵ�.
-- BINARY_INTEGER : PLS_INTEGER �� ���� �뷮, ���� �뵵�� ����Ѵ�.
-- NATRAL : PLS_INTEGER �� ���(0 ����)
-- NATRALN : NATRAL�� ������, NULL ����� ���� ����� ���ÿ� �ʱ�ȭ�� �ʿ��ϴ�.
-- POSITIVE : PLS_INTEGER �� ����(0 ������)
-- POSITIVEN : POSITIVE�� ������, NULL ����� ���� ����� ���ÿ� �ʱ�ȭ�� �ʿ��ϴ�.
-- SIGNTYPE : -1, 0, 1
-- SIMPLE_INTEGER : PLS_INTEGER �� NULL�� �ƴ� ��� ��, ����� ���ÿ� �ʱ�ȭ�� �ʿ��ϴ�.



-- ������
-- ** : ���� (�ڽ�) ����  --> 3**4 �� 3�� 4��
-- +, - : ��� ���� ���� ����
-- ��Ģ���� +, -, *, /, ||(���ڿ� ����)
-- �� ���� =, >, <, >=, <=, <>, !=, IS NULL, LIKE, BETWEEN, IN
-- �� ���� NOT AND OR

-- PL/SQL ���� �����ڸ� ����� ��
DECLARE
    a INTEGER := 2**2*3**2;
BEGIN
    DBMS_OUTPUT.PUT_LINE('a = ' || TO_CHAR(a));
END;

-- DECLARE, BEGIN ���� �� ������ �� ������ SQL ���� �ϳ��� ��ɾ��, 
-- �����ڸ� ������ �Ϲ� ��ɾ �ϳ��� ��ɾ�� �ν��ؼ� �� �ڿ� ';'�� �ִ°����� �����Ѵ�.




-- SQL ��ɰ� ���� ����Ǵ� PL/SQL
-- employees ���̺��� �����ȣ�� 100�� ����� �̸��� ������ �����ϴ� ����
select emp_name from employees where employee_id=100;
-- �̰� �̴�� �����ϸ� �ϴ��� '���� ���'�� ���´�.
-- �̸� ��ũ��Ʈ�� ����ϰ� �ʹٸ� �Ʒ��� ���� �����.

DECLARE
    e_name varchar2(30);
BEGIN
    select emp_name
    into e_name     -- select �ؼ� emp_name�� ������, �̸� e_name�̶�� ������ �����ϴ� ���
    from employees
    where employee_id=100;
    
    DBMS_OUTPUT.PUT_LINE(e_name);
END;



-- select ���� ���ؼ� ����Ǵ� ����� �ΰ� �̻��̶��, SQL �������� ���� ������ ���� ������ŭ �����
-- INTO ���� ��� �ʵ��� ������ �°� ��ġ��Ų��.
-- employees ���̺��� �����ȣ�� 100�� ����� �̸��� �μ���ȣ�� ������ �����ϴ� ����
select emp_name, department_id from employees where employee_id=100;

DECLARE
    e_name varchar2(80);   -- ����� ����
    d_id varchar2(80);   -- �μ��� ����
BEGIN
    select emp_name, department_id
    INTO e_name, d_id  
    from employees
    where employee_id=100;
    
    DBMS_OUTPUT.PUT_LINE(e_name || ' - ' || d_id);
END;




-- ������ ������ ���� ��� �ڷ����� ������ ���缭 �����ϱⰡ ���ŷο�����.
-- ���� ��Ī�� �ʵ��� �̸��� %Type�� �̿��Ͽ� �ڵ����� �ڷ����� ���������� �Ѵ�.


DECLARE
    e_name employees.emp_name%TYPE; -- ���̺�� �ʵ���� ���� �� �ڷ����� ���߰ڴٴ� �ǹ�.
    d_id employees.department_id%TYPE;
BEGIN
    select emp_name, department_id
    INTO e_name, d_id  
    from employees
    where employee_id=100;
    
    DBMS_OUTPUT.PUT_LINE(e_name || ' - ' || d_id);
END;




-- �������� 1
-- DBMS_OUPPUT.PUT_LINE() �� 9�� ����Ͽ� ������ 3���� ����ϴ� �͸� ���� ��������.
-- �̾���̱� ���굵 ����Ѵ�.
-- ����� ������ �ʿ����� �ʱ� ������ DECLARE�� ���� �ʾƵ� �ȴ�.
-- 3x1=3  3x2=6  3x3=9  ...  ���� 3, 6, 9, �� ��꿡 ���� ��µǰ� �����.



BEGIN
    DBMS_OUTPUT.PUT_LINE('3x1= ' || 3*1);
    DBMS_OUTPUT.PUT_LINE('3x2= ' || 3*2);
    DBMS_OUTPUT.PUT_LINE('3x3= ' || 3*3);
    DBMS_OUTPUT.PUT_LINE('3x4= ' || 3*4);
    DBMS_OUTPUT.PUT_LINE('3x5= ' || 3*5);
    DBMS_OUTPUT.PUT_LINE('3x6= ' || 3*6);
    DBMS_OUTPUT.PUT_LINE('3x7= ' || 3*7);
    DBMS_OUTPUT.PUT_LINE('3x8= ' || 3*8);
    DBMS_OUTPUT.PUT_LINE('3x9= ' || 3*9);
END;


-- �������� 2
-- ������̺�(employees) ���� id(employee_id)�� 201���� ����� �̸�(emp_name)�� �̸���(emp_email) �ּҸ� ����ϴ� �͸� ����� ������.
-- �̸� - �̸��� �������� ��ũ��Ʈ ���â�� �������.

DECLARE
    e_name employees.emp_name%TYPE;
    e_email employees.email%TYPE;
BEGIN
    select emp_name, email
    INTO e_name, e_email
    from employees
    where employee_id=201;
    
    DBMS_OUTPUT.PUT_LINE(e_name || ' - ' || e_email);
END;


-- �������� 3
-- select �� �� ���� insert ��ɿ� ����Ѵ�.
-- ������̺�(employees) ���̺��� ���� ū �����ȣ�� ��ȸ�ϰ�,
-- �� �����ȣ���� 1 ��ŭ ū ���ڸ� ���ο� �Է� ���ڵ��� �����ȣ�� �Ͽ� ���ڵ带 �߰�����.
-- ������ �Է»��� :
-- ����� : Harrison Ford
-- �̸��� : HARRISON
-- �Ի����� : ���� ��¥
-- �μ���ȣ : 50
-- ����ο��� ������ ��� commit; �� �־��־�� �Ѵ�.


DECLARE
    max_num employees.employee_id%TYPE;
BEGIN
    select MAX(employee_id)
    INTO max_num
    from employees;

    insert into employees(employee_id, emp_name, email, hire_date, department_id)
    values(max_num+1, 'Harrison Ford', 'HARRISON', sysdate, 50);
    
    commit; -- insert, update, delete ����� ������ �ڿ��� �ݵ�� commit; �� �������!
END;




