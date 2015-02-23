package P2;
/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman extends Thread{
	/**
	 * Creates a new doorman.
	 * @param queue		The customer queue.
	 * @param gui		A reference to the GUI interface.
	 */

    private CustomerQueue queue;
    private Gui gui;
	public Doorman(CustomerQueue queue, Gui gui) {
        this.queue = queue;
        this.gui = gui;
	}

    public void run(){
        while(true){
            try {
                //this.sleep(Constants.MIN_DOORMAN_SLEEP + (int) (Math.random()*(Constants.MAX_DOORMAN_SLEEP- Constants.MIN_DOORMAN_SLEEP+1)));
                this.sleep(Globals.doormanSleep);
                gui.println("Doorman sleep time: " + Globals.doormanSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("doorman");
            queue.addCustomer(new Customer());
        }
    }

	/**
	 * Starts the doorman running as a separate thread.
	 */
	public void startThread() {
        this.start();
		// Incomplete
	}

	/**
	 * Stops the doorman thread.
	 */
	public void stopThread() {
		// Incomplete
	}

	// Add more methods as needed
}
