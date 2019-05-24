package ThreadTest;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
//控制面板
public class ControlPanel extends JFrame {
    int skip;
    int interval;
    private Scheduler scheduler=null;
    private JButton addThread;
    private JLabel log;
    private JTextArea threadlength;
    private JTextArea deleyTime;
    private JLabel l1,l2;
    private JLabel lNowTime;
    private JButton addSpeed,minSpeed;
    int nowTime = 0;
    private int placeX=700,placeY=100,width=615,height=353;

    ControlPanel(Scheduler scheduler){
        this.scheduler=scheduler;
        init();
    }
    ControlPanel(){
        init();
    }
    public int getNowTime(){
        return nowTime;
    }

    public void setNowTime(int nowTime) {
        this.nowTime = nowTime;
        this.lNowTime.setText(""+nowTime);
    }

    private void init(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        this.setBounds(placeX,placeY,width,height);
        setContentPane(mainPanel);
        lNowTime = new JLabel(""+nowTime,JLabel.CENTER);
        deleyTime = new JTextArea("10");
        threadlength = new JTextArea("200");
        addThread = new JButton("确认添加");
        log = new JLabel();
        Font font =new Font("ziti",Font.PLAIN,28);

        l1 = new JLabel("延迟");
        l2 = new JLabel("处理时长");
        addSpeed  = new JButton("加速");
        minSpeed = new JButton("减速");
        addSpeed.setBounds(100,100,100,30);
        minSpeed.setBounds(400,100,100,30);
        mainPanel.add(addSpeed);
        mainPanel.add(minSpeed);
        lNowTime.setBounds(200,0,215,30);
        l1.setBounds(20,35,50,30);
        deleyTime.setBounds(80,35,80,30);
        l2.setBounds(200,35,70,30);
        threadlength.setBounds(280,35,120,30);
        addThread.setBounds(480,35,100,30);
        log.setText("this is a log panel");
        log.setBounds(50,150,515,170);
//        log.setBackground(new Color(123,200,139));
//        log.setAlignmentX(20);
        log.setHorizontalAlignment(0);
        log.setVerticalAlignment(0);
        log.setForeground(Color.BLACK);
        deleyTime.setFont(font);
        threadlength.setFont(font);
        addThread.setBorder(BorderFactory.createEtchedBorder());
        ControlPanel that = this;
        addThread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int dely = Integer.parseInt(that.deleyTime.getText());
                    int time = Integer.parseInt(that.threadlength.getText());
                    if (that.scheduler !=null){
                        that.scheduler.addThread(dely,time);
                    }
                }catch (Exception event){
                    System.out.println("woring");
                    JDialog d  = new JDialog(that);
                    Rectangle r=that.getBounds();
                    d.setBounds(r.x+80,r.y+80,r.width-160,r.height-160);
                    d.getContentPane().add(new JLabel("输入错误"));
                    d.setVisible(true);
                }
            }
        });
        log.setFont(new Font("haha",Font.PLAIN,23));

        addSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                that.scheduler.addSleepTime();
                that.log.setText("speed:"+that.scheduler.leval);
            }
        });
        minSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                that.scheduler.deeSleepTime();
                that.log.setText("speed:"+that.scheduler.leval);

            }
        });
        mainPanel.add(l1);
        mainPanel.add(l2);
        mainPanel.add(lNowTime);
        mainPanel.add(deleyTime);
        mainPanel.add(threadlength);
        mainPanel.add(addThread);
        mainPanel.add(log);
        setVisible(true);
    }


    public void setTime(int time){
        lNowTime.setText(""+time);
    }

    private void addThread(){

    }


    public static void main(String[] args) {
        new ControlPanel();
    }



}
