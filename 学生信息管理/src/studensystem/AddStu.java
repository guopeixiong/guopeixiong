package studensystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
    此类实现ActionListener接口，为监视器类，处理添加学生的操作
 */
public class AddStu implements ActionListener {
    JTextField field1,filed2;
    JButton button;
   public AddStu(JTextField field1,JTextField filed2,JButton button){
       this.field1=field1;
       this.filed2=filed2;
       this.button=button;
   }
    @Override
    /*
    按下按钮首先检测文本框内是否输入完整没则弹出对应提醒，输入完整则创建一个student实例并存放在ArrayList中
    ，并弹出提醒添加成功
     */
    public void actionPerformed(ActionEvent e) {
       if(!field1.getText().equals(" ")&&!field1.getText().equals(null)&&!filed2.getText().equals(" ")&&!filed2.getText().equals(null)){
           String name=field1.getText().trim();
           String number=filed2.getText().trim();
           Student.students.add(new Student(name,number));
           field1.setText(" ");
           filed2.setText(" ");
           JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.WARNING_MESSAGE);
       }
       else if (field1.getText().equals(" ")){
           JOptionPane.showMessageDialog(null,"请输入姓名","提示",JOptionPane.WARNING_MESSAGE);
       }
       else if (filed2.getText().equals(" ")){
           JOptionPane.showMessageDialog(null,"请输入学号","提示",JOptionPane.WARNING_MESSAGE);
       }
       else{
           JOptionPane.showMessageDialog(null,"请输入姓名和学号","提示",JOptionPane.WARNING_MESSAGE);
       }
    }
}
