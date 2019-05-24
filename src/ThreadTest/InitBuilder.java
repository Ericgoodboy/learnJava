package ThreadTest;

import java.util.ArrayList;
import java.util.Map;

//初始化参数做一些测试的初始化工作
public class InitBuilder {
    int[] startTimes=new int[]{1,1,2,5,100,200};
    int[] lastForLengths=new int[]{100,100,100,100,100,100};
    InitBuilder(int[] startTimes,int[] lastForLengths){

        this.startTimes=startTimes;
        this.lastForLengths = lastForLengths;

    }
    InitBuilder(){

    }
    void initTestSet(AmazingCanvas amazingCanvas,Map<Integer, ArrayList<ControlThread>> mapForword){
        for(int i=0;i<Math.min(startTimes.length,lastForLengths.length);i++){
            add(amazingCanvas,mapForword,startTimes[i],lastForLengths[i]);
        }
    }

    //添加线程到时间轴
    private void add(AmazingCanvas amazingCanvas,Map<Integer, ArrayList<ControlThread>> mapForword,int startTime,int lastForLength){
        ControlThread controlThread =new ControlThread(amazingCanvas,lastForLength);
        if(mapForword.containsKey(startTime)){
            mapForword.get(startTime).add(controlThread);
        }else {
            ArrayList<ControlThread> temp =new ArrayList<ControlThread>() ;
            temp.add(controlThread);
            mapForword.put(startTime,temp);
        }
    }


}
