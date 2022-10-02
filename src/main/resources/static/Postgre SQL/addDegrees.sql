insert
    into
        degree(name)
    values('MBBS');

insert
    into
        degree(name)
    values('BDS');

insert
    into
        degree(name)
    values('BAMS');

insert
    into
        degree(name)
    values('BAMS');

insert
    into
        degree(name)
    values('BHMS');

insert
    into
        degree(name)
    values('BYNS');

insert
    into
        degree(name)
    values('B.V.Sc & AH');

insert
    into
        degree(name)
    values('MS');


select * from doctor dd where dd.doctor_gender in (select d.doctor_gender  from doctor d where d.doctorid in (select d_d.doctor_id  from doctor_degrees d_d))  ;
delete  from "degree" where "name" = 'MBBS';

select * from auth a ;