package HMSystem;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String phone;

    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
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
    public int getAge(){
        return age;
    }
    public String getPhone(){
        return phone;
    }
}
