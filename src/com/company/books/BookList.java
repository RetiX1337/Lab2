package com.company.books;

import com.company.books.Book;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BookList implements Externalizable {
    private HashMap<Long, Book> bookList = new HashMap<>();
    private static Long idCounter = 0L;

    public BookList() {

    }

    public Book save(Book book) {
        book.setId(idCounter);
        bookList.put(idCounter, book);
        idCounter++;
        return book;
    }

    public void delete(Book book) {
        bookList.remove(book.getId());
    }

    public Book findById(Long id) {
        return bookList.get(id);
    }

    public Collection<Book> findAll() {
        return bookList.values();
    }

    public List<Book> findByType(BookType bookType) {
        return bookList.values().stream().filter(book -> book.getType().equals(bookType)).collect(Collectors.toList());
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(bookList);
        for (Book b : bookList.values()) {
            b.writeExternal(out);
        }
        out.writeLong(idCounter);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        bookList = (HashMap<Long, Book>) in.readObject();
        for (Book b : bookList.values()) {
            b.readExternal(in);
        }
        idCounter = in.readLong();
    }
}
