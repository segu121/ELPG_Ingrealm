--liquibase formatted sql
--changeset segu121:10



-- SET IDENTITY INSERT ingredients off;
-- SET IDENTITY INSERT category off;
-- SET IDENTITY INSERT ingredient_category off;
INSERT INTO ingredients (name, natural_rating, description, INCI_name,  rating) VALUES ('woda', 1, 'Woda w kosmetyku pełni funkcję rozpuszczalnika, wpływa na konsystencję produktu i jest nośnikiem aktywnych substancji w niej rozpuszczalnych. Jeżeli do produkcji kosmetyków stosujemy wodę termalną lub hydrolaty kwiatowe to woda pełni wtedy także funkcję składnika aktywnego.', 'AQUA', 1);
INSERT INTO ingredients (name, natural_rating, description, INCI_name,  rating) VALUES ('Glikol Propylenowy', 2, 'Hydrofilowa substancja nawilżająca skórę. Ma zdolność przenikania przez warstwę rogową naskórka, dzięki czemu pełni rolę promotora przenikania, ułatwia w ten sposób transport składników aktywnych kosmetyku w głąb naskórka. Tworzy na powierzchni skóry hydrofilowy film ograniczający TEWL (transepidermalną utratę wody). Jest substancją bezpieczną nawet w stężeniu 50% w gotowym preparacie do włosów. Nie poleca się stosowania kremów zawierających w swym składzie glikol propylenowy osobom ze skórą wrażliwą, skłonną do alergii, jak również dzieciom. Mimo zdolności wiązania wody, istnieje teoria, że może przyczyniać się, również do jej ucieczki przez naskórek, ze względu na zmianę struktury cementu międzykomórkowego warstwy rogowej. Z tego powodu glikol propylenowy znalazł się na liście substancji zakazanych w kosmetykach naturalnych.', 'PROPYLENE GLYCOL', 2);



INSERT INTO category (name) VALUES ('Rozpuszczalnik');
INSERT INTO category (name) VALUES ('Humektant');

create table if not exists products_categories
(
    id            bigserial,
    name          char(150) not null,
    constraint product_category_pk
    primary key (id)
    );


create unique index if not exists products_categories_id_uindex
    on products_categories (id);

create table if not exists product_prod_category
(
    id             BIGSERIAL PRIMARY KEY,
    product_id BIGINT not null,
    prod_category_id BIGINT not null
);

CREATE UNIQUE INDEX IF NOT EXISTS product_prod_category_uindex
    ON product_prod_category(id);

ALTER TABLE ONLY product_prod_category
    ADD CONSTRAINT fk_product_prod_category_product_id FOREIGN KEY (product_id) REFERENCES products(id);

ALTER TABLE ONLY product_prod_category
    ADD CONSTRAINT fk_product_prod_category_prod_category_id FOREIGN KEY (prod_category_id) REFERENCES products_categories(id);

ALTER TABLE users DROP COLUMN geolocation;
ALTER TABLE users DROP COLUMN name;
ALTER TABLE users DROP COLUMN surname;

ALTER TABLE users ADD COLUMN token char(150) not null;