package com.example.fourthlab.domain;

/**
 * @author anechaev
 * @since 16.01.2022
 */
public class Book {
    private final String name;
    private final String description;
    private final double price;

    public Book(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {return name;}

    public String getDescription() {return description;}

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}
