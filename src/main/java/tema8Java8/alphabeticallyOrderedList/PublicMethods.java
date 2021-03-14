package tema8Java8.alphabeticallyOrderedList;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;

@Log4j
public class PublicMethods {


    static String separator = File.separator;
    static String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
    static BufferedWriter writer;


    public static void fileProcessor(Path file, int month, String string) {

        try {

            Files.lines(file)
                    .skip(1)
                    .filter(s -> s.length() > 1)
                    .map(PublicMethods::mapToPerson)
                    .filter(s -> s.getDateOfBirth().getMonth().equals(Month.of(month)))
                    .sorted(new ComparatorForPerson())
//                    .sorted(Comparator.comparing((Person p1) -> p1.getLastName())
//                            .thenComparing(p -> p.getFirstName())
//                            .thenComparing(p -> p.getDateOfBirth()))
//                    .forEach(s-> System.out.println(s));
                    .forEach(s -> writeResult(s, string));

        } catch (IOException e) {
            System.out.println("Error while reading file.Please check ");
        }
    }

    public static Person mapToPerson(String line) {
        String[] fields = line.split(",");
        String[] date = fields[2].split("/");
        return Person.builder()
                .firstName(fields[0])
                .lastName(fields[1])
                .dateOfBirth(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])))
                .build();

    }

    public static void writeResult(Person person, String string) {
        writeFilteredOutput(writer, person, string);

    }

    public static BufferedWriter getWriterInstance(String string) throws IOException {
        if (writer != null) {
            return writer;
        }
        return new BufferedWriter(new FileWriter(fileLocation + string, true));
    }

    public static void writeFilteredOutput(BufferedWriter bufferedWriter, Person person, String string) {
        try {
            bufferedWriter = getWriterInstance(string);
            String outputString = person.getLastName() + "," + person.getFirstName();
            bufferedWriter.write(outputString);
            bufferedWriter.newLine();

        } catch (IOException ioException) {
            log.error(ioException.getMessage(), ioException);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
