package com.company.books;

import com.company.books.Book;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BookList implements Serializable {
    private final HashMap<Long, Book> bookList = new HashMap<>();
    private static Long idCounter = 0L;

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
}
