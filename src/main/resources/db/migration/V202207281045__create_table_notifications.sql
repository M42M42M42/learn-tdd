create table if not exists notifications (
    id varchar(64) primary key,
    content varchar(512) not null,
    status varchar(32) not null
)