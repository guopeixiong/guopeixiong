package studensystem;
/*
    此类中有两个静态方法用于遍历ArrayList
 */
public class FindMessage {
    //此方法将传入的字符串str与ArrayList中的对象逐个比较返回是否含有此信息
    static boolean findMessage(String str){
        boolean b=false;
        for(int i=0;i<Student.students.size();i++){
            if(Student.students.get(i).getName().equals(str)||Student.students.get(i).getNumber().equals(str)){
                b=true;//若含有该元素则将b的值改为true，跳出循环返回b
                break;
            }
        }
        return b;
    }
    //此方法将传入的字符串str与ArrayList中的对象逐个比较若含有该元素则返回该对象的索引
    static int findIndex(String str){
        int i;
        for(i=0;i<Student.students.size();i++){
            if (Student.students.get(i).getName().equals(str)||Student.students.get(i).getNumber().equals(str)){
                break;//若含有则结束循环返回此时的索引i
            }
        }
        return i;
    }
}
