import javax.swing.JFrame;

public class GameFrame extends JFrame implements gameConstants{

	public GameFrame() {
		
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setLocationRelativeTo(null);
		setTitle("KUNGFU MASTER 2K17");
		Board board= new Board();
		add(board);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameFrame gameframe= new GameFrame();

	}

}
