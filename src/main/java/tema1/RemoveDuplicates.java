package tema1;

//  9. Write a Java program to remove the duplicate elements of a given array and return the new length of the array.


import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array");
        int length = sc.nextInt();
        int[] array = new int[length];
        int[] arrayNoDuplicates = new int[length];
        int newLength = 0;

        System.out.println("enter the elements of the array");
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }

        for (int i : array) {
            if (PublicMethods.isUnique(i, arrayNoDuplicates)) {
                arrayNoDuplicates[newLength] = i;
                newLength++;
            } 
        }

        System.out.println("length of the unique array is " + newLength + " and the unique elements of the array are: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arrayNoDuplicates[i] + " ");

        }


    }
}
