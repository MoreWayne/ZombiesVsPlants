package com.tarena.PlantsVsZombies;
/*
 * �㶹���ֵ��ڵ�
 */


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends Thread {
	BufferedImage img;//�ӵ�ͼƬ
	BufferedImage[] bullet;//�ӵ�����
	int x,y;
	int width,height;
	
	//�����㶹���ֶ������ڱ�ʾ�ӵ���x����
	Pea pea;

	//isMove��ʾ�ӵ��̣߳�
	boolean isMove;
	//���뽩ʬ�������ж��ӵ��Ƿ���н�ʬ
	Zombies zombie;
	//ʵ����Garden����
	Garden garden;
	
	
	public Bullet(){
		try {
			//���ӵ���ֵ
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
			//һ��ʼ�ӵ�һֱ�ƶ�
			isMove=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ӵ�ͼƬ��ȡ����");
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
				System.out.println("�ӵ��߳��ж�");
			}
		}
	}
	//�ӵ�һֱ�ƶ�
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
	
	
	//�ӵ����н�ʬ
	public void hit(Zombies z){
		//ȡ�������ʬ
		Zombies[] zs=garden.zombies;
		for (int i = 0; i < zs.length; i++) {
			//ȡ��ÿ����ʬ��ֵ��z
				z=zs[i];
			
			if(x>=z.x&&x<=z.x+z.width&&x>=z.y&&x<=z.y+z.height){
				z.islive=false;
				
				isMove=false;
				garden.count++;
				
			}
			
		}
	}
	

}
