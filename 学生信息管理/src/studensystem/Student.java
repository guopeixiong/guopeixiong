package studensystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String number;
    public static ArrayList<Student> students=new ArrayList<Student>();
    public Student(String name,String number){
        this.name=name;
        this.number=number;
    }
    public Student(){
    }
    public void setName(String name){
        this.name=name;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public String getName(){
        return this.name;
    }
    public String getNumber(){
        return this.number;
    }
}
