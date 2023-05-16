package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Identifiable {
    private Long id;
    private final String phoneNumber;
    private final ArrayList<Book> books = new ArrayList<>();
    private final String name;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Ім'я: " + name +
                ", ID узятих книг: " + books.stream().map(Book::getId).toList() +
                ", Номер телефону: " + phoneNumber;
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
