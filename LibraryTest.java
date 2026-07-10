/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Library.ManageLibrary;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class LibraryTest {
    public static void main(String[] args) {
        ManageLibrary manageLibrary = new ManageLibrary("", "");
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while (choice != 4) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Input library info");
            System.out.println("2. Display library stats");
            System.out.print("Choose: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number");
                continue;
            }
            
            switch (choice) {
                case 1: manageLibrary.getLib(); break;
                case 2: manageLibrary.displayLibrary(); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
