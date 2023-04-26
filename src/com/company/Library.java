package com.company;

import com.company.books.Book;
import com.company.books.BookList;
import com.company.customer.Customer;
import com.company.customer.CustomerList;

import java.io.Serializable;

public class Library implements Serializable {
    private final BookList bookList;
    private final CustomerList customerList;

    public Library(BookList bookList, CustomerList customerList) {
        this.bookList = bookList;
        this.customerList = customerList;
    }

    public void lendBook(Book book, Customer customer) {
        customer.addBook(book);
        book.setCustomer(customer);
    }

    public BookList getBookList() {
        return bookList;
    }

    public CustomerList getCustomerList() {
        return customerList;
    }
}
