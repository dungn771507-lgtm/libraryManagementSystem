/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class BookList {
    private ArrayList<Book> list;

    public BookList() {
        this.list = new ArrayList<>();
    }

    public Book searchById(String id) {
        for (Book book : this.list) {
            if (book.getBookId().equalsIgnoreCase(id)) {
                return book;
            }
        }
        return null;
    }

    public boolean addBook(Book newBook) {
        if (this.searchById(newBook.getBookId()) == null) {
            this.list.add(newBook);
            return true;
        }
        return false; 
    }

    public void inputBooks() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Book b = new Book();
            b.InputBook(); // Call input method from Book class
            if (this.addBook(b)) {
                System.out.println("Add complete!");
            } else {
                System.out.println("Error - Book ID: " + b.getBookId() + " already exists.");
            }
            System.out.print("Add more books? (Y/N): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public void updateBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Book ID to find: ");
        String id = sc.nextLine();

        Book booktoUpdate = this.searchById(id);

        if (booktoUpdate != null) {
            System.out.print("Input new title: ");
            booktoUpdate.setTitle(sc.nextLine());
            
            System.out.print("Input new author: ");
            booktoUpdate.setAuthor(sc.nextLine());
            
            // Fix Scanner skipping issue by using parseDouble + nextLine
            System.out.print("Input new quantity: ");
            booktoUpdate.setQuantity(Double.parseDouble(sc.nextLine()));
            
            System.out.print("Input new price: ");
            booktoUpdate.setPrice(Double.parseDouble(sc.nextLine()));
            
            System.out.println("Update success!");
        } else {
            System.out.println("Book ID: " + id + " does not exist.");
        }
    }

    public void searchBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Book ID to find: ");
        String id = sc.nextLine();

        Book foundBook = this.searchById(id);

        if (foundBook != null) {
            System.out.println("--- Book Info ---");
            foundBook.ListBook();
        } else {
            System.out.println("Book ID: " + id + " does not exist.");
        }   
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("Book list is empty.");
            return;
        }
        System.out.println("--- All Books ---");
        for (Book book : list) {
            book.ListBook();  
        }
    }

    public void saveBooksToFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Book b : this.list) {
                bw.write(b.toFileString()); // Calling this method is now valid since it's in the Book class
                bw.newLine(); 
            }
            System.out.println("Successfully saved book data to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void loadBooksFromFile(String fileName) {
        this.list.clear(); 
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|"); 
                
                
                if (data.length == 5) { 
                    String id = data[0].trim();
                    String title = data[1].trim();
                    String author = data[2].trim();
                    double quantity = Double.parseDouble(data[3].trim());
                    double price = Double.parseDouble(data[4].trim());
                    

                    Book b = new Book(id, title, author, quantity, price);
                    this.list.add(b);
                }
            }
            System.out.println("Successfully loaded book data from file: " + fileName);
        } catch (Exception e) {
            System.out.println("Error reading file or file does not exist: " + e.getMessage());
        }
    }

}
