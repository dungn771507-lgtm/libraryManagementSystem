package Record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class ManageRecord{
    private ArrayList<Record> list;

    public ManageRecord() {
        this.list = new ArrayList<>();
    }

    public ManageRecord(ArrayList<Record> list) {
        this.list = list;
    }
    
    public Record searchById(String id) {
        for (Record record : this.list) {
            if (record.getRecordId().equalsIgnoreCase(id)) {
                return record;
            }
        }
        return null;
    }

    public boolean addRecord(Record newRecord) {
        if (this.searchById(newRecord.getRecordId()) == null) {
            this.list.add(newRecord);
            return true;
        }
        return false;
    }

    public void inputRecords() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Record r = new Record();
            r.InputRecord();
            if (this.addRecord(r)) {
                System.out.println("Add complete");
                saveFile("records.txt");
            } else {
                System.out.println("Error - Record ID: " + r.getRecordId() + " exist");
            }
            System.out.print("Add more record? (Y/N): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
    
    public void updateRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInput Record ID to find: ");
        String id = sc.nextLine();
        Record r = this.searchById(id);
        if (r != null) {
            while(true){
            System.out.println("Input return day (dd/mm/yyyy) : ");
            String inputreturnDay = sc.nextLine();
                if(r.checkreturnDay(inputreturnDay)){
                    r.setReturnDay(inputreturnDay);
                    System.out.println("Update success");
                    saveFile("records.txt");
                    break;
                } else {
                    System.out.println("Invalid date! Please input again following format dd/mm/yyyy");
                }
            }
        } else {
            System.out.println("Record ID: " + id + " does not exist");
        }
    }

    public void searchRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Record ID to find: ");
        String id = sc.nextLine();
        Record r = this.searchById(id);
        if (r != null) {
            r.listRecord();
        } else {
            System.out.println("Record ID: " + id + " does not exist");
        }
    }
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("Empty record list");
            return;
        }
        for (Record record : list) {
            record.listRecord();
        }
    }
    
    public void saveFile(String file) {
        PrintWriter f=null;
        try {
            f = new PrintWriter(file);
            for (Record r : list) {
                String s = r.getRecordId()+ "," +r.getBorrowDay() + "," +r.getDueDay() + "," +r.getReturnDay();
                f.print(s);
                f.flush();
            }
        } catch (Exception e) {
            System.out.println("Sth Error");
        } finally {
            try {
                if (f != null) f.close();    
            } catch (Exception e) {
                System.out.println("Sth Error");
            }
        }
    }
    
    public void loadFile(String tenfile) {
    FileReader f      = null;
    BufferedReader bf = null;
    try {
        f  = new FileReader(tenfile);
        bf = new BufferedReader(f);
        while (bf.ready()) {
            String line  = bf.readLine();
            String[] arr = line.split(",", -1);

            if (arr.length >= 3) {
                String recordId  = arr[0];
                String borrowDay = arr[1];
                String dueDay    = arr[2];
                String returnDay = arr.length == 4 ? arr[3] : "";

                Record r = new Record(recordId, borrowDay, dueDay, returnDay);
                list.add(r);
            }
        }
        System.out.println("Load file success!");
    } catch (Exception e) {
        System.out.println("No saved data found");
    } finally {
        try {
            if (f  != null) f.close();
            if (bf != null) bf.close();
        } catch (Exception e) {
            System.out.println("Sth Error");
        }
    }
}
}
