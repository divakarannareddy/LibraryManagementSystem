package com.librarymanagementwithJDBC.in;

import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try(sc;){
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> AddBook.addNewBook();
                case 2 -> BorrowBook.borrowBook();
                case 3 -> ReturnBook.returnBook();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
        }
    }
}

