package OperationSystem;

import java.util.ArrayList;

public class CycLists {
	private int nLevel;
	private int nSkip;
	private ArrayList<MyList<MyThread>> cycList;//��ת�ж�
	private int nowLevel=0;//��ǰ����ת�ȼ�
	public CycLists(int nLevel,int nSkip){
		this.nLevel=nLevel;
		this.nSkip=nSkip;
		cycList=new ArrayList<MyList<MyThread>>();
		for(int i=0;i<this.nLevel;i++){
			cycList.add(new MyList<MyThread>(i));
		}
	}
	public int getRunTime(){
		return (int) Math.pow(nSkip,nowLevel+1 );
	}
	public MyThread nextThread(){
		MyThread t=cycList.get(nowLevel).getFirst();
		if(t!=null){
			return t;
		}else if (this.nLevel==this.nowLevel+1){
			return null;
		}else{
			this.nowLevel+=1;
			return this.nextThread();
		}
	}
	public void addToNextList(MyThread t){
		int tLevel = t.getLevel();
		if (tLevel!=this.nLevel-1){
			t.setLevel(tLevel+1);
		}
		cycList.get(t.getLevel()).append(t);
	}
	public boolean interupt(ArrayList<MyThread> newThreads){
		cycList.get(0).addList(newThreads);
		if(this.nowLevel==0){
			return false;
		}else{
			this.nowLevel=0;
			return true;
		}
	}
	public int getNowLevel(){
		return nowLevel;
	}
}
