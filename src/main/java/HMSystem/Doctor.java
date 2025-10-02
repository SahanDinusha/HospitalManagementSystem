package HMSystem;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String phone;

    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSpecialization(String specialization){
        this.specialization=specialization;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public String getPhone(){
        return phone;
    }
}
