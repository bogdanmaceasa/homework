package tema3;

public class Library {

    public static void main(String[] args) {
        System.out.println("\n\nWelcome to the JAVA Library of art albums and novels!");

        Book book1 = new Book("Ion","Liviu Rebreanu",200);
        Book book2 = new Book();
        Book book3 = new Novel();
        Book book4 = new ArtAlbums("test", "testautor", 1230, "abstract", "pristine");
        Book book5 = new Book("Serotonina", 300);
        Book book6 = new Book("1984", "George Orwell");
        Book book7 = new Novel("Brave new world", "Aldous Huxley", 300 , "fiction");
        Novel book8 = new Novel("Serlock Holmes", "Arthur Doyle", 200, "detective");
//      If and when I make the variable book# refer to something, that something will be an instance of the Book class.

        System.out.println("\n\nThe books currently in the library are:\n");

//        System.out.println(book1.toString());
//        System.out.println(book2.toString());
//        System.out.println(book3.toString());
//        System.out.println(book4.toString());
//        System.out.println(book5.toString());
//        System.out.println(book6.toString());

        book6.checkOutBook();
        book4.checkOutBook();

        if(book5.isAvailable())
            System.out.println(book5.getName() + " is available and can be read or borrowed." );
        else System.out.println(book5.getName() + " is currently not available. Please come again!");

        book4.readBook();
        book8.readBook();
//        System.out.println(book7.getNovelType()); // book8 cannot access methods from Novel - it is a Reference of Book

//      after cast you can access the method from Novel class
        Novel book9= (Novel) book7;
        System.out.println("novel type " + book9.getNovelType());;
        System.out.println(book9.toString());

//      datatype of reference is changed in casting. it points to the same instance - which is a Novel object.
        Book book10= (Book) book8;
        System.out.println(book10.toString());
//        System.out.println(book8.getNovelType()); // book8 is a reference of Novel Class
//        System.out.println(book10.getNovelType()); // book10 is a reference of Book Class, it does not have access to getNovelType method

//        Novel bookNovelRef = (Novel) book1; // error ?!
//        System.out.println(bookNovelRef.getNovelType());
//        System.out.println(book6.getNovelType());
//        System.out.println(book1.toString());
//        System.out.println(bookNovelRef.toString());

        book6.returnBook();

        book2=null;

    }
}
