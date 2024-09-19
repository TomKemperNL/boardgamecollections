package nl.tomkemper.boardgamecollections;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Edition {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int year;

    protected Edition() {
    }

    public Edition(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
