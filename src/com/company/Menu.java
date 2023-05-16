package com.company;

import java.util.List;

public class Menu {
    public static void menu(Configurator configurator) {
        while (true) {
            System.out.println("""
                    1) Додати книгу\s
                    2) Показати список книг\s
                    3) Знайти книгу по ID\s
                    4) Знайти книгу за типом\s
                    5) Здати книгу\s
                    6) Повернути книгу
                    7) Додати клієнта\s
                    8) Показати клієнтів\s
                    9) Знайти клієнта за ID""");
            switch (getInt()) {
                case 1 -> {
                    System.out.println("Введіть назву книги: ");
                    String name = Main.scanner.nextLine();
                    System.out.println("Введіть автора: ");
                    String author = Main.scanner.nextLine();
                    System.out.println("Введіть рік виготовлення: ");
                    Integer year = getInt();
                    BookType bookType = chooseBookType();
                    configurator.getLibrary().getBookContainer().save(new Book(name, author, year, bookType));
                    configurator.serializeObjects();
                }
                case 2 -> configurator.getLibrary().getBookContainer().findAll().forEach(System.out::println);
                case 3 -> System.out.println(configurator.getLibrary().getBookContainer().findById((long) getInt()));
                case 4 -> configurator.getLibrary().getBookContainer().findByType(chooseBookType()).forEach(System.out::println);
                case 5 -> {
                    System.out.println("Обрати клієнта");
                    configurator.getLibrary().getCustomerContainer().findAll().forEach(System.out::println);
                    Long customerId = (long) getInt();
                    System.out.println("Обрати книгу");
                    configurator.getLibrary().getBookContainer().findAll().forEach(System.out::println);
                    Long bookId = (long) getInt();
                    configurator
                            .getLibrary()
                            .lendBook(configurator.getLibrary().getBookContainer().findById(bookId),
                                    configurator.getLibrary().getCustomerContainer().findById(customerId));
                    configurator.serializeObjects();
                }
                case 6 -> {
                    System.out.println("Обрати клієнта");
                    configurator.getLibrary().getCustomerContainer().findAll().forEach(System.out::println);
                    Long customerId = (long) getInt();
                    List<Book> lentBooks = configurator.getLibrary().getCustomerContainer().findById(customerId).getBooks();
                    System.out.println("Обрати книгу");
                    for (int i = 0; i < lentBooks.size(); i++) {
                        System.out.println(i + ". " + lentBooks.get(i));
                    }
                    Long bookId = (long) getInt();
                    configurator.getLibrary().getCustomerContainer().findById(customerId).getBooks().get(bookId.intValue()).deleteCustomer();
                    configurator.getLibrary().getCustomerContainer().findById(customerId).getBooks().remove(bookId.intValue());
                    configurator.serializeObjects();
                }
                case 7 -> {
                    System.out.println("Введіть ім'я клієнта: ");
                    String name = Main.scanner.nextLine();
                    System.out.println("Введіть номер телефону клієнта: ");
                    String phone = Main.scanner.nextLine();
                    configurator.getLibrary().getCustomerContainer().save(new Customer(name, phone));
                    configurator.serializeObjects();
                }
                case 8 -> configurator.getLibrary().getCustomerContainer().findAll().forEach(System.out::println);
                case 9 -> System.out.println(configurator.getLibrary().getCustomerContainer().findById((long) getInt()));
            }
        }
    }

    private static int getInt() {
        return Integer.parseInt(Main.scanner.nextLine());
    }

    private static BookType chooseBookType() {
        System.out.println("Оберіть тип книги: ");
        for (int i = 0; i < BookType.values().length; i++) {
            System.out.println(i + ". " + BookType.getName(BookType.values()[i]));
        }
        return BookType.values()[getInt()];
    }
}
