package tema2;

import tema1.PublicMethods;
import java.util.Scanner;

public class StringDuplicates {

//    3. Write a Java method to find the duplicate characters in a string. (Hint use str.toCharArray() to split the string into an array of characters)

    public static void main(String[] args) {


        System.out.println("enter a string");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(s);
        int length = s.length();
        char[] strArr = s.toCharArray();



        char[] uniqueChar = new char[length];
        int uniquePos = 0;

        for (int i = 0; i < length; i++) {
            if (PublicMethods.isDouplicate(i,strArr ) && PublicMethods.isUniqueChar(strArr[i],uniqueChar )){
                uniqueChar[uniquePos++] = strArr[i];
                }

        }
        System.out.println("duplicate elements are");
        for ( int i=0; i<uniquePos; i++){
            System.out.print("'" + uniqueChar[i] + "' ");
        }


    }
}

