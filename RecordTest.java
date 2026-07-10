/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Record.ManageRecord;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class RecordTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManageRecord manageRecord = new ManageRecord();
        manageRecord.loadFile("records.txt");
        
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n===== RECORD MENU =====");
            System.out.println("1. Add record");
            System.out.println("2. Search record");
            System.out.println("3. Update record (return date)");
            System.out.println("4. Display all records");
            System.out.print("Choose: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number");
                continue;
            }
            
            switch (choice) {
                case 1:
                    manageRecord.inputRecords();
                    break;
                case 2:
                    manageRecord.searchRecord();
                    break;
                case 3:
                    manageRecord.updateRecord();
                    break;
                case 4:
                    manageRecord.displayAll();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
