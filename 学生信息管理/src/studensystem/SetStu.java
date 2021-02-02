package studensystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SetStu implements ActionListener {
    JTextField field1,field2;
    JButton button;
    public SetStu(JTextField filed,JTextField field2,JButton button){
        this.field1=filed;
        this.field2=field2;
        this.button=button;
    }
    @Override
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
