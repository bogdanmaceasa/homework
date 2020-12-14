package tema4;

import java.awt.desktop.PreferencesEvent;
import java.util.Arrays;

public class StringMain {


    public static void main(String[] args) {

        String inputString = "are";
        System.out.println(inputString);
        inputString = StringManipulation.reverseStringPublic(inputString);
        System.out.println(inputString);
        System.out.println(reverseStringPrivate(inputString));

        System.out.println(StringManipulation.duplicateCharsPublic(inputString));
        System.out.println(duplicateCharsPrivate(inputString));

        String inputStringtwo = "aer";
        if ( StringManipulation.isAnagramPublic(inputString,inputStringtwo))
            System.out.println("strings are anagrams");
        else System.out.println("strings are not anagrams");

        if ( isAnagramPrivate(inputString,inputStringtwo))
            System.out.println("strings are anagrams");
        else System.out.println("strings are not anagrams");

    }


//          PRIVATE METHODS FOR MAIN

    private static String reverseStringPrivate(String string) {

        String reverseStr = "";
        for (int i = 0; i < string.length(); i++) {
            reverseStr += string.substring(string.length() - i - 1, string.length() - i);
        }
        return reverseStr;
    }

    private static char[] duplicateCharsPrivate( String string ) {
        char[] toChar = string.toCharArray();
        int index = 0;
        int indexUnique = 0;
        char[] charArrayUnique = new char[string.length()];
        for (char i : toChar) {
            if (tema1.PublicMethods.isDouplicate(index, toChar) && tema1.PublicMethods.isUniqueChar(i, charArrayUnique)) {
//      I am using methods from tema1.PubliccMethods which check for duplicate characters within an char array
//      + checks if a specific char has already been found to be duplicate
                charArrayUnique[indexUnique] = i;
                charArrayUnique[indexUnique + 1] = ',';
                indexUnique += 2;
            }
            index++;
        }
        return charArrayUnique;
    }

    private static boolean isAnagramPrivate(String a, String b) {

        if (a.length() != b.length())
            return false;

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        for (int i = 0; i<a.length(); i++ ) {
            if ( arrayA[i]!=arrayB[i])
                return false;
        }
        return true;
    }

}
