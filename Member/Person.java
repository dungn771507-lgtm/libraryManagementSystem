package Member;

import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class Person {
    private String ID;
    private String name;

    public Person() {
        this.ID = "";
        this.name = "";
    }
    
    public Person(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void inputPerson() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input ID: ");
        this.ID = sc.nextLine();
        System.out.println("Input Name: ");
        this.name = sc.nextLine();
    }
    
    public void outputPerson() {
        System.out.println("ID: " +this.ID);
        System.out.println("Name: " +this.name);
    }
}
