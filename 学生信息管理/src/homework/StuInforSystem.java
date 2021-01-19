package homework;
import java.util.Scanner;
import java.util.ArrayList;
public class StuInforSystem {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        //学生信息在ArrayList中的存储方式为姓名，学号；姓名，学号；姓名，学号；……
        ArrayList <String> student=new ArrayList<>();
        String operation;
        do{
            speak("请输入您需要的操作：添加学生信息/修改学生信息/查询学生信息/删除学生信息/退出");
            //通过识别用户输入的操作名进入switch相应的case
            operation=getString();
            if (operation.equals("添加学生信息")||operation.equals("修改学生信息")||operation.equals("查询学生信息")||operation.equals("删除学生信息")||operation.equals("退出")) {
                switch (operation) {
                    case "添加学生信息":
                        addstudent(student);
                        break;
                    case "修改学生信息":
                        setStudent(student);
                        break;
                    case "查询学生信息":
                        findStudent(student);
                        break;
                    case "删除学生信息":
                        deleteStudent(student);
                }
            }
            else{
                speak("输入错误！请输入正确的操作名称");
            }
        }while(!operation.equals("退出"));
        sc.close();
    }
    static void addstudent(ArrayList e){
        speak("请输入学生姓名：");
        String name=getString();
        e.add(name);
        speak("请输入学生学号：");
        String number=getString();
        e.add(number);
        speak("添加成功！");
    }
    static void setStudent(ArrayList e){
        speak("请输入要修改的学生姓名或学生学号：");
        String nameOrNumer=getString();
        if (e.contains(nameOrNumer)){
            speak("请输入修改为：");
            String newNameOrNumber=getString();
            e.set(e.indexOf(nameOrNumer),newNameOrNumber);
            speak("修改成功！");
        }
        else{
            speak("对不起，该学生不存在，请核对姓名或学号是否有误");
        }
    }
    static void findStudent(ArrayList e){
        speak("请输入查询方式：姓名/学号");
        String select=getString();
        if (select.equals("姓名")){
            speak("请输入要查询的学生姓名：");
            String name=getString();
            if(e.contains(name)){
                speak("学生姓名："+name);
                speak("学生学号："+e.get(e.indexOf(name)+1).toString());
            }
            else{
                speak("对不起，该学生不存在");
            }
        }
        else if(select.equals("学号")){
            speak("请输入要查询的学生学号：");
            String number=getString();
            if (e.contains(number)){
                speak("学生姓名："+e.get(e.indexOf(number)-1).toString());
                speak("学生学号："+number);
            }
            else{
                speak("对不起，该学生不存在");
            }
        }
        else{
            speak("请输入正确的查询方式");
        }
    }
    static void deleteStudent(ArrayList e){
        speak("请输入要删除的学生姓名或学号：");
        String nameOrNumber=getString();
        char c=nameOrNumber.charAt(0);
        if (Character.isDigit(c)){
            if (e.contains(nameOrNumber)){
                e.remove(e.indexOf(nameOrNumber)-1);
                e.remove(nameOrNumber);
                speak("删除成功！");

            }
            else{
                speak("对不起，该学生不存在！");
            }
        }
        else{
            if (e.contains(nameOrNumber)){
                e.remove(e.indexOf(nameOrNumber)+1);
                e.remove(nameOrNumber);
                speak("删除成功！");
            }
            else{
                speak("对不起，该学生不存在！");
            }

        }
    }
    static void speak(String s){
        System.out.println(s);
    }
    static String getString(){
        String s=sc.next();
        return s;
    }
}

