package library_management_system;

import java.util.Scanner;

public class Student extends Person {

    Scanner input = new Scanner(System.in);
    String grade;
    int academicNumber;

    public Student(String name,int id,String grade,int acadNo) {
        super(name,id);
        this.grade=grade;
        this.academicNumber=acadNo;
    }

    public void setAcademicNumber(int academicNumber) {
        this.academicNumber = academicNumber;
    }

    public int getAcademicNumber() {
        return academicNumber;
    }

    public void setGrade(String Class) {
        this.grade = Class;
    }

    public String getGrade() {
        return grade;
    }

    public void Get_Book_Inf(String s) {
        int i=new Library_Database().SearchBookWithName(s);
        Book b=new Library_Database().books.get(i);
        b.DisplayBookDetails();
    }

    public void borrowABook(Book b) {
        new Library_Database().borrowedBook(b, this); // anonymous object
        System.out.println("The book is borrowed successfully :)");
    }

    public void returnABook(Book b) {
        new Library_Database().ReturnedBook(b, this);
        System.out.println("The book is returned successfully :)");
    }
}
