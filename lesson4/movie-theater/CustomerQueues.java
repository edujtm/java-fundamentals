package exercises.lesson4;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomerQueues {

    private static ArrayList<LinkedList<Customer>> queues;

    static {
        queues = new ArrayList<>(5);
        for (int i = 0; i < 5; ++i) {
            queues.add(new LinkedList<>());
        }
    }

    public static void enterCustomer(int queue, Customer customer) {
        queues.get(queue).add(customer);
    }

    public static Customer attendCustomer(int queue) {
        return queues.get(queue).poll();
    }
}
