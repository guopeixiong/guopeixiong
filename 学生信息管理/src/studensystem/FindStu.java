package studensystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
