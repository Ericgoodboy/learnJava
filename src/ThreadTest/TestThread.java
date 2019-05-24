package ThreadTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestThread extends JFrame {
    JTextArea textArea1,textArea2;
    JButton button1,button2;
    TestThread(){
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        JPanel contentPanel = new JPanel();
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
        contentPanel.add(button1);
        contentPanel.add(button2);
        contentPanel.add(textArea1);
        contentPanel.add(textArea2);
        button1.setText("单线程");
        button2.setText("多线程");
        textArea1.setAutoscrolls(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<5;i++){
                    sb.append("book\n");
                }
                for(int i = 0;i<5;i++){
                    sb.append("note\n");
                }
                textArea1.setText(sb.toString());
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final StringBuilder sb = new StringBuilder();
                for(int i=0;i<5;i++){
                    new Thread(){
                        public void run(){
                            sb.append("book\n");
                        }
                    }.start();

                }
                for(int i = 0;i<5;i++){
                    new Thread(){
                        public void run(){
                            sb.append("note\n");
                        }
                    }.start();
                }
                textArea2.setText(sb.toString());
            }
        });
        setBounds(100,100,200,200);
        button1.setBounds(0,0,100,30);
        button2.setBounds(100,0,100,30);
        textArea1.setBounds(0,30,100,170);
        textArea2.setBounds(100,30,100,170);
        this.setVisible(true);
    }
    public static void main(String a[]){
        new TestThread();
    }


}
