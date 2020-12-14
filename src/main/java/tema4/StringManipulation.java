package tema4;

/*
        3. String manipulation (write all methods in the same class, with private static)

        Write a method to reverse a given string in place. - DONE
        Write a method to print duplicate characters from a string. - DONE
        Write a method to check if two strings are anagrams of each other. - DONE
        Write a method to find all the permutations of a string.
        Write a method to check if a string contains only digits.
        Write a method to find duplicate characters in a given string.
        Write a method to count a number of vowels and consonants in a given string.
        Write a method to count the occurrence of a given character in a string.
        Write a method to print the first non-repeated character from a string.
        Write a method to convert a given String into int like the Integer.parseInt().
        Write a method to reverse words in a given sentence without using any library method.
        Write a method to check if two strings are a rotation of each other.
        Write a method to check if a given string is a palindrome.
        Write a method to find the length of the longest substring without repeating characters.
        Given string str, write a method to find the longest palindromic substring in str.
        Write a method to remove the duplicate character from String.
        Write a method to remove a given character from String.
        Given an array of strings, find the most frequent word in a given array, I mean, the string that appears the most in the array. In the case of a tie, the string that is the smallest (lexicographically) ​is printed.

*/

import tema1.PublicMethods;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringManipulation {

//    String str;
//
//    public StringManipulation(String str) {
//        this.str = str;
//    }

    public static String reverseStringPublic(String string) {

        String reverseStr = "";
        for (int i = 0; i < string.length(); i++) {
            reverseStr += string.substring(string.length() - i - 1, string.length() - i);
        }
        return reverseStr;

    }

    public static char[] duplicateCharsPublic(String string) {

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

    public static boolean isAnagramPublic(String a, String b) {

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

    /* in poggers

    public static boolean isAnagramPublicTwo ( String a, String b){

        if (a.length() != b.length())
            return false;

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        char[][] arrayAOccurances = new char[2][];
        char[][] arrayBOccurances = new char[2][];
        int lengthAOccurance = 0;
        int lengthBOccurance = 0;
        int index =0;
        for (char x : arrayA) {
            if (checkPos(x,arrayAOccurances[1][])) {
                arrayAOccurances[1][index]= x;
                index++;
            }

        }

    }

    public static char[] checkPos (char b, char[] a){



    }

     */

}
