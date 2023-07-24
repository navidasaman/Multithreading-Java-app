class Cappuccino extends Coffee {
String type = "Cappuccino";
    
    public Cappuccino() {
    }
    
    public String getType() {
        return type.toString();
    }
    
    public int getEnergy() {
        return getEnergy(20, 31);
    }	
	
//	int energy;
//
//	public Cappuccino(String type, int minEnergy, int maxEnergy) {
//		super(type, minEnergy, maxEnergy);
//		type = "Cappuccino";
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