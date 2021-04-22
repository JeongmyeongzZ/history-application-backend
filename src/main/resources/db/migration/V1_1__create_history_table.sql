create table history
(
    id varchar(36) not null,
    content text not null,
    date date not null
) engine=InnoDB collate=utf8mb4_general_ci;

create unique index history_date_uindex
    on history (date);

create unique index history_id_uindex
    on history (id);

alter table history
    add constraint history_pk
        primary key (id);

