--liquibase formatted sql
--changeset segu121:2

create table if not exists users
(
    id            bigserial,
    name          char[] not null,
    email         char[] not null,
    h_pass        char[] not null,
    surname       char[],
    nick          char[],
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
    name char[] not null,
    constraint tags_pk
        primary key (id)
);


create unique index if not exists tags_id_uindex
    on tags (id);

create table if not exists colors
(
    id   bigserial,
    name char[] not null,
    constraint colors_pk
        primary key (id)
);



create unique index if not exists colors_id_uindex
    on colors (id);

create table if not exists tags_colors
(
    id       bigserial,
    tag_id   bigint not null,
    color_id bigint not null,
    constraint tags_colors_pk
        primary key (id),
    constraint tags_colors_tags_id_fk
        foreign key (tag_id) references tags,
    constraint tags_colors_colors_id_fk
        foreign key (color_id) references colors
);



create unique index if not exists tags_colors_id_uindex
    on tags_colors (id);

create table if not exists category
(
    id   serial,
    name char not null,
    constraint category_pk
        primary key (id)
);



create table if not exists ingredients
(
    id             bigserial,
    name           char[]  not null,
    natural_rating integer not null,
    description    text,
    INCI_name    char[]  not null,
    category_id    bigint  not null,
    rating         integer not null,
    constraint ingredients_pk
        primary key (id),
    constraint ingredients_category_fk
        foreign key (category_id) references category
);



create unique index if not exists ingredients_id_uindex
    on ingredients (id);

create table if not exists products
(
    id          bigserial,
    name        char[]  not null,
    producer    char[]  not null,
    prod_rating integer not null,
    prod_ing    text    not null,
    user_id     bigint  not null,
    prod_img    char    not null,
    category_id bigint  not null,
    constraint products_pk
        primary key (id),
    constraint products_category_fk
        foreign key (category_id) references category
);



create unique index if not exists products_id_uindex
    on products (id);

create table if not exists user_add_ing
(
    id               bigserial,
    poss_prod_ing    text    not null,
    user_id          bigint  not null,
    poss_prod_rating integer not null,
    category_id      bigint  not null,
    constraint user_add_ing_pk
        primary key (id),
    constraint user_add_ing_users_id_fk
        foreign key (user_id) references users
            deferrable,
    constraint user_add_ing_category_fk
        foreign key (category_id) references category
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

create table if not exists ing_colors
(
    id       bigserial,
    ing_id   bigint not null,
    color_id bigint not null,
    constraint ing_colors_pk
        primary key (id),
    constraint ing_colors_ingredients_id_fk
        foreign key (ing_id) references ingredients,
    constraint ing_colors_colors_id_fk
        foreign key (color_id) references colors
);


create unique index if not exists ing_colors_id_uindex
    on ing_colors (id);

create unique index if not exists category_id_uindex
    on category (id);


