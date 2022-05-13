package model;

public class Employee {
    private int id;
    private  String first_name;
    private  String last_name;
    private  String birth_day;
    private String sex;
    private int salary;

    public  Employee(int id,String first_name,String last_name,String birth_day,String sex,int salary){
        this.id=id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.birth_day=birth_day;
        this.sex=sex;
        this.salary=salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public  String toString(){
        String text="";
        text+=id+","+first_name+","+last_name+","+birth_day+","+sex+","+salary;
        return  text;
    }

    @Override
    public  boolean equals(Object obj){
        Employee employee=(Employee) obj;
        return  employee.salary==this.salary;
    }
}
