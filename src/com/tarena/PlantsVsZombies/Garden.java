package com.tarena.PlantsVsZombies;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * ��԰���У�����ͼ�ƶ��Ľ�ʬ�������̫�������տ����㶹���֣����ݻ�
 * 
 * 
 */
public class Garden extends JPanel{
	//��ʼ����ͼƬ
	BufferedImage bg1;
	//��ʼ��ϷͼƬ
	BufferedImage start;
	//��԰����ͼƬ
	BufferedImage bg2;
	
	//�ж��Ƿ�����ʼ��Ϸ
	boolean isStart;
	//����mouseX��mouseYΪ�������
	int mouseX,mouseY;
	//����Zombie����
	Zombies[] zombies;
	//̫��
	Sun[] suns;
	Sun sun;
	//����5����ͬ�����տ�
	Plants[] plants;
	//����5���㶹����
	Pea[] peas;
	Pea p;
	//�ӵ���
	Bullet[] bullets;
	Bullet bullet;
	//С��
	Car[] cars;
	

	
	
	
	
	public Garden(){
		try {
			//��ȡ��ʼ����ͼƬ����Ϸ����ͼƬ
			bg1=ImageIO.read(new File("images/login.png"));
			start=ImageIO.read(new File("images/start_leave.png"));
			//���Ƿ�ʼ��Ϸ��ֵ
			isStart=false;
			
			
			//��ȡ��Ϸ����
			bg2=ImageIO.read(new File("images/background1.png"));
			
			
			//��ȡ���տ�
			plants=new Plants[5];
			for (int i = 0; i < plants.length; i++) {
				plants[i]= new Plants();
				plants[i].start();
			}
			
			//��Zombie��ֵ
			
			
			zombies=new Zombies[20];
			for (int i = 0; i < zombies.length; i++) {
				zombies[i]=new Zombies();
				zombies[i].start();
			}
			
			
			
			//��̫����ֵ
			suns=new Sun[5];
			for(int i=0;i<suns.length;i++){
				suns[i]=new Sun();
				suns[i].start();
			}
					
			//���㶹���ָ�ֵ
			peas=new Pea[5];
			for (int i = 0; i < peas.length; i++) {
				peas[i]=new Pea();
				peas[i].start();
			}
			
			//���ӵ���ֵ
			bullets=new Bullet[5];
			for (int i = 0; i < bullets.length; i++) {
				bullets[i]=new Bullet();
				bullets[i].start();
			}
			//��С����ֵ
			
			
			cars=new Car[5];
			for(int i=0;i<5;i++){
				cars[i]=new Car();
				cars[i].start();
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ͼƬ��ȡ����");
		}
		
	}
	
	
	
	public void paint(Graphics g){
		//������ʼ��Ϸ����
		g.drawImage(bg1, 0, 0, 1024, 768, null);
		g.drawImage(start,512,384,start.getWidth(),start.getHeight(),null);
		//�ж��Ƿ�����ʼ��Ϸ�����������򻭳���԰
		if(isStart){
			//������԰
			g.drawImage(bg2, 0, 0, 1024,768, null);
			
			//������ʬ
			for (int i = 0; i < zombies.length; i++) {
				g.drawImage(zombies[i].img, zombies[i].x, zombies[i].y, zombies[i].width, zombies[i].height, null);

			}
			//���������ͬ�����տ�����
			for (int i = 0; i < plants.length; i++) {
				g.drawImage(plants[i].img, plants[i].x, plants[i].y+(i*150), plants[i].width, plants[i].height, null);
			}
			
			//�����㶹����
			for (int i = 0; i < peas.length; i++) {
				g.drawImage(peas[i].img, peas[i].x, peas[i].y+(i*150), peas[i].width, peas[i].height, null);
			}
			//����bullets�е������ӵ�
			for (int i = 0; i < bullets.length; i++) {
				g.drawImage(bullets[i].img,bullets[i].x,bullets[i].y+(i*150),bullets[i].width,bullets[i].height,null);
			}
			//����С��
			for (int i = 0; i < cars.length; i++) {
				g.drawImage(cars[i].img, cars[i].x, cars[i].y+(i*150), cars[i].width, cars[i].height, null);
			}
			//����̫��
			for(int i=0;i<suns.length;i++){
				g.drawImage(suns[i].sun_img, suns[i].x, suns[i].y, suns[i].width, suns[i].height, null);
				}
			g.setColor(new Color(0,255,255));
			g.setFont(new Font("����",Font.BOLD,20));
			g.drawString("�Ѳ�׽̫����"+count, 50, 80);
		
		}
	
	}
		
		
		

	
	
	

	
	
	public void action(){
		
		MouseAdapter mouse=new MouseAdapter(){
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//�ж��Ƿ�����ʼ��Ϸ
				if(mouseX > 512 && mouseX < 512+start.getWidth() &&mouseY>384 &&mouseY<384+start.getHeight()){
					isStart=true;
				}
				//�������̫����
				catchSun();
				
//				Bullet bullet=new Bullet(Garden.this);
//				
//				bullet.x=p.x+p.width;
//				bullet.y=p.y;
//				bullet.p=new Point(bullet.x,bullet.y);
//				bullet.start();
//				bullets.add(bullet);
				
			}
			@Override 
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				mouseX=e.getX();
				mouseY=e.getY();
			}
			
		};
		
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
//		for (int i = 0; i < cars.length; i++) {
//			bullets[i].start();
//		}
//		
		//��ͣ��ˢ�����
		while(true){
			repaint();
		}
	}
	
	//��׽̫��������
	int count=0;
	public void catchSun(){
		for(int i=0;i<suns.length;i++){
			Sun sun= suns[i];
			if(mouseX>sun.x&&mouseX<sun.x+sun.width&&mouseY>sun.y&&mouseY<sun.y+sun.height){
				sun.isExists=false;
				count+=5;
			}
			
		}
		
	}
	
	
	//�ӵ����н�ʬ
//	public void hitZombie(){
//		for (int i = 0; i < zombies.length; i++) {
//			Zombies z=zombies[i];
//			if(bullet.x>z.x){
//				z.islive=false;
//				
//			}
//		}
//	
//	}
	
	

}
