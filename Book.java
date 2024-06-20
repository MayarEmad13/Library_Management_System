package library_management_system;

public class Book {

    String title;
    String author;
    int SNo;
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSNo(int SNo) {
        this.SNo = SNo;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getSNo() {
        return SNo;
    }

    void DisplayBookDetails() {
        System.out.println("The title of the book is: " + this.title);
        System.out.println("The author of the book is: " + this.author);
        System.out.println("The serial number of the book is: " + this.SNo);
    }
}
