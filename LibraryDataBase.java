package library_management_system;
public interface LibraryDataBase {
    void add();//public abstract void add()
    void remove();
    void remove(Book b);
    int searchBook(Book b);
    int SearchBookWithName(String name);
    int SearchBookWithSNo(int sNo);
    void DisplayAllBooks();
    void borrowedBook(Book b,Student s);
    void ReturnedBook(Book b,Student s);
    void ShowAllBorrowingOperation();
}
