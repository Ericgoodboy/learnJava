package OperationSystem;

import java.util.ArrayList;

public class MyList<T extends MyThread> {
	private ArrayList<T> list=new ArrayList<T>();
	private int ListProi;
	public MyList(int ListProi){
		this.ListProi=ListProi;
	}
	public void addList(ArrayList<T> list){
		for(T t:list){
			this.list.add(t);
			t.setLevel(ListProi);
		}
	}
	public void append(T t){
		this.list.add(t);
		t.setLevel(ListProi);
	}
	public T getFirst(){//��ȡ��ǰ�ȼ��ĵ�һ������
		if(list.size()==0){
			return null;
		}
		T t = list.get(0);
		list.remove(t);
		return t;
	}
	
}
