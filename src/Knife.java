import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Knife {
	
	int x,y,w,h;
	Boolean isVisible;
	BufferedImage spritesheet;
	BufferedImage knifeImage;
	int speed;
	
	
	 Knife(int x,int y) {
		
		this.x=x;
		this.y=y;
		w=h=50;
		speed=2;
		isVisible=true;
		loadSpriteSheet();
		knifeImage=knifeImage();
		
		
	}
	
public void loadSpriteSheet() {
	
		
		try {
			spritesheet=ImageIO.read(Knife.class.getResource("spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public BufferedImage knifeImage() {
	
	BufferedImage img;
	
	img=spritesheet.getSubimage(48,429,10,14);
	
	return img;
}

public void moveKnife() {
	
	
	x-=speed;
}

public void drawKnife(Graphics g) {
	
	g.drawImage(knifeImage,x,y,w,h,null);
	
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
	
	
	

}
