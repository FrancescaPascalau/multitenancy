CREATE TABLE employee
(
    id        BIGINT NOT NULL,
    tenant_id VARCHAR(255) NULL,
    full_name VARCHAR(255) NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

CREATE TABLE tenant
(
    id   VARCHAR(255) NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_tenant PRIMARY KEY (id)
);

CREATE TABLE payment
(
    id        BIGINT NOT NULL,
    tenant_id VARCHAR(255) NULL,
    amount    BIGINT NULL,
    CONSTRAINT pk_payment PRIMARY KEY (id)
);

CREATE TABLE receipt
(
    id          BIGINT NOT NULL,
    employee_id BIGINT NULL,
    tenant_id   VARCHAR(255) NULL,
    amount      BIGINT NULL,
    issued_at   datetime NULL,
    CONSTRAINT pk_receipt PRIMARY KEY (id)
);

INSERT INTO employee (id, tenant_id, full_name)
VALUES (101, 'tenant_1', 'Patrick Hill');
INSERT INTO employee (id, tenant_id, full_name)
VALUES (102, 'tenant_3', 'Sue Muss');
INSERT INTO employee (id, tenant_id, full_name)
VALUES (103, 'tenant_2', 'Robert Crave');
INSERT INTO employee (id, tenant_id, full_name)
VALUES (104, 'tenant_1', 'Fleur Gold');

INSERT INTO tenant (id, name)
VALUES ('tenant_1', 'Tesla');
INSERT INTO tenant (id, name)
VALUES ('tenant_2', 'SpaceX');
INSERT INTO tenant (id, name)
VALUES ('tenant_3', 'Google');

INSERT INTO payment (id, tenant_id, amount)
VALUES (800, 'tenant_1', 50);

INSERT INTO receipt (id, employee_id, tenant_id, amount, issued_at)
VALUES (700, 101, 'tenant_1', 50, NOW());