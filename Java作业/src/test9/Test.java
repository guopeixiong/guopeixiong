package test9;

import java.io.*;

class Student{
    private String name;
    private String ID;
    public Student(String name,String ID){
        this.name=name;
        this.ID=ID;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        String str="ID:";
        str+=this.ID;
        str+=",name:";
        str+=this.name;
        return str;
    }
}
class StuManage{
    Student[] stus;
    final int minNums=10;
    public StuManage(int nums){
        this.init(nums);
    }
    private void init(int nums){
        if(nums>0){
            this.stus=new Student[nums];
        }else{
            this.stus=new Student[minNums];
        }
        try{
            FileReader reader =new FileReader(new File("D:\\guopeixiong\\Java作业\\src\\test9","student.txt"));
            BufferedReader in=new BufferedReader(reader);
            String str="";
            while((str=in.readLine())!=null){
                String ID="";
                String name="";
                for (int i=0;i<str.length();i++){
                    char c=str.charAt(i);
                    if (Character.isDigit(c)){
                        ID+=c;
                    }else{
                        name+=c;
                    }
                }
                for(int i=0;i<stus.length;i++){
                    if (stus[i]==null){
                        stus[i]=new Student(name,ID);
                        break;
                    }
                }

            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int add(Student stu){
        int result=-1;
        if(stu==null){
            return result;
        }
        for (int i=0;i<stus.length;i++){
            if (stus[i]==null){
                stus[i]=stu;
                this.refresh();
                result=0;
                break;
            }
        }
        return result;
    }
    public int add(String name,String ID){
        int result=-1;
        for (int i=0;i<stus.length;i++){
            if (stus[i]==null){
                stus[i]=new Student(name,ID);
                this.refresh();
                result=0;
                break;
            }
        }
        return result;
    }
    private int getIndexByname(String strName){
        if (strName==null){
            return -1;
        }
        for (int i=0;i<stus.length;i++){
            if (stus[i].getName().equals(strName)){
                return i;
            }
        }
        return -1;
    }
    private int getIndexByID(String strID){
        if (strID==null){
            return -1;
        }
        for (int i=0;i<stus.length;i++){
            if (stus[i].getID().equals(strID)){
                return i;
            }
        }
        return -1;
    }
    private int getIndex(String strName,String strID){
        if (strName==null&&strID==null){
            return -1;
        }
        for (int i=0;i< stus.length;i++){
            if (stus[i]!=null){
                if (stus[i].getName().equals(strName)||stus[i].getID().equals(strID)){
                    return i;
                }
            }
        }
        return -1;
    }
    public int getStudentIndex(String strName,String strID){
        int index=-1;
        if (strID==null){
            index=this.getIndexByname(strName);
        }else{
            if (strName==null){
                index=this.getIndexByID(strID);
            }else{
                index=this.getIndex(strName,strID);
            }
        }
        return index;
    }
    public Student getstudent(String strName,String strID){
        int index=-1;
        if (strID==null){
            index=this.getIndexByname(strName);
        }else{
            if (strName==null){
                index=this.getIndexByID(strID);
            }else{
                index=this.getIndex(strName,strID);
            }
        }
        if (index!=-1){
            return stus[index];
        }
        return null;
    }
    public int delete(String name,String ID){
        int index=this.getIndex(name,ID);
        if (index!=-1){
            stus[index]=null;
            this.refresh();
            return 0;
        }
        return -1;
    }
    public int modify(String name,String ID,String newName,String newID){
        Student stu=this.getstudent(name,ID);
        if (stu==null){
            return -1;
        }
        if (newName!=null){
            stu.setName(newName);
        }
        if (newID!=null){
            stu.setID(newID);
        }
        this.refresh();
        return 0;
    }
    private void refresh(){
        try{
            FileWriter writer=new FileWriter(new File("D:\\guopeixiong\\Java作业\\src\\test9","student.txt"),false);
            BufferedWriter out=new BufferedWriter(writer);
            for (int i=0;i< stus.length;i++){
                if (stus[i]!=null){
                    out.write(stus[i].getID()+stus[i].getName());
                    out.newLine();
                }
            }
            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public String toString(){
        String str="Total:[";
        for (Student stu:stus){
            if (stu!=null){
                str+="{";
                str+=stu.toString();
                str+="}";
            }
        }
        str+="]";
        return str;
    }
}
public class Test {
    public static void main(String[] args) {
        StuManage stuMan=new StuManage(20);
        stuMan.add("张三","001");
        stuMan.add(new Student("李四","002"));
        System.out.println("添加后的结果:"+stuMan);
        System.out.println("按学号001查找学生:"+stuMan.getstudent(null,"001"));
        System.out.println("根据姓名张三查找学生:"+stuMan.getstudent("张三",null));
        System.out.println("根据学号001姓名张三查找学生:"+stuMan.getstudent("张三","001"));
        stuMan.modify(null,"001","张思",null);
        System.out.println("修改后的结果:"+stuMan);
        stuMan.delete(null,"001");
        System.out.println("删除后的结果:"+stuMan);
    }
}
