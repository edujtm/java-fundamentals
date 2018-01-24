package exercises.lesson4;

import javax.swing.plaf.InternalFrameUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Attender extends Thread {

    private Random randomGenerator = new Random();
    private int whichQueue;
    private Boolean threadalive = true;

    public Attender(int queue) {
        whichQueue = queue;
    }

    @Override
    public void run() {
        Customer customer;
        int timetodecide = 0;

        while (this.threadalive) {
            customer = CustomerQueues.attendCustomer(this.whichQueue);
            if (customer != null) {
                timetodecide = 3000 + 1000 * randomGenerator.nextInt(3);
                try {
                    Thread.sleep(timetodecide);
                    this.attend(customer);
                } catch (InterruptedException e) {
                   System.out.println("Attender interrupted");
                }
            } else {
               try {
                  Thread.sleep(1000);
               } catch (InterruptedException e) {
                   System.out.println("Attender interrupted");
               }
            }
        }
    }

    public void attend(Customer customer) {
        int wait = 0;
        if (Tickets.getTicket(customer.getMovie())) {
            System.out.println("Customer ID#" + customer.getID() + " from queue "  + this.whichQueue + " buys a ticket after " + MovieTheater.elapsedTime() + " seconds for the movie " + Tickets.names.get(customer.getMovie()));
        } else {
            System.out.println("Customer ID#" + customer + " from queue " + this.whichQueue + " leaves queue. No tickets available for the movie " + Tickets.names.get(customer.getMovie()));
        }
    }

    public void end() {
        this.threadalive = false;
    }
}
