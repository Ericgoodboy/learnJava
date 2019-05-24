package ThreadTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scheduler extends Thread{
    int skip;
    int cycLength;
    public CycThreadList cycThreadList;
    public Map<Integer,ArrayList<ControlThread>> mapForword;
    int nowTime = 0;
    AmazingCanvas amazingCanvas;
    private int sleepTime=50;
    public int leval = 5;
    private int[] speedList = new int[]{150,100,70,60,50,40,30,20,10};
    ArrayList<String> logList=new ArrayList<String>();
    Scheduler(int skip,int cycLength){
        mapForword = new HashMap<Integer,ArrayList<ControlThread>>();
        this.skip = skip;
        this.cycLength = cycLength;
        cycThreadList = new CycThreadList(cycLength);
    }
    public void run(){

        while(true){
            //检查列队和map中是否还有线程
//            System.out.printf("-----time:%6s start------\n",nowTime);
            ControlThread toDoThread = getThreadFromCyclist();
            if(toDoThread == null){
                if(mapForword.size()==0){
                 show();
                 break;
                }else {
                    //循环列队没有线程但mapforward有线程
                    System.out.println("---000");
                    if(mapForword.containsKey(nowTime)){
                        cycThreadList.add(mapForword.get(nowTime));
                        mapForword.remove(nowTime);
                    }
                    addNowTime(toDoThread);
                    continue;
                }
            }
            System.out.println();
            someSeconds(toDoThread,(int)Math.pow(skip,toDoThread.cycIndex+1));
//            System.out.printf("-----time:%6s end------\n",nowTime);

        }
    }

    public void show(){
        System.out.println("所有线程跑完啦，拜拜，再见，晚安，舒服!!!!!!");
    }
    public ControlThread getThreadFromCyclist(){
        ControlThread controlThread = cycThreadList.get();
        if(controlThread == null){
            if(mapForword.containsKey(nowTime)){
                cycThreadList.add(mapForword.get(nowTime));
                mapForword.remove(nowTime);
                return cycThreadList.get();
            }
        }
        return controlThread;
    }
    public void addNowTime(ControlThread toDoThread){
        nowTime+=1;
        amazingCanvas.setTimeString(nowTime);
        try {
            if(toDoThread!=null){
                logList.add(toDoThread.getName());
            }
            this.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("需求商需要维护的话删掉这个，主要是为了收费");
        }
    }

    public void setSleepTime(int sleepTime){
        this.sleepTime = sleepTime;
    }
    public void addSleepTime(){
        int temp = this.leval+1;
        if (temp<=this.speedList.length){
            this.leval = temp;
            this.sleepTime = this.speedList[this.leval-1];
        }
    }
    public void deeSleepTime(){
        int temp = this.leval-1;
        if (temp>0){
            this.leval = temp;
            this.sleepTime = this.speedList[this.leval-1];
        }
    }
    public int someSeconds(ControlThread nowThread,int seconds){
        System.out.println("Scheduler.someSeconds");
        System.out.println("nowThread = [" + nowThread + "], seconds = [" + seconds + "]");
        boolean isConfitOut=false;
        for(int i=0;i<seconds;i++) {
            //检查是否有线程加加进来
            if(nowThread.done){
                break;
            }
            boolean isConfit=false;
            if(mapForword.containsKey(nowTime)){
                isConfit=cycThreadList.add(mapForword.get(nowTime));
                mapForword.remove(nowTime);
            }
            //如果冲突，跳出来
            if(isConfit){
                cycThreadList.placeBack();
                isConfitOut=true;
                break;
            }
            //运行一秒
            nowThread.run();
            //时间加一，线程休眠一定时间
            addNowTime(nowThread);
        }
        //做一些后续的事情，比如冲突处理和看是否结束什么的
        doSomeAfterThat(nowThread,isConfitOut);//还没写
        return 0;
    }
    public void doSomeAfterThat(ControlThread nowThrea,boolean isConfitOut){
        if(nowThrea.done){
            System.out.println("Scheduler.doSomeAfterThat");

        }else {
            if(isConfitOut){
                cycThreadList.append(nowThrea.cycIndex,nowThrea);//返回原有列队
            }
            cycThreadList.append((int)Math.min(nowThrea.cycIndex+1,cycLength-1),nowThrea);
        }
    }
    public boolean checkMap(){
        if(mapForword.containsKey(nowTime)){
            return true;
        }
        return false;
    }
    public void addThread(int deleytime,int length){
        int doTime = nowTime+deleytime+1;
        if (mapForword.containsKey(doTime)){
            mapForword.get(doTime).add(new ControlThread(this.amazingCanvas,length));
        }else{
            ArrayList<ControlThread> temp = new ArrayList<ControlThread>();
            temp.add(new ControlThread(this.amazingCanvas,length));
            mapForword.put(doTime,temp);
        }

    }

}
