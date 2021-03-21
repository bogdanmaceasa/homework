package tema3Library;

public class Library {

    public static void main(String[] args) {

        System.out.println("\n\nWelcome to the JAVA Library of art albums and novels!");

        Book[] libraryDataBase = new Book[50];

//      we create a list of all books that are added to the library
        libraryDataBase[0] = new Book("Ion", "Liviu Rebreanu", 200);
        libraryDataBase[1] = new Book();
        libraryDataBase[2] = new Novel();
        libraryDataBase[3] = new ArtAlbums("test", "testautor", 1230, "abstract", "pristine");
        libraryDataBase[4] = new Book("Serotonina", 300);
        libraryDataBase[5] = new Book("1984", "George Orwell");
        libraryDataBase[6] = new Novel("Brave new world", "Aldous Huxley", 300, "fiction");
        libraryDataBase[7] = new Novel("Serlock Holmes", "Arthur Doyle", 200, "detective");

        System.out.println("\n\nThe valid books listed in the library are:\n");

        int indexOfValidBooks = 0;
        // all valid books in the library should have a book name, all other information is optional
        // book name and author name cannot be changed
        // book number of pages can be edited - maybe after the first read ?

        for (Book book : libraryDataBase) {
            if (book != null)
                if (book.getName() != "Unnamed book") { /*!book.equals(new Book() creates a new instance for each element that is not null which gets output at the constructor level*/
                    System.out.println(book.toString());
                    indexOfValidBooks++;
                }

        }

        System.out.println();
        libraryDataBase[4].checkOutBook();
        libraryDataBase[5].checkOutBook();
        System.out.println();
        if (libraryDataBase[4].isAvailable())
            System.out.println(libraryDataBase[4].getName() + " is available and can be read or borrowed.");
        else System.out.println(libraryDataBase[4].getName() + " is currently not available. Please come again!");
        System.out.println();
        libraryDataBase[4].readBook();
        libraryDataBase[7].readBook();
        System.out.println();
//        libraryBookList[7].getNovelType();

//      after cast you can access the method from Novel class
        System.out.println();
        Novel book9 = (Novel) libraryDataBase[7];
        System.out.println("novel type " + book9.getNovelType());
        ;
        System.out.println(book9.toString());
        System.out.println();
//      datatype of reference is changed in casting. it points to the same instance - which is a Novel object.
        Book book10 = (Book) libraryDataBase[7];
        System.out.println(book10.toString());
//        System.out.println(book9.getNovelType()); // book9 is a reference of Novel Class
//        System.out.println(book10.getNovelType()); // book10 is a reference of Book Class, it does not have access to getNovelType method
        System.out.println();

    }
}
