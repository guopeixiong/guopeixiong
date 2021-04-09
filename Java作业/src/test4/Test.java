package test4;
import java.util.Scanner;
class MyException extends Exception{
    public MyException(){}
}
public class Test {
    public static void main(String[] args) {
        System.out.println("请输入成绩,中间用空格隔开:");
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        scanner.close();
        Scanner sc=new Scanner(str);
        sc.useDelimiter(" ");
        int i=0,sum=0;
        while(sc.hasNext()){
            String grade=sc.next();
            try{
                if (!grade.matches("\\d{1,3}")){
                    throw new MyException(){
                      public String getMessage(){
                          return "输入的成绩中有非数字";
                      }
                    };
                }
                else if (Integer.parseInt(grade)>100){
                    throw new MyException(){
                        public String getMessage(){
                            return "输入的成绩有大于100的";
                        }
                    };
                }
                else{
                    sum+=Integer.parseInt(grade);
                    i++;
                }
            }catch (MyException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("合法成绩共"+i+"个,总和为:"+sum+",平均成绩为:"+(double)sum/i);
        sc.close();
    }
}
