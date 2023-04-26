package com.company.customer;

import com.company.Identifiable;
import com.company.books.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Customer implements Identifiable, Externalizable {
    private Long id;
    private String phoneNumber;
    private ArrayList<Book> lentBooks = new ArrayList<>();
    private String name;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {

    }

    public void addBook(Book book) {
        lentBooks.add(book);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Book> getLentBooks() {
        return lentBooks;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", IDs of lent books: " + lentBooks.stream().map(Book::getId).toList() +
                ", Phone number: " + phoneNumber;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(id);
        out.writeObject(phoneNumber);
        out.writeObject(lentBooks);
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = (Long) in.readObject();
        phoneNumber = (String) in.readObject();
        lentBooks = (ArrayList<Book>) in.readObject();
        name = (String) in.readObject();
    }
}
