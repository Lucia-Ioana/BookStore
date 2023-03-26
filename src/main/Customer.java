package main;

import java.util.ArrayList;

public class Customer {
    private String name;
    private Book[] cartOfBooks = new Book[5];

    public Customer(String name) {
        this.name = name;
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
