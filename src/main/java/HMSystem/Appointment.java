package HMSystem;

public class Appointment {
    private int id;
    private int doctorID;
    private int patientID;
    private String date;

    public void setId(int id){
        this.id=id;
    }
    public void setDoctorID(int doctorID){
        this.doctorID=doctorID;
    }
    public void setPatientID(int patientID){
        this.patientID=patientID;
    }
    public void setDate(String date){
        this.date=date;
    }


    public int getId(){
        return id;
    }
    public int getDoctorID(){
        return doctorID;
    }
    public int getPatientID(){
        return patientID;
    }
    public String getDate(){
        return date;
    }
}
