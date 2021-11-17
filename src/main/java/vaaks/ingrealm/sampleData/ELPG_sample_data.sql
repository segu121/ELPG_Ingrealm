
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS ingredients CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS user_add_ing CASCADE;
DROP TABLE IF EXISTS user_search_one_ing CASCADE;
DROP TABLE IF EXISTS tags CASCADE;
DROP TABLE IF EXISTS colors CASCADE;
DROP TABLE IF EXISTS tags_colors CASCADE;
DROP TABLE IF EXISTS ing_colors CASCADE;

create table users
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

alter table users
    owner to "ELPgrande";

create unique index users_id_uindex
    on users (id);

create table ingredients
(
    id          bigserial,
    name        char[]  not null,
    rating      integer not null,
    description text,
    constraint ingredients_pk
        primary key (id)
);

alter table ingredients
    owner to "ELPgrande";

create unique index ingredients_id_uindex
    on ingredients (id);

create table products
(
    id          bigserial,
    name        char[]  not null,
    producer    char[]  not null,
    prod_rating integer not null,
    prod_ing    text    not null,
    user_id     bigint  not null,
    prod_img    char    not null,
    constraint products_pk
        primary key (id)
);

alter table products
    owner to "ELPgrande";

create unique index products_id_uindex
    on products (id);

create table user_add_ing
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

alter table user_add_ing
    owner to "ELPgrande";

create unique index user_add_ing_id_uindex
    on user_add_ing (id);

create table user_search_one_ing
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

alter table user_search_one_ing
    owner to "ELPgrande";

create unique index user_search_one_ing_id_uindex
    on user_search_one_ing (id);

create table tags
(
    id   bigserial,
    name char[] not null,
    constraint tags_pk
        primary key (id)
);

alter table tags
    owner to "ELPgrande";

create unique index tags_id_uindex
    on tags (id);

create table colors
(
    id   bigserial,
    name char[] not null,
    constraint colors_pk
        primary key (id)
);

alter table colors
    owner to "ELPgrande";

create unique index colors_id_uindex
    on colors (id);

create table tags_colors
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

alter table tags_colors
    owner to "ELPgrande";

create unique index tags_colors_id_uindex
    on tags_colors (id);

create table ing_colors
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

alter table ing_colors
    owner to "ELPgrande";

create unique index ing_colors_id_uindex
    on ing_colors (id);

