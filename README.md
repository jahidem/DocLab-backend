## DocLab-backend ![Markdown Logo](./logo-doclab.png)
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
* GET request to `/patients` provide the list of all available
  doctors at the moment in Json format.


* GET request to `/patient/{id}` gives info of the doctor
  having the `id` in Json format.

* POST request to `/patient` with body {"doctorName" : "Example name"} adds new doctor to the database with the given `doctotName`.


###### For Appontment
