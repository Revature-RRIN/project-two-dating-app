drop table user_answer cascade constraints;
drop table answers cascade constraints;
drop table questions cascade constraints;
drop table messages cascade constraints;
drop table status cascade constraints; 
drop table matches cascade constraints;
--drop table matchseeker cascade constraints;
--drop table admini cascade constraints;
drop table users cascade constraints;

create table users (
    users_id number (3) primary key,
    usertype number (2),
    username varchar2 (20),
    pass varchar2 (20),
    firstname varchar2 (20),
    lastname varchar2 (20),
--    profilepic blob,
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
    user1_id number (3),
    user2_id number (3),
    status_id number (3),
    constraint fk_user1_id foreign key (user1_id) references users (users_id),
    constraint fk_user2_id foreign key (user2_id) references users (users_id)
);

create table status (
    status_id number (3) primary key,
    status_state varchar2 (20),
    constraint fk_status foreign key (status_id) references matches (matches_id)
);

create table messages (
    messages_id number (4) primary key,
    sender_id number (3),
    receiver_id number (3),
    remark varchar2 (300),
--    constraint fk_id foreign key (messages_id) references matches (matches_id),
    constraint fk_sender_id foreign key (sender_id) references users (users_id),
    constraint fk_receiver_id foreign key (receiver_id) references users (users_id) 
    --or should it be user-id to include admins??
);
--ALTER TABLE messages DROP CONSTRAINT FK_id;

create table questions (
    question_id number (2) primary key,
    question varchar2 (300)
);


--create table answers (
--    answers_id number (3) primary key,
--    answer_1 number (3),
--    answer_2 number (3),
--    answer_3 number (3),
--    answer_4 number (3),
--    cumulative number (3),
--    constraint fk_answer_id foreign key (id) references matchseeker (id)
--);

create table answers (
    answers_id number (3) primary key,
    which_question_id number (2),
    response number (2),
    constraint fk_which_question_id foreign key (which_question_id) references questions (question_id)
);

--might have to add primary key
create table user_answer (
    user_answer_id number (3) primary key,
    q_id number (2),
    u_id number (3),
    a_id number (2),
    constraint fk_q_id foreign key (q_id) references questions (question_id),
    constraint fk_u_id foreign key (u_id) references users (users_id),
    constraint fk_a_id foreign key (a_id) references answers (answers_id)
);


create sequence users_seq start with 1 increment by 1 minvalue 1 cache 2;
create sequence matches_seq start with 1 increment by 1 minvalue 1 cache 2;
create sequence status_seq start with 1 increment by 1 minvalue 1 cache 2;
create sequence messages_seq start with 1 increment by 1 minvalue 1 cache 2;
create sequence questions_seq start with 1 increment by 1 minvalue 1 cache 2;
create sequence answers_seq start with 1 increment by 1 minvalue 1 cache 2;
create sequence user_answer_seq start with 1 increment by 1 minvalue 1 cache 2;

insert into users (users_id, usertype, username, pass, firstname, lastname, score, age, gender, location, banned) values (1, 1, 'user', 'pass', 'R', 'X', 1, 1, 1, 'z', 'y');

commit;

