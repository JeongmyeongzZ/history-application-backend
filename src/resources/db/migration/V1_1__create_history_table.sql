create table history (
    id varchar(36) not null,
    content text not null,
    date date not null,
    primary key (id)
) engine=InnoDB collate=utf8mb4_general_ci;

create unique index `history__index-date`
	on history (date);

