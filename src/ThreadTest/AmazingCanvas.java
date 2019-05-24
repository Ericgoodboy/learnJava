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
    public void paint(Graphics g){
        if (isFirst){
            paintHeader(g);
            isFirst = true;
        }
        printTime(g);
        if(mode==-1){
            paintArray(g);
        }else {
            ThreadInfo threadInfo = map.get(mode);
            paintItem(g,threadInfo.yPlace,threadInfo.process,threadInfo.name);
        }
    }
    private void printTime(Graphics g){
        g.clearRect(0,0,canvasWidth,headingTop);
        g.setColor(Color.red);
        g.drawString(timeString,260,10);
    }
    private void paintHeader(Graphics g){
        g.setColor(Color.red);
        g.drawLine(0,headingTop,canvasWidth,headingTop);
        g.drawString(titleString,200,10);
    }
    public void setProcess(int threadId,double process){
        map.get(threadId).runOnce(process);
        mode=threadId;
        repaint();
    }
    public void paintArray(Graphics g){
        int mapLength = map.size()+1;
        Set<Integer> keys = map.keySet();
        int skip = (canvesHeight-headingTop-boxHeight-30)/mapLength;
        g.clearRect(0,headingTop+1,canvasWidth,canvesHeight);
        int yPlace=skip+headingTop;
        for(int key:keys){
            ThreadInfo threadInfo = map.get(key);
            threadInfo.yPlace = yPlace;
            paintItem(g,yPlace,threadInfo.process,threadInfo.name);
            yPlace+=skip;
        }
    }
    public void update(Graphics g){
        paint(g);
    }
    private void paintItem(Graphics g,int yPlace,double processing,String name){
        int xPlace = (int)((canvasWidth-boxWidth)*processing);
        g.clearRect(0,yPlace-(int)(boxHeight/2),canvasWidth,boxHeight+1);
        g.setColor(Color.red);
        g.drawLine(0,yPlace,xPlace,yPlace);
        int demox[]=new int[]{xPlace,xPlace,xPlace+boxWidth,xPlace};
        int demoy[]=new int[]{yPlace-(int)(boxHeight/2),yPlace+(int)(boxHeight/2),yPlace,yPlace-(int)(boxHeight/2)};
        g.drawPolygon(demox,demoy,demox.length);
        g.setColor(Color.BLACK);
        g.drawString(name,xPlace+3,yPlace+5);
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
