package library_management_system;

import java.util.*;

public class Library_Database implements LibraryDataBase {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Book> BorrowedBooks = new ArrayList<>();
    static Map<Student, Book> Borrowing = new HashMap<>();
    Scanner input = new Scanner(System.in);
    static int cntBooks;

    @Override
     public void add() {
        System.out.println("Let's go to add a new book");
        Book b = new Book();
        System.out.println("Enter the title of the book");
        b.title = input.next();
        System.out.println("Enter the serial number of the book");
        b.SNo = input.nextInt();
        System.out.println("Enter the name of the author of the book");
        b.author = input.next();
        books.add(b);
        cntBooks++;
    }

    public void add(Book b) {
        books.add(b);
        cntBooks++;
    }

    public void remove() {
        Book b = new Book();
        System.out.println("Enter the title of the book");
        b.title = input.next();
        System.out.println("Enter the serial number of the book");
        b.SNo = input.nextInt();
        System.out.println("Enter the name of the author of the book");
        b.author = input.next();
        int idx=this.SearchBookWithSNo(b.SNo);
        books.remove(idx);
        cntBooks--;
    }

    public void remove(Book b) {
        int idx=this.SearchBookWithSNo(b.SNo);
        books.remove(idx);
        cntBooks--;
    }

    public void DisplayAllBooks() {
        System.out.println("The books will be displayed now ");
        for (int i = 0; i < cntBooks; i++) {
            System.out.println("Book number " + (i + 1));
            System.out.println("Book's title is: " + books.get(i).title);
            System.out.println("Book's author is: " + books.get(i).author);
            System.out.println("Book's serialNumber is: " + books.get(i).SNo);
            // books.get(i).DisplayBookDetails();
        }
        System.out.println("The Books is displayed successfully");
    }

    public int searchBook(Book b) {
        System.out.println("Let's go to sercch if the book is existing or not");
        for (int i = 0; i < cntBooks; i++) {
            if (books.get(i).SNo == b.SNo) {
                return i;
            }
        }
        return -1;
    }

    public int SearchBookWithName(String name) {
        System.out.println("Let's go to sercch if the book's name is existing or not ");
        for (int i = 0; i < cntBooks; i++) {
            if ((books.get(i).title).equals(name)) { 
                return i;
            }
        }
        return -1;
    }

    public int SearchBookWithSNo(int sNo) {
        System.out.println("Let's go to search for the book");
        for (int i = 0; i < cntBooks; i++) {
            if (books.get(i).SNo == sNo) {
                return i;
            }
        }
        return -1;

    }

    public void borrowedBook(Book b, Student s) {
        this.remove(b);
        //cntBooks--;
        BorrowedBooks.add(b);
        Borrowing.put(s, b);
    }

    public void ReturnedBook(Book b, Student s) {
        this.add(b);
        //cntBooks++;
        Borrowing.replace(s, b);
        BorrowedBooks.remove(b);
    }

    public void ShowAllBorrowingOperation() {
        System.out.println("The number of Borrowing Operations is: " + Borrowing.size());
        for (Student key : Borrowing.keySet()) {
            Student s = key;
            Book b = Borrowing.get(s);
            System.out.println("Student academicNumber is: " + s.academicNumber + " and the SerailNumber of the book is: " + b.SNo);
        }
    }

}
