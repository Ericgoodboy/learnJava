package OperationSystem.test;

import javax.swing.JFrame;

import OperationSystem.ProcessingCanves;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcessingCanves pc = new ProcessingCanves();
		JFrame mainFrame = new JFrame();
		mainFrame.add(pc);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

}
