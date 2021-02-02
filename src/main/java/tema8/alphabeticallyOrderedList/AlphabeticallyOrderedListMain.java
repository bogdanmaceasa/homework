package tema8.alphabeticallyOrderedList;

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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;


@Log4j
public class AlphabeticallyOrderedListMain {

    public static void main(String[] args) {

        String separator = File.separator;
        String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
        File outFile = new File (fileLocation + "resultsByMonth.txt");
        Path file = Paths.get(fileLocation + "tema.txt");

        if (outFile.exists()) {
            outFile.delete();
        }
//        ( BufferedWriter writer = PublicMethods.getWriterInstance(outFile))
        try {

            Files.lines(file)
                    .skip(1)
                    .filter(s -> s.length() > 1)
                    .map(PublicMethods::mapToPerson)
                    .filter(s-> s.getDateOfBirth().getMonth().equals(Month.JANUARY))
                    .sorted(new ComparatorForPerson())
                    .forEach(PublicMethods::writeResult);
//                    .forEach(person -> System.out.println(person));

//            List<String> array= Stream.iterate()

        } catch (IOException e) {
            System.out.println("Error while reading file.Please check ");
        }


    }
}