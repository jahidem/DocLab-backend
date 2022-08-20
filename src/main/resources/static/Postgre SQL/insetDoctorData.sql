insert into doctor(doctor_name,
                   doctor_clinic_name,
                   doctor_sub_district,
                   doctor_email,
                   doctor_experience,
                   doctor_gender,
                   doctor_location,
                   doctor_password,
                   doctor_speciality,
                   doctor_visiting_fee,
                   doctor_rating,
                   doctor_info
                    )

            values('Remon Khan',
                    'LabAid Hospital',
                    'Dhaka',
                    'remonkhan@gmail.com',
                    7,
                    'Male',
                    '23/1 Dhanmondi, Mohammadpur, Dhaka',
                    '123456',
                    'Dentist',
                    1500,
                    4.3,
                    'specify a comma-separated list of table columns. Each column consists of the column name, the kind of data that column stores, the length of data, and the column constraint.'
                    );


insert into doctor(doctor_name,
                   doctor_clinic_name,
                   doctor_sub_district,
                   doctor_email,
                   doctor_experience,
                   doctor_gender,
                   doctor_location,
                   doctor_password,
                   doctor_speciality,
                   doctor_visiting_fee,
                   doctor_rating,
                   doctor_info
                    )

            values('Amir Hossain',
                    'Sahid Sarwardi Hospital',
                    'Dhaka',
                    'amirhossain@gmail.com',
                    9,
                    'Male',
                    '23/1 Shamoli, Mohammadpur, Dhaka',
                    '123456',
                    'General Doctor',
                    800,
                    3.9,
                    'specify a comma-separated list of table columns. Each column consists of the column name, the kind of data that column stores, the length of data, and the column constraint.'
                    );


insert into doctor(doctor_name,
                   doctor_clinic_name,
                   doctor_sub_district,
                   doctor_email,
                   doctor_experience,
                   doctor_gender,
                   doctor_location,
                   doctor_password,
                   doctor_speciality,
                   doctor_visiting_fee,
                   doctor_rating,
                   doctor_info
                    )

            values('Antor Kumar',
                    'Sylhet Medical Hospital',
                    'Sylhet',
                    'antorkumar@gmail.com',
                    4,
                    'Male',
                    '1/3 porbot, Sylhet',
                    '123456',
                    'Dermatologist',
                    1000,
                    4.9,
                    'specify a comma-separated list of table columns. Each column consists of the column name, the kind of data that column stores, the length of data, and the column constraint.'
                    );

insert into doctor(doctor_name,
                   doctor_clinic_name,
                   doctor_sub_district,
                   doctor_email,
                   doctor_experience,
                   doctor_gender,
                   doctor_location,
                   doctor_password,
                   doctor_speciality,
                   doctor_visiting_fee,
                   doctor_rating,
                   doctor_info
                    )

            values('Punima Roy',
                    'Rongpur Medical Hospital',
                    'Rongpur',
                    'purnimaroy@gmail.com',
                    4,
                    'Male',
                    '1/3 porbot, Rongpur',
                    '123456',
                    'Homoeopath',
                    500,
                    2.9,
                    'specify a comma-separated list of table columns. Each column consists of the column name, the kind of data that column stores, the length of data, and the column constraint.'
                    );


select * from appointment;

-- see deatail about a particular column
SELECT *
FROM INFORMATION_SCHEMA.COLUMNS
WHERE table_name = 'appointment'
AND COLUMN_NAME = 'doctor_id'
