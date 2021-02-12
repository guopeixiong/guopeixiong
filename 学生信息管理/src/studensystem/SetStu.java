package studensystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
    此类实现ArrayListener接口，为监视器类，用于处理修改学生信息的操作
 */
public class SetStu implements ActionListener {
    JTextField field1,field2;
    JButton button;
    public SetStu(JTextField filed,JTextField field2,JButton button){
        this.field1=filed;
        this.field2=field2;
        this.button=button;
    }
    @Override
    /*
    按下按钮后检测文本框是否输入不完整或没有输入，是则弹出相应提醒
    否则查找该学生是否存在，存在则修改其信息并弹出提醒修改成功，不
    存在则提出提醒该学生不存在
     */
    public void actionPerformed(ActionEvent e) {
        if (!field1.getText().equals(" ")&&!field1.getText().equals(null)){
            if (!field2.getText().equals(" ")&&!field1.getText().equals(null)){
                String oldNameOrnumber=field1.getText().trim();
                if (FindMessage.findMessage(oldNameOrnumber)){
                    String newNameOrNumber=field2.getText().trim();
                    char a=newNameOrNumber.charAt(0);
                    int index=FindMessage.findIndex(oldNameOrnumber);
                    if(Character.isDigit(a)){
                        Student.students.get(index).setNumber(newNameOrNumber);
                        field1.setText(" ");
                        field2.setText(" ");
                        JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        Student.students.get(index).setName(newNameOrNumber);
                        field1.setText(" ");
                        field2.setText(" ");
                        JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"该学生不存在","提示",JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"请输入新姓名或学号","提示",JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"请输入原姓名或学号","提示",JOptionPane.WARNING_MESSAGE);
        }
    }
}
