package com.company.books;

import com.company.Identifiable;
import com.company.customer.Customer;

import java.io.*;

public class Book implements Identifiable, Externalizable {
    private String name;
    private String author;
    private Integer year;
    private boolean isAvailable;
    private BookType type;
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

    public Book() {

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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(id);
        out.writeObject(name);
        out.writeObject(author);
        out.writeObject(year);
        out.writeObject(isAvailable);
        out.writeObject(type);
        out.writeObject(customer);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = (Long) in.readObject();
        name = (String) in.readObject();
        author = (String) in.readObject();
        year = (Integer) in.readObject();
        isAvailable = (boolean) in.readObject();
        type = (BookType) in.readObject();
        customer = (Customer) in.readObject();
    }
}
