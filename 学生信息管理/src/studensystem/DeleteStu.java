package studensystem;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
    此类实现ActionListener接口，为监视器类，用于处理删除学生的操作
 */
public class DeleteStu implements ActionListener {
    JTextField field;
    JButton button;
    public DeleteStu(JTextField field,JButton button){
        this.field=field;
        this.button=button;
    }
    @Override
    /*
    若按下确认按钮首先检测文本框是否有输入内容若没有则弹出对话款提醒，有输入则查找ArrayList中是否有此学生，
    若没有则删除弹出提醒，有则删除学生，并弹出提醒删除成功
     */
    public void actionPerformed(ActionEvent e) {
        if(!field.getText().equals(" ")&&!field.getText().equals(null)){
            String student=field.getText().trim();
            if(FindMessage.findMessage(student)){
                int yesOrNo=JOptionPane.showConfirmDialog(null,"是否删除","提示",JOptionPane.YES_NO_OPTION);
                if(yesOrNo==JOptionPane.YES_OPTION){
                    int index=FindMessage.findIndex(student);
                    Student.students.remove(index);
                    field.setText(" ");
                    JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    field.setText(" ");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"该学生不存在","提示", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"请输入姓名或学号","提示",JOptionPane.WARNING_MESSAGE);
        }
    }
}
