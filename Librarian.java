package library_management_system;

import java.util.*;

public class Librarian extends Person {
    
    private String password;
    boolean IsLibrarian = false;
    static Set<String> passwords = new HashSet<String>();
    Scanner input = new Scanner(System.in);
    
    public Librarian() {
        passwords.add("A13579");
        passwords.add("B24681");
        passwords.add("H12458");
        passwords.add("R34729");
        while (true) {
            System.out.println("Please, Enter your name");
            this.name = input.next();
            System.out.println("Please, Enter your id");
            this.setId(input.nextInt());
            System.out.println("Please, Enter your Password");
            this.password = input.next();
            if (VerifyLibrarian(this.password) == false) {
                System.out.println("Sorry the Password is Wrong and this is not the password of an Librarian");
                System.out.println("Are you want to try again? YES or NO");
                String s = input.next();
                if (s.equals("NO")) {
                    break;
                }
            } else {
                IsLibrarian = true;
                break;
            }
        }
        
    }
    
    public String getPassword() {
        return password;
    }
    
    static boolean VerifyLibrarian(String pass) { // static methode to call it directly by its name without creating a refrence
        Iterator itr = passwords.iterator();
        while (itr.hasNext()) {   /// 2 3 4
            String s = (String) itr.next();// iterators return an object so we shoud casting it to string
            //passwords.add((String) itr.next());
            if (s.equals(pass)) {
                return true;
            }
        }
        return false;
    }
}
