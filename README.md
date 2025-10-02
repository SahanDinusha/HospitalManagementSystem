# Hospital Management System (Java + MySQL)

This is a **console-based Hospital Management System** built using **Java** and **MySQL (JDBC)**.  
It allows you to manage patients, doctors, and appointments with a simple menu-driven interface.

## Features
- Add and view patients
- Add and view doctors
- Add and view appointments
- Menu-driven console interface
- Data stored in MySQL database

## Project Structure
- **Patient.java** → Model class for patient (id, name, age, phone)  
- **Doctor.java** → Model class for doctor (id, name, specialization)  
- **Appointment.java** → Model class for appointment (id, doctor_id, patient_id, date)  
- **DBConnection.java** → Handles MySQL database connection  
- **HospitalManagementSystem.java** → Main class with menu and JDBC methods  

## Database Schema
```sql
CREATE TABLE patient (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    phone VARCHAR(20)
);

CREATE TABLE doctor (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    specialization VARCHAR(100)
);

CREATE TABLE appointment (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id INT,
    patient_id INT,
    appointment_date DATE,
    FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id)
);
