package tema8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonnaci {

    /*



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
//        File outFile = new File(fileLocation + "rezultate.txt");
        File file = new File(fileLocation + "fibonacci.txt");

        if (file.exists()) {
            file.delete();
        }

        try (Writer writer = new FileWriter(file)) {


            BigInteger bigInteger = BigInteger.valueOf(0);
            BigInteger bigInteger1 = BigInteger.valueOf(1);
            //            ArrayList<BigInteger> string =
            Stream.iterate(new BigInteger[]{bigInteger, bigInteger1}, i -> new BigInteger[]{i[1], i[0].add(i[1])})
                    .limit(100)
                    .map(i -> i[0])
                    .forEach(i -> {
                        try {
                            writer.write(String.valueOf(i)+ "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
//                    .collect(Collectors.toCollection(ArrayList<BigInteger>::new));
//            for (BigInteger bigInteger : string) {
//                writer.write(String.valueOf(bigInteger));
//                writer.write("\n");
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
