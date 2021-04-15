package test5;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class test {
    public static int myParseInt(String str){
        String s = str.replaceAll("[^0-9]+", "*");
        if (s.matches("[*]+?")){
            return 0;
        }
        else{
            String[] split = s.split("[*]");
            String s1 ="";
            for (int i=0;i<split.length;i++){
                if (split[i].matches("[0-9]+")){
                    s1+=split[i];
                }
            }
            return Integer.parseInt(s1);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串:");
        String s=sc.nextLine();
        int i=myParseInt(s);
        if (i==0){
            System.out.println("字符串中没有数字!");
        }
        else{
            System.out.println("字符串中的数字是:"+i);
        }
    }
}
