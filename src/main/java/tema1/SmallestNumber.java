package tema1;

// 2. Display the smallest number from an array of numbers (2 versions: with normal for and with foreach)

import java.util.Scanner;

import static java.lang.Integer.min;

public class SmallestNumber {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array");
        int leng = sc.nextInt();
        int[] arrayIn = new int[leng];
        System.out.println("enter the elements of the array");
        for (int j = 0; j < leng; j++) {
            arrayIn[j] = sc.nextInt();
        }
        int minNum = Integer.MAX_VALUE;

/*
        VARIANTA 1
        =========================================================
*/


        for (int j : arrayIn) {
            minNum = min(j, minNum);
        }

        System.out.println("the smallest number in the array is " + minNum);

/*
        VARIANTA 2
        ==========================================================
*/


        for (int i = 0; i < leng; i++) {
            minNum = (minNum > arrayIn[i]) ? arrayIn[i] : minNum;
        }
        System.out.println("the smallest number in the array is " + minNum);


    }

}
