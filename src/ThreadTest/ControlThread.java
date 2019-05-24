package ThreadTest;

import java.util.Random;

public class ControlThread extends Thread{
    static int  genLength=1;
    private int myId;
    private AmazingCanvas amazingCanvas;
    private double process=0.0;
    private double speed=0;
    public int cycIndex;
    public int exeTime;

    ControlThread(AmazingCanvas amazingCanvas,int plantTime){
        this.amazingCanvas = amazingCanvas;
        this.myId=genID();
        this.speed = 1.0/plantTime;
        this.amazingCanvas.addThread(myId);
    }
    private synchronized int genID(){
        Random r =new Random();
        return (++genLength)*3+r.nextInt(2);
    }
    public boolean done=false;
    @Override
    public void run() {
        System.out.println("runonce"+this);
        if (process<=1){

                doTask();
        }
        if (process>1){
            doneTask();
        }
    }
    public void doTask(){
        process+=speed;
        this.amazingCanvas.setProcess(this.myId,process);
    }
    public void  doneTask(){
        amazingCanvas.removeThread(this.myId);
        done = true;

    }



}
