insert
    into
        auth
        (auth_doctor_doctorid, auth_email, auth_password, auth_patient_patient_id, auth_token)
    values
        (?, ?, ?, ?, ?);


update
        auth
    set
        auth_doctor_doctorid=?,
        auth_email=?,
        auth_password=?,
        auth_patient_patient_id=?,
        auth_token=?
    where
        auth_id=?;

  select
        exists(select
            *
        from
            auth a
        where
            a.auth_token = ?);
            