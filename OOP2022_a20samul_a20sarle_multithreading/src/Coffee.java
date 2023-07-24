public class Coffee {
	String type;
	int energy;

	public Coffee() {
	}

	public int getEnergy(int minEnergy, int maxEnergy) {
		int e = RandomGenerator.rand(minEnergy, maxEnergy);
		return e;
	}
	
	public String getType() {
        return type.toString();
    }
}

//	String type;
//	int minEnergy;
//	int maxEnergy;
//	
//	public Coffee(String type, int minEnergy, int maxEnergy) {
//		this.type = type;
//		this.minEnergy = minEnergy;
//		this.maxEnergy = maxEnergy;
//	}
