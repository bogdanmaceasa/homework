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

        PublicMethods.Calculator(n1, n2, operation);


    }


}

