package Internship.Library;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Changed to 'Book' to follow Java naming conventions
    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>(); // Corrected from 'books' to 'Book'
    private static Scanner scanner = new Scanner(System.in); // Moved scanner initialization here

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Manage Books");
            System.out.println("2. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageBooks();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageBooks() {
        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Show Book Info");
            System.out.println("5. Back to Main Menu");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    showBooks();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter ISBN: ");
        int ISBN = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Available Copies: ");
        int copies = scanner.nextInt();

        books.add(new Book(ISBN, title, author, copies)); // Corrected 'books' to 'Book'
        System.out.println("Book added successfully.");
    }

    private static void borrowBook() {
        System.out.print("Enter your name: ");
        String memberName = scanner.nextLine();
        System.out.print("Enter ISBN of the book you want to borrow: ");
        int ISBN = scanner.nextInt();

        for (Book book : books) {
            if (book.getISBN() == ISBN) { // Corrected from 'books.ISBN' to 'book.getISBN()'
                book.borrowBook(memberName);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void returnBook() {
        System.out.print("Enter your name: ");
        String memberName = scanner.nextLine();
        System.out.print("Enter ISBN of the book you want to return: ");
        int ISBN = scanner.nextInt();

        for (Book book : books) {
            if (book.getISBN() == ISBN) { // Corrected from 'books.ISBN' to 'book.getISBN()'
                book.returnBook(memberName);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void showBooks() {
        for (Book book : books) { // Changed 'sbook' to 'book'
            book.showBookInfo(); // Corrected from 'books.showBookInfo()' to 'book.showBookInfo()'
        }
    }
}
