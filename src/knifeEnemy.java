import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class knifeEnemy implements gameConstants,state{
	
	int x,y,w,h;
	Boolean isVisible;
	BufferedImage spritesheet;
	int state;
	BufferedImage knifeImage;
	int speed;
	BufferedImage defaultImageArr[]= new BufferedImage[5];
	BufferedImage throwKnifeUpArr[]= new BufferedImage[3];
	BufferedImage throwKnifeDownArr[]= new BufferedImage[3];
	ArrayList <Knife> knives= new ArrayList<>();
	
	public knifeEnemy(int x) {
		
		this.x=x;
		w=60;
		h=60;
		speed=3;
		y=GAME_HEIGHT-50-h;
		state=WALK;
		loadSpriteSheet();
		defaultImageArr=defaultImage();
		loadKnives();
//		throwKnifeUpArr=throwKnifeUpImage();
//		throwKnifeDownArr=throwKnifeDownImage();
		
	}
	
	public void loadKnives() {
		
		Knife knife=new Knife(this.x,this.y);
		knives.add(knife);
		
	}

	public void loadSpriteSheet() {
	
		
		try {
			spritesheet=ImageIO.read(knifeEnemy.class.getResource("spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public BufferedImage[] defaultImage() {
		
		BufferedImage array[]= new BufferedImage[5];
		
		array[0]=spritesheet.getSubimage(166,400,18,40);
		array[1]=spritesheet.getSubimage(166,400,18,40);
		array[2]=spritesheet.getSubimage(188,399,17,40);
		
		
		
		array[3]=spritesheet.getSubimage(188,399,17,40);
		array[4]=spritesheet.getSubimage(166,400,18,40);
	
		return array;
		
		
		
	}
	
	int walkIndex=0;
	
	public void KnifeEnemyWalkEffect(Graphics g) {
		
if(walkIndex>=defaultImageArr.length-1) {
			
			walkIndex=0;
		}
		
		
		
		else {
			
			g.drawImage(defaultImageArr[walkIndex],x,y,w,h,null);
			walkIndex++;
		    state=WALK;
		    //System.out.println("enemy drawn...");
		}

         //   g.drawImage(defaultImageArr[0],x,y,w,h,null);
		
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



	public void moveKnifeEnemy() {
		
		x-=speed;
	}
	


public BufferedImage[] throwKnifeUpImage() {
	
	BufferedImage array[]= new BufferedImage[3];
	
	array[0]= spritesheet.getSubimage(166,399,16,40);
	array[1]= spritesheet.getSubimage(142,392,20,48);
	array[2]= spritesheet.getSubimage(113,401,26,40);
	
	return array;
}

//public BufferedImage[] throwKnifeDownImage() {
//	
//	BufferedImage array[]= new BufferedImage[3];
//	
//	array[0]= spritesheet.getSubimage(165,401,20,40);
//	array[1]= spritesheet.getSubimage(85,401,28,39);
//	array[2]= spritesheet.getSubimage(59,401,25,40);
//	
//	return array;
//}

int knifeUpIndex=0;
public void throwKnifeUpEffect(Graphics g) {
	
	if(knifeUpIndex>=throwKnifeUpArr.length-1) {
		
		knifeUpIndex=0;
		
	}
	
	else {
		
		g.drawImage(throwKnifeUpArr[knifeUpIndex],x,y,w,h,null);
		knifeUpIndex++;
		
		
		
		for(Knife knife :  knives) {
			
			if(knife.getIsVisible()) {
				
				
			
				knife.drawKnife(g);
			knife.moveKnife();
			
			}
		}
		state=THROW_KNIFE;
		
	}
	
	
}


//int knifeDownIndex=0;
//public void throwKnifeDownEffect(Graphics g) {
//	
//	if(knifeDownIndex>=throwKnifeDownArr.length-1) {
//		
//		knifeDownIndex=0;
//		
//	}
//	
//	else {
//		
//		g.drawImage(throwKnifeDownArr[knifeDownIndex],x,y,w,h,null);
//		knifeDownIndex++;
//		state=THROW_KNIFE;
//		
//	}
//	
//	
//}
//
//
//

public void drawKnifeEnemy(Graphics g) {
	
	KnifeEnemyWalkEffect(g);
	
}

	

}
