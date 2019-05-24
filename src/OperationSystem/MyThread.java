package OperationSystem;

public class MyThread{
	int threadNum;
	int threadLength;
	String threadName;
	int startTime;
	private int nowPlace=0;
	private int level;
	public MyThread(int threadNum,int threadLength,String threadName,int startTime){
		level=0;
		this.threadNum = threadNum;
		this.threadLength = threadLength;
		this.threadName =threadName;
		this.startTime=startTime;
	}
	public boolean run(){
		nowPlace+=1;
		if(nowPlace<=threadLength){
			return true;
		}
		return false;
	}
	public int getLevel(){
		return level;
	}
	public void setLevel(int level){
		this.level = level;
	}
	
}
