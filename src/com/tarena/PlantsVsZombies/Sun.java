package com.tarena.PlantsVsZombies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/*
 * 
 * ����̫���������ʧ������������50
 * 
 */
public class Sun extends Thread{
	BufferedImage sun_img;
	int x,y;
	int width,height;
	int step;
	//�ж�̫���Ƿ񱻵������Ϊtrueʱ��ʾ���̫������
	
	boolean isExists; //Ϊtrue �Ǳ�ʾ̫�����ڣ�һֱ���䣬false ��ʾ̫������׽
	public Sun(){
		try {
			sun_img=ImageIO.read(new File("images/sun.png"));
			
			
			width=sun_img.getWidth();
			height=sun_img.getHeight();
			Random r=new Random();
			y=-height;
			x=r.nextInt(1024-width-200);
			//̫����������ٶ�
			step=r.nextInt(10)+1;
			isExists=true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ͼƬ��ȡ����");
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
				System.out.println("̫���߳��ж�");
			}
		}
	}
	//̫�������԰ ���½���
	public void goOut(){
		Random r=new Random();
		y=-height;
		x=r.nextInt(1024-width-200);
		//̫����������ٶ�
		step=r.nextInt(10)+1;
		isExists=true;
		
	}
	//ʵ��̫�����ƶ�
	public void move(){
		y+=step;
		
	}
	
	

}
