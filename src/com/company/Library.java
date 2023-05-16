package com.company;

import java.io.Serializable;

public class Library implements Serializable {
    private final BookContainer bookContainer;
    private final CustomerContainer customerContainer;

    public Library(BookContainer bookContainer, CustomerContainer customerContainer) {
        this.bookContainer = bookContainer;
        this.customerContainer = customerContainer;
    }

    public void lendBook(Book book, Customer customer) {
        customer.addBook(book);
        book.setCustomer(customer);
    }

    public BookContainer getBookContainer() {
        return bookContainer;
    }

    public CustomerContainer getCustomerContainer() {
        return customerContainer;
    }
}
