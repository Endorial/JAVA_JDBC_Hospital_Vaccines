# Hospital_Vaccine_Administrator

## About & Tasks

The Castellón city council has asked us for an application to be able to manage vaccinated patients. 
A patient belongs to an outpatient clinic and may be vaccinated with one or more vaccines

### The database created is:

![image2](https://user-images.githubusercontent.com/57392686/217212021-434bc27d-4ddb-4c0f-b396-0924dc9ad828.jpg)

### Ambulatorio :

ncodigo----------------->int PK no auto<br>
cnombre--------------->texto(50) not null<br>
cdireccion------------->texto(100) not null<br>
ctelefono-------------->texto(20) not null<br>


### pacientes :

nsip---------------------->int PK no auto<br>
cnombre--------------->texto(20) not null<br>
capellidos------------->texto(50) not null<br>
nedad------------------>int not null<br>
nambulatorio-------->int not null FK(ambulatorios)<br>
bfoto------------------->longblob not null (guarda la foto del paciente)<br>


### Vacunas> 

ncodigo---------------------->int PK auto<br>
cnombre--------------------->texto(50) not null<br>
bcomposicion-------------->blob not null (representa la composición de la vacuna)<br>

### Vacuna_paciente

npaciente---------------------->int PK no auto FK(pacientes)<br>
nvacuna------------------------> int PK no auto FK(vacunas)<br>
ndosis--------------------------->int no null (dosis que se pone de la vacuna)<br>


### TASKS :

1. Create the database given the attached SQL file
2. Insert two ambulatory (ambulatorios)
3. Insert three patients (one in one clinic and two in the other) with a photo included
4. Vaccinate 2 patients with one vaccine each and a third with three (the vaccines are 
already created)
5. Change the photo of a patient
6. List all outpatients with vaccinations
7. Delete a patient given their nsip (we assume it always exists

### TIPS:
The vaccines are already inserted in the database, I give you the class "composition" that has 
been used.
que se ha usado.
