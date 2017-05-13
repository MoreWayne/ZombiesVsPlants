package com.tarena.PlantsVsZombies;

import javax.swing.JFrame;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("PlantVsZombies");
		Garden garden=new Garden();
		frame.add(garden);
		//获取屏幕大小
//		int width=(int)(frame.getToolkit().getScreenSize().width*0.8);
//		int height=(int)(frame.getToolkit().getScreenSize().height*0.8);
		//设置窗体属性
		frame.setSize(1024,768);
		frame.setLocation(0,0);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		garden.action();
	
	}

}
