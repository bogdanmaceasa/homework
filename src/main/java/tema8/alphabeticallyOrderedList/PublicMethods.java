package tema8.alphabeticallyOrderedList;

import lombok.extern.log4j.Log4j;
import tema7.skiRaceResults.RaceResults;
import tema7.skiRaceResults.RaceResultsBuilder;
import tema7.skiRaceResults.Skier;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Log4j
public class PublicMethods {


    static String separator = File.separator;
    static String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
    static BufferedWriter writer;


    public static Person mapToPerson(String line) {
        String[] fields = line.split(",");
        String[] date = fields[2].split("/");
        return Person.builder()
                .firstName(fields[0])
                .lastName(fields[1])
                .dateOfBirth(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])))
                .build();

    }

    public static void writeResult(Person person){
        writeFilteredOutput(writer,person);

    }

    public static BufferedWriter getWriterInstance() throws IOException {
        if (writer != null) {
            return writer;
        }
        return new BufferedWriter(new FileWriter(fileLocation + "resultsByMonth.txt", true));
    }

    public static void writeFilteredOutput(BufferedWriter bufferedWriter, Person person){
        try {
            bufferedWriter = getWriterInstance();
            String outputString = person.getLastName() + "," + person.getFirstName();
            bufferedWriter.write(outputString);
            bufferedWriter.newLine();

        } catch (IOException ioException) {
            log.error(ioException.getMessage(),ioException);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
}
