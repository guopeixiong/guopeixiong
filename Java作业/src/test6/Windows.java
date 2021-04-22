package test6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Windows implements ActionListener {
    //定义所需组件
    private JFrame jFrame;
    private JButton b1,b2,b3,b4,b5;
    private JTextField t1,t2,t3;
    private JLabel l1,l2;
    private Font font;
    //在构造方法中完成各组件的初始化
    public Windows(String str){
        //实例化底层容器以及字体
        jFrame=new JFrame(str);
        jFrame.setLayout(null);
        font=new Font("微软雅黑",Font.BOLD,50);
        //实例化按钮,文本框,标签
        b1=new JButton("加");
        b2=new JButton("差");
        b3=new JButton("积");
        b4=new JButton("除");
        b5=new JButton("清除");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        l1=new JLabel(" ");
        l2=new JLabel("=");
        //设置个组件位置,及大小
        jFrame.setBounds(300,500,2000,600);
        b1.setBounds(675,350,100,100);
        b2.setBounds(825,350,100,100);
        b3.setBounds(975,350,100,100);
        b4.setBounds(1125,350,100,100);
        b5.setBounds(1800,150,150,100);
        t1.setBounds(250,100,300,100);
        t2.setBounds(850,100,300,100);
        t3.setBounds(1400,100,300,100);
        l1.setBounds(650,100,50,100);
        l2.setBounds(1250,100,50,100);
        //设置各组件字体
        jFrame.setFont(font);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b4.setFont(font);
        b5.setFont(font);
        t1.setFont(font);
        t2.setFont(font);
        t3.setFont(font);
        l1.setFont(font);
        l2.setFont(font);
        //设置组件是否可见
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);
        b4.setVisible(true);
        b5.setVisible(true);
        t1.setVisible(true);
        t2.setVisible(true);
        t3.setVisible(true);
        l1.setVisible(false);
        l2.setVisible(false);
        //将组件添加至底层容器中
        jFrame.add(b1);
        jFrame.add(b2);
        jFrame.add(b3);
        jFrame.add(b4);
        jFrame.add(b5);
        jFrame.add(t1);
        jFrame.add(t2);
        jFrame.add(t3);
        jFrame.add(l1);
        jFrame.add(l2);
        //为按钮注册监视器
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        //设置窗口退出时操作及整个窗口是否可见
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try {
                Double sum=Double.parseDouble(t1.getText()) + Double.parseDouble(t2.getText());
                l1.setText("+");
                l1.setVisible(true);
                l2.setVisible(true);
                t3.setText(String.valueOf(sum));
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(jFrame,"输入格式有误",null,JOptionPane.WARNING_MESSAGE);
            }
        }else if (e.getSource()==b2){
            try {
                double sum=Double.parseDouble(t1.getText()) - Double.parseDouble(t2.getText());
                l1.setText("-");
                l1.setVisible(true);
                l2.setVisible(true);
                t3.setText(String.valueOf(sum));
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(jFrame,"输入格式有误",null,JOptionPane.WARNING_MESSAGE);
            }
        }else if (e.getSource()==b3){
            try {
                double sum=Double.parseDouble(t1.getText()) * Double.parseDouble(t2.getText());
                l1.setText("x");
                l1.setVisible(true);
                l2.setVisible(true);
                t3.setText(String.valueOf(sum));
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(jFrame,"输入格式有误",null,JOptionPane.WARNING_MESSAGE);
            }
        }else if (e.getSource()==b4){
            try {
                Double sum=Double.parseDouble(t1.getText()) / Double.parseDouble(t2.getText());
                l1.setText("/");
                l1.setVisible(true);
                l2.setVisible(true);
                t3.setText(String.valueOf(sum));
            }catch(NumberFormatException e1){
                JOptionPane.showMessageDialog(jFrame,"输入格式有误",null,JOptionPane.WARNING_MESSAGE);
            }
        }else {
            l1.setVisible(false);
            l2.setVisible(false);
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
        }

    }
    public static void main(String[] args) {
        Windows win1=new Windows("计算");
    }
}
