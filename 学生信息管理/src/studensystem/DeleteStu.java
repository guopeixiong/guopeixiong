package studensystem;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStu implements ActionListener {
    JTextField field;
    JButton button;
    public DeleteStu(JTextField field,JButton button){
        this.field=field;
        this.button=button;
    }
    @Override
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
