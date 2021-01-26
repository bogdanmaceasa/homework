package tema6;

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

        Person xHuman = new Person ( "Johan", 50);
        Person yHuman = new Person ( "Alex", 20);
        Person zHuman = new Person ( "Ada", 10);
        Person wHuman = new Person ( "Sebi", 11);
        Person uHuman = new Person ( "Hubert", 18);
        Person ioiHuman = new Person ( "Zack", 18);

        personTreeSet.add(xHuman);
        personTreeSet.add(yHuman);
        personTreeSet.add(zHuman);
        personTreeSet.add(wHuman);
        personTreeSet.add(uHuman);
        personTreeSet.add(ioiHuman);

         /*   Generate Address Lists  */

        List<String> addresses = List.of("Brasov","Bucuresti");
        List<String> addresses2 = List.of("Bucuresti","Iasi","Cluj");
        List<String> addresses3 = new ArrayList<>();

        addresses3.add("Brasov");
        addresses3.add("Timisoara");


        /*   Generate Hobby Lists  */
        List<Hobby> hobbyList1 = new ArrayList<>();
        List<Hobby> hobbyList2 = List.of(new Hobby("Tenis",10,addresses),
                                         new Hobby("Fotbal",2,List.of("Bacau","Sibiu")));
        List<Hobby> hobbyList3 = List.of(new Hobby("Rugby",10,addresses),
                new Hobby("Basketball",2,List.of("Brasov","Sibiu")));

        hobbyList1.add(new Hobby("Curling",1, new ArrayList<String>(){{add("M.Ciuc");}}));
        hobbyList1.add(new Hobby("Ping",2,addresses2));
        hobbyList1.add(new Hobby("Pong",2,addresses3));


        /*   Generate Person - Hobby hashMap  */
        Map<Person, List<Hobby>> personHobbyMap = new HashMap<>();

        for ( Person person: personTreeSet){
            if ( person.getName().equals("Johan")
                    || person.getName().equals("Sebi")){
                personHobbyMap.put(person,hobbyList1);
            } else if ( person.getName().equals("Hubert") ) {
                personHobbyMap.put(person,hobbyList3);
            } else personHobbyMap.put(person,hobbyList2);
        }

        for (Person key : personTreeSet ){
            System.out.println(key + " "  + personHobbyMap.get(key));
        }
    }





}
