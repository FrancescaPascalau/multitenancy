CREATE TABLE employee
(
    id        BIGINT NOT NULL,
    tenant_id BIGINT NULL,
    full_name VARCHAR(255) NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

CREATE TABLE tenant
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_tenant PRIMARY KEY (id)
);

CREATE TABLE payment
(
    id        BIGINT NOT NULL,
    tenant_id BIGINT NULL,
    amount    BIGINT NULL,
    CONSTRAINT pk_payment PRIMARY KEY (id)
);

CREATE TABLE receipt
(
    id          BIGINT NOT NULL,
    employee_id BIGINT NULL,
    tenant_id   BIGINT NULL,
    amount      BIGINT NULL,
    issued_at   datetime NULL,
    CONSTRAINT pk_receipt PRIMARY KEY (id)
);

INSERT INTO employee (id, tenant_id, full_name)
VALUES (101, 1, 'Patrick Hill');
INSERT INTO employee (id, tenant_id, full_name)
VALUES (102, 3, 'Sue Muss');
INSERT INTO employee (id, tenant_id, full_name)
VALUES (103, 2, 'Robert Crave');

INSERT INTO tenant (id, name)
VALUES (1, 'Google');
INSERT INTO tenant (id, name)
VALUES (2, 'SpaceX');
INSERT INTO tenant (id, name)
VALUES (3, 'Tesla');

INSERT INTO payment (id, tenant_id, amount)
VALUES (800, 1, 50);

INSERT INTO receipt (id, employee_id, tenant_id, amount, issued_at)
VALUES (700, 101, 1, 50, NOW());