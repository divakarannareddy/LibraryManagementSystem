package com.librarymanagementwithJDBC.in;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BorrowBook {
    public static void borrowBook() {
        Scanner sc = new Scanner(System.in);


        Connection conn = DBConnection.connect(); 
        try{
        	System.out.print("Do you have MemberShip in this Library: ");
        	String member = sc.nextLine();
        	if(member.equals("yes")) {
            System.out.print("Enter Book ID: ");
            int bookId = sc.nextInt();
            System.out.print("Enter Member ID: ");
            int memberId = sc.nextInt();
            // Check for book availability
            String checkQuery = "SELECT available_copies FROM Books WHERE book_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setInt(1, bookId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt("available_copies") > 0) {
                // Borrow the book
                String borrowQuery = "INSERT INTO BorrowedBooks (borrow_id, book_id, member_id, borrow_date) VALUES (borrow_seq.NEXTVAL, ?, ?, SYSDATE)";
                PreparedStatement borrowStmt = conn.prepareStatement(borrowQuery);
                borrowStmt.setInt(1, bookId);
                borrowStmt.setInt(2, memberId);
                borrowStmt.executeUpdate();

                // Update available no.of copies
                String updateQuery = "UPDATE Books SET available_copies = available_copies - 1 WHERE book_id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();
                borrowStmt = conn.prepareStatement("select * from BorrowedBooks", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet bq = borrowStmt.executeQuery();
                bq.last();
                System.out.println("Book Borrowed Successfully! Your BorrowId is "+bq.getInt(1));
            } else {
                System.out.println("Book not available!");
            }
            conn.close();
 
        } else{
        	System.out.print("Enter name: ");
        	String name = sc.nextLine();
        	System.out.print("Enter phone: ");
        	String phone = sc.nextLine();
        	System.out.print("Enter mailid: ");
        	String mailid = sc.nextLine();
        	//Add Member into Members Table
        	PreparedStatement newMemeber = conn.prepareStatement("insert into Members values(member_ship.nextval,?,?,?)");
        	newMemeber.setString(1, name);
        	newMemeber.setString(2, phone);
        	newMemeber.setString(3, mailid);
        	int k = newMemeber.executeUpdate();

        	if(k>0) {
            	newMemeber = conn.prepareStatement("select * from Members",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            	ResultSet rs = newMemeber.executeQuery();
            	rs.last();
        		System.out.println("Membership Registartion Successfull! You are now an Member in library and your MemberId is "+rs.getInt(1));
        	}else {
        		System.out.println("Membership Registartion failed");
        	}
        	}}
        catch (Exception e) {
            e.printStackTrace();
        }
        }
    }


