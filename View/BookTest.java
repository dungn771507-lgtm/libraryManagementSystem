package View;

import Book.BookList;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class BookTest {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        Scanner sc = new Scanner(System.in);
        String fileName = "books_data.txt"; 
        int choice;

        System.out.println("=====================================");
        System.out.println("   INITIALIZING LIBRARY SYSTEM...    ");
        System.out.println("=====================================");
       
        bookList.loadBooksFromFile(fileName);

        do {
            System.out.println("\n========= BOOK MANAGEMENT =========");
            System.out.println("1. Add new book(s)");
            System.out.println("2. Display all books");
            System.out.println("3. Update a book by ID");
            System.out.println("4. Search a book by ID");
            System.out.println("5. Save books to file");
            System.out.println("0. Exit");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");
            
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1: bookList.inputBooks(); break;
                case 2: bookList.displayAll(); break;
                case 3: bookList.updateBook(); break;
                case 4: bookList.searchBook(); break;
                case 5: bookList.saveBooksToFile(fileName); break;
                case 0:
                    System.out.println("Saving data before exiting...");
                    bookList.saveBooksToFile(fileName);
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

}
