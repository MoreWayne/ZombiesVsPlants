package com.tarena.PlantsVsZombies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
/*
 * ��ʬ��
 * ��С��λ�ã��ٶȣ�
 * 
 */
public class Zombies extends Thread{
	//��ʬͼƬ
	BufferedImage img;
	//��ʬ����
	BufferedImage[] images;
	int x,y;
	int width,height;
	int step;//��ʬ���ٶ�
	boolean islive;//true ��ʾ��ʬ�����ƶ���false ��ʾ������
	//����һ���������飬Ŀ�����ý�ʬ���ֵ�ʱ������տ���ͬһ�ܵ���
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
			
			//ֻ��һ�ֽ�ʬ
			for(int i=0;i<images.length;i++){
				images[i]=ImageIO.read(new File("images/zombies/zombie01_"+i+".png"));
			}
			
			islive=true;
			
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("��ʬͼƬ��ȡ����");
		}
		
	}
	
	int index=0; //��ʾ��������zombies�±�
	
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
	
	
	//��ʬһֱ�ƶ�
	public void move(){
		x-=step;

//		System.out.println(x);
		img = images[index];
		index++;
		if(index == 22){
			index = 0;
		}
	}
	//��ʬ��ȥ�����½���
	public void goOut(){
		Random r=new Random();
		x=1024;
		y=a[r.nextInt(5)];
		step=r.nextInt(3)+1;
		islive=true;
	}
	
	
	
	
}
