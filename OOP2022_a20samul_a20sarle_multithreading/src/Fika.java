import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Fika{
	ConcurrentLinkedQueue<String> coffeeQueue;

public static void main(String[] args) throws InterruptedException {
        
        // *** Change value 10 to change speed of programme execution ***
//        long SpeedUpProgramme = System.currentTimeMillis() + 10;
//        
//        do{
            Fika fika = new Fika();
//            Thread fikaThread = new Thread();
//            fikaThread.start();
              fika.run();
            
//        }while (System.currentTimeMillis() < SpeedUpProgramme);
//
//     
//     // *** Change the value of "setDurationOfProgrammeExecution" to change the duration of
//        // program execution ***
//        int setDurationOfProgrammeExecution = 500;
//        while(true) {
//            if(System.currentTimeMillis() >= SpeedUpProgramme * setDurationOfProgrammeExecution) {
//                System.exit(0);
//            }
//        }
   }

long currentTime = System.currentTimeMillis();
public void exitProgramme() {
    // *** Change "setDurationSec" to choose how long the programme will run for ***
    int setDurationSec = 1;
    long setProgrammeDuration = System.currentTimeMillis() + setDurationSec*20000;
    Timer t = new Timer(); 
    TimerTask checkIfProgrammeExeededDuration = new TimerTask() {  
        @Override  
        public void run() {
            currentTime = currentTime + System.currentTimeMillis();
            if(System.currentTimeMillis() >= setProgrammeDuration) {
                System.out.println("\nProgramme called to stop according to setProgrammeDuration");
                System.exit(0);
            }
        };  
    };
    t.scheduleAtFixedRate(checkIfProgrammeExeededDuration,0,500);
}

	public void run() {
		exitProgramme();
		
		new Worker("Erik");
		new Worker("Simon");
		new Worker("Adrian");
		new Worker("Nora");
		
//		Thread fikaThread = new Thread();
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
	}

}
