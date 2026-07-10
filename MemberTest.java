/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Member.MemberList;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class MemberTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberList memberList = new MemberList();
        
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n===== MEMBER MENU =====");
            System.out.println("1. Add member");
            System.out.println("2. Display all");
            System.out.println("3. Delete member");
            System.out.print("Choose: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number");
                continue;
            }
            
            switch (choice) {
                case 1: memberList.inputMembers(); break;
                case 2: memberList.displayAll(); break;
                case 3: memberList.deleteMemberByID(); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
