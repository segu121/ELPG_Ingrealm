--liquibase formatted sql
--changeset segu121:5


create table if not exists ingredient_category
(
    id             BIGSERIAL PRIMARY KEY,
    ingredient_id BIGINT not null,
    category_id BIGINT not null
    );

CREATE UNIQUE INDEX IF NOT EXISTS ingredient_category_uindex
ON ingredient_category(id);

ALTER TABLE ONLY ingredient_category
    ADD CONSTRAINT fk_ingredient_category_ingredient_id FOREIGN KEY (ingredient_id) REFERENCES ingredients(id);

ALTER TABLE ONLY ingredient_category
    ADD CONSTRAINT fk_ingredient_category_category_id FOREIGN KEY (category_id) REFERENCES category(id);

