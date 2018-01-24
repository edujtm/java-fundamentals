package exercises.lesson4;

import java.util.Random;

public class Entry extends Thread {

    private Random randomGenerator = new Random();
    private static int IDs;
    private boolean threadalive = true;

    @Override
    public void run() {
        int waittime = 0;

        while (this.threadalive) {
            waittime = 1000 + 1000 * randomGenerator.nextInt(3);

            try {
                Thread.sleep(waittime);
                this.entry(waittime);
            } catch (InterruptedException e) {
                System.out.println("Entry interrupted");
            }
        }
    }

    public void entry(int waittime) {
        int whichMovie = randomGenerator.nextInt(15);
        int whichQueue = whichMovie / 3;
        Customer customer = new Customer(IDs++, whichMovie);
        CustomerQueues.enterCustomer(whichQueue, customer);
        System.out.println("Customer#" + customer.getID() + " enters the queue " + whichQueue + " in " +  MovieTheater.elapsedTime() + " seconds");
    }

    public void end() {
        this.threadalive = false;
    }
}
