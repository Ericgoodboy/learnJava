package ThreadTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestPanel extends JFrame {

    TestPanel() throws InterruptedException {
        AmazingCanvas amazingCanvas = new AmazingCanvas();
        Dimension dimension=amazingCanvas.getPreferredSize();
        setBounds(100,100,dimension.width,dimension.height);
        JPanel mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setBounds(0,0,dimension.width,dimension.height);
        mainPanel.setLayout(null);
        mainPanel.add(amazingCanvas);
        amazingCanvas.setBounds(0,0,dimension.width,dimension.height);
        setVisible(true);
        
//        this.notifyAll();
    }
    public static void main(String[] args)throws InterruptedException {
        new TestPanel();
    }
}
