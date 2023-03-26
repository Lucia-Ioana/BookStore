package main;

public class Book {
    private String name;
    private String isbn;
    private String authorName;
    private int nrOfPages;
    private String editorialName;
    private String genre;
    private long price;

    public Book(String name, String isbn, String authorName, int nrOfPages, String editorialName, String genre, long price) {
        this.name = name;
        this.isbn = isbn;
        this.authorName = authorName;
        this.nrOfPages = nrOfPages;
        this.editorialName = editorialName;
        this.genre = genre;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;

    }
    public String getAuthorName(){
        return authorName;
    }

    public void setAuthorName(){
        this.authorName = authorName;
    }

    public int getNrOfPages(){
        return  nrOfPages;
    }

    public void setNrOfPages(int nrOfPages){
        this.nrOfPages = nrOfPages;
    }
    public String getEditorialName(){
        return editorialName;
    }
    public void setEditorialName(String editorialName){
        this.editorialName= editorialName;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(){
        this.genre = genre;
    }

    public long getPrice() {
        return price;
    }
    public void setPrice(long price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authorName='" + authorName + '\'' +
                ", nrOfPages=" + nrOfPages + '\'' +
                ", editorialName='" + editorialName + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + ( price /100.00) + "RON" +
                '}';
    }
}
