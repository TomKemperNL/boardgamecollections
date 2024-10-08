package nl.tomkemper.boardgamecollections;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Boardgame {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private int rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;

    public List<Edition> getEditions() {
        return editions;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Edition> editions = new ArrayList<>();



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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
