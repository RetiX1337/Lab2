package com.company;

import java.io.IOException;

public class Configurator {
    private final Library library;

    public Configurator() {
        CustomerContainer deserializedCustomerContainer = null;
        BookContainer deserializedBookContainer = null;
        try {
            deserializedCustomerContainer = (CustomerContainer) Serializer.deserialize("customerContainer.bin", CustomerContainer.class);
            deserializedBookContainer = (BookContainer) Serializer.deserialize("bookContainer.bin", BookContainer.class);
        } catch (IOException e) {
            System.out.println("IO exception");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        this.library = new Library(deserializedBookContainer, deserializedCustomerContainer);
    }

    public void serializeObjects() {
        try {
            Serializer.serialize(library.getCustomerContainer(), "customerContainer.bin", CustomerContainer.class);
            Serializer.serialize(library.getBookContainer(), "bookContainer.bin", BookContainer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Library getLibrary() {
        return library;
    }
}
