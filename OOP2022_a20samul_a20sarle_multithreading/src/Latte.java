public class Latte extends Coffee {
	String type = "Latte";

	public Latte() {
	}

	public String getType() {
		return type.toString();
	}

	public int getEnergy() {
		return getEnergy(25, 36);
	}
}

//	int energy;
//
//	public Latte(String type, int minEnergy, int maxEnergy) {
//		super(type, minEnergy, maxEnergy);
//		type = "Latte";
//		energy = RandomGenerator.rand(minEnergy, maxEnergy);
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public int getCoffeeEnergy() {
//		return energy;
//	}
