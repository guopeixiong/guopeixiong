package studensystem;

import java.util.ArrayList;
import java.util.List;
/*
    此类为学生类，每一个实例即为一个学生
 */
public class Student {
    //学生属性，姓名/学号
    private String name;
    private String number;
    //静态ArrayList实现学生信息存放，且只能存放Student类的实例
    public static ArrayList<Student> students=new ArrayList<Student>();
    //有参构造方法，用于创建学生实例
    public Student(String name,String number){
        this.name=name;
        this.number=number;
    }
    //无参构造方法
    public Student(){
    }
    /*
    set/get方法实现获取学生信息和修改学生信息
     */
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
