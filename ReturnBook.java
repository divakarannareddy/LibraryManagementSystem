package com.librarymanagementwithJDBC.in;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ReturnBook {
    public static void returnBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Borrow ID: ");
        int borrowId = sc.nextInt();

        Connection conn = DBConnection.connect();
        try{
            // Get borrowed details
            String selectQuery = "SELECT book_id, borrow_date FROM BorrowedBooks WHERE borrow_id = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setInt(1, borrowId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int bookId = rs.getInt("book_id");
                // Calculate fine (Assume ₹5 per day after 10 days)
                String fineQuery = "SELECT CASE WHEN (SYSDATE - borrow_date) > 10 THEN (SYSDATE - borrow_date - 10) * 5 ELSE 0 END AS fine FROM BorrowedBooks WHERE borrow_id = ?";
                PreparedStatement fineStmt = conn.prepareStatement(fineQuery);
                fineStmt.setInt(1, borrowId);
                ResultSet fineRs = fineStmt.executeQuery();

                int fine = 0;
                if (fineRs.next()) {
                    fine = fineRs.getInt("fine");
                }

                // Update return date and fine
                String updateQuery = "UPDATE BorrowedBooks SET return_date = SYSDATE, fine = ? WHERE borrow_id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setInt(1, fine);
                updateStmt.setInt(2, borrowId);
                updateStmt.executeUpdate();

                // Update available copies
                String bookUpdateQuery = "UPDATE Books SET available_copies = available_copies + 1 WHERE book_id = ?";
                PreparedStatement bookUpdateStmt = conn.prepareStatement(bookUpdateQuery);
                bookUpdateStmt.setInt(1, bookId);
                bookUpdateStmt.executeUpdate();

                System.out.println("Book Returned! Fine: ₹" + fine);
            } else {
                System.out.println("Invalid Borrow ID!");
            }
            conn.close();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
