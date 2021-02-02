package tema8;

import java.io.File;

public class Fibonnaci {

    /*

1. Write a method that can generate the first 100 numbers from Fibonacci series
using Java 8 streams which returns the sequence as an array of
int(BigInteger can fit all 100 Fobonacci numbers).

Find all transactions in the year 2011 and sort them by value (small to high).
What are all the unique cities where the traders work?
Find all traders from Cambridge and sort them by name.
Return a string of all traders’ names sorted alphabetically.
Are any traders based in Milan?
Print all transactions’ values from the traders living in Cambridge.
What’s the highest value of all the transactions?
Find the transaction with the smallest value.
     */


    public static void main(String[] args) {

        String separator = File.separator;
        String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
        File outFile = new File(fileLocation + "rezultate.txt");
        File file = new File(fileLocation + "tema.txt");

        if (outFile.exists()) {
            outFile.delete();
        }


    }
}
