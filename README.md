<img src="./logo2.png" alt="drawing" width="150"/> 

## DocLab-backend ! 
 >The backend API of the webapp DocLab.

#### Descripson:
This API provides access to the `Database` to the front end of
frontend([DocLab-frontend](https://github.com/IIT-Project-Team/DocLab-frontend)) of this webapp.
#### APIs:
###### For Doctor 
* GET request to `/doctor` provide the list of all available
 doctors at the moment in Json format.


* GET request to `/doctor/{id}` gives info of the doctor
  having the `id` in Json format.

* POST request to `/doctor/post` with attached body {"doctorName" : "Example Name"} adds new doctor to the database 
named `Example Name`.
* DELETE request to `/doctor/delete/{id}` deletes the doctor having the `id`, but returns `NO CONTENT(204)`
if it doesn't exists.


###### For Patient
* GET request to `/patient` provide the list of all available
  doctors at the moment in Json format.


* GET request to `/patient/{id}` gives info of the patient
  having the `id` in Json format.

* POST request to `/patient/post` with body {"doctorName" : "Example name"} adds new doctor to the database with the given `doctotName`.


###### For Appontment
* GET request to `/appointment` provide the list of all appointments at the moment in Json format.

* GET request to `/appointment/getByDoctor/{id}` gives info of the Appointments for a doctor
  having the `id` in Json format.


* GET request to `/appointment/getByPatient/{id}` gives info of the Appointments for a patient
  having the `id` in Json format.

* POST request to `/appointment/post` with body 
  `{
  "appointmentLabLocation": "Dhaka",
  "appointmentAccepted": true,
  "doctorId": 3,
  "patientId": 1,
  "appointmentTime": "2022-12-11T11:40:49.000+00:00"
  }`
  add patient having id of `1` to the doctor having id of `3` for an appointment.

* adds new doctor to the database with the given `doctotName`.
