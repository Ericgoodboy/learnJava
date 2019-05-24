package FrameTest;

import javax.swing.*;
import java.awt.*;

public class BallTrash extends JPanel implements Runnable {
    int x1 = 0;
    int y1 = 60;
    int x2 = 326 -30;
    int y2 = 60;
    int width = 30;
    int height = 30;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(x1,y1,width,height);
        g.setColor(Color.blue);
        g.fillOval(x2,y2,width,height);

    }

    @Override
    public void run() {
        boolean f1=true,f2=true;
        while (true){
            if (x1+width>x2+1){
                x1+=5;
                width=width-10;
            }
        }
    }
}
