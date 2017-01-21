package ru.aakifiev.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by aakifiev on 21.01.2017.
 */

@Entity
public class Product {

    @Id
    private Integer id;
    private String name;

    public Product(){
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + "]";
    }
}
