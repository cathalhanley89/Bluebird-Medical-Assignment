package dev.cathalhanley.product;

import com.sun.istack.NotNull;
import dev.cathalhanley.core.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Product extends BaseEntity{
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @NotNull
    @Min(1)
    private double price;
    private Date creationDate;

    protected Product() {
        super();
    }

    public Product(String name, double price){
        this();
        this.name = name;
        this.creationDate = new Date();
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = new Date();
    }
}
