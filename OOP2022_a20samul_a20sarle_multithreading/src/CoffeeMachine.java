import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CoffeeMachine implements Runnable {
	final ConcurrentLinkedQueue<Worker> coffeeQueue = new ConcurrentLinkedQueue<>();
	ArrayList<Coffee> coffeeReserves = new ArrayList<>();
	WaitGenerator waitForProcess = new WaitGenerator();
	CoffeeMachine coffeeMachine = CoffeeMachine.this;
	Latte latte;
	Cappuccino cappuccino;
	BlackCoffee blackCoffee;
	Thread coffeeThread;
	
	
	// Create singleton
	private static volatile CoffeeMachine instance = null;
	
	// Constructor for coffee machine
	public CoffeeMachine() {
		this.latte = new Latte();
		this.blackCoffee = new BlackCoffee();
		this.cappuccino = new Cappuccino();
        coffeeThread = new Thread(coffeeMachine);
        coffeeThread.start();
	}
	
	// Making sure there can only be one instance of coffee machine
    public static CoffeeMachine getInstance() {
        if (instance == null) {
            synchronized(CoffeeMachine.class) {
                if (instance == null) {
                    instance = new CoffeeMachine();
                }
            }
        }
        return instance;
    }
    
    // Make and add coffee with interval of 2 seconds
    public void makeCoffee() {
		waitForProcess.processing(2000);
		Coffee c = getCoffeeType();
		coffeeReserves.add(c);
		System.out.println("Drink created. Coffee Machine has "+coffeeReserves.size()+" drinks in reserve.");
	}
    
    // Returns the energy value of coffee to be served
 	public int returnCoffeeEnergy() {
 		int e = 0;
 		Coffee coffeeType = coffeeReserves.get(lastCoffeeInReserve());
 		if(coffeeType.equals(latte)) {
 			e = getLatte().getEnergy();
 		}
 		else if(coffeeType.equals(blackCoffee)) {
 			e = getBlackCoffee().getEnergy();
 		}
 		else if(coffeeType.equals(cappuccino)) {
 			e = getCappuccino().getEnergy();
 		}
 		else {
 			System.out.println("No coffee type found.");
 		}
 		removeServedCoffee();
 		return e;
 	}
 	
 	// Worker enters coffee queue 
    public synchronized void getInCoffeeLine(Worker worker) {
    	if( !(coffeeQueue.contains(worker)) ) {
            coffeeQueue.add(worker);
        }
    	serveCoffees();
    }
    
   // Serves coffee to worker
    public synchronized void serveCoffees() {
    	while(coffeeQueue.size() > 0) {
	        if (coffeeReserves.size() > 1) {
		        Worker worker = getWorkerToServe();
		
				waitForProcess.processing(1000);
				
		        int servedCoffeeEnergy = returnCoffeeEnergy();
		        worker.energyLevel += servedCoffeeEnergy;
		        System.out.println(worker + " enjoyed a " + coffeeReserves.get(lastCoffeeInReserve()).getType()+" with "+servedCoffeeEnergy+ " energy.");
		        
		        if (worker.energyLevel > 99) {
		        	worker.energyLevel = 100;
		        	System.out.println(worker + " goes back to work with energy level " + worker.energyLevel);
		        }
		        else if (worker.energyLevel < 99 && worker.energyLevel > 0){
		        	getInCoffeeLine(worker);
		        }
		        else {
		        	System.out.println(worker + " encountered issues in getInCoffeeLine()");
		        }
	        }
    	}
    }
	
    // Removes worker from queue to give coffee
	public Worker getWorkerToServe() {																					
		return coffeeQueue.poll();
	}
	
	// Randomises which coffee type to make
	public Coffee getCoffeeType() {
		Coffee c = null;
	      int r = RandomGenerator.rand(1, 4);
	      if(r == 1) {
	          c = getLatte();
	      }
	      else if(r == 2) {
	    	  c = getBlackCoffee();
	      }
	      else if(r == 3) {
	    	  c = getCappuccino();
	      }
	      else {
	          System.out.println("Something went wrong in getCoffeeType()");
	      }
	      return c;
	  }
	
	// Get last coffee of array
	public int lastCoffeeInReserve() {
		int lastIndex;
		if(coffeeReserves.size() > 0) {
			lastIndex = coffeeReserves.size() - 1;
		}
		else {
			lastIndex = 0;
		}
		return lastIndex;
	}
	
	// Removes the coffee that was served
	public void removeServedCoffee() {
    	if(coffeeReserves.size() > 0) {
    		coffeeReserves.remove(lastCoffeeInReserve());
    	}
    }
	
	public Latte getLatte() {
		return latte;
	}

	public Cappuccino getCappuccino() {
		return cappuccino;
	}

	public BlackCoffee getBlackCoffee() {
		return blackCoffee;
	}
	
	@Override
	public void run() {
		do {
			makeCoffee();
		}
		while(coffeeReserves.size() < 20);
	}	
}

