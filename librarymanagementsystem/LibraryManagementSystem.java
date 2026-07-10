package librarymanagementsystem;

import Book.BookList;
import Library.ManageLibrary;
import Member.LibrarianList;
import Member.MemberList;
import Record.ManageRecord;
import java.util.Scanner;

/**
 *3
 * @author MySimp
 */
public class LibraryManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        BookList myBookList = new BookList();
        ManageRecord myManageRecord = new ManageRecord();
        MemberList myMemberList = new MemberList();
        LibrarianList myLibrarianList = new LibrarianList();
        ManageLibrary myLibrary = new ManageLibrary("", "");
        Menu menu = new Menu(sc, myBookList, myManageRecord, myMemberList, myLibrarianList, myLibrary);
        int choice = 0;
        while (choice != 6) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Book");
            System.out.println("2. Member & Librarian");
            System.out.println("3. Record");
            System.out.println("4. Library");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: menu.bookMenu(); break;
                case 2: menu.personMenu(); break;
                case 3: menu.recordMenu(); break;
                case 4: menu.libraryMenu(); break;
                case 5: System.out.println("Goodbye"); break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
