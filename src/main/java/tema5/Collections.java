package tema5;

/*
1. You need to store Persoane in a TreeSet. Define 2 Comparators (one for name - nume and one for age-varsta) that will be used when creating the TreeSet;

Add Persoane to the TreeSet; iterate through the treeset and print the name and the age;
NOTE: if you are using a Comparator, the class Persoana should not implement Comparable anymore.

2. You need to store some information about some persons: for one person, you need a list of his/her hobbies;

Define for Hobby a class that contains:

Name of hobby (String) – eq: cycling, swimming
Frequency (int) – how many times a week they practice it
List of Addresses where this hobby can be practiced (List<Adresa>)
You will use a HashMap

<Persoana, List<Hobby>>

NOTE: equals() from Persoana must be overwritten

Add some information to this map; for a certain Persoana, print the names of the hobbies and the countries where it can be practiced
 */

import java.util.*;

public class Collections {

    public static void main(String[] args) {

        /*   Generate Comparator and TreeSet for Person Data Type   */

        ComparatorForPersonAndAge comparatorForTreeSet = new ComparatorForPersonAndAge();
        Set<Person> personTreeSet = new TreeSet<>(comparatorForTreeSet);

        Person firstHuman = new Person("Adam", 1000);
        Person secondHuman = new Person ( "Eva", 1000);
        Person xHuman = new Person ( "Johan", 50);
        Person yHuman = new Person ( "Alex", 20);
        Person zHuman = new Person ( "Ada", 10);
        Person random = zHuman;
        Person wHuman = new Person ( "Sebi", 11);
        Person uHuman = new Person ( "Hubert", 18);
        Person ioiHuman = new Person ( "Zack", 18);

        System.out.println(personTreeSet.add(firstHuman));
        System.out.println(personTreeSet.add(secondHuman));
        System.out.println(personTreeSet.add(xHuman));
        System.out.println(personTreeSet.add(yHuman));
        System.out.println(personTreeSet.add(zHuman));
        System.out.println(personTreeSet.add(wHuman));
        System.out.println(personTreeSet.add(uHuman));
        System.out.println(personTreeSet.add(ioiHuman));
        System.out.println(personTreeSet.add(random));


        for ( Person person: personTreeSet ) {
            System.out.println(person);
        }

         /*   Generate Address Lists  */

        List<String> addresses = List.of("Str. Cal. Buc, nr. 100, Brasov, Romania","Bul. Cel Mare, nr. 100, Brasov, Romania","Bul. Cel Mic, nr. 1, Brasov, Romania");
        List<String> addresses2 = List.of("Str. Cal. Buc, nr. 1, Brasov, Romania","Bul. Cel Mare, nr. 2, Brasov, Romania","Bul. Cel Mic, nr. 3, Brasov, Romania");
        List<String> addresses3 = new ArrayList<>();

        addresses3.add("Bul.Cel Mare,nr.2,Brasov,Romania");
        addresses3.add("Bul.Mare,nr.1,Brasov,Romania");

        /*   Generate Hobby Lists  */
        List<Hobby> hobbyList2 = new ArrayList<>(); 
        List<Hobby> hobbyList1 = List.of(new Hobby("Tenis",10,addresses),
                                         new Hobby("Inot",5,addresses2),
                                         new Hobby("Fotbal",2,List.of("Str.Cal.Bucresti,Brasov,Romania","Bul.Cel Mare,nr.2,Brasov,Romania")));

        hobbyList2.add(new Hobby("Curling",1, new ArrayList<String>(){{add("Str. Cal. Buc, nr. 1, Brasov, Romania");}}));
        hobbyList2.add(new Hobby("Ping",2,addresses));
        hobbyList2.add(new Hobby("Ping",2,addresses3));
        hobbyList2.add(new Hobby("Pong",2,addresses2));


        Map<Person, List<Hobby>> personHobbyMap = new HashMap<>();

    }





}
