package work1;

//  8. Calculate and display the factorial of a given number n. (ex: 4! = 1*2*3*4)

import java.util.Scanner;

public class FactN {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number:");
        int n1 = sc.nextInt();

        System.out.println("factorial of " + n1 + " is: " + PublicMethods.getFact(n1));


    }


}
