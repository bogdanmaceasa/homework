import org.junit.Test;
import extraHomework1.PublicMethods;

import static org.junit.Assert.assertEquals;

public class PublicMethodsTest {

    @Test
    public void firstTest() {
        double testPrime = PublicMethods.tempConverter(212);
        assertEquals("comment", true, testPrime);
    }


}
