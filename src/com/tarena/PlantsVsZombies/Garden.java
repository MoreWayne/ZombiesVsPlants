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
 * 花园类有：背景图移动的僵尸，下落的太阳，向日葵，豌豆射手，除草机
 * 
 * 
 */
public class Garden extends JPanel{
	//开始背景图片
	BufferedImage bg1;
	//开始游戏图片
	BufferedImage start;
	//花园背景图片
	BufferedImage bg2;
	
	//判断是否点击开始游戏
	boolean isStart;
	//定义mouseX和mouseY为鼠标坐标
	int mouseX,mouseY;
	//定义Zombie对象
	Zombies[] zombies;
	//太阳
	Sun[] suns;
	Sun sun;
	//传入5个相同的向日葵
	Plants[] plants;
	//传入5个豌豆射手
	Pea[] peas;
	Pea p;
	//子弹类
	Bullet[] bullets;
	Bullet bullet;
	//小车
	Car[] cars;
	

	
	
	
	
	public Garden(){
		try {
			//获取开始背景图片和游戏背景图片
			bg1=ImageIO.read(new File("images/login.png"));
			start=ImageIO.read(new File("images/start_leave.png"));
			//给是否开始游戏赋值
			isStart=false;
			
			
			//获取游戏背景
			bg2=ImageIO.read(new File("images/background1.png"));
			
			
			//获取向日葵
			plants=new Plants[5];
			for (int i = 0; i < plants.length; i++) {
				plants[i]= new Plants();
				plants[i].start();
			}
			
			//给Zombie赋值
			
			
			zombies=new Zombies[20];
			for (int i = 0; i < zombies.length; i++) {
				zombies[i]=new Zombies();
				zombies[i].start();
			}
			
			
			
			//给太阳赋值
			suns=new Sun[5];
			for(int i=0;i<suns.length;i++){
				suns[i]=new Sun();
				suns[i].start();
			}
					
			//给豌豆射手赋值
			peas=new Pea[5];
			for (int i = 0; i < peas.length; i++) {
				peas[i]=new Pea();
				peas[i].start();
			}
			
			//给子弹赋值
			bullets=new Bullet[5];
			for (int i = 0; i < bullets.length; i++) {
				bullets[i]=new Bullet();
				bullets[i].start();
			}
			//给小车赋值
			
			
			cars=new Car[5];
			for(int i=0;i<5;i++){
				cars[i]=new Car();
				cars[i].start();
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("图片读取有误");
		}
		
	}
	
	
	
	public void paint(Graphics g){
		//画出开始游戏界面
		g.drawImage(bg1, 0, 0, 1024, 768, null);
		g.drawImage(start,512,384,start.getWidth(),start.getHeight(),null);
		//判断是否点击开始游戏，如果点击，则画出花园
		if(isStart){
			//画出花园
			g.drawImage(bg2, 0, 0, 1024,768, null);
			
			//画出僵尸
			for (int i = 0; i < zombies.length; i++) {
				g.drawImage(zombies[i].img, zombies[i].x, zombies[i].y, zombies[i].width, zombies[i].height, null);

			}
			//画出五个相同的向日葵动画
			for (int i = 0; i < plants.length; i++) {
				g.drawImage(plants[i].img, plants[i].x, plants[i].y+(i*150), plants[i].width, plants[i].height, null);
			}
			
			//画出豌豆射手
			for (int i = 0; i < peas.length; i++) {
				g.drawImage(peas[i].img, peas[i].x, peas[i].y+(i*150), peas[i].width, peas[i].height, null);
			}
			//画出bullets中的所有子弹
			for (int i = 0; i < bullets.length; i++) {
				g.drawImage(bullets[i].img,bullets[i].x,bullets[i].y+(i*150),bullets[i].width,bullets[i].height,null);
			}
			//画出小车
			for (int i = 0; i < cars.length; i++) {
				g.drawImage(cars[i].img, cars[i].x, cars[i].y+(i*150), cars[i].width, cars[i].height, null);
			}
			//画出太阳
			for(int i=0;i<suns.length;i++){
				g.drawImage(suns[i].sun_img, suns[i].x, suns[i].y, suns[i].width, suns[i].height, null);
				}
			g.setColor(new Color(0,255,255));
			g.setFont(new Font("楷体",Font.BOLD,20));
			g.drawString("已捕捉太阳数"+count, 50, 80);
		
		}
	
	}
		
		
		

	
	
	

	
	
	public void action(){
		
		MouseAdapter mouse=new MouseAdapter(){
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//判断是否点击开始游戏
				if(mouseX > 512 && mouseX < 512+start.getWidth() &&mouseY>384 &&mouseY<384+start.getHeight()){
					isStart=true;
				}
				//点击捕获太阳·
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
		//不停的刷新面板
		while(true){
			repaint();
		}
	}
	
	//捕捉太阳并计数
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
	
	
	//子弹击中僵尸
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
