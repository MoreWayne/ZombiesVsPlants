package com.tarena.PlantsVsZombies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/*
 * 
 * 下落太阳，点击消失，计数器增加50
 * 
 */
public class Sun extends Thread{
	BufferedImage sun_img;
	int x,y;
	int width,height;
	int step;
	//判断太阳是否被点击到，为true时表示点击太阳增加
	
	boolean isExists; //为true 是表示太阳存在，一直下落，false 表示太阳被捕捉
	public Sun(){
		try {
			sun_img=ImageIO.read(new File("images/sun.png"));
			
			
			width=sun_img.getWidth();
			height=sun_img.getHeight();
			Random r=new Random();
			y=-height;
			x=r.nextInt(1024-width-200);
			//太阳下落随机速度
			step=r.nextInt(10)+1;
			isExists=true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("图片读取有误");
		}
	}
	
	public void run(){
		while(true){
			
//			System.out.println(y);
			
			if(isExists){
				move();
			}else{
				goOut();
			}
						
			
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("太阳线程中断");
			}
		}
	}
	//太阳落出花园 重新进入
	public void goOut(){
		Random r=new Random();
		y=-height;
		x=r.nextInt(1024-width-200);
		//太阳下落随机速度
		step=r.nextInt(10)+1;
		isExists=true;
		
	}
	//实现太阳的移动
	public void move(){
		y+=step;
		
	}
	
	

}
