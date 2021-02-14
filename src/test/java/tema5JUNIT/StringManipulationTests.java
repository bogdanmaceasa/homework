package tema5JUNIT;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import tema4ATM.StringManipulation;


@RunWith(MockitoJUnitRunner.class)
public class StringManipulationTests {

    /*  String Manipulation tests  */

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
    public void testIsAnagramPublicTwo(){
        String str = "anagram";
        String strB= "margana";
        boolean test = StringManipulation.isAnagramPublicTwo(str,strB);
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

    @Test
    public void testFirstNonRepeat(){
        String str = "aio123u4nmd1ac1a";
        String test = StringManipulation.firstNonRepeat(str);
        Assert.assertEquals("test first non-repetitive char in string checker method", "i", test );
    }

    @Test
    public void testFirstNonRepeatTwo(){
        String str = "aioaio";
        String test = StringManipulation.firstNonRepeat(str);
        Assert.assertEquals("test first non-repetitive char in string checker method", "no unique elements", test );
    }

    @Test
    public void testConvertToInt(){
        String str = "123412";
        int test = StringManipulation.convertToInt(str);
        Assert.assertEquals("test first non-repetitive char in string checker method", 123412, test );
    }

    @Test
    public void testWordOccurrence(){
        String[] words = {"wor", "wor", "is", "apple", "wait", "play", "music", "play", "wor", "play"};
        String test = StringManipulation.wordOccurrence(words);
        Assert.assertEquals("test first non-repetitive char in string checker method", "wor", test );

    }


    /* Hackerrank tests */

    @Test
    public void testGetSmallestAndLargest(){
        String str = "welcometojava";
        String test = StringManipulation.getSmallestAndLargest(str,3);
        Assert.assertEquals("test", "ava\n" +"wel", test);

    }

    @Test
    public void testReturnTokens(){
        String str = "                a                    ";
        String test = StringManipulation.returnTokens(str);
        Assert.assertEquals("test", "1\n" +
                "a", test);


    }


}
