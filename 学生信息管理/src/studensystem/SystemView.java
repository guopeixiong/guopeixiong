package studensystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
此类为该系统的图形界面
 */
public class SystemView {
    private JFrame frame;
    private JTabbedPane jTabbedPane;
    private JPanel p1,p2,p3,p4;
    private JLabel l11,l12,l21,l22,l3,l4;
    private JTextField f11,f12,f21,f22,f3,f4;
    private JTextArea showMessage;
    private JButton b1,b2,b3,b4,b5;
    //在构造方法中完成各种组件的实例化与设置
    public SystemView(){
        //设置系统字体
        Font size=new Font("微软雅黑",Font.BOLD,30);
        //实例化并设置底层容器
        frame=new JFrame("学生信息管理系统");
        frame.setFont(size);
        frame.setBounds(300,300,1800,1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //实例化并设置选项卡格窗
        jTabbedPane=new JTabbedPane();
        jTabbedPane.setFont(size);
        jTabbedPane.setVisible(true);
        //实例化并设置面板
        p1=new JPanel();
        p1.setLayout(null);
        p1.setVisible(true);
        p2=new JPanel();
        p2.setLayout(null);
        p2.setVisible(true);
        p3=new JPanel();
        p3.setLayout(null);
        p3.setVisible(true);
        p4=new JPanel();
        p4.setLayout(null);
        p4.setVisible(true);
        //实例化并设置标签
        l11=new JLabel("姓名：");
        l11.setFont(size);
        l11.setBounds(500,300,100,50);
        l11.setVisible(true);
        l12=new JLabel("学号:");
        l12.setFont(size);
        l12.setBounds(500,400,100,50);
        l12.setVisible(true);
        l21=new JLabel("原姓名或学号:");
        l21.setFont(size);
        l21.setBounds(775,300,250,50);
        l21.setVisible(true);
        l22=new JLabel("新姓名或学号：");
        l22.setFont(size);
        l22.setBounds(775,500,250,50);
        l22.setVisible(true);
        l3=new JLabel("姓名或学号：");
        l3.setFont(size);
        l3.setBounds(775,300,250,50);
        l3.setVisible(true);
        l4=new JLabel("姓名或学号：");
        l4.setFont(size);
        l4.setBounds(775,300,250,50);
        l4.setVisible(true);
        //实例化并设置文本框
        f11=new JTextField(" ");
        f11.setFont(size);
        f11.setBounds(600,300,600,50);
        f11.setVisible(true);
        f12=new JTextField(" ");
        f12.setFont(size);
        f12.setBounds(600,400,600,50);
        f12.setVisible(true);
        f21=new JTextField(" ");
        f21.setFont(size);
        f21.setBounds(600,400,600,50);
        f21.setVisible(true);
        f22=new JTextField(" ");
        f22.setFont(size);
        f22.setBounds(600,600,600,50);
        f22.setVisible(true);
        f3=new JTextField(" ");
        f3.setFont(size);
        f3.setBounds(600,400,600,50);
        f3.setVisible(true);
        f4=new JTextField(" ");
        f4.setFont(size);
        f4.setBounds(600,400,600,50);
        f4.setVisible(true);
        //实例化并设置文本区区
        showMessage=new JTextArea();
        showMessage.setFont(size);
        showMessage.setBounds(600,600,600,250);
        showMessage.setVisible(false);
        //实例化并设置按钮
        b1=new JButton("确认");
        b1.setFont(size);
        b1.setBounds(800,500,200,50);
        b1.setVisible(true);
        b2=new JButton("确认");
        b2.setFont(size);
        b2.setBounds(800,700,200,50);
        b2.setVisible(true);
        b3=new JButton("确认");
        b3.setFont(size);
        b3.setBounds(800,500,200,50);
        b3.setVisible(true);
        b4=new JButton("确认");
        b4.setFont(size);
        b4.setBounds(800,500,200,50);
        b4.setVisible(true);
        b5=new JButton("退出");
        b5.setFont(size);
        b5.setBounds(800,1000,200,50);
        b5.setVisible(false);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage.setText(null);
                showMessage.setVisible(false);
                b5.setVisible(false);
            }
        });
        //将组件添加到对应的面板中，再将面板添加到选项卡格窗中
        p1.add(l11);
        p1.add(l12);
        p1.add(f11);
        p1.add(f12);
        p1.add(b1);
        jTabbedPane.add("添加学生信息",p1);
        p2.add(l21);
        p2.add(l22);
        p2.add(f21);
        p2.add(f22);
        p2.add(b2);
        jTabbedPane.add("修改学生信息",p2);
        p3.add(l3);
        p3.add(f3);
        p3.add(showMessage);
        p3.add(b3);
        p3.add(b5);
        jTabbedPane.add("查询学生信息",p3);
        p4.add(l4);
        p4.add(f4);
        p4.add(b4);
        jTabbedPane.add("删除学生信息",p4);
        //将选项卡格窗添加到底层容器中
        frame.add(jTabbedPane);
        frame.setVisible(true);
        //创建监视器并未相应的组件注册监视器
        AddStu addStu=new AddStu(f11,f12,b1);
        b1.addActionListener(addStu);
        SetStu setStu=new SetStu(f21,f22,b2);
        b2.addActionListener(setStu);
        FindStu findStu=new FindStu(f3,showMessage,b3,b5);
        b3.addActionListener(findStu);
        DeleteStu deleteStu=new DeleteStu(f4,b4);
        b4.addActionListener(deleteStu);
    }
}
