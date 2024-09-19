package nl.tomkemper.boardgamecollections;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Boardgame {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private int rating;

    protected Boardgame() {
    }

    public Boardgame(String name) {
        this.name = name;
        this.rating = 6;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
