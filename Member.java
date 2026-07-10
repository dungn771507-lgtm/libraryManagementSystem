/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class Member extends Person{
    private String borrowday;
    private int borrowPeriod;

    public Member() {
        super();
        this.borrowday = "";
        this.borrowPeriod = 0;
    }

    public Member(String ID, String name, String borrowday, int borrowPeriod) {
        super(ID, name);
        this.borrowday = borrowday;
        this.borrowPeriod = borrowPeriod;
    }

    public String getBorrowday() {
        return borrowday;
    }

    public void setBorrowday(String borrowday) {
        this.borrowday = borrowday;
    }

    public int getBorrowPeriod() {
        return borrowPeriod;
    }

    public void setBorrowPeriod(int borrowPeriod) {
        this.borrowPeriod = borrowPeriod;
    }

    @Override
    public void inputPerson() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input Name: ");
        this.setName(sc.nextLine());

        while (true) {
            System.out.println("Input borrowday (dd/mm/yyyy) : ");
            String inputborrowday = sc.nextLine();

            if (checkborrowday(inputborrowday)) {
                this.borrowday = inputborrowday;
                break;
            } else {
                System.out.println("Invalid date! Please input again following format dd/mm/yyyy :");
            }
        }

        while (true) {
            try {
                System.out.println("Input borrowed period (number of days): ");
                int period = Integer.parseInt(sc.nextLine());

                if (period > 0) {
                    this.borrowPeriod = period;
                    break;
                } else {
                    System.out.println("Period must be greater than 0!");
                }
            } catch (NumberFormatException error) {
                System.out.println("Invalid input! Please enter a valid whole number.");
            }
        }
    }

    @Override
    public void outputPerson() {
        super.outputPerson(); 
        System.out.println("Borrow Day :" + this.borrowday);
        System.out.println("Borrowed Period: " + this.borrowPeriod + " days");
        System.out.println("Due Day (Expired): " + this.expiredday());
    }

    public boolean checkborrowday(String checkday) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(checkday, formatter);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public String expiredday() {
        if (this.borrowday == null || this.borrowday.equals("")) {
            return "No book borrowing date yet ";
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate borrday = LocalDate.parse(this.borrowday, formatter);
            LocalDate dueday = borrday.plusDays(this.borrowPeriod);
            return dueday.format(formatter);
        } catch (Exception error) {
            return "Expired day calculation error";
        }
    }
}
