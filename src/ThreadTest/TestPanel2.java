package ThreadTest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class TestPanel2  extends JFrame  {
    TestPanel2() throws InterruptedException {
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
        Scheduler scheduler =new Scheduler(10,3);
        scheduler.amazingCanvas = amazingCanvas;
        InitBuilder initBuilder =new InitBuilder();
        initBuilder.initTestSet(amazingCanvas,scheduler.mapForword);
        //Set<Integer> a=scheduler.mapForword.keySet();
        ControlPanel controlPanel = new ControlPanel(scheduler);
        Thread.sleep(1000);
        scheduler.run();

    }
    public static void main(String[] args){
        System.out.println("-----------------1");
        try {
            new TestPanel2();
        } catch (InterruptedException e) {
            System.out.println("-----------------1");
            e.printStackTrace();
        }
    }
}
