package com.company;

import com.company.books.BookList;
import com.company.customer.CustomerList;

import java.io.IOException;

public class DependencyManager {
    private final Library library;

    public DependencyManager() {
        CustomerList deserializedCustomerList = new CustomerList();
        BookList deserializedBookList = new BookList();
        try {
            Serializer.deserialize(deserializedCustomerList, "customerList.bin");
            Serializer.deserialize(deserializedBookList, "bookList.bin");
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
            Serializer.serialize(library.getCustomerList(), "customerList.bin");
            Serializer.serialize(library.getBookList(), "bookList.bin");
            Serializer.serialize(library, "library.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Library getLibrary() {
        return library;
    }
}
