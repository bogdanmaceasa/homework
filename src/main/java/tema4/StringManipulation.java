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
        Write a method to check if a given string is a palindrome. - DONE
        Write a method to find the length of the longest substring without repeating characters. - DONE ?!
        Given string str, write a method to find the longest palindromic substring in str. - DONE
        Write a method to remove the duplicate character from String. - DONE
        Write a method to remove a given character from String. - DONE
        Given an array of strings, find the most frequent word in a given array, I mean, the string that appears the most in the array. - DONE
        In the case of a tie, the string that is the smallest (lexicographically) is printed.
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
    public static String duplicateCharsPublic(String string) {

        char[] toChar = string.toCharArray();
        int index = 0;
        int indexUnique = 0;
        char[] charArrayUnique = new char[0];
        for (char i : toChar) {
            if (tema1.PublicMethods.isDouplicate(index, toChar) && tema1.PublicMethods.isUniqueChar(i, charArrayUnique)) {
//      I am using methods from tema1.PublicMethods which checks for duplicate characters within an char array
//      + checks if a specific char has already been found to be duplicate
                charArrayUnique = addCharToArray(charArrayUnique, i);
            }
            index++;
        }
        return String.valueOf(charArrayUnique);
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
                int res = arrayAOccurances[0][i] - arrayBOccurances[0][j];
                res = (res < 0 ? -res : res);
                if (res == 0 || res == 32) {
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

        char[] uniqueChars = new char[string.length()];
        int[] uniqueCharsOccurrence = new int[string.length()];
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            boolean notAdded = true;
            for (int j = i + 1; j < string.length(); j++) {

                if (string.charAt(i) == uniqueChars[j]) {
                    uniqueCharsOccurrence[j]++;
                    notAdded = false;
                    break;
                }
            }
            if (notAdded) {
                uniqueChars[index] = string.charAt(i);
                index++;
            }
        }
        for (int i = 0; i < index; i++)
            if (uniqueCharsOccurrence[i] == 0)
                return String.valueOf(uniqueChars[i]);
        return "no unique elements";
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


        if (stringA.length() != stringB.length()) {
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
    public static void isPalindrome(String string) {

        String firstHalf = string.substring(0, string.length() / 2);
        String secondHalf;
        if (string.length() % 2 == 0)
            secondHalf = string.substring(string.length() / 2);
        else secondHalf = string.substring(string.length() / 2 + 1);

        System.out.println(firstHalf);
        System.out.println(secondHalf);
        if (firstHalf.equals(reverse(secondHalf)))
            System.out.println("is palindrome");
        else System.out.println("is not palindrome");

    }

    //Write a method to find the length of the longest substring without repeating characters.
    public static void longestNonRepeat(String string) {
        int max = 0;
        int longestIndexBeginsAt = 0;
        for (int i = 0; i < string.length() - max; i++) {
            String substring = "";
            int count = 0;
            for (int j = i; j < string.length(); j++) {
                String checker = String.valueOf(string.charAt(j));
                if (substring.contains(checker)) {
                    if (max < count) {
                        max = count;
                        longestIndexBeginsAt = i;
                    }
                    break;
                } else {
                    substring = substring + string.charAt(j);
                    count++;
                }
            }
        }
        System.out.println("longest non-repeat substring found is: " + string.substring(longestIndexBeginsAt, longestIndexBeginsAt + max));
        System.out.println("the length of the substring is: " + max);
    }

    //Given string str, write a method to find the longest palindromic substring in str.
    public static void longestPalindrome(String string) {
        // method covers all types of palindromes with odd and even number of letters in the palindrome.

        int maxLength = 0, indexSaved = 0, index = 0, indexSaved1 = 0, maxLength1 = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            int length = 0;
            for (int j = 0; j <= Math.min(string.substring(0, i).length(), string.substring(i + 2).length()); j++) {
                if (string.charAt(i - j) == string.charAt(i + 1 + j)) {
                    index = i;
                    length++;
                } else break;
            }
            if (maxLength < length) {
                maxLength = length;
                indexSaved = index;
            }
        }

        for (int i = 0; i < string.length() - 2; i++) {
            int length = 0;
            for (int j = 0; j <= Math.min(string.substring(0, i).length(), string.substring(i + 3).length()); j++) {
                if (string.charAt(i - j) == string.charAt(i + 2 + j)) {
                    index = i;
                    length++;
                } else break;
            }
            if (maxLength1 < length) {
                maxLength1 = length;
                indexSaved1 = index;
            }
        }
        if (maxLength1 > maxLength) {
            System.out.println("length of the palindrom substring is: " + (maxLength1 * 2 + 1));
            if ((indexSaved1 + maxLength1 + 1) == (string.length()) - 1)
                System.out.println(string.substring(indexSaved1 - maxLength1 + 1));
            else System.out.println(string.substring(indexSaved1 - maxLength1 + 1, indexSaved1 + maxLength1 + 2));
        } else if ((indexSaved + maxLength) == (string.length()) - 1) {
            System.out.println("length of the palindrom substring is: " + maxLength * 2);
            System.out.println(string.substring(indexSaved - maxLength + 1));
        } else {
            System.out.println("length of the palindrom substring is: " + maxLength * 2);
            System.out.println(string.substring(indexSaved - maxLength + 1, indexSaved + maxLength + 1));
        }

    }

    //Write a method to remove the duplicate character from String.
    public static void removeDuplicateChars(String string) {
        char[] stringToChars = new char[0];
        for (int i = 0; i < string.length(); i++) {
            boolean isPresent = false;
            for (int j = 0; j < stringToChars.length; j++)
                if (string.charAt(i) == stringToChars[j]) {
                    isPresent = true;
                }
            if (!isPresent) {
                stringToChars = addCharToArray(stringToChars, string.charAt(i));
            }
        }
        System.out.print("string with no duplicate characters is: ");
        for (char c : stringToChars) {
            System.out.print(c);
        }
    }

    //Write a method to remove a given character from String.
    public static void removeGivenChar(String string, char c) {

        while (string.indexOf(c) >= 0) {
            if (string.indexOf(c) == 0)
                string = string.substring(1);
            else if (string.indexOf(c) == string.length() - 1)
                string = string.substring(0, string.length() - 1);
            else
                string = string.substring(0, string.indexOf(c)).concat(string.substring(string.indexOf(c) + 1));
        }

        System.out.println(string);
    }

    //Given an array of strings, find the most frequent word in a given array, I mean, the string that appears the most in the array.
    public static String wordOccurrence(String[] string) {
        int highestCount = 0, posOfWord = 0;
        for (int i = 0; i < string.length; i++) {
            int count = 0;
            for (int j = i; j < string.length; j++) {
                if (string[i].equals(string[j]))
                    count++;
            }
            if (highestCount < count) {
                posOfWord = i;
                highestCount = count;
            } else if (highestCount == count) {
                if (string[posOfWord].length() > string[i].length())
                    posOfWord = i;
            }
        }

        return string[posOfWord];
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
                int res = array2[0][j] - array1[i];
                res = (res < 0 ? -res : res);
                if (res == 0 || res == 32) {
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

    private static char[] addCharToArray(char[] array1, char a) {

        char[] array2 = new char[array1.length + 1];
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
        array2[array1.length] = a;
        return array2;
    }

    /* Hackerrank methods */

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        smallest = s.substring(0, k);
        for (int i = 0; i <= s.length() - k; i++) {
            String subStr = s.substring(i, i + k);
            if (smallest.compareTo(subStr) > 0) {
                smallest = subStr;
            }
            if (subStr.compareTo(largest) > 0) {
                largest = subStr;
            }
        }

        return smallest + "\n" + largest;
    }

    public static String returnTokens(String s) {

        String[] strArray = new String[s.length()];
        final String[] res = s.split("[^A-Za-z]+"); // ?!?!?!?!?!?

        int token = 0;
        boolean charsExist = false;
        for (int i = 0; i < s.length(); i++) {
            boolean tokenEnd = false;
            strArray[i] = "";
            if (((s.charAt(i) >= 65) && (s.charAt(i) <= 90)) ||
                    ((s.charAt(i) >= 97) && (s.charAt(i) <= 122))) {
                charsExist = true;
                if (i == s.length() - 1) {
                    strArray[token] += s.substring(i);
                } else strArray[token] += s.substring(i, i + 1);
            } else tokenEnd = true;
            if (tokenEnd) {
                if (i > 0 && i < s.length() - 1) {
                    token++;
                }
            }
        }

        String str = "";
        int token2 = 0;
        if ( charsExist ) {
            for (int i = 0; i <= token; i++) {
                if (strArray[i] != "") {
                    str += "\n" + strArray[i];
                    token2++;
                }
            }
            return token2 + str;
        } else return "0";
    }


}
