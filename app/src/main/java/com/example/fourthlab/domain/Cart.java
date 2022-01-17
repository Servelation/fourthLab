package com.example.fourthlab.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anechaev
 * @since 16.01.2022
 */
public class Cart {
    private static final Cart cart = new Cart();

    public static Cart getInstance() {return cart;}

    private Cart() {}

    private final Map<String, List<Book>> cartContent = new HashMap<>();

    public Cart addBook(Book book) {
        String bookName = book.getName();
        List<Book> books = cartContent.get(bookName);
        if (books == null) {
            List<Book> newBooks = new ArrayList<>();
            newBooks.add(book);
            cartContent.put(bookName, newBooks);
        } else {
            books.add(book);
        }
        return cart;
    } //startActivityForResult

    public Cart removeBook(Book book) {
        String bookName = book.getName();
        List<Book> books = cartContent.get(bookName);
        if (books == null) {
            return cart;
        }
        List<Book> updatedList = books.subList(0, books.size() - 1);
        if (updatedList.isEmpty()) {
            cartContent.remove(bookName, books);
        } else {
            cartContent.put(bookName, updatedList);
        }
        return cart;
    }

    public Map<String, List<Book>> getCartContent() {
        return cartContent;
    }
}
