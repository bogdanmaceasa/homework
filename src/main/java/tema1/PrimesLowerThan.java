package tema1;

// 5. Display all the prime numbers lower than a given number, read the number from keyboard


import java.util.Scanner;

public class PrimesLowerThan {

    public static void main(String[] args) {

/*
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        VERSION 1

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/


//        Scanner myNumber = new Scanner(System.in);
//        System.out.println("enter a number greater than 3");
//        int num = myNumber.nextInt();
//
//
//        int[] primeArray = new int[num / 2];
//        primeArray[0] = 1;
//        primeArray[1] = 2;
//        int k = 1;
//
//
//        for (int i = 3; i <= num; i++) {
//            if (i % 2 == 0) {
//                continue;
//            } else {
//                boolean isPrime = true;
//                for (int j = 3; j <= (i / 2); j+2) {
//                    if ((i % j) == 0) {
//                        isPrime = false;
//                        break;
//                    }
//                }
//                if (isPrime) {
//                    k++;
//                    primeArray[k] = i;
//                }
//            }
//
//        }
//        System.out.printf("prime numbers smaller than " + num + " are :");
//
//        for (int m = k; m >= 0; m--)
//            System.out.print("\n" + primeArray[m]);




/*
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        VERSION 2

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/

//
//        Scanner myNumber = new Scanner(System.in);
//        System.out.println("enter a number greater than 3");
//        int num = myNumber.nextInt();
//        int[] primeArray = new int[num / 2];
//        primeArray[0] = 1;
//        primeArray[1] = 2;
//
//        int index = 1;
//
//        System.out.print("prime numbers smaller than " + num + " are :");
//        System.out.println();
//        System.out.print(" " + primeArray[0]);
//        System.out.print(" " + primeArray[1]);
//
//
//        for (int i = 3; i <= num; i += 2) {
//            boolean prime = true;
//            for (int j = 1; j <= index; j++) {
//                if ((i / 2) >= primeArray[j]) {
//                    if ((i % primeArray[j]) == 0) {
//                        prime = false;
//                    }
//                }
//            }
//            if (prime) {
//                index++;
//                primeArray[index] = i;
//                System.out.print(" " + i);
//            }
//        }
//        System.out.println();




/*
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        VERSION 3

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/


//            Scanner myNumber = new Scanner(System.in);
//            System.out.println("enter a number greater than 3");
//            int num = myNumber.nextInt();
//
//            int[] primeArray = new int[num / 2];
//            primeArray[0] = 1;
//            primeArray[1] = 2;
//            int index = 1;
//
//            for (int i = 3; i < num; i++) {
//                if (PublicMethods.isPrime(i)) {
//                    index++;
//                    primeArray[index] = i;
//                }
//            }
//
//            System.out.print("prime numbers smaller than " + num + " are :");
//
//            for (int m = index; m >= 0; m--)
//                System.out.print("\n" + primeArray[m]);
//
//


/*
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        VERSION 4 - USING Wilson’s theorem => p is prime if (((fact(p - 1) + 1) % p) == 0)

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/

        Scanner myNumber = new Scanner(System.in);
        System.out.println("enter a number greater than 3");
        int num = myNumber.nextInt();

        System.out.print("prime numbers smaller than " + num + " are :");
        System.out.println();
        System.out.print(" " + "1");

        for (int i = 2; i <= num; i++)
            System.out.println(PublicMethods.wilsonsTheorem(i) + " ");


    }
}