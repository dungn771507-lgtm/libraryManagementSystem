/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Member;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class LibrarianList {
    private ArrayList<Librarian> list;

    public ArrayList<Librarian> getList() {
        return list;
    }

    public LibrarianList() {
        this.list = new ArrayList<>();
    }

    public void inputLibrarian() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Librarian m = new Librarian();
            m.inputPerson(); 
            this.list.add(m);
            System.out.println("Add Librarian complete");
            
            System.out.print("Do you want to add more members? (Y/N): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public void deleteLibrarianByID() {
    if (list.isEmpty()) {
        System.out.println("Empty Librarian list! Nothing to delete.");
        return;
    }

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Librarian ID to delete: ");
    String searchID = sc.nextLine();

    Librarian foundLibrarian = null;

    for (Librarian l : list) {
        if (l.getID().equalsIgnoreCase(searchID)) {
            foundLibrarian = l;
            break;
        }
    }

    if (foundLibrarian != null) {
        System.out.println("Librarian found:");
        foundLibrarian.outputPerson();

        System.out.print("Do you really want to delete this librarian? (Y/N): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            list.remove(foundLibrarian);
            System.out.println("Delete librarian complete!");
        } else {
            System.out.println("Delete canceled.");
        }
    } else {
        System.out.println("Librarian with ID " + searchID + " not found!");
    }
}
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("Empty Librarian list");
            return;
        }
        System.out.println("\nLIBRARIAN LIST");
        for (Librarian librarian : list) {
            librarian.outputPerson();
        }
    }
}
