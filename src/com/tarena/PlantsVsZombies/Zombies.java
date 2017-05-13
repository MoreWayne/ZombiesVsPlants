package com.tarena.PlantsVsZombies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
/*
 * 僵尸类
 * 大小，位置，速度，
 * 
 */
public class Zombies extends Thread{
	//僵尸图片
	BufferedImage img;
	//僵尸动画
	BufferedImage[] images;
	int x,y;
	int width,height;
	int step;//僵尸的速度
	boolean islive;//true 表示僵尸正在移动，false 表示被打死
	//定义一个整型数组，目的是让僵尸出现的时候和向日葵在同一跑道内
	int[] a={60,210,360,510,660};
	
	
	
	public Zombies(){
		try{
			
			img = ImageIO.read(new File("images/zombies/zombie01_0.png"));
			width = img.getWidth();
			height = img.getHeight();
			
			Random r=new Random();
			x=1024;
			y=a[r.nextInt(5)];
			
			step=r.nextInt(3)+1;
			
			
			images=new BufferedImage[22];
			
			//只有一种僵尸
			for(int i=0;i<images.length;i++){
				images[i]=ImageIO.read(new File("images/zombies/zombie01_"+i+".png"));
			}
			
			islive=true;
			
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("僵尸图片读取有误");
		}
		
	}
	
	int index=0; //表示访问数组zombies下标
	
	public void run(){
		while(true){
			if(islive){
				move();
			}
			if(x<-200){
				
				goOut();
			}
			
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	//僵尸一直移动
	public void move(){
		x-=step;

//		System.out.println(x);
		img = images[index];
		index++;
		if(index == 22){
			index = 0;
		}
	}
	//僵尸出去后，重新进入
	public void goOut(){
		Random r=new Random();
		x=1024;
		y=a[r.nextInt(5)];
		step=r.nextInt(3)+1;
		islive=true;
	}
	
	
	
	
}
