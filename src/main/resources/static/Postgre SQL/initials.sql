
    alter table doctor_degrees
       drop constraint FKsqbj0s6n7sxktag3h5jvpoiwm


    alter table doctor_degrees
       drop constraint FK9k2p1b0d9c115mnir48v1syox


    drop table if exists appointment cascade


    drop table if exists degree cascade


    drop table if exists doctor cascade


    drop table if exists doctor_degrees cascade


    drop table if exists patient cascade;


    create table appointment (
       appointment_id  serial not null,
        appointment_accepted boolean,
        appointment_lab_location varchar(255),
        appointment_time timestamp,
        doctor_id int4,
        patient_id int4,
        primary key (appointment_id)
    );


    create table degree (
       degree_id  serial not null,
        name varchar(255),
        primary key (degree_id)
    )


    create table doctor (
       doctorid  serial not null,
        doctor_clinic_name varchar(255),
        doctor_consultency_count int4,
        doctor_email varchar(255),
        doctor_experience int4,
        doctor_gender varchar(255),
        doctor_image oid,
        doctor_info varchar(255),
        doctor_location varchar(255),
        doctor_name varchar(255),
        doctor_password varchar(255),
        doctor_rating float4,
        doctor_speciality varchar(255),
        doctor_sub_district varchar(255),
        doctor_visiting_fee int4,
        token varchar(255),
        primary key (doctorid)
    )


    create table doctor_degrees (
       degree_id int4 not null,
        doctor_id int4 not null,
        primary key (degree_id, doctor_id)
    );


    create table patient (
       patient_id  serial not null,
        bill float8,
        patient_email varchar(255),
        patient_name varchar(255),
        patient_password varchar(255),
        phone_number varchar(255),
        token varchar(255),
        primary key (patient_id)
    )


    alter table doctor_degrees
       add constraint FKsqbj0s6n7sxktag3h5jvpoiwm
       foreign key (doctor_id)
       references doctor


    alter table doctor_degrees
       add constraint FK9k2p1b0d9c115mnir48v1syox
       foreign key (degree_id)
       references DEGREE
       
       
       
update auth a set auth_token = 'lol' where a.auth_id = '4'