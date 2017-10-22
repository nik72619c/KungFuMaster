import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Boss implements gameConstants,state{
	
	int x,y,w,h;
	int state;
	BufferedImage spritesheet;
	int speed;
	BufferedImage defaultImageArr[]= new BufferedImage[10];
	BufferedImage PunchImageArr[]= new BufferedImage[11];
	Boolean isVisible;
	int xSpeed=8;
	
	public Boss() {
		
		x=1050;
		y=50;
		w=80;
		h=100;
		speed=4;
		isVisible=true;
		
		loadSpritesheet();
		defaultImageArr=defaultImage();
		PunchImageArr=bossPunchImage();
		
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
			spritesheet= ImageIO.read(Boss.class.getResource("spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage[] defaultImage() {
		
		BufferedImage array[]= new BufferedImage[10];
		
		array[0]= spritesheet.getSubimage(94,634,22,49);
		array[1]= spritesheet.getSubimage(94,634,22,49);

		array[2]= spritesheet.getSubimage(94,634,22,49);
		array[3]= spritesheet.getSubimage(94,634,22,49);
		array[4]= spritesheet.getSubimage(94,634,22,49);
		array[5]= spritesheet.getSubimage(94,634,22,49);
	
		array[6]=spritesheet.getSubimage(120,635,24,49);
		array[7]=spritesheet.getSubimage(120,635,24,49);
		array[8]= spritesheet.getSubimage(94,634,22,49);
		array[9]= spritesheet.getSubimage(94,634,22,49);
		
	
		
		
		return array;
		
	}
	
	public void moveBoss() {
		
		x-=speed;
		
	}
	
	int walkIndex=0;
	
	public void bossWalkEffect(Graphics g) {
		
		
		if(walkIndex>=defaultImageArr.length-1) {
			
			walkIndex=0;
		}
		
		else {
			
			g.drawImage(defaultImageArr[walkIndex],x,y,w,h,null);
			walkIndex++;
			
		}
		
	}
	
	public BufferedImage[] bossPunchImage() {
		
		BufferedImage array[]= new BufferedImage[11];
		
		array[0]= spritesheet.getSubimage(38,635,38,50);
		array[1]= spritesheet.getSubimage(38,635,38,50);
		array[2]= spritesheet.getSubimage(38,635,38,50);
		array[3]= spritesheet.getSubimage(38,635,38,50);
		array[4]= spritesheet.getSubimage(38,635,38,50);
		array[5]= spritesheet.getSubimage(38,635,38,50);
		array[6]= spritesheet.getSubimage(38,635,38,50);
		array[7]= spritesheet.getSubimage(38,635,38,50);
		array[8]=spritesheet.getSubimage(76,633,17,50);
		array[9]=spritesheet.getSubimage(76,633,17,50);
		array[10]=spritesheet.getSubimage(76,633,17,50);
		
		return array;
		
		
	}
	
	int punchIndex=0;
	
	public void bossPuchEffect(Graphics g) {
		
		if(punchIndex>=PunchImageArr.length-1) {
			state=WALK;
			punchIndex=0;
			
		}
		
		else {
			
			g.drawImage(PunchImageArr[punchIndex],x,y,w,h,null);
			punchIndex++;
			state=PUNCH;
		}
		
	}
	
	public void dieBoss(Graphics g) {
		
		BufferedImage img[]= new BufferedImage[1];
		
		img[0]=spritesheet.getSubimage(10,635,26,49);
		
		g.drawImage(img[0],x,y,w,h,null);
	}
	
	public void moveDieBoss() {
		
		
		x+=xSpeed;
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

}
