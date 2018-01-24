package exercises.lesson4;

public class Customer {

    private int ID;
    private int movie;

    public Customer(int id, int movie) {
        this.ID = id;
        this.movie = movie;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }
}
