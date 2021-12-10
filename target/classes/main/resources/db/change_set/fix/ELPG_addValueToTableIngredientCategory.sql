--liquibase formatted sql
--changeset segu121:7

INSERT INTO ingredient_category (id, ingredient_id, category_id) VALUES (5, 1, 3);
INSERT INTO ingredient_category (id, ingredient_id, category_id) VALUES (6, 2, 3);
INSERT INTO ingredient_category (id, ingredient_id, category_id) VALUES (7, 2, 4);