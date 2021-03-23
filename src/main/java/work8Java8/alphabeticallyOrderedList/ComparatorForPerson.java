package work8Java8.alphabeticallyOrderedList;

import java.util.Comparator;

public class ComparatorForPerson implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        if (o1.getLastName().compareTo(o2.getLastName()) > 0) {
            return 1;
        }
        if (o1.getLastName().compareTo(o2.getLastName()) < 0) {
            return -1;
        }
        if (o1.getFirstName().compareTo(o2.getFirstName()) > 0) {
            return 1;
        }
        if (o1.getFirstName().compareTo(o2.getFirstName()) < 0) {
            return -1;
        }
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());

    }


}
