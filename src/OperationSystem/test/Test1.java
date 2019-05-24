package OperationSystem.test;

import java.awt.Canvas;
import java.lang.reflect.Method;

import OperationSystem.MyThread;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyThread a = new MyThread(0, 0, null);
//		a.run();
		Class<?> b =Canvas.class;
		Method[] m=b.getDeclaredMethods();
		for(Method me : m){
			System.out.println(me);
		}
	}

}
