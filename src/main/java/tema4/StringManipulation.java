package tema4;

/*     3. String manipulation (write all methods in the same class, with private static)

        Write a method to reverse a given string in place. - DONE
        Write a method to print duplicate characters from a string. - DONE
        Write a method to check if two strings are anagrams of each other. - DONE
        Write a method to find all the permutations of a string. - DONE
        Write a method to check if a string contains only digits. - DONE
        Write a method to find duplicate characters in a given string. - DUPLICATE with 2
        Write a method to count a number of vowels and consonants in a given string. - DONE
        Write a method to count the occurrence of a given character in a string. - DONE
        Write a method to print the first non-repeated character from a string. - DONE
        Write a method to convert a given String into int like the Integer.parseInt(). - DONE
        Write a method to reverse words in a given sentence without using any library method. - DONE
        Write a method to check if two strings are a rotation of each other. - DONE
        Write a method to check if a given string is a palindrome.
        Write a method to find the length of the longest substring without repeating characters.
        Given string str, write a method to find the longest palindromic substring in str.
        Write a method to remove the duplicate character from String.
        Write a method to remove a given character from String.
        Given an array of strings, find the most frequent word in a given array, I mean, the string that appears the most in the array. In the case of a tie, the string that is the smallest (lexicographically) ​is printed.
*/

import java.util.Arrays;

public class StringManipulation {

    //Write a method to reverse a given string in place.
    public static String reverseStringPublic(String string) {

        String reverseStr = "";
        for (int i = 0; i < string.length(); i++) {
            reverseStr += string.substring(string.length() - i - 1, string.length() - i);
        }
        return reverseStr;

    }

    //Write a method to print duplicate characters from a string.
    //Write a method to find duplicate characters in a given string.
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

    //Write a method to check if two strings are anagrams of each other. easy way
    public static boolean isAnagramPublic(String a, String b) {

        if (a.length() != b.length())
            return false;

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        for (int i = 0; i < a.length(); i++) {
            if (arrayA[i] != arrayB[i])
                return false;
        }
        return true;
    }

    //Write a method to check if two strings are anagrams of each other. hard way
    public static boolean isAnagramPublicTwo(String a, String b) {

        if (a.length() != b.length())
            return false;

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        char[][] arrayAOccurances = new char[2][arrayA.length];
        char[][] arrayBOccurances = new char[2][arrayB.length];

        int lengthA = checkUniqueEntries(arrayA, arrayAOccurances, arrayA.length);
        int lengthB = checkUniqueEntries(arrayB, arrayBOccurances, arrayB.length);

        if (lengthA != lengthB)
            return false;

        for (int i = 0; i < lengthA; i++) {
            boolean isPresent = false;
            for (int j = 0; j < lengthB; j++) {
                if (arrayAOccurances[0][i] == arrayBOccurances[0][j]) {
                    isPresent = true;
                    if (arrayAOccurances[1][i] != arrayBOccurances[1][j])
                        return false;
                    break;
                }
            }
            if (!isPresent)
                return false;
        }
        return true;
    }

    //Write a method to find all the permutations of a string.
    public static void findPermutations(String string, String output) {
        if (string.length() == 0) {
            System.out.println(output + " ");
            return;
        }
        for (int i = 0; i < string.length(); i++) {
            String storedOutput = output + string.charAt(i); // storedOutput is the initial value + charAt(i) at each call of the method.
            findPermutations(string.substring(0, i) + string.substring(i + 1), storedOutput); // method called recursively with subtring excluding charAt(i) and the new stored output.
        }
    }

    //Write a method to check if a string contains only digits.
    public static boolean containsOnlyDigits(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (((int) string.charAt(i) < 48)
                    || ((int) string.charAt(i) > 57)) {
                return false;
            }
        }
        return true;
    }

    //Write a method to count a number of vowels and consonants in a given string.
    public static void countConsonantsVowels(String string) {

        int countVowels = 0;
        int countCons = 0;

        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] strToChar = string.toCharArray();
        for (char c : strToChar) {
            boolean isVowel = false;
            for (char v : vowels) {
                if (c == v) {
                    countVowels++;
                    isVowel = true;
                    break;
                }
            }
            if (!isVowel) {
                if ((c > 'a' && c <= 'z') || (c > 'A' && c <= 'Z')) {
                    countCons++;
                }
            }
        }
        System.out.println("number of vowels in string: " + countVowels + " and number of consonants " + countCons);
    }

    //Write a method to count the occurrence of a given character in a string.
    public static int countOccurrenceInString(String string, char a) {

        int index = 0;
        char[] strToChar = string.toCharArray();
        for (char c : strToChar) {
            if (a == c)
                index++;
        }
        return index;
    }

    //Write a method to print the first non-repeated character from a string.
    public static String firstNonRepeat(String string) {

        char[] strinToChar = string.toCharArray();
        int occurrence = 0;
        int i = 0;
        if (i < string.length()) {
            for (int j = i + 1; j < string.length(); j++) {
                if (strinToChar[i] == strinToChar[j]) {
                    if (j == string.length() - 1)
                        return "no unique elements";
                    occurrence++;
                } else if (occurrence >= 1) {
                    i = j;
                    occurrence = 0;
                } else return String.valueOf(strinToChar[i]);
            }
        }
        return String.valueOf(strinToChar[string.length() - 1]);
    }

    //Write a method to convert a given String into int like the Integer.parseInt().
    public static int convertToInt(String string) {

        int toInt = 0;
        char[] stringToChar = string.toCharArray();
        for (char c : stringToChar) {
            if (c >= 48 && c <= 57)
                toInt = toInt * 10 + (c - 48);
        }
        return toInt;
    }

    //Write a method to reverse words in a given sentence without using any library method.
    public static void reverseWords(String string) {

        int numberOfSpaces = 0;
        int j = 0;

        for (int index = 0; index < string.length(); index++) {
            if (string.charAt(index) == ' ') {
                numberOfSpaces++;
            }
        }

        int[] positionOfSpaces = new int[numberOfSpaces];
        for (int index = 0; index < string.length(); index++) {
            if (string.charAt(index) == ' ') {
                positionOfSpaces[j] = index;
                j++;
            }
        }
//        System.out.println(numberOfSpaces);
//        System.out.println(Arrays.toString(positionOfSpaces));
        String[] words = new String[numberOfSpaces + 1];
        int cursor = 0;
        int nextCharPosition = 0;
        for (int index = 0; index < numberOfSpaces; index++) {
            int nextWordLength = positionOfSpaces[index] - nextCharPosition;
            words[index] = string.substring(0, nextWordLength);
            nextCharPosition = positionOfSpaces[index] + 1;
            cursor = nextWordLength + 1;
            if (cursor < string.length())
                string = string.substring(cursor);
        }
        words[numberOfSpaces] = string;

        String str = "";
        for (String s : words) {
            str = str.concat(reverse(s)).concat(" ");
            System.out.println(str);
        }
    }

    //Write a method to check if two strings are a rotation of each other.
    public static void isRotate(String stringA, String stringB) {


        if ( stringA.length() != stringB.length() ) {
            System.out.println("Strings are not equal in size");
            return;
        }

        int posPivotInA = stringA.indexOf(stringB.charAt(0));
        int lengthRightOfPivot = stringA.substring(posPivotInA).length();
        int lengthLeftOfPivot = stringA.substring(0, posPivotInA).length();
//        System.out.println(stringA);
//        System.out.println(stringB);
        String stringBLeftString = stringB.substring(0, lengthRightOfPivot);
        String stringBRightString = stringB.substring(stringB.length() - lengthLeftOfPivot);
        String stringARightString = stringA.substring(posPivotInA);
        String stringALeftString = stringA.substring(0, posPivotInA);

        System.out.println(stringBLeftString + " " + stringBRightString + " " + stringALeftString + " " + stringARightString);

        if ((stringBRightString.equals(stringALeftString)) &&
                (stringBLeftString.equals(stringARightString)))
            if (posPivotInA == 0)
                System.out.println("Strings are identical");
            else System.out.println("stringA is a rotation of stringB");
        else System.out.println("stringA is NOT a rotation of stringB");
    }

    //Write a method to check if a given string is a palindrome.
    public static void isPalindrome(String string){


    }


//    =========================== PRIVATE METHODS USED FOR BUSINESS LOGIC IN METHODS ABOVE ============================

    private static String reverse(String string) {
        String str = "";
        char[] c = string.toCharArray();
        for (int index = c.length - 1; index >= 0; index--) {
            str = str.concat(String.valueOf(c[index]));
        }
        return str;
    }

    private static int checkUniqueEntries(char[] array1, char[][] array2, int length) {

        for (int i = 0; i < length; i++) {
            array2[1][i] = '0';
        }
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            boolean isInArray = false;
            for (int j = 0; j < length; j++) {
                if (array2[0][j] == array1[i]) {
                    isInArray = true;
                    array2[1][j] += 1;
                }
            }
            if (!isInArray) {
                array2[0][index] = array1[i];
                array2[1][index] += 1;
                index++;
            }
        }
        return index;
    }


}
