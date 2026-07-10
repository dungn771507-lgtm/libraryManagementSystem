package Library;

import java.util.Scanner;

/**
 *
 * @author MySimp
 */
public class Library {
    private String libraryName;
    private String address;
    
    public Library() {
        this.libraryName = "";
        this.address = "";
    }

    public Library(String libraryName, String address) {
        this.libraryName = libraryName;
        this.address = address;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void InputLibrary() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input Library Name: ");
        this.libraryName = sc.nextLine();
        System.out.println("Input Address: ");
        this.address = sc.nextLine();
    }
    public void outputLibrary() {
        System.out.println("Library Name: " + this.libraryName);
        System.out.println("Address: " + this.address);
    }
    
}
