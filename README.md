# Multithreading-Java-app
A Java app implementing the use of threads for concurrency to increase speed effeciency.  

<img width="332" alt="image" src="https://github.com/navidasaman/Multithreading-Java-app/assets/119083568/bbd81436-a22e-4edb-bec0-bfd596d0dfcc">

• Each person has a unique name and energy level between 30 to 90, which in turn decreses every T seconds (interval between 500-1500ms). If energy level is below 30 the person must consume coffee.

• Coffee Machine creates three types of coffees which give the workers different amount of energy boost. It takes the machine 2 seconds to make a coffee, if not consumed it will be put in the drink reserve which starts at 0 drinks in reserve.
- BlackCoffee gives 15-20 energy boost
- Cappuccino gives 20-30 energy boost
- Latte gives 25-35 energy boost

• Workers will need to queue for the coffee machine in fifo order and if the workers energy is still below 100 after coffee consumation they must be placed in the back of the queue. Worker should leave queue if enegry level = 0.
