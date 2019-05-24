package FrameTest;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class TestGradientFrame extends JFrame {
    TestGradientFrame(){
        JPanel j = new JPanel(){
            @Override
            public void paint(Graphics g){
                Graphics2D g2 = (Graphics2D) g;
                Rectangle2D.Float rect = new Rectangle2D.Float(0,0,260,240);
                GradientPaint paint = new GradientPaint(20,20,Color.BLUE,260,260,Color.red);
                g2.setPaint(paint);
                g2.fill(rect);

            }
        };
        setContentPane(j);
        setBounds(100,100,300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestGradientFrame();
    }
}
