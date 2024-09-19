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

    public Boardgame(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
