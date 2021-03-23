package work2;

import java.util.Scanner;

public class PairsEqualToSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array :");
        int length = sc.nextInt();
        int[] array = new int[length];

        System.out.println("enter the elements of the array :");
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("enter the desired :");
        int sum = sc.nextInt();
        boolean anyPairs = false;
        System.out.println("the pairs in the array are: ");
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if ((array[i] + array[j]) == sum) {
                    anyPairs = true;
                    System.out.println("(" + array[i] + "," + array[j] + ")");
                }
            }
        }
        if (!anyPairs)
            System.out.println("no pairs");

    }


}
