package com.company;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BookContainer implements Serializable {
    private final HashMap<Long, Book> bookContainer = new HashMap<>();
    private static Long idCounter = 0L;

    public Book save(Book book) {
        book.setId(idCounter);
        bookContainer.put(idCounter, book);
        idCounter++;
        return book;
    }

    public void delete(Book book) {
        bookContainer.remove(book.getId());
    }

    public Book findById(Long id) {
        return bookContainer.get(id);
    }

    public Collection<Book> findAll() {
        return bookContainer.values();
    }

    public List<Book> findByType(BookType bookType) {
        return bookContainer.values().stream().filter(book -> book.getType().equals(bookType)).collect(Collectors.toList());
    }
}
