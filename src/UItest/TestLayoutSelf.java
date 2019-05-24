package UItest;

import javax.swing.*;

public class TestLayoutSelf extends JFrame {
    public TestLayoutSelf(){
        JPanel panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(new CircleLayout());
        panel.add(new JButton("1"));
        panel.add(new JButton("'2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        this.setBounds(100,100,100,100);
    }
    public static void main(String a[]){
        new TestLayoutSelf().setVisible(true);
    }
}
