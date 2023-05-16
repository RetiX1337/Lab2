package com.company;

import com.company.books.Book;
import com.company.books.BookType;
import com.company.customer.Customer;

import java.util.List;

public class Menu {
    public static void menu(DependencyManager dependencyManager) {
        while (true) {
            System.out.println("1. Add a book");
            System.out.println("2. Show books");
            System.out.println("3. Find a book by ID");
            System.out.println("4. Find a book by type");
            System.out.println("5. Lend a book");
            System.out.println("6. Return a book");
            System.out.println("7. Add a customer");
            System.out.println("8. Show customers");
            System.out.println("9. Find a customer by ID");
            switch (getInt()) {
                case 1 -> {
                    System.out.println("Enter the name of a book: ");
                    String name = Main.scanner.nextLine();
                    System.out.println("Enter the name of author: ");
                    String author = Main.scanner.nextLine();
                    System.out.println("Enter the year of production: ");
                    Integer year = getInt();
                    BookType bookType = chooseBookType();
                    dependencyManager.getLibrary().getBookList().save(new Book(name, author, year, bookType));
                    dependencyManager.serializeObjects();
                }
                case 2 -> dependencyManager.getLibrary().getBookList().findAll().forEach(System.out::println);
                case 3 -> System.out.println(dependencyManager.getLibrary().getBookList().findById((long) getInt()));
                case 4 -> dependencyManager.getLibrary().getBookList().findByType(chooseBookType()).forEach(System.out::println);
                case 5 -> {
                    System.out.println("Choose a customer");
                    dependencyManager.getLibrary().getCustomerList().findAll().forEach(System.out::println);
                    Long customerId = (long) getInt();
                    System.out.println("Choose a book");
                    dependencyManager.getLibrary().getBookList().findAll().forEach(System.out::println);
                    Long bookId = (long) getInt();
                    dependencyManager
                            .getLibrary()
                            .lendBook(dependencyManager.getLibrary().getBookList().findById(bookId),
                                    dependencyManager.getLibrary().getCustomerList().findById(customerId));
                    dependencyManager.serializeObjects();
                }
                case 6 -> {
                    System.out.println("Choose a customer");
                    dependencyManager.getLibrary().getCustomerList().findAll().forEach(System.out::println);
                    Long customerId = (long) getInt();
                    List<Book> lentBooks = dependencyManager.getLibrary().getCustomerList().findById(customerId).getLentBooks();
                    System.out.println("Choose a book to return");
                    for (int i = 0; i < lentBooks.size(); i++) {
                        System.out.println(i + ". " + lentBooks.get(i));
                    }
                    Long bookId = (long) getInt();
                    dependencyManager.getLibrary().getCustomerList().findById(customerId).getLentBooks().get(bookId.intValue()).deleteCustomer();
                    dependencyManager.getLibrary().getCustomerList().findById(customerId).getLentBooks().remove(bookId.intValue());
                    dependencyManager.serializeObjects();
                }
                case 7 -> {
                    System.out.println("Enter the customer's name: ");
                    String name = Main.scanner.nextLine();
                    System.out.println("Enter the customer's phone number: ");
                    String phone = Main.scanner.nextLine();
                    dependencyManager.getLibrary().getCustomerList().save(new Customer(name, phone));
                    dependencyManager.serializeObjects();
                }
                case 8 -> dependencyManager.getLibrary().getCustomerList().findAll().forEach(System.out::println);
                case 9 -> System.out.println(dependencyManager.getLibrary().getCustomerList().findById((long) getInt()));
            }
        }
    }

    private static int getInt() {
        return Integer.parseInt(Main.scanner.nextLine());
    }

    private static BookType chooseBookType() {
        System.out.println("Choose a type of book: ");
        for (int i = 0; i < BookType.values().length; i++) {
            System.out.println(i + ". " + BookType.values()[i]);
        }
        return BookType.values()[getInt()];
    }
}
