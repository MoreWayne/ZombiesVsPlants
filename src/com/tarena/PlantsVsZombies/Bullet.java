package com.tarena.PlantsVsZombies;
/*
 * 豌豆射手的炮弹
 */


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends Thread {
	BufferedImage img;//子弹图片
	BufferedImage[] bullet;//子弹动画
	int x,y;
	int width,height;
	
	//创建豌豆射手对象，用于表示子弹的x坐标
	Pea pea;

	//isMove表示子弹线程，
	boolean isMove;
	//传入僵尸。用于判断子弹是否击中僵尸
	Zombies zombie;
	//实例化Garden对象
	Garden garden;
	
	
	public Bullet(){
		try {
			//给子弹赋值
			img=ImageIO.read(new File("images/bullet_01.png"));
			height=img.getHeight();
			width=img.getWidth();
			x=400;
			y=120;
			bullet=new BufferedImage[10];
			for (int i = 0; i < bullet.length; i++) {
				bullet[i]=ImageIO.read(new File("images/bullet_01.png"));
			}
//			garden=g;
			//一开始子弹一直移动
			isMove=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("子弹图片读取错误");
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			try {
				
				if(isMove){
					move();
				}
				if(x>1024){
					isMove=false;
					hit();
				}
				
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("子弹线程中断");
			}
		}
	}
	//子弹一直移动
	int index=0;
	public void move(){
		img=bullet[index];
		index++;
		if(index==10){
			index=0;
		}
		x=x+10;
	}
	//
	public void hit(){
		
		
		x=400;
		y=120;
		isMove=true;
		
		
	}
	
	
	//子弹击中僵尸
	public void hit(Zombies z){
		//取出多个僵尸
		Zombies[] zs=garden.zombies;
		for (int i = 0; i < zs.length; i++) {
			//取出每个僵尸赋值给z
				z=zs[i];
			
			if(x>=z.x&&x<=z.x+z.width&&x>=z.y&&x<=z.y+z.height){
				z.islive=false;
				
				isMove=false;
				garden.count++;
				
			}
			
		}
	}
	

}
