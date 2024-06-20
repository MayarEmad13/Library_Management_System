package library_management_system;

import java.util.Scanner;

public class Library_Management_System {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Library Management System");
        LibraryDataBase data = new Library_Database();
        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Are you a Librarian or Student?");
            String s = input.next();
            s = s.trim().toLowerCase(); // STUDENT ----> student
            if (s.equals("librarian")) {
                Librarian lib = new Librarian(); // calling the constructor
                if (lib.IsLibrarian == false) {
                    continue;
                }
                boolean flag = true;
                while (flag == true) {
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("select from the following options what do you want?");
                    System.out.println("press 0 to add new book");
                    System.out.println("press 1 to delete a book");
                    System.out.println("press 2 to display all existing books");
                    System.out.println("press 3 to search for a book");
                    System.out.println("press 4 to display all borrowing operations and from who!");
                    System.out.println("press 5 to logout");
                    int choise = input.nextInt();
                    switch (choise) {
                        case 0:
                            data.add();
                            break;
                        case 1:
                            data.remove();
                            break;
                        case 2:
                            data.DisplayAllBooks();
                            break;
                        case 3:
                            System.out.println("Do you want Searching by the title or by sNo of the book?");
                            String ss = input.next();
                            if (ss.equals("sNo")) {
                                System.out.println("Enter the SerialNumber of the book");
                                int sno = input.nextInt();
                                int x=data.SearchBookWithSNo(sno);
                                if(x==-1)
                                    System.out.println("the book is not found");
                                else 
                                    System.out.println("the book is found and its number is: "+(x+1));
                            } else {
                                System.out.println("Enter the title of the book");
                                ss = input.next();
                                int x=data.SearchBookWithName(ss);
                                if(x==-1)
                                    System.out.println("the book is not found");
                                else
                                    System.out.println("the book is found and its number is: "+(x+1));
                            }
                            break;
                        case 4:
                            data.ShowAllBorrowingOperation();
                            break;
                        case 5:
                            flag = false;
                            break;
                        default:
                            System.out.println("your choise is wrong, Try again");
                            break;
                    }
                }

            } else {
                 System.out.println("Please, Enter your name");
                 String nam=input.next();
                 System.out.println("Please, Enter your id");
                 int id=input.nextInt();
                 System.out.println("Please, Enter your grade");
                 String grade=input.next();
                 System.out.println("Please, Enter your academicNumber");
                 int aca=input.nextInt();
                 Student st=new Student(nam,id,grade,aca);
                 boolean flag = true;
                while (flag == true) {
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("select from the following options what do you want?");
                    System.out.println("press 0 to borrow a book");
                    System.out.println("press 1 to return a book");
                    System.out.println("press 2 to display all existing books");
                    System.out.println("press 3 to search for a book");
                    System.out.println("press 4 to get information about a book by its title");
                    System.out.println("press 5 to logout");
                    int choise = input.nextInt();
                    switch (choise) {
                        case 0:
                            System.out.println("Please, Enter the serialNumber of the book, its title and its author that you want to borrow it");
                            int se=input.nextInt();
                            String title=input.next();
                            String author=input.next();
                            Book b=new Book();
                            b.setSNo(se);
                            b.setTitle(title);
                            b.setAuthor(author);
                            st.borrowABook(b);
                            break;
                        case 1:
                            System.out.println("Please, Enter the serialNumber of the book, its title and its author that you want to return it");
                            se=input.nextInt();
                            title=input.next();
                            author=input.next();
                            Book bb=new Book();
                            bb.setSNo(se);
                            bb.setTitle(title);
                            bb.setAuthor(author);
                            st.returnABook(bb);
                            break;
                        case 2:
                            data.DisplayAllBooks();
                            break;
                        case 3:
                            System.out.println("Do you want Searching by the title or by sNo of the book?");
                            String ss = input.next();
                            if (ss.equals("sNo")) {
                                System.out.println("Enter the SerialNumber of the book");
                                int sno = input.nextInt();
                                int x=data.SearchBookWithSNo(sno);
                                if(x==-1)
                                    System.out.println("the book is not found");
                                else
                                    System.out.println("the book is found and its number is: "+(x+1));
                            } else {
                                System.out.println("Enter the title of the book");
                                ss = input.next();
                                int x=data.SearchBookWithName(ss);
                                if(x==-1)
                                    System.out.println("the book is not found");
                                else
                                    System.out.println("the book is found and its number is: "+x);
                            }
                            break;
                        case 4:
                            System.out.println("Enter the title");
                            String tit=input.next();
                            st.Get_Book_Inf(tit);
                            break;
                        case 5:
                            flag = false;
                            break;
                        default:
                            System.out.println("your choise is wrong, Try again");
                            break;
                    }
                }
            }
        }
    }

}
