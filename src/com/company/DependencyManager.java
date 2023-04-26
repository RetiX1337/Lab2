package com.company;

import com.company.books.BookList;
import com.company.customer.CustomerList;

import java.io.IOException;

public class DependencyManager {
    private final Library library;

    public DependencyManager() {
        CustomerList deserializedCustomerList = null;
        BookList deserializedBookList = null;
        try {
            deserializedCustomerList = (CustomerList) Serializer.deserialize("customerList.bin", CustomerList.class);
            deserializedBookList = (BookList) Serializer.deserialize("bookList.bin", BookList.class);
        } catch (IOException e) {
            System.out.println("IO exception");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        this.library = new Library(deserializedBookList, deserializedCustomerList);
    }

    public void serializeObjects() {
        try {
            Serializer.serialize(library.getCustomerList(), "customerList.bin", CustomerList.class);
            Serializer.serialize(library.getBookList(), "bookList.bin", BookList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Library getLibrary() {
        return library;
    }
}
