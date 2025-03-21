package com.librarymanagementwithJDBC.in;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddBook {
    public static void addNewBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter Available Copies: ");
        int copies = sc.nextInt();

        Connection conn = DBConnection.connect();
        try{
            String sql = "INSERT INTO Books VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookId);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, genre);
            ps.setInt(5, copies);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Book Added Successfully!");
            }
            conn.close();
           
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
