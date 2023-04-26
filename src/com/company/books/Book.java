package com.company.books;

import com.company.Identifiable;
import com.company.customer.Customer;

import java.io.Serializable;

public class Book implements Identifiable {
    private final String name;
    private final String author;
    private final Integer year;
    private boolean isAvailable;
    private final BookType type;
    private Customer customer;
    private Long id;

    public Book(String name, String author, Integer year, BookType type) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.type = type;
        isAvailable = true;
        this.customer = null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        isAvailable = false;
    }

    public void deleteCustomer() {
        this.customer = null;
        isAvailable = true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getName() {
        return name;
    }

    public BookType getType() {
        return type;
    }

    public Integer getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name  +
                ", Author: " + author +
                ", Year: " + year +
                ", Is available: " + isAvailable +
                ", Type: " + type +
                ", Customer ID: " + (customer!=null?customer.getId():"none");
    }
}
