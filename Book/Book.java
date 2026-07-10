package Book;

import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class Book {
    private String bookId;
    private String title;
    private String author;
    private double quantity;
    private double price;
    
    public Book() {
        this.bookId = "";
        this.title = "";
        this.author = "";
        this.quantity = 0;
        this.price = 1;
    }

    public Book(String bookId, String title, String author, double quantity, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        if (quantity > 0) {
           this.quantity = quantity; 
        } else {
            System.out.println("Error: Quantity must be higher than 0");
            Scanner sc = new Scanner(System.in);
            System.out.print("Input Quantity: ");
            setQuantity(Double.parseDouble(sc.nextLine()));
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
           this.price = price; 
        } else {
            System.out.println("Error: Price must be higher than 0");
            Scanner sc = new Scanner(System.in);
            System.out.print("Input Price: ");
            setPrice(Double.parseDouble(sc.nextLine()));
            
        }
        
    }
    public void InputBook() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input Book ID: ");
        this.bookId = sc.nextLine();
        System.out.println("Input Title: ");
        this.title = sc.nextLine();
        System.out.println("Input Author: ");
        this.author = sc.nextLine();
        System.out.println("Input Quantity: ");
        setQuantity(Double.parseDouble(sc.nextLine()));
        System.out.println("Input Price: ");
        setPrice(Double.parseDouble(sc.nextLine()));
    }

    public void ListBook() {
        System.out.println("Book ID: " + this.bookId);
        System.out.println("Title: " + this.title);
        System.out.println("author: " + this.author);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Price: " + this.price + "$");
    }
    
    public String toFileString() {
        return bookId + "|" + title + "|" + author + "|" + quantity + "|" + price;
    }

}
