package tema3;

import java.awt.print.Book;
import java.util.Scanner;

public class Library {

    public static void main(String[] args) {



//        Scanner scan = new Scanner(System.in);
        System.out.println("\n\nWelcome to the JAVA Library of art albums and novels!");

        Books book1 = new Books("Ion","Liviu Rebreanu",200);
        Books book2 = new Books();
        Books book3 = new Novels();
        Books book4 = new ArtAlbums("test", "testautor", 1230, "abstract");
        Books book5 = new Books("Serotonina", 300);
        Books book6 = new Books("1984", "George Orwell");

        System.out.println("\n\nThe books currently in the library are:\n");

        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
        System.out.println(book4.toString());
        System.out.println(book5.toString());
        System.out.println(book6.toString());

        book6.checkOutBook();
        book5.checkOutBook();


        book2=null;








    }


}
