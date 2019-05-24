package FrameTest;

import javax.swing.*;

public class ShowFrame extends JFrame {
    ShowFrame(){
        JPanel j = new JFlower();

        setContentPane(j);
        setBounds(100,100,500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ShowFrame();
    }
}
