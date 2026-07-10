package Library;

import Member.Librarian;
import Member.Member;
import java.util.ArrayList;
  
/**
 *
 * @author MySimp
 */
public class ManageLibrary {
    private ArrayList<Member> list;
    private ArrayList<Librarian> librarians;
    private Library lib;

    public ManageLibrary(String libraryName, String address) {
        lib=new Library();
        lib.InputLibrary();
        list = new ArrayList<>();
        librarians = new ArrayList<>();
    }

    public Library getLib() {
        return lib;
    }

    public void setLib(Library lib) {
        this.lib = lib;
    }
    
    
    public void addMember(Member member) {
        list.add(member);
        System.out.println("Member added successfully.");
    }

    public boolean deleteMember(String memberId) {
        for (Member m : list) {
            if (m.getID().equals(memberId)) {
                list.remove(m);
                System.out.println("Member deleted successfully.");
                return true;
            }
        }
        System.out.println("Member not found.");
        return false;
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
        System.out.println("Librarian added successfully.");
    }

    public boolean deleteLibrarian(String librarianId) {
        for (Librarian l : librarians) {
            if (l.getID().equals(librarianId)) {
                librarians.remove(l);
                System.out.println("Librarian deleted successfully.");
                return true;
            }
        }
        System.out.println("Librarian not found.");
        return false;
    }

    public void displayLibrary() {
//        System.out.println("Library Name: " + getLibraryName());
//        System.out.println("Address: " + getAddress());
//        System.out.println("Number of Members: " + list.size());
//        System.out.println("Number of Librarians: " + librarians.size());
        lib.outputLibrary();
        for (Librarian li : librarians) {
                    li.outputPerson();
                }
        for (Member member : list) {
            member.outputPerson();
        }
    }
}
