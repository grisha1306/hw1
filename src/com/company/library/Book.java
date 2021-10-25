package com.company.library;

import java.util.Arrays;

public class Book {
    private String name;
    private double price;
    private int qty = 0;
    private Author[] authors;

    public Book (String name, Author[] authors, double price ){
        this.name = name;
        this.price = price;
        this.authors = new Author[] {
                new Author("Petr", "Petr@gmail.com", 'm'),
                new Author("Ivan", "Ivan@gmail.com", 'm')
                };
    }

    public Book (String name, Author[] authors, double price, int qty ){
        this.name = name;
        this.authors = new Author[] {
                new Author("Petr", "Petr@gmail.com", 'm'),
                new Author("Ivan", "Ivan@gmail.com", 'm')
        };
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAuthorNames() {
        return authors[0].getName() + ", " + authors[1].getName();
    }

    public String toString () {
        return "Book[name=" + name + ",authors=" + Arrays.toString(authors) + ",price=" + price + ",qty=" + qty + "]";
    }
}

