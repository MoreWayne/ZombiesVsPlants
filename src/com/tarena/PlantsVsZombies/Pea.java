package com.tarena.PlantsVsZombies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * �㶹����
 * 1������λ��
 * 2.��̬ͼƬ
 * 3.�����ڵ�
 * 
 */
public class Pea extends Thread{
	int x,y;
	int width,height;
	BufferedImage img;
	BufferedImage[] peas;
	
	public Pea(){
		try {
			img=ImageIO.read(new File("images/plant_wandousheshou/plant_wandousheshou_1.png"));
			x=300;
			y=100;
			width=100;
			height=100;
			peas=new BufferedImage[13];
			for (int i = 0; i < peas.length; i++) {
				peas[i]=ImageIO.read(new File("images/plant_wandousheshou/plant_wandousheshou_"+(i+1)+".png"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�㶹����ͼƬ��ȡ����");
		}
	}
	
	int index=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			img=peas[index];
			index++;
			if(index==12){
				index=0;
			}
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�㶹�߳��ж�");
			}
		}
	}
	

}
