package work8Java8.alphabeticallyOrderedList;

/*
By using streams and lamba expressions, implement a small application which:
1.load from a file a structure like:
first name, last name, date of birth

2. write back another file containing only
first name, last name
ordered alphabetically for all the of all matches which have the birthday on a month indicated.

Application takes 3 params:
1. input filename
2. target month (1-12)
3. output file name
Use unit tests to check the correctness.

 */

import lombok.extern.log4j.Log4j;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Log4j
public class AlphabeticallyOrderedListMain {

    public static void main(String[] args) {

        String separator = File.separator;
        String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
        String outFile = "resultByMonth.txt";
        Path file = Paths.get(fileLocation + "tema.txt");

        if (new File(fileLocation + outFile).exists()) {
            new File(fileLocation + outFile).delete();
        }
        PublicMethods.fileProcessor(file, 1, outFile);
    }
}