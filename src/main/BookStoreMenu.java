package main;

import org.w3c.dom.ls.LSOutput;

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
                    buyBook();
                    break;
                case 3:
                    showBookByName();
                    break;
                case 4:
                    showBooksByAuthor();
                    break;
                case 5:
                    showBooksByEditorialName();
                    break;
                case 6:
                    showBooksByPrice();
                    break;
                case 7:
                    showBookWithMoreNrOfPagesThan();
                    break;
                case 8:
                    showBooksByGenre();
                    break;
                case 9:
                    double totalPrice = calculateTotalPrice();
                    System.out.println(totalPrice);
                    break;
                case 10:
                    double averagePriceInRon = calculateAveragePrice();
                    System.out.println("Average price is : " + averagePriceInRon + " RON");
                    break;
                case 11:
                    showBookWithLowestPrice();
                    break;
                case 12:
                    showBookWithHighestPrice();
                    break;
                case 13:
                    showBookWithLargestNrOfPages();
                    break;
                case 14:
                    showBookWithTheSmallestNrOfPages();
                    break;
                case 15:
                    System.out.println("Option " + option + " selected");
                case 16:
                    currentCustomer.showCartOfBooksBought();
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
        System.out.println("8.Show books by genre");
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

    public void buyBook(){
        showBooks();
        System.out.print("Choose a book :" );
        int selectedBookNr = inNumbers.nextInt();
        Book selectedBook = books[selectedBookNr];
        System.out.println("Selected Book : " + selectedBook.getName());
        System.out.println("You have to pay:" + (selectedBook.getPrice()/100.0) + "RON");
        // TODO: 3/26/2023 payment
        currentCustomer.addBookToCartOfBooks(selectedBook);

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
        }
    }

    public void showBooksByPrice() {
        System.out.println("Enter minimum price: ");
        double minPriceInRon = inNumbers.nextDouble();
        long minPriceInBani = (long) (minPriceInRon * 100);
        System.out.println("Enter maximum price: ");
        double maxPriceinRon = inNumbers.nextDouble();
        long maxPriceInBani = (long) (maxPriceinRon * 100);
        System.out.println("Books available in the price range are: ");
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            if (currentBook.getPrice() >= minPriceInBani && currentBook.getPrice() <= maxPriceInBani) {
                System.out.println(i + " " + currentBook);
            }
        }
    }

    public void showBooksByEditorialName() {
        System.out.println("Enter the editorial name: ");
        String editorialName = inText.nextLine();
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            if (currentBook.getEditorialName().equalsIgnoreCase(editorialName)) {
                System.out.println(i + " - " + currentBook);
            }

        }
    }

    public double calculateTotalPrice() {
        long priceInBani;
        long sum = 0;
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            sum += currentBook.getPrice();
        }
        priceInBani = sum;
        return (double) (priceInBani / 100);
    }

    public double calculateAveragePrice() {
        long averageInBani;
        long sum = 0;
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            sum += currentBook.getPrice();
        }
        averageInBani = sum / books.length;
        return (double) (averageInBani / 100);
    }

    public void showBooksByGenre() {
        System.out.println("Enter the genre : ");
        String genre = inText.nextLine();
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            if (currentBook.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(i + " - " + currentBook);
            }
        }
    }

    public void showBookWithLargestNrOfPages() {
        int maxNrOfPages = books[0].getNrOfPages();
        Book largestBook = null;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getNrOfPages() > maxNrOfPages) {
                maxNrOfPages = books[i].getNrOfPages();
                largestBook = books[i];
            }
        }
        System.out.println("The largest book is " + largestBook);
    }

    public void showBookWithTheSmallestNrOfPages() {
        int minNrOfPages = books[0].getNrOfPages();
        Book smallestBook = null;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getNrOfPages() < minNrOfPages) {
                minNrOfPages = books[i].getNrOfPages();
                smallestBook = books[i];
            }
        }
        System.out.println("The smallest book is : " + smallestBook);
    }

    public void showBookWithMoreNrOfPagesThan() {
        System.out.println("Enter the number of pages: ");
        int nrOfPages = inNumbers.nextInt();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getNrOfPages() > nrOfPages) {
                Book currentBook = books[i];
                System.out.println(currentBook);
            }
        }
    }

    public void showBookWithLowestPrice() {
        long minPrice = books[0].getPrice();
        Book lowestPrice = books[0];
        for (int i = 1; i < books.length; i++) {
            if (books[i].getPrice() < minPrice) {
                minPrice = lowestPrice.getPrice();
                lowestPrice = books[i];
            }
        }
        System.out.println("The book with the lowest price is: " + lowestPrice);
    }

    public void showBookWithHighestPrice() {
        long maxPrice = books[0].getNrOfPages();
        Book highestPrice = books[0];
        for (Book book : books) {
            if (book.getPrice() > maxPrice) {
                maxPrice = highestPrice.getPrice();
                highestPrice = book;
            }
        }
        System.out.println("The book with the highest price is: " + highestPrice);
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


