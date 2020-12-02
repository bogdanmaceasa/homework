package tema3;

public class Library {

    public static void main(String[] args) {



//        Scanner scan = new Scanner(System.in);
        System.out.println("\n\nWelcome to the JAVA Library of art albums and novels!");

        Book book1 = new Book("Ion","Liviu Rebreanu",200);
        Book book2 = new Book();
        Book book3 = new Novel();
        Book book4 = new ArtAlbums("test", "testautor", 1230, "abstract", "pristine");
        Book book5 = new Book("Serotonina", 300);
        Book book6 = new Book("1984", "George Orwell");
        Book book7 = new Novel("Brave new world", "Aldous Huxley", 300 , "fiction");
        Novel book8 = new Novel("Serlock Holmes", "Arthur Doyle", 200, "detective");

        System.out.println("\n\nThe books currently in the library are:\n");

        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
        System.out.println(book4.toString());
        System.out.println(book5.toString());
        System.out.println(book6.toString());

        book6.checkOutBook();
        book5.checkOutBook();
        book4.checkOutBook();

        if(book5.isAvailable())
            System.out.println(book5.getName() + " is available and can be read or borrowed." );
        else System.out.println(book5.getName() + " is currently not available. Please come again!");

        book4.readBook();
        book7.readBook();
        book8.readBook();

        Book book9= (Book) book8;
        System.out.println(book9.toString());
        book9.readBook();

        book6.returnBook();


        book2=null;








    }


}
