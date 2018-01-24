package exercises.lesson4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MovieTheater {

    static double start;

    public static void main(String[] args) {
        start = System.currentTimeMillis();
        Scanner input = new Scanner(System.in);
        List<Attender> attenders = new ArrayList<>(5);
        String userInput;


        generateAttenders(attenders);
        Entry comingCustomer = new Entry();
        comingCustomer.start();

        userInput = input.next();
        comingCustomer.end();
        endAttenders(attenders);
        //System.exit(0);
    }

    private static void generateAttenders(List<Attender> attenders) {
        for (int i = 0; i < 5; ++i) {
           attenders.add(new Attender(i));
        }
        for (Attender attender : attenders) {
            attender.start();
        }
    }

    private static void endAttenders(List<Attender> attenders) {
        for (Attender attender : attenders)  {
            attender.end();
        }
    }

    public static int elapsedTime() {
        return (int) ((System.currentTimeMillis() - start) / 1000);
    }
}
