package test4;

import java.util.Scanner;

class NotNumberException extends Exception{
    public NotNumberException(String message){
        super(message);
    }
}
class OutException extends Exception{
    public OutException(String message){
        super(message);
    }
}
public class Demo {
    public static int getIntNumber(Scanner sc){
        System.out.println("请输入成绩:");
        int i=0;
        String str="";
        try{
            str=sc.nextLine();
            i=Integer.parseInt(str);
        }catch(NumberFormatException e){
            System.out.println("该成绩不是数字!");
        }
        finally {
            return i;
        }
    }
    public static void isOut(int a) throws OutException{
        if (a>100){
            throw new OutException("该成绩不在0~100之间");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int students=0;
        for (int i=0;i<5;i++) {
            try {
                int a = getIntNumber(sc);
                isOut(a);
                if (a!=0){
                    sum += a;
                    students++;
                }
            }catch (OutException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("成绩总和:"+sum+",平均成绩:"+(double)sum/students);
        System.out.println(students);
    }
}
