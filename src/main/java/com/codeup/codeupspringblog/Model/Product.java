package com.codeup.codeupspringblog.Model;
import jakarta.persistence.*;
import org.hibernate.annotations.GeneratorType;

@Entity
//The belew code is to create another table
@Table (name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    //if we want the column to do some special things, but we have to make new table tho
//    @Column(nullable = false)
    private String name;
    private int CostInCents;

    public Product(long id, String name, int costInCents) {
        Id = id;
        this.name = name;
        CostInCents = costInCents;
    }

    public Product() {

    }

    @jakarta.persistence.Id
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCostInCents() {
        return CostInCents;
    }

    public void setCostInCents(int costInCents) {
        CostInCents = costInCents;
    }

}
