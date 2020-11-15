package tema1;

//  6. Change the implementation of the calculator from the previous meeting to use only if-else instead of switch.

import java.util.Scanner;

public class CalcIfElse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number: ");
        int n1 = sc.nextInt();
        System.out.println("enter the second number: ");
        int n2 = sc.nextInt();
        System.out.println("enter the desired operation to be performed ");
        String operation = sc.next();
        boolean validOperation = false;
        if (operation.equals("+")) {
            System.out.println("the sum of the two numbers is " + (n1 + n2));
            validOperation = true;
        } else if (operation.equals("-")) {
            System.out.println(n1 + "minus " + n2 + " is " + (n1 - n2));
            validOperation = true;
        } else if (operation.equals("*")) {
            System.out.println(n1 + "times " + n2 + " is " + (n1 * n2));
            validOperation = true;
        } else if (operation.equals("/")) {
            System.out.println(n1 + "divided by " + n2 + " is " + (n1 / n2));
            validOperation = true;
        }

        if (!validOperation)
            System.out.println("Unknown calculation");


    }
}
