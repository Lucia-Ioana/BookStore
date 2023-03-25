package main;

public class Book {
    private String name;
    private String isbn;
    private String authorName;
    private int nrOfPages;
    private String editorialName;
    private String type;
    private String price;

    public Book(String name, String isbn, String authorName, int nrOfPages, String editorialName, String type, String price) {
        this.name = name;
        this.isbn = isbn;
        this.authorName = authorName;
        this.nrOfPages = nrOfPages;
        this.editorialName = editorialName;
        this.type = type;
        this.price = price;
    }

}
