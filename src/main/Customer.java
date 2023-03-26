package main;

import java.util.ArrayList;

public class Customer {
    private String name;
    private Book[] cartOfBooks = new Book[5];

    public Customer(String name) {
        this.name = name;
    }

    public void addBookToCartOfBooks(Book currentBook) {
        int empty = firstemptyIndex();
        if (empty != -1) {
            cartOfBooks[empty] = currentBook;
        }
    }

    private int firstemptyIndex() {
        int firstEmptyIndex = -1;
        for (int i = 0; i < cartOfBooks.length; i++) {
            if (cartOfBooks[i] == null) {
                firstEmptyIndex = i;
                break;
            }
        }

        return firstEmptyIndex;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book[] getCartOfBooks() {
        return cartOfBooks;
    }

    public void setCartOfBooks(Book[] cartOfBooks) {
        this.cartOfBooks = cartOfBooks;
    }
}
