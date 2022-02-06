--liquibase formatted sql
--changeset segu121:11


ALTER TABLE users DROP COLUMN token;

create table if not exists confirmation_token
(
    id            bigserial not null,
    user_id       bigserial  not null,
    token          char(150) not null,
    createAt       timestamp with time zone,
    expiredAt      timestamp with time zone,
    confirmed      timestamp with time zone,

    constraint confirmation_token_pk
    primary key (id)
);

CREATE UNIQUE INDEX IF NOT EXISTS confirmation_token_uindex
    ON confirmation_token(id);

ALTER TABLE ONLY confirmation_token
    ADD CONSTRAINT fk_confirmation_token_user_id FOREIGN KEY (user_id) REFERENCES users(id);
