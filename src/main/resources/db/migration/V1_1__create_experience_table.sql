create table experience (
     id varchar(36) not null,
     company varchar(60) not null,
     position varchar(60) not null,
     start_date date not null,
     end_date date null,
     PRIMARY KEY (id)
) engine=InnoDB collate=utf8mb4_general_ci;

create index experience_date_index on experience (start_date, end_date);

create unique index experience_id_uindex on experience (id);
