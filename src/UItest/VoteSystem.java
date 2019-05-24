package UItest;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class VoteSystem extends JFrame {
    JCheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    JLabel label1,label2,label3,label4;
    JProgressBar progressBar1,progressBar2,progressBar3,progressBar4;
    JButton vote,flash;
    JPanel contentPanel;
    public VoteSystem(){
        Init();
        place();
        setVisible(true);
    }
    public void Init(){
        checkBox1 = new JCheckBox("java");
        checkBox2 = new JCheckBox("python");
        checkBox3 = new JCheckBox("node");
        checkBox4 = new JCheckBox("Ruby");
        label1 = new JLabel("0");
        label2 = new JLabel("0");
        label3 = new JLabel("0");
        label4 = new JLabel("0");
        progressBar1 = new JProgressBar();
        progressBar2 = new JProgressBar();
        progressBar3 = new JProgressBar();
        progressBar4 = new JProgressBar();
        vote = new JButton("投票");
        flash = new JButton("刷新");
        contentPanel = new JPanel();
        setResizable(false);

    }
    public void place(){
        this.setContentPane(contentPanel);
        JPanel showPanel = new JPanel();
        JPanel confrimPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.add(showPanel);
        setBounds(100,100,300,210);
        showPanel.setBounds(0,0,280,130);
        contentPanel.add(confrimPanel);
        confrimPanel.setBounds(0,130,280,50);
        showPanel.setPreferredSize(new Dimension(280,300));
        confrimPanel.setPreferredSize(new Dimension(280,50));
        showPanel.setBorder(BorderFactory.createTitledBorder("选择框"));
        confrimPanel.setBorder(BorderFactory.createTitledBorder("确认框"));
        Border a=BorderFactory.createEmptyBorder();
        //整体布局完毕
//        Border a=confrimPanel.getBorder();
//
//        System.out.println(a.getBorderInsets(confrimPanel));
        showPanel.setLayout(null);
        showPanel.add(checkBox1);
        checkBox1.setBounds(5,15,80,25);
        showPanel.add(checkBox2);
        checkBox2.setBounds(5,40,80,25);
        showPanel.add(checkBox3);
        checkBox3.setBounds(5,65,80,25);
        showPanel.add(checkBox4);
        checkBox4.setBounds(5,90,80,25);


        showPanel.add(progressBar1);
        progressBar1.setBounds(85,17,120,20);
        progressBar1.setString("25%");
        progressBar1.setStringPainted(true);
        progressBar1.setValue(25);
        showPanel.add(progressBar2);
        progressBar2.setBounds(85,17+25*1,120,20);
        progressBar2.setString("0%");
        progressBar2.setStringPainted(true);
        progressBar2.setValue(25);
        showPanel.add(progressBar3);
        progressBar3.setBounds(85,17+25*2,120,20);
        progressBar3.setString("0%");
        progressBar3.setStringPainted(true);
        progressBar3.setValue(25);
        showPanel.add(progressBar4);
        progressBar4.setBounds(85,17+25*3,120,20);
        progressBar4.setString("0%");
        progressBar4.setStringPainted(true);
        progressBar4.setValue(25);
        //processBar deplayee completed!!!

        placeLabel(showPanel,label1,1);
        placeLabel(showPanel,label2,2);
        placeLabel(showPanel,label3,3);
        placeLabel(showPanel,label4,4);
    }
    public void placeLabel(JPanel p,JLabel l,int index){
        p.add(l);
        l.setBounds(230,17+25*index-25,80,20);
        l.setText("0票");
    }


    public static void main(String a[]){
        new VoteSystem();
    }

}
