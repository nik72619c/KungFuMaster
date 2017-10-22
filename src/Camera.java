import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Camera implements gameConstants{
	
	int x,y,w,h;
	BufferedImage img;
	int xSpeed;
	
	
	public Camera(){
		
		w=GAME_WIDTH;
		h=200;
		x=y=0;
		xSpeed=4;
		try {
			img=ImageIO.read(Camera.class.getResource("background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Image getPartImage() {
		
		
		return img.getSubimage(x, y, w, h);
	
	}
	
	public void moveForward() {
		
		x+=xSpeed;
		
		
		
	}
	
	public void moveBackward() {
		
		x-=xSpeed;
	}
	
	public void drawBG(Graphics g) {
		
		g.drawImage(getPartImage(),0,0,w,h,null);
		
		
	}

}
