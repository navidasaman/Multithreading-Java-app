public class BlackCoffee extends Coffee {
String type = "BlackCoffee";
    
    public BlackCoffee() {
    }
    
    public String getType() {
        return type.toString();
    }
    
    public int getEnergy() {
        return getEnergy(25, 36);
    }
	
	
//	int energy;
//
//	public BlackCoffee(String type, int minEnergy, int maxEnergy) {
//		super(type, minEnergy, maxEnergy);
//		type = "BlackCoffee";
//		energy = RandomGenerator.rand(minEnergy, maxEnergy);
//	}
//
//	public String getType() {
//		return type.toString();
//	}
//
//	public int getCoffeeEnergy() {
//		return energy;
//	}

}