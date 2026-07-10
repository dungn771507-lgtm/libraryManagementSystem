/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

import Book.BookList;
import Library.ManageLibrary;
import Member.Librarian;
import Member.LibrarianList;
import Member.Member;
import Member.MemberList;
import Record.ManageRecord;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class Menu {
    private Scanner sc;
    private BookList myBookList;
    private ManageRecord myManageRecord;
    private MemberList myMemberList;
    private LibrarianList myLibrarianList;
    private ManageLibrary myLibrary;

    public Menu(Scanner sc, BookList myBookList, ManageRecord myManageRecord, MemberList myMemberList, LibrarianList myLibrarianList, ManageLibrary myLibrary) {
        this.sc = sc;
        this.myBookList = myBookList;
        this.myManageRecord = myManageRecord;
        this.myMemberList = myMemberList;
        this.myLibrarianList = myLibrarianList;
        this.myLibrary = myLibrary;
    }

    public void bookMenu() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n===== BOOK MENU =====");
            System.out.println("1. Add book");
            System.out.println("2. Search book");
            System.out.println("3. Update book");
            System.out.println("4. Display all");
            System.out.println("5. Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: myBookList.inputBooks(); break;
                case 2: myBookList.searchBook(); break;
                case 3: myBookList.updateBook(); break;
                case 4: myBookList.displayAll(); break;
                case 5: System.out.println("Back to main menu"); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
    
    public void personMenu() {
    int choice = 0;
    while (choice != 3) {
        System.out.println("\n===== PEOPLE MENU =====");
        System.out.println("1. Member");
        System.out.println("2. Librarian");
        System.out.println("3. Back");
        System.out.print("Choose: ");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: memberMenu(); break;
            case 2: librarianMenu(); break;
            case 3: System.out.println("Back to main menu"); break;
            default: System.out.println("Invalid choice");
        }
    }
}

    public void memberMenu() {
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n===== MEMBER MENU =====");
            System.out.println("1. Add member");
            System.out.println("2. Display all");
            System.out.println("3. Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: 
                myMemberList.inputMembers();
                for (Member m : myMemberList.getList()) {
                myLibrary.addMember(m);
                }
                break;
                case 2: myMemberList.displayAll(); break;
                case 3: System.out.println("Back to main menu"); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
    
    public void librarianMenu() {
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n===== LIBRARIAN MENU =====");
            System.out.println("1. Add librarian");
            System.out.println("2. Display all");
            System.out.println("3. Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                myLibrarianList.inputLibrarian();
                for (Librarian l : myLibrarianList.getList()) {
                myLibrary.addLibrarian(l);
                }
                break;
                case 2: myLibrarianList.displayAll(); break;
                case 3: System.out.println("Back to main menu"); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
    
    public void recordMenu() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n===== RECORD MENU =====");
            System.out.println("1. Add record");
            System.out.println("2. Search record");
            System.out.println("3. Update record");
            System.out.println("4. Display all");
            System.out.println("5. Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: myManageRecord.inputRecords(); break;
                case 2: myManageRecord.searchRecord(); break;
                case 3: myManageRecord.updateRecord(); break;
                case 4: myManageRecord.displayAll(); break;
                case 5: System.out.println("Back to main menu"); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
    
    public void libraryMenu() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Input library info");
            System.out.println("2. Display library stats");
            System.out.println("3. Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: myLibrary.getLib(); break;
                case 2: myLibrary.displayLibrary(); break;
                case 3: System.out.println("Back to main menu"); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
