create sequence country_id_seq start with 1 increment by 1;

CREATE TABLE country_table (
    id bigint default nextval('country_id_seq') not null,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(10) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    primary key (id)
);