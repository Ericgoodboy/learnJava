package FileControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TestFrame1 extends JFrame {
    JPanel mainPanel;
    JButton bt2;
    JLabel fileLabel;
    TestFrame1(){
        mainPanel=new JPanel();
        mainPanel.setSize(new Dimension(300,400));
        bt2 = new JButton("bt1");
        fileLabel = new JLabel("file");
        mainPanel.add(bt2);
        mainPanel.add(fileLabel);
        TestFrame1 that =this;
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                that.do_button_Click();
            }
        });
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }
    public void do_button_Click(){
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(TestFrame1.this);
        File file = chooser.getSelectedFile();
        fileLabel.setText(file.getName());
        try (FileReader in = new FileReader(file)) {
            char[] a=new char[200];
            System.out.println(""+in.getEncoding());

            in.read(a);
            String s=new String(a);
            System.out.println(s);

        }catch (Exception e){

        }
    }
    public static void main(String a[]){
        new TestFrame1();
    }
}
