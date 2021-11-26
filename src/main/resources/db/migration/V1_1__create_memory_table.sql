create table memory (
     id varchar(36) not null,
     image_url varchar(255) not null,
     description text not null,
     date date not null,
     PRIMARY KEY (id)
) engine=InnoDB collate=utf8mb4_general_ci;

create index memory_date_index on memory (date);

create unique index memory_id_uindex on memory (id);
