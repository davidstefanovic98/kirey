#Tried implementing Flyway migration but it doesn't work with MariaDB 10.7...

create table if not exists `student`
(
    student_id         int auto_increment
        primary key,
    first_name         varchar(64)                              not null,
    last_name          varchar(128)                             not null,
    date_of_birth      date                                     not null,
    date_of_admission  date                                     not null,

    #audit attributes
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1
);


create table if not exists `faculty`
(
    faculty_id         int auto_increment
        primary key,
    name               varchar(128)                             not null,
    city               varchar(64)                              not null,

    #audit attributes
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1

);

create table if not exists `faculty_student`
(

    faculty_student_id int auto_increment primary key,
    faculty_fk         int                                      not null,
    student_fk         int                                      not null,

    #audit attributes
    created_date       timestamp    default current_timestamp() not null,
    last_modified_date timestamp    default current_timestamp() not null,
    last_modified_by   varchar(255) default 'system'            null,
    record_status      int          default 1,

    constraint fk_faculty_student_faculty
        foreign key (faculty_fk) references faculty (faculty_id),
    constraint fk_faculty_student_student
        foreign key (student_fk) references student (student_id)
);