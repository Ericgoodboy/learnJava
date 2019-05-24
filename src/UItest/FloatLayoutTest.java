package UItest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FloatLayoutTest extends JFrame {
    JPanel contentPanel;
    FloatLayoutTest(){
        setTitle("流布局");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPanel =new JPanel();
        setBounds(100,300,450,450);
        contentPanel.setBorder(new EmptyBorder(50,5,5,5));
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER,7,7));//设置边框布局
        setContentPane(contentPanel);
        JButton northBt = new JButton("北方");
        contentPanel.add(northBt);
        JButton eastBt = new JButton("东方");
        contentPanel.add(eastBt);
        JButton center = new JButton("中间");
        contentPanel.add(center);
        JButton west = new JButton("西方");
        contentPanel.add(west);
        JButton south = new JButton("南方");
        contentPanel.add(south);


    }
    public static void main(String a[]){
        new FloatLayoutTest().setVisible(true);
    }
}
