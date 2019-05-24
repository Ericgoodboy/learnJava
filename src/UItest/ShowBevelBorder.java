package UItest;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ShowBevelBorder extends JPanel {
    JLabel label = new JLabel("凹陷的立体边框");
    ShowBevelBorder(){
        this.setSize(new Dimension(500,500));

        label.setBounds(300,180,120,30);//设置标签的位置和大小
        label.setHorizontalAlignment(SwingConstants.CENTER);//设置文字居中
        label.setBorder(new BevelBorder(BevelBorder.LOWERED,Color.BLACK,Color.red,Color.BLUE,Color.red));//设置标签边框
        this.add(label);

    }
    public static void main(String a[]){
        JPanel jp1=new ShowBevelBorder();
        JFrame jf=new JFrame();
        jf.add(jp1);
        jf.pack();
        jf.setVisible(true);
    }
}
