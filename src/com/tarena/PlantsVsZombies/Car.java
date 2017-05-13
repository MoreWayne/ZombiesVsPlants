package com.tarena.PlantsVsZombies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Car extends Thread {
	int x,y;
	int width,height;
	BufferedImage img;
	BufferedImage[] cars;//小车移动动画
	Zombies zombie;//
	public Car(){
		try {
			//给小车赋值
			img=ImageIO.read(new File("images/LawnMower.png"));
			x=100;
			y=100;
			width=100;
			height=100;
			cars=new BufferedImage[10];
			for (int i = 0; i < cars.length; i++) {
				cars[i]=ImageIO.read(new File("images/LawnMower.png"));
			}
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("小车图片读取错误");
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(zombie.x<200){
			move();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	int index=0;
	//小车移动
	public void move(){
		x+=10;
		img=cars[index];
		index++;
		if(index==10){
			index=0;
		}
		
	}
	
	
}
