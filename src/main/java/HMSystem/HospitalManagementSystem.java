package HMSystem;

import java.util.Scanner;
import java.sql.*;
import java.util.concurrent.locks.ReadWriteLock;

public class HospitalManagementSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Welcome To Hospital Management System ===");
            System.out.println("1. Add a Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Add a Patient");
            System.out.println("4. View Patients");
            System.out.println("5. Create a Appointment");
            System.out.println("6. View all Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    addDoctor();
                    break;
                case 2:
                    viewDoctor();
                    break;
                case 3:
                    addPatient();
                    break;
                case 4:
                    viewPatient();
                    break;
                case 5:
                    createAppointment();
                    break;
                case 6:
                    viewAppointment();
                    break;
                case 7:
                    System.out.println("Good Bye & Have A Nice Day!...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect Choice!");
                    break;
            }
         }
    }

    static void addDoctor(){
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Doctor Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter specialization: ");
            String specialization = scanner.nextLine();
            System.out.print("Enter Contact No: ");
            String phone = scanner.nextLine();

            String query = "insert into doctor(name, specialization, phone) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,specialization);
            ps.setString(3,phone);
            ps.executeUpdate();
            System.out.println("Doctor added!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    static void viewDoctor(){
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("select * from doctor");
            System.out.println("\n------------------------------------------------------------");
            System.out.println("Id|      Doctor Name    |    Specialization    |  ContactNo");
            System.out.println("------------------------------------------------------------");
            while (rs.next()){
                System.out.println(rs.getInt("doctor_id") + " |  "
                                   + rs.getString("name") + "  |     "
                                   + rs.getString("specialization") + "     |  "
                                   + rs.getString("phone"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    static void addPatient(){
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Patient Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Contact No: ");
            String phone = scanner.nextLine();

            String query = "insert into patient(name, age, phone) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setString(3,phone);
            ps.executeUpdate();
            System.out.println("Patient added!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    static void viewPatient(){
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("Select * from patient");
            System.out.println("\n-------------------------------------------------");
            System.out.println("Id|        Patient Name      | Age |   ContactNo   ");
            System.out.println("-------------------------------------------------");
            while (rs.next()){
                System.out.println(rs.getInt("patient_id") + " |       "
                                   + rs.getString("name") + "      |  "
                                   + rs.getInt("age") + " |   "
                                   + rs.getString("phone"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    static void createAppointment(){
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("\nEnter Doctor ID: ");
            int doctor_id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter patient ID: ");
            int patient_id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Appointment date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            String query = "insert into appointment(doctor_id, patient_id, appointment_date) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,doctor_id);
            ps.setInt(2,patient_id);
            ps.setString(3,date);
            ps.executeUpdate();
            System.out.println("Appointment Created Successfully!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    static void viewAppointment(){
        try (Connection con = DBConnection.getConnection()) {
            String query =  "SELECT a.appointment_id, p.name AS patient_name, d.name AS doctor_name, a.appointment_date " +
                    "FROM appointment a " +
                    "JOIN patient p ON a.patient_id = p.patient_id " +
                    "JOIN doctor d ON a.doctor_id = d.doctor_id";

            ResultSet rs = con.createStatement().executeQuery(query);

            System.out.println("\n------------------------------------------------------------------");
            System.out.println("Id|       Patient Name     |       Doctor Name     |       Date");
            System.out.println("------------------------------------------------------------------");
            while (rs.next()){
                System.out.println(rs.getInt("appointment_id") + " |      "
                        + rs.getString("patient_name") + "     |   "
                        + rs.getString("doctor_name") + "   |    "
                        + rs.getDate("appointment_date"));
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
