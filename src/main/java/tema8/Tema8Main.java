package tema8;

import org.apache.commons.lang3.stream.Streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Tema8Main {

//            List<String> array= Stream.iterate()

    /*

    1. Write a method that can generate the first 100 numbers from Fibonacci series
    using Java 8 streams which returns the sequence as an array of
    int(BigInteger can fit all 100 Fobonacci numbers).
     */
    public static void main(String[] args) {


        String separator = File.separator;
        String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
        String outFile = "outfile.txt";
        Path pathFile = Paths.get(fileLocation + "tema.txt");
        File file = new File(fileLocation + outFile);


        try (Writer writer = new FileWriter(file)) {

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
