package P2;

import java.util.LinkedList;
import java.util.List;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	/**
	 * Creates a new customer queue.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
    private List queue;
    private Gui gui;
    private int queueLength;

    public CustomerQueue(int queueLength, Gui gui) {
		this.gui = gui;
        this.queueLength = queueLength;

        queue = new LinkedList<Customer>();
        addCustomer();
	}

    public void addCustomer(){
        Customer customer1 = new Customer();
        gui.fillLoungeChair(0, customer1);
        queue.add(customer1);

    }

	// Add more methods as needed
}
