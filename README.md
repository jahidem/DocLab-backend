## DocLab-backend ![Markdown Logo](./logo-doclab.png)
 >The backend API of the webapp DocLab.

#### Descripson:
This API provides access to the `Database` to the front end of
frontend([DocLab-frontend](https://github.com/IIT-Project-Team/DocLab-frontend)) of this webapp.
#### APIs:
###### For Doctor
* GET request to `/doctors` provide the list of all available
 doctors at the moment in Json format.


* GET request to `/doctor/{id}` gives info of the doctor
  having the `id` in Json format.

* POST request to `/doctor` with body {"doctorName" : "Example name"} adds new doctor to the database with the given `doctotName`.


###### For Patient
* GET request to `/patients` provide the list of all available
  doctors at the moment in Json format.


* GET request to `/patient/{id}` gives info of the doctor
  having the `id` in Json format.

* POST request to `/patient` with body {"doctorName" : "Example name"} adds new doctor to the database with the given `doctotName`.
