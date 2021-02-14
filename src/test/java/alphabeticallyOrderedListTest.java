import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import tema8Java8.alphabeticallyOrderedList.ComparatorForPerson;
import tema8Java8.alphabeticallyOrderedList.Person;
import tema8Java8.alphabeticallyOrderedList.PublicMethods;

import java.time.Month;

@RunWith(MockitoJUnitRunner.class)
public class alphabeticallyOrderedListTest {

    @InjectMocks
    private PublicMethods alphabeticallyOrderedList;
    private final ComparatorForPerson comparatorForPerson = new ComparatorForPerson();

    @Test
    public void alphabeticallyOrderedListTest() {

        String line = "Bogdan,Maceasa,1988/01/23";

        Person person = alphabeticallyOrderedList.mapToPerson(line);

        Assert.assertEquals("Bogdan",person.getFirstName());
        Assert.assertEquals("Maceasa",person.getLastName());
        Assert.assertEquals(1988,person.getDateOfBirth().getYear());
        Assert.assertEquals(Month.JANUARY,person.getDateOfBirth().getMonth());
        Assert.assertEquals(23,person.getDateOfBirth().getDayOfMonth());

    }

    @Test
    public void csvLineToSkierResultsListMappingTest() {
        // Given
        String line1 = "Bogdan,Maceasa,1988/01/23";
        String line2 = "Andrei,Ionescu,2000/12/23";
        String line3 = "Jimmy,Smitzer,2010/05/12";
        String line4 = "Ian,Smitzer,2011/10/12";
        String line5 = "Ian,Smitzer,2015/10/12";

        Person person1 = alphabeticallyOrderedList.mapToPerson(line1);
        Person person2 = alphabeticallyOrderedList.mapToPerson(line2);
        Person person3 = alphabeticallyOrderedList.mapToPerson(line3);
        Person person4 = alphabeticallyOrderedList.mapToPerson(line4);
        Person person5 = alphabeticallyOrderedList.mapToPerson(line5);

        // When

        int compare = comparatorForPerson.compare(person1,person2);
        int compare2 = comparatorForPerson.compare(person2,person3);
        int compare3 = comparatorForPerson.compare(person1,person3);
        int compare4 = comparatorForPerson.compare(person4,person3);
        int compare5 = comparatorForPerson.compare(person5,person4);


        // Then
        Assert.assertEquals(1,compare);
        Assert.assertEquals(-1,compare2);
        Assert.assertEquals(-1,compare3);
        Assert.assertEquals(-1,compare4);
        Assert.assertEquals(-1,compare5);


    }

}

