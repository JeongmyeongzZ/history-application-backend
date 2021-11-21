create table history (
     id varchar(36) not null,
     title varchar(60) not null,
     content text not null,
     improvements text null,
     start_date date not null,
     end_date date null,
     created_date date not null,
     updated_date date not null,
     PRIMARY KEY (id)
) engine=InnoDB collate=utf8mb4_general_ci;

create index history_date_index on history (start_date, end_date);

create unique index history_id_uindex on history (id);
