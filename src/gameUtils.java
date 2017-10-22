

import java.util.Random;


public class gameUtils {
	
	static  Random r= new Random();
	  int range;
	
	public gameUtils(int range) {
		
		this.range= range;
		r= new Random(this.range);
	}
	
	 public int getRandomNumber() {
		
		return (r.nextInt(this.range));
	}

	
}