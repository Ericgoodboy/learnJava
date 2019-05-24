package ThreadTest;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AmazingCanvas extends Canvas {
    Map<Integer,ThreadInfo> map;
    int boxWidth=20;
    int boxHeight=20;
    int headingTop = 40;
    int canvasWidth = 600;
    int canvesHeight = 500;
    private String titleString="-----";
    private String timeString="0";
    private int mode=-1;
    public double proc=0.0;
    private class ThreadInfo{
        private double process;
        private String name;
        public int yPlace;
        ThreadInfo(String name){
            this.process = 0;
            this.name = name;
        }

        public double getProcess() {
            return process;
        }
        public String getName(){
            return name;
        }
        public void runOnce(double process){
            this.process=process;
        }
    }
    AmazingCanvas(){
        map=new HashMap<Integer, ThreadInfo>();
        setPreferredSize(new Dimension(canvasWidth,canvesHeight));
    }
    public void  setTimeString(int time){
        timeString = "time:"+time;
    }
    private boolean isFirst = true;

    public void setProcess(int threadId,double process){
        map.get(threadId).runOnce(process);
        mode=threadId;
        repaint();
    }

    public void update(Graphics g){
        paint(g);
    }

    public void removeThread(int threadId){
        map.remove(threadId);
        synchronized (this){
            mode=-1;
            this.repaint();
        }

    }
    public void addThread(int threadId){
        map.put(threadId,new ThreadInfo(""+threadId));
        synchronized (this){
            mode=-1;
            this.repaint();
        }
    }

}
