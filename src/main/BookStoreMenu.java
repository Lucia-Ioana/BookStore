package main;

import java.util.Arrays;
import java.util.Scanner;

public class BookStoreMenu {
    Scanner inText = new Scanner(System.in);
    Scanner inNumbers = new Scanner(System.in);
    private Book[] books = new Book[2];
    private String nameOfBookStore;
    private Customer currentCustomer;


    public BookStoreMenu(String nameOfBookStore) {
        this.nameOfBookStore = nameOfBookStore;
    }

    public void adminMenu() {
        checkIn();
        populateBookStore();
    }

    public void checkIn() {
        System.out.print("Enter you name : ");
        String clientName = inText.nextLine();
        Customer customer = new Customer(clientName);
        currentCustomer = customer;
    }

    public void startCustomerApp() {
        int option;
        do {
            showMenu();
            System.out.print("Choose an option : ");
            option = inNumbers.nextInt();
            switch (option) {
                case 1:
                    showBooks();
                    break;
                case 2:
//                    buyBook();
                    break;
                case 3:
                    showBookByName();
                    break;
                case 4:
                    showBooksByAuthor();
                    break;
                case 5:
                    System.out.println("Option " + option + " selected");
                    break;
                case 6:
                    showBooksByPrice();
                    break;
                case 7:
                    System.out.println("Option " + option + " selected");
                    break;
                case 8:
                    System.out.println("Option " + option + " selected");
                    break;
                case 9:
                    System.out.println("Option " + option + " selected");
                    break;
                case 10:

                    break;
                case 11:
                    System.out.println("Option " + option + " selected");
                    break;
                case 12:
                    System.out.println("Option " + option + " selected");
                    break;
                case 13:
//                    largestNumberOfPages();
                    break;
                case 14:
                    System.out.println("Option " + option + " selected");
                    break;
                case 15:
                    System.out.println("Option " + option + " selected");
                case 16:
                    System.out.println("");
                    break;
                case 17:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("Wrong option.Please choose a valid option!");
            }
        } while (option != 17);
    }

    public void populateBookStore() {
        System.out.println("1.Please introduce books in your book store: ");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book no " + i + ":");
            System.out.print("Enter name: ");
            String name = inText.nextLine();
            System.out.print("Enter isbn: ");
            String isbn = inText.nextLine();
            System.out.print("Enter authorName: ");
            String authorName = inText.nextLine();
            System.out.print("Enter nrOfPages: ");
            int nrOfPages = inNumbers.nextInt();
            System.out.print("Enter editorialName: ");
            String editorialName = inText.nextLine();
            System.out.print("Enter genre: ");
            String genre = inText.nextLine();
            System.out.print("Enter price: ");
            double priceInRon = inNumbers.nextDouble();
            long priceInBani = (long) (priceInRon * 100);
            Book currentBook = new Book(name, isbn, authorName, nrOfPages, editorialName, genre, priceInBani);
            books[i] = currentBook;
        }
    }

    public void showMenu() {
        System.out.println("--Welcome to the " + nameOfBookStore + "!");
        System.out.println("1.Show books");
        System.out.println("2.Buy a book");
        System.out.println("3.Show books by name");
        System.out.println("4.Show books by authorName");
        System.out.println("5.Show books by editorialName");
        System.out.println("6.Show books by price");
        System.out.println("7.Show books that have more then nrOfPages");
        System.out.println("8.Show books by type");
        System.out.println("9.Calculate and show total price for all books in library");
        System.out.println("10.Calculate and show the average price of all books");
        System.out.println("11.Show the book with the lowest price");
        System.out.println("12.Show the book with the highest price");
        System.out.println("13.Show the book with the largest number of pages");
        System.out.println("14.Show the book with the smallest number of pages");
        System.out.println("15.Show the book with the longest name.");
        System.out.println("16.Show client history of books");
        System.out.println("17.EXIT");
    }

    public void showBooks() {
        System.out.println(" The available books are : ");
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            System.out.println(i + " " + currentBook);
        }
    }


    public void showBookByName() {
        System.out.println("Please enter the book name:");
        String bookName = inText.nextLine();
        System.out.println("Book list found for  " + bookName + " are: ");
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            if (currentBook.getName().equalsIgnoreCase(bookName)) {
                System.out.println(i + " - " + currentBook);
            }
            else {
                System.out.println("No available books at the moment");
            }
        }
    }

    public void showBooksByAuthor() {
        System.out.println("Please enter author's name:");
        String authorName = inText.nextLine();
        System.out.println("Book list found with this author are: ");
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            if (currentBook.getAuthorName().contains(authorName)) {
                System.out.println(i + " - " + currentBook);
            }
            else {
                System.out.println("No available books at the moment");
            }
        }
    }

    public void showBooksByPrice() {
        System.out.println("Enter minimum price: ");
        double minPriceInRon = inNumbers.nextDouble();
        long minPriceInBani = (long)(minPriceInRon * 100);
        System.out.println("Enter maximum price: ");
        double maxPriceinRon = inNumbers.nextDouble();
        long maxPriceInBani = (long)(maxPriceinRon * 100);
        System.out.println("Books available in the price range are: ");
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            if(currentBook.getPrice() >= minPriceInBani && currentBook.getPrice()<= maxPriceInBani ) {
                System.out.println(i + " " + currentBook);
            }
            else {
                System.out.println("No available books at the moment");
            }
        }
    }


    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public String getNameOfBookStore() {
        return nameOfBookStore;
    }

    public void setNameOfBookStore(String nameOfBookStore) {
        this.nameOfBookStore = nameOfBookStore;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

}


