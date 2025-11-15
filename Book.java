package Internship.Library;

import java.util.ArrayList;

public class Book { // Renamed class from 'books' to 'Book' (singular)
    private int ISBN;
    private String title;
    private String author; // Changed to lowercase for consistency
    private ArrayList<String> borrowedBy = new ArrayList<>(); // Initialize the list
    private int copies;

    public Book(int ISBN, String title, String author, int copies) { // Corrected parameter names
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.copies = copies; // Initialize copies
    }

    public boolean borrowBook(String memberName) {
        if (copies > 0) {
            copies--;
            borrowedBy.add(memberName);
            System.out.println(memberName + " borrowed " + title + ". Copies left: " + copies);
            return true;
        } else {
            System.out.println(title + " is not available right now.");
            return false;
        }
    }

    public boolean returnBook(String memberName) {
        if (borrowedBy.contains(memberName)) {
            copies++;
            borrowedBy.remove(memberName);
            System.out.println(memberName + " returned " + title + ". Copies available: " + copies);
            return true;
        } else {
            System.out.println(memberName + " did not borrow " + title + ".");
            return false;
        }
    }

    public void showBookInfo() { // Changed from static to instance method
        System.out.println("Title: " + title + ", Author: " + author + ", Available Copies: " + copies);
    }

    public int getISBN() { // Changed from static to instance method
        return ISBN;
    }
}