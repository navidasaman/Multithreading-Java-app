import java.util.Random;

public class RandomGenerator {
	public static int rand(int a, int b) {
		// a = lowest value in range
		// b = starts at value 0. Define max range value but -1 (goes up to the value
		// but does not include the value)
		// b-a is used to prevent randInt>b.
		Random rand = new Random();
		int randInt = a + rand.nextInt(b - a);
		return randInt;
	}
}
