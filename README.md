# 📦Product MVC Project

## 📖프로젝트 소개
제품재고, 주문, 고객 정보를 입력하고
수정, 삭제, 목록 출력 및 특정 조건으로 정렬이 가능한
온라인 쇼핑 시스템을 구현한 미니 프로젝트입니다.

## 📆개발 기간
* 24.11.20(수) ~ 24.11.24(일)

### ⚙개발 환경
* `JavaSE 21`
* `JDK 21.0.4`
* `ECLIPSE IDE : 4.33.0`
* `DataBase : Oracle DB(21cXE)`

## 📌주요 기능
**재고**
* 재고 정보 입력, 수정, 삭제, 출력, 정렬(CRUD)
<details>
<summary><b>INSERT</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/product_insert.png width = "400px" height = "200px">
</details>
<details>
<summary><b>SELECT</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/product_select.png width = "400px" height = "200px">
</details>
<details>
<summary><b>UPDATE</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/product_update.png width = "400px" height = "200px">
</details>
<details>
<summary><b>DELETE</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/product_delete1.png width = "400px" height = "200px">
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/product_delete2.png width = "400px" height = "200px">
</details>
<details>
<summary><b>SORT</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/product_sort.png width = "400px" height = "200px">
</details>

___

**주문**
* 주문 정보 입력, 수정, 삭제, 출력, 정렬(CRUD)
* 주문 입력시 자동으로 재고 감소 기능
<details>
<summary><b>INSERT</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/order_insert1.png width = "400px" height = "200px">
    <br>
    
**주문 입력시 재고 감소**
    <br>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/order_insert2.png width = "400px" height = "200px">
</details>
<details>
<summary><b>SELECT</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/order_select.png width = "400px" height = "200px">
</details>
<details>
<summary><b>UPDATE</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/order_update.png width = "400px" height = "200px">
</details>
<details>
<summary><b>DELETE</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/order_delete.png width = "400px" height = "200px">
</details>
<details>
<summary><b>SORT</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/order_sort.png width = "400px" height = "200px">
</details>

___

**고객**
* 고객 정보 입력, 수정, 삭제, 출력, 정렬(CRUD)
* 중복ID 체크 기능
<details>
<summary><b>INSERT</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/customer_insert.png width = "400px" height = "200px">
</details>
<details>
<summary><b>SELECT</b></summary> 
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/order_select.png width = "400px" height = "200px">
</details>
<details>
<summary><b>UPDATE</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/order_update.png width = "400px" height = "200px">
</details>
<details>
<summary><b>DELETE</b></summary> 
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/order_delete.png width = "400px" height = "200px">
</details>
<details>
<summary><b>SORT</b></summary>
    <img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/order_sort.png width = "400px" height = "200px">
</details>

___

## ✏쿼리문
```
-- 재고 테이블
CREATE TABLE PRODUCTS(
    no number,                   -- 제품번호(PK, SEQ)
    code varchar2(2),            -- 제품코드(UK)
    name varchar2(20) not null,  -- 제품명
    type varchar2(20) not null,  -- 제품종류
    price number not null,       -- 가격
    stock number not null        -- 재고량
);
ALTER table products add constraint products_no_pk primary key(no);
ALTER table products add constraint products_code_uk UNIQUE(code);
drop table products;
create sequence products_seq
start with 1
increment by 1;

-- 주문 테이블
CREATE TABLE ORDERS(
    no number,                    -- 주문번호(PK, SEQ)
    id varchar2(12),              -- 주문ID(UK)
    c_name varchar2(12) not null, -- 주문자이름
    p_code varchar2(2),           -- 제품코드(FK(products))
    quantity number,              -- 주문수량
    odate date default sysdate    -- 주문날짜
);
ALTER table orders add constraint orders_no_pk primary key(no);
ALTER table orders add constraint orders_id_uk UNIQUE(id);
ALTER table orders add constraint orders_p_code_fk 
    FOREIGN KEY(p_code) References products(code) on delete set null;

create sequence orders_seq
start with 1
increment by 1;

-- 고객 테이블
CREATE TABLE CUSTOMERS(
    no number,                      -- 고객번호(PK, SEQ)
    name varchar2(12) not null,     -- 이름
    id varchar2(12),                -- 아이디(UK)
    passwd varchar2(12) not null,   -- 패스워드
    birthday varchar2(8) not null,  -- 생년월일
    phone varchar2(15) not null,    -- 전화번호
    o_id varchar2(12)               -- 주문번호(FK(orders))
);
ALTER table customers add constraint customers_no_pk primary key(no);
ALTER table customers add constraint customers_id_uk UNIQUE(id);
ALTER table customers add constraint customers_o_id_fk 
    FOREIGN KEY(o_id) References orders(id) on delete set null;

create sequence customers_seq
start with 1
increment by 1;

-- 재고삭제트리거(주문이 진행되면 재고테이블에서 주문된 수량만큼 빼주는 트리거)
CREATE OR REPLACE TRIGGER ORDERS_INSERT_TRIGGER
    AFTER INSERT ON ORDERS
    FOR EACH ROW
DECLARE
    current_stock NUMBER;
BEGIN
    -- 현재 재고 확인
    SELECT STOCK 
    INTO current_stock
    FROM PRODUCTS
    WHERE CODE = :NEW.p_code
    FOR UPDATE; -- 동시성 제어를 위해 행 잠금

    -- 재고 부족 여부 확인
    IF current_stock < :NEW.quantity THEN
        RAISE_APPLICATION_ERROR(-20001, '재고가 부족합니다.');
    END IF;

    -- 재고 업데이트: 주문된 수량만큼 감소
    UPDATE PRODUCTS 
    SET STOCK = STOCK - :NEW.quantity 
    WHERE CODE = :NEW.p_code;
END;
/

commit;

```

## 📖테이블 정보
<img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/product_table.png>

## 📖ERD 다이어그램
<img src=https://github.com/kwonminsung0/ProductProject/blob/main/image/product_erd.png>
