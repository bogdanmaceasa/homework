package tema8;

import lombok.extern.log4j.Log4j;
import tema8.alphabeticallyOrderedList.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Log4j
public class PublicMethods {

    static String separator = File.separator;
    static String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
    static BufferedWriter writer;


    public static void writeResult(Person person) {
        writeFilteredOutput(writer, person);
    }

    public static BufferedWriter getWriterInstance() throws IOException {
        if (writer != null) {
            return writer;
        }
        return new BufferedWriter(new FileWriter(fileLocation + "resultsByMonth.txt", true));
    }

    public static void writeFilteredOutput(BufferedWriter bufferedWriter, Person person) {
        try {
            bufferedWriter = getWriterInstance();
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

    public static int fibonacci(int n){

        if ( n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
