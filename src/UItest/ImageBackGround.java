package UItest;

import javax.swing.*;

public class ImageBackGround extends JFrame {
    ImageBackGround(){
        JPanel contentPanel;
        setTitle("图片");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPanel =new JPanel();
        setBounds(100,300,450,450);
        JTextField jLabel=new ImageLabel();
        setContentPane(contentPanel);
        contentPanel.add(jLabel);

    }
    public static void main(String a[]){
        new ImageBackGround().setVisible(true);
    }
}
