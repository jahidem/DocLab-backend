insert into doctor(Doctor_name) values('Remon Khan');
select * from doctor;
SELECT *
FROM INFORMATION_SCHEMA.COLUMNS
WHERE table_name = 'doctor'
AND COLUMN_NAME = 'doctor_rating'