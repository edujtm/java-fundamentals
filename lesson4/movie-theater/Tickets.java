package exercises.lesson4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tickets {

    public static HashMap<Integer, Integer> tickets;
    public static HashMap<Integer, String> names;

    static {
        tickets = new HashMap<>();
        names = new HashMap<>();
        for (int i = 0; i < 15; ++i) {
            tickets.put(i, 50);
        }

        BufferedReader reader = null;
        List<String> movies = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("src/exercises/lesson4/movies.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) movies.add(line);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado. Terminando execucao");
        } catch (IOException e) {
            System.out.println("Problema ao ler arquivo!. Terminando execucao");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < movies.size(); ++i)  {
            names.put(i, movies.get(i));
        }
    }

    private Tickets() { }

    public static synchronized boolean getTicket(int movie) {
        int qnt = tickets.get(movie);
        if (qnt > 0) {
            tickets.put(movie, --qnt);
            return true;
        }
        return false;
    }
}
