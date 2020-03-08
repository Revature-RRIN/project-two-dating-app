drop table answers cascade constraints;
drop table messages cascade constraints;
drop table status cascade constraints; 
drop table matches cascade constraints;
drop table matchseeker cascade constraints;
drop table admini cascade constraints;
drop table users cascade constraints;



create table users (
    users_id number (3) primary key,
    usertype number (2),
    username varchar2 (20),
    pass varchar2 (20),
    firstname varchar2 (20),
    lastname varchar2 (20),
    profilepic blob,
    score number (3),
    age number (3),
    gender number (1),
    location varchar2 (30),
    banned varchar2 (8)
);

--create table admini (
--    id number (2) primary key,
--    constraint fk_admini_id foreign key (id) references users (id)
--);

--create table matchseeker (
--    id number (3) primary key,
--    profilepic blob,
--    score number (3),
--    age number (3),
--    gender number (1),
--    location varchar2 (30),
--    banned varchar2 (8),
--    constraint fk_ms_id foreign key (id) references users (id)
--);

create table matches (
    matches_id number (3) primary key,
    male_id number (3),
    female_id number (3),
    status_id number (3),
    constraint fk_male_id foreign key (male_id) references matchseeker (id),
    constraint fk_female_id foreign key (female_id) references matchseeker (id)
);

create table status (
    status_id number (3) primary key,
    status_state varchar2 (20),
    constraint fk_status foreign key (id) references matches (id)
);

create table messages (
    massages_id number (4) primary key,
    sender_id number (3),
    receiver_id number (3),
    remark varchar2 (300),
    constraint fk_id foreign key (id) references matches (id),
    constraint fk_sender_id foreign key (sender_id) references matchseeker (id),
    constraint fk_receiver_id foreign key (receiver_id) references matchseeker (id) 
    --or should it be user-id to include admins??
);

create table answers (
    answers_id number (3) primary key,
    answer_1 number (3),
    answer_2 number (3),
    answer_3 number (3),
    answer_4 number (3),
    cumulative number (3),
    constraint fk_answer_id foreign key (id) references matchseeker (id)
);

create sequence users_seq start with 1 increment by 1 minvalue 1 cache 2;
create sequence matches_seq start with 1 increment by 1 minvalue 1 cache 2;
create sequence status_seq start with 1 increment by 1 minvalue 1 cache 2;
create sequence messages_seq start with 1 increment by 1 minvalue 1 cache 2;
create sequence answers_seq start with 1 increment by 1 minvalue 1 cache 2;

commit;
