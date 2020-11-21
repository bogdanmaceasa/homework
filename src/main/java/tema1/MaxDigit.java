package tema1;

//   3. Display the max digit from a number, read the number from keyboard.

import java.util.Scanner;


public class MaxDigit {

    public static void main(String[] args) {

        Scanner myNumber = new Scanner(System.in);
        System.out.println("enter a number with multiple digits");
        int number = myNumber.nextInt();
        System.out.println("the biggest digit of the number is " + PublicMethods.getMaxDigit(number));

    }

}
