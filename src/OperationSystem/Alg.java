package OperationSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Alg {
	private CycLists cycLists;
	private int nowTime;
	private int nLevel,nSkip;
	private Map threadMap=new HashMap<Integer,ArrayList<MyThread>>();
	public void alg(){
		init();
		while(true){
			MyThread my = cycLists.nextThread();
			int time = cycLists.getRunTime();
			boolean done=false;
			for(int i = 0;i<time;i++){
				nowTime+=1;
				if (threadMap.containsKey(nowTime)){//�жϴ��
					if (cycLists.interupt((ArrayList<MyThread>)threadMap.get(nowTime))){
						threadMap.remove(nowTime);
						nowTime-=1;
						break;
					}
					else{
						threadMap.remove(nowTime);
					}
				}
				if(!my.run()){
					done=true;
					break;
				}
			}
			if(!done){
				
			}
		}
	}
	public void init(){
		this.cycLists=new CycLists(nLevel,nSkip);
		nowTime=0;
	}
	public void addThread(MyThread t){
		
	}
}
