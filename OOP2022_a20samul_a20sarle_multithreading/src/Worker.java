import java.util.Timer;

public class Worker implements Runnable {
	String name;
	int energyLevel;
	int T;
	Thread thread;
	CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
	Timer timer = new Timer();
	Worker worker = Worker.this;
	
	public Worker(String name) {
		this.name = name;
		this.energyLevel = RandomGenerator.rand(30, 91);
		this.T = RandomGenerator.rand(500, 1501); // T is the randomly assigned value of decreasing energy of the worker
		createThread(this);
	}
	
	public String toString() {
		return name;
	}

	// Creates a worker thread
	public void createThread(Worker worker) {
		thread = new Thread(worker);
		thread.start();
	}

	public void isWorking() {
		System.out.println(worker + " is working with energy level "+energyLevel);
	}

	// Worker gets in coffee queue
	public void getInCoffeeQueue() {
		coffeeMachine.getInCoffeeLine(worker);
	}

	// Worker goes home
	public void goHome() {
		// Cancel worker thread
		timer.cancel();
		System.out.println(worker + " went home with "+ energyLevel);
	}
	
	@Override
	public void run() {
		// Code executed based on energy level with interval of T
		while(energyLevel > 0) {
			energyLevel -= 1;
			
			// If energy level is between 0 and 30
			if (energyLevel > 0 && energyLevel < 30) {
				// If worker is in queue
				if(coffeeMachine.coffeeQueue.contains(worker)) {
					System.out.println(worker + " is waiting for coffee with energy level "+worker.energyLevel);
				}
				// If worker is *not* in queue
				else {
					System.out.println(worker+" is taking a break with energy level "+worker.energyLevel);
					getInCoffeeQueue();
				}
			} 
			// If worker is *not* in coffeQueue and  energy level is equal to 30 (or above) and equal to 100 (or below)
			else if (energyLevel > 29 && energyLevel < 101) {
				// If worker is in queue
				if(coffeeMachine.coffeeQueue.contains(worker)) {
					System.out.println(worker + " is waiting for coffee with energy level "+worker.energyLevel);
				}
				// If worker is *not* in queue
				else {
					isWorking();
				}
			}
			// If workers' energy is equal to 0
			else if (energyLevel == 0) {
				goHome();
			}
			else {
				System.out.println(worker+" encountered issues in Worker.run() & energy "+worker.energyLevel);
			}
			
			// Putting thread to sleep for period of T milliseconds
			try {
				Thread.sleep(T);
			} catch(InterruptedException e ) {
				
			}
		}	
	};
}
