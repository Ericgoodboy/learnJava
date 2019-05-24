package UItest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BorderLayoutTest extends JFrame {
    JPanel contentPanel;
    BorderLayoutTest(){
        setTitle("边框布局");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPanel =new JPanel();
        setBounds(100,1000,450,450);
        contentPanel.setBorder(new EmptyBorder(50,5,5,5));
        contentPanel.setLayout(new BorderLayout(7,7));//设置边框布局
        setContentPane(contentPanel);
        JButton northBt = new JButton("北方");
        contentPanel.add(northBt,BorderLayout.NORTH);
        JButton eastBt = new JButton("东方");
        contentPanel.add(eastBt,BorderLayout.EAST);
        JButton center = new JButton("中间");
        contentPanel.add(center,BorderLayout.CENTER);
        JButton west = new JButton("西方");
        contentPanel.add(west,BorderLayout.WEST);
        JButton south = new JButton("南方");
        contentPanel.add(south,BorderLayout.SOUTH);
    }
    public static void main(String a[]){
        new BorderLayoutTest().setVisible(true);
    }
}
