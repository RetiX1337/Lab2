package com.company.customer;

import com.company.Identifiable;
import com.company.books.Book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Customer implements Identifiable, Serializable {
    private Long id;
    private final String phoneNumber;
    private final ArrayList<Book> lentBooks = new ArrayList<>();
    private final String name;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
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
}
