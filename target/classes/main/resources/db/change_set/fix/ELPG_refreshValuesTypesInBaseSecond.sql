--liquibase formatted sql
--changeset segu121:3

create table if not exists users
(
    id            bigserial,
    name          char(150) not null,
    email         char(150) not null,
    h_pass        char(250) not null,
    surname       char(150),
    nick          char(150),
    geolocation   point,
    register_data date   not null,
    constraint users_pk
        primary key (id)
);


create unique index if not exists users_id_uindex
    on users (id);

create table if not exists tags
(
    id   bigserial,
    name char(150) not null,
    constraint tags_pk
        primary key (id)
);

create unique index if not exists tags_id_uindex
    on tags (id);


create table if not exists category
(
    id   serial,
    name char(250) not null,
    constraint category_pk
        primary key (id)
);



create table if not exists ingredients
(
    id             bigserial,
    name           char(150)  not null,
    natural_rating integer not null,
    description    text,
    INCI_name    char(150)  not null,
    rating         integer not null,
    constraint ingredients_pk
        primary key (id)
);



create unique index if not exists ingredients_id_uindex
    on ingredients (id);

create table if not exists products
(
    id          bigserial,
    name        char(150)  not null,
    producer    char(150)  not null,
    prod_rating integer not null,
    prod_ing    text    not null,
    user_id     bigint  not null,
    prod_img    char    not null,
    constraint products_pk
        primary key (id)
);



create unique index if not exists products_id_uindex
    on products (id);

create table if not exists user_add_ing
(
    id               bigserial,
    poss_prod_ing    text    not null,
    user_id          bigint  not null,
    poss_prod_rating integer not null,
    constraint user_add_ing_pk
        primary key (id),
    constraint user_add_ing_users_id_fk
        foreign key (user_id) references users
            deferrable
);


create unique index if not exists user_add_ing_id_uindex
    on user_add_ing (id);

create table if not exists user_search_one_ing
(
    id             bigserial,
    ingredients_id bigint  not null,
    user_id        integer not null,
    constraint user_search_one_ing_pk
        primary key (id),
    constraint user_search_one_ing_ingredients_id_fk
        foreign key (ingredients_id) references ingredients,
    constraint user_search_one_ing_users_id_fk
        foreign key (user_id) references users
);



create unique index if not exists user_search_one_ing_id_uindex
    on user_search_one_ing (id);


create unique index if not exists category_id_uindex
    on category (id);


