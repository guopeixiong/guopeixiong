package test10;

import test9.Student;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class StuManage {
    Map<String, Student> stus;
    public StuManage(){
        this.init();
    }
    private void init(){
        stus=new HashMap<String,Student>();
    }
    public int add(Student stu){
        int result=-1;
        if (stu==null){
            return result;
        }else{
            stus.put(stu.getName(),stu);
            stus.put(stu.getID(),stu);
            result=0;
        }
        return result;
    }
    public int add(String name,String ID){
        int result=-1;
        if (name!=null&&ID!=null){
            Student stu=new Student(name,ID);
            stus.put(name,stu);
            stus.put(ID,stu);
            result=0;
        }else{
            return result;
        }
        return result;
    }
    public Student getStudent(String name,String ID){
        Student stu=null;
        stu=stus.get(name);
        if (stu==null){
            stu=stus.get(ID);
        }
        return stu;
    }
    public int delete(String name,String ID){
        int result=-1;
        Student stu=this.getStudent(name,ID);
        if (stu!=null){
            stus.remove(stu.getName(),stu);
            stus.remove(stu.getID(),stu);
            result=0;
        }
        return result;
    }
    public int modify(String name,String ID,String newName,String newID){
        int result=-1;
        Student stu=this.getStudent(name,ID);
        if (stu!=null){
            if (newName!=null){
                stu.setName(newName);
                result=0;
            }
            if (newID!=null){
                stu.setID(newID);
                result=0;
            }
        }
        return result;
    }
    public String toString(){
        String str="";
        Set<Student> set=new LinkedHashSet<>();
        for (Student stu:stus.values()){
            set.add(stu);
        }
        for (Student stu:set){
            str+=stu+"\n";
        }
        return str;
    }
}
public class Test {
    public static void main(String[] args) {
        StuManage stuMan=new StuManage();
        stuMan.add("张三","001");
        stuMan.add("李四","002");
        System.out.println("添加后的结果"+stuMan);
        System.out.println("按学号001查找学生:"+stuMan.getStudent(null,"001"));
        System.out.println("根据姓名张三查找学生:"+stuMan.getStudent("张三",null));
        System.out.println("根据学号001姓名张三查找学生:"+stuMan.getStudent("张三","001"));
        stuMan.modify(null,"001","张思",null);
        System.out.println("修改后的结果:"+stuMan);
        stuMan.delete(null,"001");
        System.out.println("删除后的结果:"+stuMan);
    }
}
