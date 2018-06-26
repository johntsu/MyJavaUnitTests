package random;

import java.util.Random;

public class RandomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
        int max=9999;
        int min=1;
        
		for(int i=0; i < 20; i++) {
			System.out.println(random.nextInt(max)%(max-min+1) + min);
		}

	}

}
