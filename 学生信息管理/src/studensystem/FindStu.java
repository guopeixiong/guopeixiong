package studensystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
    此类实现ActionListener接口，为监视器类，用于处理查询学生的操作
 */
public class FindStu implements ActionListener {
    JTextField field;
    JTextArea showMessage;
    JButton button1,button2;
    public FindStu(JTextField field,JTextArea showMessage,JButton button1,JButton button2){
        this.field=field;
        this.showMessage=showMessage;
        this.button1=button1;
        this.button2=button2;
    }
    @Override
    /*
    按下按钮后首先检测文本框内是否有输入没有则弹出提醒，有则检测文本框输入的内容是否为数字，
    为数字则是学号，否则为姓名，查询是否有该学生，有则在文本区输出该学生的全部信息，没有则弹出提醒
     */
    public void actionPerformed(ActionEvent e) {
        if(!field.getText().equals(" ")&&!field.getText().equals(null)){
            String student=field.getText().trim();
            if (FindMessage.findMessage(student)){
                int index=FindMessage.findIndex(student);
                showMessage.setVisible(true);
                showMessage.append("查询到以下学生："+"\n");
                showMessage.append("姓名："+Student.students.get(index).getName()+"\n");
                showMessage.append("学号："+Student.students.get(index).getNumber()+"\n");
                button2.setVisible(true);
                field.setText(" ");
            }
            else{
                JOptionPane.showMessageDialog(null,"该学生不存在","提示",JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"请输入姓名或学号","提示",JOptionPane.WARNING_MESSAGE);
        }
    }
}
