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


class Book implements BookActionsTemplate {

    private final String bookName; // final instance variable that needs to be assigned a value in all constructors
    private final String author; // final instance variable that needs to be assigned a value in all constructors
    private int pagNum;
    private boolean isAvailable;

    Book() {
        this.bookName = "Unnamed book";
        this.author = "Unnamed author";
        this.pagNum = 0;
        this.isAvailable = true;
        System.out.print("\nAn unknown book has been added to the library. As it is unreadable, it will not be useful in the library. You need to throw it and add another one.");
    }

    Book(String bookName, String author, int pagNum) {
        this.bookName = bookName;
        this.author = author;
        this.pagNum = pagNum;
        this.isAvailable = true;
        System.out.print("\nA new book was checked into the library.");
    }

    Book(String bookName, int pagNum) {

        this.bookName = bookName;
        this.author = "Unnamed author";
        this.pagNum = pagNum;
        this.isAvailable = true;
        System.out.print("\nA new book was checked into the library.The author is and forever will remain unknown.");
    }

    Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
        this.isAvailable = true;
        System.out.print("\nA new book was checked into the library.Page number is unknown.");

    }

    @Override
    public void checkOutBook() {
        isAvailable = false;
        System.out.print("\nThe book " + this.bookName + " has has been checked out and is now unavailable!");
    }

    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.print("\nThe book " + this.bookName + " has been returned to the library!");
    }

    public void setPagNum(int pagNum) {
        this.pagNum = pagNum;
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

    public void readBook(){
        System.out.println("Someone is reading, please be quiet while in the library!");
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
