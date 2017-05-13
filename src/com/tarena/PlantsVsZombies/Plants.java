package com.tarena.PlantsVsZombies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plants extends Thread{
	//读入向日葵图片
	BufferedImage img;
	//向日葵动画
	BufferedImage[] plants;
	//向日葵坐标，大小
	int x,y;
	int width,height;
	public Plants(){
		
		try {
			//给向日葵赋值
			img=ImageIO.read(new File("images/sun_flower1.png"));
			
			x=200;
			y=100;
			width=100;
			height=100;
			plants=new BufferedImage[18];
			for (int i = 0; i < plants.length; i++) {
				plants[i]=ImageIO.read(new File("images/xiangrikui/plant_xiangrikui_"+i+".png"));
			}
					
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("向日葵图片读取错误");
		}
		
		
	}
	
	int index=0;
	@Override
	//向日葵一直的移动
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		try {
			
			img=plants[index];
			index++;
			if(index==17){
				index=0;
			}
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	
	
}
