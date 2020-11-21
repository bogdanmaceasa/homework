package tema1;

import static java.lang.Integer.min;

public class PublicMethods {

    /**
     * Calculates the biggest digit of a number
     *
     * @param number - type integer
     * @return returns the biggest digit of number
     */
    public static int getMaxDigit(int number) {
        int maxDigit = Integer.MIN_VALUE;
        while (number >= 1) {
            maxDigit = maxDigit > number % 10 ? maxDigit : number % 10;
            number /= 10;
        }
        return maxDigit;
    }


    /**
     * Calculates the biggest digit of a number
     *
     * @param n1,n2,opertation - type integer
     * @return prints in console the result for the operation entered for n1 and n2
     */
    public static void Calculator(int n1, int n2, String operation) {
        if (operation.equals("+")) {
            System.out.println("the sum of the two numbers is " + (n1 + n2));
        } else if (operation.equals("-")) {
            System.out.println(n1 + "minus " + n2 + " is " + (n1 - n2));
        } else if (operation.equals("*")) {
            System.out.println(n1 + "times " + n2 + " is " + (n1 * n2));
        } else if (operation.equals("/")) {
            System.out.println(n1 + "divided by " + n2 + " is " + (n1 / n2));
        } else {
            System.out.println("Unknown calculation");
        }

    }




/*
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        VERSION 1

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/

    /**
     * Calculates if testNumber is Prime
     *
     * @param testNumber - type integer
     * @return true if testNumber is Prime / false if testNumber is not Prime
     */
    public static boolean isPrime(int testNumber) {

        boolean isPrime = true;
        if (testNumber % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= (testNumber / 2); i += 2) {
                if ((testNumber % i) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
/*
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        VERSION 2 - USING Wilson’s theorem => p is prime if (((fact(p - 1) + 1) % p) == 0)

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/

    /**
     * Calculates if testNumber is Prime
     *
     * @param num - type integer
     * @return true if testNumber is Prime / false if testNumber is not Prime
     */
    public static boolean wilsonsTheorem(int num) {

        int fact = 1;
        for (int j = 1; j < num; j++) {
            fact *= j;
        }
        if ((fact + 1) % num == 0)
            return true;

        return false;
    }


    /**
     * Calculates if a binary array is square ( array[x][x] )
     *
     * @param array desired array
     * @return true if array is square
     */
    public static boolean isSquare(int[][] array) {

        int arrayDepth = 0;

        for (int[] i : array) {
            arrayDepth++; // calculates the number of arrays in the bidimensional array ( depth of the array )
        }

        for (int[] i : array) {
            int arrayLength = 0;
            for (int j : i) {
                arrayLength++; // calculates the length of each array on each level
            }
            if (arrayDepth != arrayLength)
                return false; // for each level of the array, if the length of the level is not the depth of the array => returns false
        }

        return true; // if the previous conditions never return false, the array is square
    }


    /**
     * returns the n!
     *
     * @param n1 desired number
     * @return n!
     */
    public static int getFact(int n1) {
        int fact = 1;
        for (int i = 1; i <= n1; i++) {
            fact *= i;
        }
        return fact;
    }


    /**
     * checks if a number is a palindrom
     *
     * @param n desired number
     * @return true is number is palindrom / false if not
     */
    public static boolean palindrom(int n) {
        int reverseNumber = 0;
        int num = n;
        while (num >= 1) {
            reverseNumber = reverseNumber * 10 + num % 10;
            num /= 10;
        }
        return reverseNumber == n;

    }


    /**
     * check the smallest number in an array
     *
     * @param arrayIn desired array
     * @return returns the minimum number in the array
     */

    public static int getMinNum(int[] arrayIn) {

        int minNum = Integer.MAX_VALUE;
/*
        VARIANTA 1
=========================================================
*/
        for (int i : arrayIn) {
            minNum = (minNum > i) ? i : minNum;
        }

/*
        VARIANTA 2
==========================================================
*/
//        for (int i : arrayIn) {
//            minNum = min(i, minNum);
//        }

        return minNum;

    }

    /**
     * check the smallest number in an array
     *
     * @param array desired array
     * @return returns the minimum number in the array
     */
    public static boolean isUnique(int i, int[] array) {
        for (int j : array) {
            if (i == j)
                return false;
        }
        return true;
    }

}

