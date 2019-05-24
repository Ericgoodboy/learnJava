package FrameTest;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;

public class TestArea extends JFrame {
    TestArea(){
        JComponent j = new JPanel(){
            @Override
            public void paint(Graphics g) {
                //super.paint(g);
                g.clearRect(0,0,200,200);
                Graphics2D g2 = (Graphics2D) g;
                Rectangle r1 = new Rectangle(50,50,75,75);
                Rectangle r2 = new Rectangle(0,0,75,75);
                Area a1 = new Area(r1);
                Area a2 = new Area(r2);
                //a1.add(a2);
                //a1.exclusiveOr(a2);
                //a1.intersect(a2);
                
                g2.fill(a1);
            }
        };
        setContentPane(j);
        setBounds(100,100,200,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestArea();
    }
}
