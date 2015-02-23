package P2;

import java.util.ArrayList;
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
    private List<Customer> queue;
    private Gui gui;
    private int queueLength;
    private ArrayList<Customer> seats;

    public CustomerQueue(int queueLength, Gui gui) {
		this.gui = gui;
        this.queueLength = queueLength;

        queue = new LinkedList();
        seats = new ArrayList<Customer>();
        for (int n = 0; n < queueLength; n++){
            seats.add(null);
        }

        //for(int i = 0; i<7; i++){
        //    addCustomer(new Customer());
        //}
	}

    public synchronized void addCustomer(Customer customer){
        if (queue.size() < queueLength){
            queue.add(customer);
            for(int i = 0; i < queueLength; i++){
                if (seats.get(i)==null){
                    seats.set(i, customer);
                    gui.fillLoungeChair(i, customer);
                    break;
                }
            }
        }
    }

    public synchronized Customer removeCustomer(){
        if (!queue.isEmpty()){
            Customer c = queue.remove(0);
            int index = seats.indexOf(c);
            seats.set(index, null);
            gui.emptyLoungeChair(index);
            return c;
        }
        return null;
    }

	// Add more methods as needed
}
