package ru.aakifiev.model;

import javax.persistence.*;

/**
 * Created by aakifiev on 22.01.2017.
 */

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "id="+id+", name="+name+", country="+country;
    }
}
