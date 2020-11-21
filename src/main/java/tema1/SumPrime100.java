package tema1;

// 1. Calculate the sum of the first 100 prime numbers.

public class SumPrime100 {

    public static void main(String[] args) {

        int index = 1;
        int numar = 3;

        System.out.print("the first 100 prime numbers are:");
        System.out.println();
        System.out.println(1);
        System.out.println(2);
        int sum = 2;


        while (index < 100) {
            if (PublicMethods.isPrime(numar)) {
                index++;
                sum += numar;
                System.out.println(numar);
            }
            numar++;
        }



        System.out.println("the sum for the first 100 prime numbers is: " + sum);
    }


}



