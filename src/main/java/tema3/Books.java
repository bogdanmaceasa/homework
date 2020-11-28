package tema3;

/*

Create a small application that mimics a library catalog.
It needs to be able to:
- add books
- delete books
- list books

Books are of two kinds:
- novels
- art albums
They both have names and number of pages.


Novels have type (like mystery, sf, etc.) while albums have paper quality.

Model these entities (book, novel, album) with different classes and inheritance.


 */


public class Books {

    private String bookName;
    private String author;
    private final int pagNum;
    private boolean isAvailable;

    Books() {
        this.bookName = "Unnamed book";
        this.author = "Unnamed author";
        this.isAvailable = true;
        this.pagNum = 0;
        System.out.print("\nAn unknown book has been added to the library.");
    }

    Books(String bookName, String author, int pagNum) {
        this.bookName = bookName;
        this.author = author;
        this.pagNum = pagNum;
        System.out.print("\nA new book was checked into the library.");
    }

    Books(String bookName, int pagNum) {

        this.bookName = bookName;
        this.pagNum = pagNum;
        System.out.print("\nA new book was checked into the library.The author is unknown.");
    }

    Books(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
        System.out.print("\nA new book was checked into the library.Page number is unknown.It will forever remain a mistery!");
        this.pagNum = 0;
    }

    public void setName(String name) {
        this.bookName = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void checkOutBook() {
        isAvailable = false;
        System.out.println("The book " + this.bookName + " has has been checked out and is now unavailable!");
    }

    public void returnBook(){
        isAvailable = true;
        System.out.println("The book" + this.bookName + "has been returned to the library!");
    }

    public String getName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getPagNum() {
        return pagNum;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", pagNum=" + pagNum +
                '}';
    }



}
