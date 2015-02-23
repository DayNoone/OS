package P2;
/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 */
public class Barber extends Thread{
	/**
	 * Creates a new barber.
	 * @param queue		The customer queue.
	 * @param gui		The GUI.
	 * @param pos		The position of this barber's chair
	 */
    private CustomerQueue queue;
    private int pos;
    private Gui gui;
	public Barber(CustomerQueue queue, Gui gui, int pos) {
        this.queue = queue;
        this.pos = pos;
        this.gui = gui;
	}

    public void run(){
        while(true){
            try {
                gui.barberIsSleeping(pos);
                //this.sleep(Constants.MIN_BARBER_SLEEP + (int) (Math.random()*(Constants.MAX_BARBER_SLEEP- Constants.MIN_BARBER_SLEEP+1)));
                this.sleep(Globals.barberSleep);
                gui.println("Barber sleep time: " + Globals.barberSleep);
                gui.barberIsAwake(pos);

                Customer c = queue.removeCustomer();

                if (c != null){
                    gui.fillBarberChair(pos, c);
                    gui.println("Barber #" + pos + " is working");
                    //this.sleep(Constants.MIN_BARBER_WORK + (int) (Math.random() * (Constants.MAX_BARBER_WORK - Constants.MIN_BARBER_WORK + 1)));
                    this.sleep(Globals.barberWork);
                    gui.println("Barber sleep time: " + Globals.barberWork);
                    gui.emptyBarberChair(pos);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

	/**
	 * Starts the barber running as a separate thread.
	 */
	public void startThread() {
		this.start();
		// Incomplete
	}

	/**
	 * Stops the barber thread.
	 */
	public void stopThread() {
		// Incomplete
	}

	// Add more methods as needed
}

