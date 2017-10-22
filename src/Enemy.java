import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy implements gameConstants, state{
	
	
	int x,y,w,h;
	int speed;
	Boolean isVisible;
	BufferedImage spritesheet;
	BufferedImage defaultImageArr[]= new BufferedImage[8];
	int state;
	int yspeed;
	
	
	 
	public Enemy(int x){
		
		//x=70;
		this.x=x;
		yspeed=3;
		w=h=60;
		y=GAME_HEIGHT-50-h;
		state=WALK;
		speed=3;
		isVisible=true;
		loadSpritesheet();
		//gameUtils gameutils= new gameUtils(1936-GAME_WIDTH);
		
		defaultImageArr=defaultImg();
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

	public void loadSpritesheet() {
		
		
		try {
			spritesheet=ImageIO.read(Enemy.class.getResource("spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public BufferedImage [] defaultImg() {
		
		BufferedImage array[]= new BufferedImage[8];
		
		array[0]= spritesheet.getSubimage(189,347,16,41);
	    array[1]=spritesheet.getSubimage(169,347,19,41);
	    array[2]=spritesheet.getSubimage(169,347,19,41);
	    array[3]=spritesheet.getSubimage(169,347,19,41);
	    array[4]=spritesheet.getSubimage(169,347,19,41);
	    array[5]= spritesheet.getSubimage(189,347,16,41);
	    array[6]= spritesheet.getSubimage(189,347,16,41);
	    array[7]= spritesheet.getSubimage(189,347,16,41);
	    
	    
	
	return array;
		
		
	}
	
	int walkIndex=0;
	
	public void enemyWalkEffect(Graphics g) {
		
		
		if(walkIndex>=defaultImageArr.length-1) {
			
			walkIndex=0;
		}
		
		
		
		else {
			
			g.drawImage(defaultImageArr[walkIndex],x,y,w,h,null);
			walkIndex++;
		}
		
	//	g.drawImage(defaultImageArr[0],x,y,w,h,null);
		
	}
	
	public void dieEnemy(Graphics g) {
		
		BufferedImage img[]= new BufferedImage[1];
		
		img[0]=spritesheet.getSubimage(84,352,23,36);
		g.drawImage(img[0],x,y,w,h,null);
		
		
	}
	
	public void stop() {
		
		speed=0;
	}
	
	public void move() {
		
		x-=speed;
	}
	
	public void drawEnemy(Graphics g) {
		
		
		enemyWalkEffect(g);
		
		if(state==DEAD) {
			
			dieEnemy(g);
			moveDeadEnemy();
		}
	}
	
	public void moveDeadEnemy() {
		
		y+=yspeed;
	}

	}
	


