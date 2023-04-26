package com.company;

import com.company.books.Book;
import com.company.books.BookList;
import com.company.customer.Customer;
import com.company.customer.CustomerList;

import java.io.*;

public class Library implements Externalizable {
    private BookList bookList;
    private CustomerList customerList;

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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(bookList);
        out.writeObject(customerList);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        bookList = (BookList) in.readObject();
        customerList = (CustomerList) in.readObject();
    }
}
