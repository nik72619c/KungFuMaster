import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board  extends JPanel implements gameConstants,state {
	
	Player player= new Player();
	Camera camera= new Camera();
	Timer timer;
	Enemy enemies[]= new Enemy[14];
	 gameUtils gameutils= new gameUtils(1936-GAME_WIDTH);
	 Life life= new Life();
	 Life bossLife= new Life();
	 knifeEnemy knifeenemies[]= new knifeEnemy[3];
	 gameUtils gameutils2= new gameUtils(1);
	 Boss boss= new Boss();
	 int flag=0;
	
	Board(){
		
		loadEnemies();
		loadKnifeEnemies();
		gameloop();
		setFocusable(true);
		bindEvents();
		
		
		
	}
	
	public void loadKnifeEnemies() {
		
		
		knifeenemies[0]= new knifeEnemy(600);
		knifeenemies[1]= new knifeEnemy(1300);
		knifeenemies[2]= new knifeEnemy(800);
	}
	
	public void loadEnemies() {
		
//		int random;
//		int previous = 0;
//		
//		outer:
//		for(int i=0;i<enemies.length;i++) {
//			
//		
//			random=900+gameutils.getRandomNumber();
//			previous=random;
//			
//			if(random<previous) {
//				
//				int difference=previous-random;
//				random+=difference;
//			}
//			
//			
//		//	System.out.println("random is"+ random);
//			Enemy enemy= new Enemy(random+500);
//			enemies[i]=enemy;
//			
//			
//			}
		
		enemies[0]=new Enemy(900);
		enemies[1]= new Enemy(990);
		enemies[2]= new Enemy(1150);
		enemies[3]= new Enemy(1200);
		enemies[4]= new Enemy(1300);
		enemies[5]= new Enemy(1500);
		enemies[6]= new Enemy(1900);
		enemies[7]= new Enemy(2176);
		enemies[8]= new Enemy(2300);
		enemies[9]= new Enemy(2567);
		enemies[10]= new Enemy(2800);
		enemies[11]= new Enemy(2900);
		enemies[12]= new Enemy(3000);
		enemies[13]= new Enemy(3160);
		
			
		
		
		
	}
	
	public void gameloop(){
		
		timer = new Timer(DELAY,(e)->{
			
			repaint();
			checkCollision();
			
			
			
		});
		
		timer.start();
		
	}
	
	public Boolean isCollision(Player player, Enemy enemy) {
		
		int xDistance=Math.abs(player.getX()- enemy.getX());
		
		return xDistance<=(player.getW()-10);
		
		
	}
	
	
	public void checkCollision() {
		
		for(int i=0;i<enemies.length;i++) {
			
			if(isCollision(player, enemies[i]) && enemies[i].isVisible) {
				
				if(player.state==KICK || player.state==DOWN_KICK) {
					
					enemies[i].setIsVisible(false);
					enemies[i].state=DEAD;
					
				}
				
				else if( player.flag==0) {
					
					enemies[i].stop();
					life.decreaseLife();
				}
				
			}
		}
				
		
	}
	
	
	public void bindEvents() {
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					
					
					
				}
				
				
				if(e.getKeyCode()==KeyEvent.VK_W) {
					
					
					
					
					
				}
				
				if(e.getKeyCode()==KeyEvent.VK_S) {
					
					
				}
				
				if(e.getKeyCode()==KeyEvent.VK_A) {
					
					if(camera.x>=GAME_WIDTH) {
						
						camera.x=GAME_WIDTH;
					}
					
					camera.moveBackward();
					
				}
				
				if(e.getKeyCode()==KeyEvent.VK_D) {
					
				
					
					if(camera.x<=1936-GAME_WIDTH)
					camera.moveForward();
					player.state=WALK;
					boss.moveBoss();
					
					
					
					
				}
				
				if(e.getKeyCode()==KeyEvent.VK_K) {
					
					player.state=KICK;
					
					
				}
				
				if(e.getKeyCode()==KeyEvent.VK_J) {
					
					player.state=DOWN_KICK;
				}
				
				
				
			}
			
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				
			}
			
			
			
			
			
		});
	//player.move();
	}
	
	public Boolean isBossCollision(Player player, Boss boss) {
		
		
		int xDistance=Math.abs(boss.getX()-player.getX());
		
		return xDistance<=boss.getW();
	}

		public void checkBosscollision(Graphics g) {
			
			if(isBossCollision(player, boss)) {
				
				boss.bossPuchEffect(g);
				
				if(player.state==DOWN_KICK) {
					
					bossLife.decreaseBossLife();
				}
				
				if(player.state==KICK) {
					
					life.decreaseLife();
					bossLife.decreaseBossLife();
				}
				
				if(player.state==WALK) {
					
				life.decreaseLife();
				}
				
				if(player.state==-1) {
					
					bossLife.decreaseBossLife();
					
				}
				
				
				
			}
			
		}
		
		
		public void DrawGameOver(Graphics g) {
			
			g.setColor(Color.RED);
			g.setFont(new Font("Ariel",Font.BOLD,50));
			g.drawString("GAME OVER !!",GAME_WIDTH/2-100,GAME_HEIGHT/2);
		}

		
		public void drawWin(Graphics g) {
			
			g.setColor(Color.GREEN);
			g.setFont(new Font("Ariel",Font.BOLD,50));
			g.drawString("YOU WIN !!", GAME_WIDTH/2-100, GAME_HEIGHT/2);
		}
	
	


	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	
		camera.drawBG(g);
		if(player.state==WALK)
		
		player.walkEffect(g);
		
		if(player.state==KICK) {
			
			player.kickEffect(g);
		}
		
		if(player.state==DOWN_KICK) {
			
			player.downKickEffect(g);
		}
		
		for(int i=0;i<enemies.length;i++) {
			
			
			
			enemies[i].drawEnemy(g);
			//enemies[i].enemyWalkEffect(g);
			enemies[i].move();
			
		}
		
		life.drawPlayerLife(g);
		bossLife.drawBossLife(g);
		
		
	
//		for(int i=1;i<knifeenemies.length;i++) {
//			
//			int m=i-1;
//			
//			
//			
//			knifeenemies[i].drawKnifeEnemy(g);
//			knifeenemies[i].KnifeEnemyWalkEffect(g);
//			
//			if(knifeenemies[i].getX()- player.getX()>=300) {
//			
//			knifeenemies[i].moveKnifeEnemy();
//			knifeenemies[i].throwKnifeUpEffect(g);
//			
//			}
//			
//			
//		}
//	
	
		
		boss.bossWalkEffect(g);
		
		checkBosscollision(g);
		
		if(life.w<=0) {
			
			player.diePlayer(g);
			player.moveDiePlayer();
			
			DrawGameOver(g);
			
			if(player.y>=GAME_HEIGHT) {
				
				
				timer.stop();
			}
		}
		
		if(bossLife.w2<=0) {
			
			boss.dieBoss(g);
			boss.moveDieBoss();
			drawWin(g);
			
		}
		
		if(boss.getX()>=1936) {
			
			timer.stop();
		}
		
		
	}

		
		
}
