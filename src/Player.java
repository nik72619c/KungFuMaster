import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player implements gameConstants,state{
	
	int x,y,w,h;
	int speed;
	Boolean isVisible;
	BufferedImage spritesheet;
	final int FLOOR=GAME_HEIGHT-50;
	BufferedImage defaultImageArr[]= new BufferedImage[5];
	BufferedImage kickImageArr[]= new BufferedImage[12];
	int state;
	BufferedImage downKickArr[]= new BufferedImage[13];
	int flag=0;
	
	Player(){
		
		x=70;
		w=80;
		h=60;
		isVisible=true;
		y=FLOOR-h;
		speed=1;
		state=WALK;
		loadSpriteSheet();
		defaultImageArr=defaultImage();
		kickImageArr=kickImage();
		downKickArr=downKickImage();
		
	}

	
	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}


	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * @return the isVisible
	 */
	public Boolean getIsVisible() {
		return isVisible;
	}


	/**
	 * @param isVisible the isVisible to set
	 */
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}


	public void loadSpriteSheet() {
		
		try {
			spritesheet=ImageIO.read(Player.class.getResource("spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage[] defaultImage() {
		
		
		BufferedImage array[]= new BufferedImage[5];
		
		array[0]=spritesheet.getSubimage(234,5,18,44);
		array[1]=spritesheet.getSubimage(212,9,20,38);
		array[2]=spritesheet.getSubimage(212,9,20,38);
		array[3]=spritesheet.getSubimage(234,5,18,44);
		array[4]=spritesheet.getSubimage(234,5,18,44);
		
		return array;
	}
	
	public BufferedImage[] downKickImage() {
		
		BufferedImage array[]= new BufferedImage[13];
		array[0]=  spritesheet.getSubimage(254,98,16,29);
		array[1]=  spritesheet.getSubimage(213,97,31,33);
		array[2]=  spritesheet.getSubimage(213,97,31,33);
		array[3]=  spritesheet.getSubimage(213,97,31,33);

		array[4]=  spritesheet.getSubimage(213,97,31,33);
		array[5]=  spritesheet.getSubimage(213,97,31,33);
		array[6]=  spritesheet.getSubimage(213,97,31,33);
		array[7]=  spritesheet.getSubimage(213,97,31,33);
		array[8]=  spritesheet.getSubimage(213,97,31,33);
		array[9]=  spritesheet.getSubimage(213,97,31,33);
		array[10]=  spritesheet.getSubimage(213,97,31,33);
		array[11]=  spritesheet.getSubimage(213,97,31,33);
		array[12]=  spritesheet.getSubimage(254,98,16,29);
		
		return array;
	}
	
	public BufferedImage[] kickImage() {
		
		BufferedImage array[]= new BufferedImage[12];
		
		array[0]= spritesheet.getSubimage(257,4,23,43);
		array[1]=spritesheet.getSubimage(212,51,32,44);
		array[2]= spritesheet.getSubimage(284,9,20,42);
		array[3]=spritesheet.getSubimage(213,51,32,42);
		array[4]=spritesheet.getSubimage(213,51,32,42);
		array[5]=spritesheet.getSubimage(213,51,32,42);
		array[6]=spritesheet.getSubimage(213,51,32,42);
		array[7]=spritesheet.getSubimage(213,51,32,42);
		array[8]=spritesheet.getSubimage(213,51,32,42);
		array[9]=spritesheet.getSubimage(280,56,17,37);
		array[10]=spritesheet.getSubimage(280,56,17,37);
		array[11]=spritesheet.getSubimage(280,56,17,37);
		
		
		return array;
	}
	
	int walkIndex=0;

	
	public void walkEffect(Graphics g) {
		
		
		if(walkIndex>=defaultImageArr.length-1) {
			
			walkIndex=0;
		}
		
		
		else {
			
			g.drawImage(defaultImageArr[walkIndex],x,y,w,h,null);
			walkIndex++;
			state=WALK;
			
		}
		
		
		
		
	}
	
	int kickIndex=0;
	
	public void kickEffect(Graphics g) {
		
		if(kickIndex>=kickImageArr.length-1) {
			
			state=WALK;
			kickIndex=0;
			walkIndex=0;
			flag=0;
			
			
		}
		
		else {
			
			g.drawImage(kickImageArr[kickIndex],x,y,w,h,null);
			kickIndex++;
			state=KICK;
			flag=1;
			
		}
		
		
	}
	
	int downKickIndex=0;
	
	public void downKickEffect(Graphics g) {
		
		if(downKickIndex>=downKickArr.length-1) {
			
			downKickIndex=0;
			state=WALK;
			flag=0;
			
		}
		
		else {
			
			g.drawImage(downKickArr[downKickIndex],x,y,w,h,null);
			downKickIndex++;
			state=DOWN_KICK;
			flag=1;
			
		}
		
		
		
	}
	
	public void diePlayer(Graphics g) {
		
		
		BufferedImage img[]= new BufferedImage[1];
		
		img[0]=spritesheet.getSubimage(210,139,27,36);
		g.drawImage(img[0],x,y,w,h,null);
	}
	
	public void moveDiePlayer() {
		y+=speed;
	}
	
	public void drawPlayer(Graphics g) {
		
		if(state==WALK) {
			
			walkEffect(g);
		}
		
		if(state==KICK) {
			
			kickEffect(g);
			
			
		}
		
		if(state==DOWN_KICK) {
			
			downKickEffect(g);
		}
		
		if(state==-1) {
			
			
			downKickEffect(g);
		}
		
		
	}
	
	
	
	
	
}
