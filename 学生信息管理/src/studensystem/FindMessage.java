package studensystem;

public class FindMessage {
    static boolean findMessage(String str){
        boolean b=false;
        for(int i=0;i<Student.students.size();i++){
            if(Student.students.get(i).getName().equals(str)||Student.students.get(i).getNumber().equals(str)){
                b=true;
                break;
            }
        }
        return b;
    }
    static int findIndex(String str){
        int i;
        for(i=0;i<Student.students.size();i++){
            if (Student.students.get(i).getName().equals(str)||Student.students.get(i).getNumber().equals(str)){
                break;
            }
        }
        return i;
    }
}
