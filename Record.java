/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Record;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class Record {
    private String recordId;
    private String borrowDay;
    private String dueDay;
    private String returnDay;
    
    public Record() {
        this.recordId = "";
        this.borrowDay = "";
        this.dueDay = "";
        this.returnDay = "";
    }

    public Record(String recordId, String borrowDay, String dueDay, String returnDay) {
        this.recordId = recordId;
        this.borrowDay = borrowDay;
        this.dueDay = dueDay;
        this.returnDay = returnDay;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(String borrowDay) {
        this.borrowDay = borrowDay;
    }

    public String getDueDay() {
        return dueDay;
    }

    public void setDueDay(String dueDay) {
        this.dueDay = dueDay;
    }

    public String getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(String returnDay) {
        this.returnDay = returnDay;
    }

    

    public void InputRecord() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input Record ID: ");
        this.recordId = sc.nextLine();
        
        while(true){
            System.out.println("Input borrow day (dd/mm/yyyy) : ");
            String inputborrowDay = sc.nextLine();
            
            if(checkborrowDay(inputborrowDay)){
                this.borrowDay=inputborrowDay;
                break;
            } else {
                System.out.println("Invalid date! Please input again following format dd/mm/yyyy");
            }
        }
        
        while(true){
            System.out.println("Input due day (dd/mm/yyyy) : ");
            String input = sc.nextLine();
            
            if (!checkdueDay(input)) {
                System.out.println("Invalid date! Please input again following format dd/mm/yyyy");
            } else if (!checkAfter(input, this.borrowDay)) {
                System.out.println("Due day must be after borrow day: "+ this.borrowDay);
            } else {
                this.dueDay = input;
                break;
            }
        }
        
        this.returnDay = "";
    }
    
    public void listRecord() {
        System.out.println("\nRecord ID: " + this.recordId);
        System.out.println("Borrow Date: " + this.borrowDay);
        System.out.println("Due Date: " + this.dueDay);
        if (returnDay.equals("")) {
            System.out.println("Return Date: not returned");
        } else {
            System.out.println("Return Day: " + this.returnDay);
        }
        System.out.println("Fine: " + "$");
    }
    
    public boolean checkborrowDay (String checkday){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(checkday,formatter);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean checkdueDay (String checkday){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(checkday,formatter);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean checkAfter(String date1, String date2) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d1 = LocalDate.parse(date1, formatter);
            LocalDate d2 = LocalDate.parse(date2, formatter);
            return d1.isAfter(d2);
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean checkreturnDay (String checkday){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(checkday,formatter);
            return true;
        }catch(Exception error){
            return false;
        }
    }
}
