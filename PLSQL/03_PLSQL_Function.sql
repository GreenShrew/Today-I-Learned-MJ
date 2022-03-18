-- �Լ�
-- PL/SQL �ڵ� �ۼ��ÿ��� ���ݱ��� ����ϴ� �͸���� �� ������� �ʴ´�.
-- �Ϲ������� �̸��� �ִ� ���� ���α׷�(�Լ�) �Ǵ� ���ν����� ����ϴ� ���� ��κ��̴�.
-- �͸� ���� �ѹ� ����ϰ� ���� ������������ �ֹ߼� ��������,
-- �Լ� �Ǵ� ���ν����� �������� ���� �����ͺ��̽��� ����Ǿ� ������ ������ �����̴�.


-- �Լ��� ����
-- CREATE OR REPLACE FUNCTION �Լ��̸�(�Ű�����1, �Ű�����2 ... )
-- RETURN ���ϵ� ������Ÿ��;
-- IS[AS]
--      ����, ��� ����
-- BEGIN
--      �����

--      RETURN ���ϰ�;
-- [ EXCEPTION
--      ����ó���� ]
-- END [�Լ��̸�];  <- �Լ��̸� ���� ����!

-- �󼼳���
-- CREATE OR REPLACE FUNCTION : CREATE OR REPLACE FUNCTION ��� ������ �̿��Ͽ� �Լ��� �����Ѵ�.
--      �Լ��� ����� �����ϴ��� �� ������ ��� ������ �� �� �ְ�, ���������� ������ �� ������
--      �Լ��� ����� �̸����� ���ȴ�.
-- �Ű����� : �����μ��� �����ϴ� ������, "�����̸� �����ڷ���" ���·� �ۼ��Ѵ�.
-- ù��° RETURN ���� �������� ���ϵ� �ڷ��� �ڷ����� ����, �Ʒ��� �ι�° RETURN ���� ������
--      �� �ڷ������� ���� ���ϵ� �� �Ǵ� ���� �̸��� ���ش�.


-- �ΰ��� ������ �����ؼ� ù���� ���� �ι�° ������ ���� �������� ���ؼ� �������ִ� �Լ�
-- �Ʒ� myMod �� �����ϸ� 'Function MYMOD��(��) �����ϵǾ����ϴ�.' ��� ������ ���´�.
-- �׸��� SQL ������ �����ϵ� �ش� �Լ��� ����� �� �ְ� �ȴ�!

CREATE OR REPLACE FUNCTION myMod( num1 NUMBER, num2 NUMBER )
    RETURN NUMBER
IS
    vn_remainder NUMBER := 0;   -- �������� ������ ����
    vn_mok NUMBER := 0;    -- ���� ������ ����
BEGIN
    vn_mok := FLOOR( num1/num2 );   -- ���� �򿡼� ������ ����(�Ҽ��� ����)
    vn_remainder := num1 - (num2*vn_mok);   -- ��*������ ������ ���� ������ ���
    RETURN vn_remainder;    -- ������ ��ȯ
END;

select myMod(14, 3) from dual;

select * from countries;
-- �Լ� ���� SQL ���� ����� ���� �ִ�!
-- countries ���̺��� id�� �޾Ƽ� ���� �̸��� ����ϴ� �Լ��� ����
CREATE OR REPLACE FUNCTION fn_getCountryName( p_country_id NUMBER )
    RETURN VARCHAR2
IS
    vs_country_name COUNTRIES.COUNTRY_NAME%TYPE;    -- ���� �̸��� ������ ����
BEGIN
    select country_name
    into vs_country_name
    from countries
    where country_id = p_country_id;
    
    RETURN vs_country_name;
END;

select fn_getCountryName(52777), fn_getCountryName(10000) from dual;
-- �� select ��� ����� 10000�� id�� null�� ��µȴ�.
-- �̸� "�ش籹�� ����" �̶�� ��µǵ��� fn_getCountryName �Լ��� ��������.

CREATE OR REPLACE FUNCTION fn_getCountryName( p_country_id NUMBER )
    RETURN VARCHAR2
IS
    vs_count NUMBER(10);
    vs_country_name COUNTRIES.COUNTRY_NAME%TYPE;    -- ���� �̸��� ������ ����
BEGIN
    -- ���޹��� ���̵� �ش��ϴ� ������ ������ ��ȸ�ϰ�,
    -- ������ 0�̸� "�ش籹�� ����", 0�� �ƴϸ� �ش籹���� �̸��� �ٽ� ��ȸ�ؼ� ����
    
    select count(*)
    into vs_count
    from countries
    where country_id = p_country_id;
    
    IF vs_count >=1 THEN
        select country_name
        into vs_country_name
        from countries
        where country_id = p_country_id;
        
        RETURN vs_country_name;
    ELSE
        RETURN '�ش籹�� ����';
END;





















































































































































































