package work1;

// 4. Check if a number is palindrom ( e.g palindrom 1221, 34143), read the number from keyboard.


import java.util.Scanner;

public class IsPalindrom {


    /*
        VERSION 1
    =================================================================================================================

    */
    public static void main(String[] args) {

        Scanner myNumber = new Scanner(System.in);
        System.out.println("enter a number");
        int num = myNumber.nextInt();

        if (PublicMethods.palindrom(num))
            System.out.println("number is a palindrom");
        else System.out.println("number is not a palindrom");


/*
    VERSION 2
    ==================================================================================================================

 */

//      find the length of the number

//        int number, number2 = num;
//        int length = 0;
//        while (num >= 1) {
//            num /= 10;
//            length++;
//        }
//
////      declare an array which will be filled on each index with the digits of the number
//
//        int[] numArray = new int[length];
//        int i = 0;
//        while (number >= 1) {
//            numArray[i] = number % 10;
//            number /= 10;
//            i++;
//        }
//
////      the boolean variable will only become false if
////      there is a digit that breaks the palindrom condition
//
//        boolean isPalindrom = true;
//
//        for (int j = 0; j <= (length / 2); j++) {
//            if (numArray[j] != numArray[length - j - 1]) {
//                isPalindrom = false;
//                System.out.println("number is not a palindrom");
//                break;
//            }
//        }
//        if (isPalindrom) {
//            System.out.println("number is a palindrom");
//        }

    }


}
