package OperationSystem;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProcessingCanves extends Canvas {

	/**
	 * 
	 */
	private int padding=20;
	private int height = 350;
	private int wight = 600;
	ArrayList<Integer> i;
	private int Ox=20;
	private int Oy=330;
	private ArrayList<Integer> yLable=new ArrayList<Integer>();
	private static final long serialVersionUID = -5137583501070944668L;
	int ySkip;
	public ProcessingCanves(){
		this.setSize(new Dimension(wight,height));
		this.setBackground(new Color(0.8f, 0.5f, 0.3f));
		//Graphics g=this.getGraphics();
		for(int i=0;i<10;i++){
			yLable.add(i);
		}
		ySkip=(int)((height-padding)/(yLable.size()+1));
	}
	public void paint(Graphics g){
		g.setColor(new Color(0.0f, 0.0f, 0.0f));
		drawAies(g);
	}
	public void drawAies(Graphics g){
		int[] alexX=new int[]{Ox,Ox,wight-padding};
		int[] alexY=new int[]{padding,Oy,Oy};
		for(int i=0;i<2;i++){
			g.drawLine(alexX[i], alexY[i],alexX[i+1] , alexY[i+1]);
		}
		int nowX=padding;
		int nowY=Oy-ySkip;
		for(int i=0;i<yLable.size();i++){
			int la=yLable.get(i);
			g.drawString(""+la, Ox-10, nowY);
			nowY-=ySkip;
		}
		
		
	}
	public void repaint(){
		
	}
	public void update(){
		
	}

}
