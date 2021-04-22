package test6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5;
    JTextField t1,t2,t3;
    Font font;
    public Demo(String s){
        super(s);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(500,500,1000,700);
        font=new Font("宋体",Font.BOLD,35);

        b1=new JButton("和");
        b1.setFont(font);
        b1.setSize(100,50);
        b1.setVisible(true);
        b1.addActionListener(this);

        b2=new JButton("差");
        b2.setFont(font);
        b2.setSize(100,50);
        b2.setVisible(true);
        b2.addActionListener(this);

        b3=new JButton("积");
        b3.setFont(font);
        b3.setSize(100,50);
        b3.setVisible(true);
        b3.addActionListener(this);

        b4=new JButton("除");
        b4.setFont(font);
        b4.setSize(100,50);
        b4.setVisible(true);
        b4.addActionListener(this);

        b5=new JButton("清除");
        b5.setFont(font);
        b5.setSize(100,50);
        b5.setVisible(true);
        b5.addActionListener(this);

        t1=new JTextField();
        t1.setFont(font);
        t1.setLocation(400,100);
        t1.setSize(200,50);
        t1.setVisible(true);

        t2=new JTextField();
        t2.setFont(font);
        t2.setLocation(400,200);
        t2.setSize(200,50);
        t2.setVisible(true);

        t3=new JTextField();
        t3.setFont(font);
        t3.setLocation(400,300);
        t3.setSize(200,50);
        t3.setVisible(true);

        JPanel p=new JPanel();
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.setLocation(0,500);
        p.setSize(1000,100);

        this.add(t1);
        this.add(t2);
        this.add(t3);
        this.add(p);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s1=t1.getText();
        String s2=t2.getText();
        if (e.getSource()==b1){
            try {
                double sum=Double.parseDouble(s1) + Double.parseDouble(s2);
                t3.setText(String.valueOf(sum));
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(this,"输入错误!",null,JOptionPane.WARNING_MESSAGE);
            }
        }else if (e.getSource()==b2){
            try {
                double sum=Double.parseDouble(s1) - Double.parseDouble(s2);
                t3.setText(String.valueOf(sum));
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(this,"输入错误",null,JOptionPane.WARNING_MESSAGE);
            }
        }else if (e.getSource()==b3){
            try {
                Double sum=Double.parseDouble(s1) * Double.parseDouble(s2);
                t3.setText(String.valueOf(sum));
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(this,"输入错误",null,JOptionPane.WARNING_MESSAGE);
            }
        }else if (e.getSource()==b4){
            try {
                Double sum=Double.parseDouble(s1) / Double.parseDouble(s2);
                t3.setText(String.valueOf(sum));
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(this,"输入错误",null,JOptionPane.WARNING_MESSAGE);
            }
        }else{
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
        }
    }

    public static void main(String[] args) {
        Demo demo=new Demo("计算机");
    }
}
