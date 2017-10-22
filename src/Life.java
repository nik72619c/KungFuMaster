import java.awt.Color;
import java.awt.Graphics;

public class Life {
	
	int x,y,w,h;
	int x2,y2,w2;
	
	Boolean isVisible;
	
	
	public Life() {
		
		x=y=50;
		w=150;
		h=10;
		isVisible=true;
		x2=700;
		y2=y;
		w2=150;
		
	}
	
	public void drawPlayerLife(Graphics g) {
		
		g.setColor(Color.RED);
		g.drawRect(50, 50, 150, 10);
		g.fillRect(x, y, w, h);
		
	}
	
	
	public void drawBossLife(Graphics g) {
		
		g.setColor(Color.yellow);
		g.drawRect(700,50,150,10);
		g.fillRect(x2, y2, w2, h);
		
	}
	
	
	public void decreaseLife(){
		
		w-=1;
		
		
		
	}
	
	public void decreaseBossLife() {
		
		
		w2-=2;
	}

}
