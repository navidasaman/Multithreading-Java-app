public class WaitGenerator {
    public void processing(int timeMillis) {
        try {
            Thread.sleep(timeMillis);
            //coffees -= 1;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}