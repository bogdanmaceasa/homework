package tema4;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StringManipulationTests {

    @Test
    public void testReverseStringPublic(){

        String string = "mere";
        string = StringManipulation.reverseStringPublic(string);
        Assert.assertEquals("test for Reverse String method", "erem", string );
    }

    @Test
    public void testDuplicateCharsPublic(){

        String string = "mere";
        String stringArr = StringManipulation.duplicateCharsPublic(string);
        Assert.assertEquals("test for duplicate String method", "e", stringArr );
    }

    @Test
    public void testIsAnagramPublic(){

        String str = "amer";
        String strB= "mare";
        boolean test = StringManipulation.isAnagramPublic(str,strB);
        Assert.assertEquals("test for anagram checker String method", true, test );
    }

    @Test
    public void testContainsOnlyDigits(){

        String str = "1234";
        boolean test = StringManipulation.containsOnlyDigits(str);
        Assert.assertEquals("test for numeric string checker method", true, test );
    }

    @Test
    public void testContainsOnlyDigitsError(){

        String str = "123z4";
        boolean test = StringManipulation.containsOnlyDigits(str);
        Assert.assertEquals("test for numeric string checker method", false, test );
    }

    @Test
    public void testCountConsonantsVowels(){

        String str = "123z4";
        boolean test = StringManipulation.containsOnlyDigits(str);
        Assert.assertEquals("test for numeric string checker method", false, test );
    }

    @Test
    public void testCountOccurrenceInString(){

        String str = "aio123u4nmd1ac1a";
        int test = StringManipulation.countOccurrenceInString(str,'a');
        Assert.assertEquals("test character occurance in string checker method", 3, test );
    }


}
