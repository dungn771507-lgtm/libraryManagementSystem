/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class MemberList {
        private ArrayList<Member> list;

    public ArrayList<Member> getList() {
        return list;
    }

    public MemberList() {
        this.list = new ArrayList<>();
    }

    public void inputMembers() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Member m = new Member();

            while (true) {
                System.out.println("Input ID (numbers only): ");
                String inputID = sc.nextLine();

                if (!inputID.matches("\\d+")) {
                    System.out.println("Invalid ID! Only numbers allowed.");
                } else if (isIDExists(inputID)) {
                    System.out.println("This ID already exists! Please input a different ID.");
                } else {
                    m.setID(inputID);
                    break;
                }
            }

            m.inputPerson();
            this.list.add(m);
            System.out.println("Add member complete!");

            System.out.print("Do you want to add more members? (Y/N): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public boolean isIDExists(String id) {
        for (Member m : list) {
            if (m.getID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void deleteMemberByID() {
        if (list.isEmpty()) {
            System.out.println("Empty member list! Nothing to delete.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Member ID to delete: ");
        String searchID = sc.nextLine();

        Member foundMember = null;
        for (Member m : list) {
            if (m.getID().equalsIgnoreCase(searchID)) {
                foundMember = m;
                break;
            }
        }

        if (foundMember != null) {
            System.out.println("Member found:");
            foundMember.outputPerson();

            System.out.print("Do you really want to delete this member? (Y/N): ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                list.remove(foundMember);
                System.out.println("Delete member complete!");
            } else {
                System.out.println("Delete canceled.");
            }
        } else {
            System.out.println("Member with ID " + searchID + " not found!");
        }
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("Empty member list!");
            return;
        }
        System.out.println("\nMEMBER LIST");
        for (Member member : list) {
            member.outputPerson();
            System.out.println("----------------------");
        }
    }

    public void readFromFile() {
        String filename = "membertest.txt";

        try ( BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int addedCount = 0;
            int duplicateCount = 0;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String id = data[0].trim();

                    if (isIDExists(id)) {
                        System.out.println("Warning: Bỏ qua ID bị trùng trong file (" + id + ")");
                        duplicateCount++;
                        continue;
                    }

                    Member m = new Member(id, data[1].trim(), data[2].trim(), Integer.parseInt(data[3].trim()));
                    list.add(m);
                    addedCount++;
                }
            }

            System.out.println("Read file successfully! Added " + addedCount + " members.");
            if (duplicateCount > 0) {
                System.out.println("Ignored " + duplicateCount + " duplicate member(s).");
            }

        } catch (Exception e) {
            System.out.println("File read error: " + e.getMessage());
        }
    }
}
