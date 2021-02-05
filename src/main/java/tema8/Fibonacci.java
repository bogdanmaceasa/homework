package tema8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.stream.Stream;


/*

    1. Write a method that can generate the first 100 numbers from Fibonacci series
    using Java 8 streams which returns the sequence as an array of
    int(BigInteger can fit all 100 Fibonacci numbers).

 */


public class Fibonacci {

    public static void main(String[] args) {

        String separator = File.separator;
        String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
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
                            writer.write(i + "\n");
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
