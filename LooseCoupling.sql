

create table users (
    id number (3) primary key,
    username varchar2 (20),
    pass varchar2 (20),
    firstname varchar2 (20),
    lastname varchar2 (20)
);

create table admini (
    id number (2) primary key
);

create table matchseeker (
    id number (3) primary key,
    profilepic blob,
    score number (3),
    age number (3),
    gender number (1),
    location varchar2 (30)
);

create table matches (
    id number (3) primary key,
    male_id number (3),
    female_id number (3),
    status_id number (3)
);

create table status (
    id number (3) primary key,
    status_state varchar2 (20)
);

create table messages (
    id number (4) primary key,
    sender_id number (3),
    receiver_id number (3),
    remark varchar2 (300)
);

create table answers (
    id number (3) primary key,
    answer_1 number (3),
    answer_2 number (3),
    answer_3 number (3),
    answer_4 number (3),
    cumulative number (3)
);



