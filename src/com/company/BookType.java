package com.company;

import java.io.Serializable;

public enum BookType implements Serializable {
    BOOK, MAGAZINE, NEWSPAPER;

    public static String getName(BookType bookType) {
        switch(bookType) {
            case BOOK -> {
                return "Книга";
            }
            case NEWSPAPER -> {
                return "Газета";
            }
            case MAGAZINE -> {
                return "Журнал";
            }
            default -> {
                return "";
            }
        }
    }
}
