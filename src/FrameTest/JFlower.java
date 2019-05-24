package FrameTest;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class JFlower extends JPanel implements Runnable{
    double m=0;
    JFlower(){
        new Thread(this).start();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        Ellipse2D.Float ellipse = new Ellipse2D.Float(0,0,70,30);
        Color color =Color.red;
        g2.translate((int)this.getWidth()/2,(int)this.getHeight()/2);
        g2.setColor(color);
        g2.rotate(m);
        int i=0;
        while (i<9){
            g2.rotate(30);
            g2.fill(ellipse);
            i++;
        }

    }

    @Override
    public void run() {
        while (true){
            m+=0.02;
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
