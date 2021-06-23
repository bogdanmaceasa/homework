package csvManipulation;

import lombok.extern.log4j.Log4j;


import java.io.*;

@Log4j
public class PublicMethods {

    static String separator = File.separator;
    static String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
    static String fileName = "edited_NUE.txt";
    static String fileName1 = "edited_MNL.txt";
    static String fileName2 = "edited_MAS.txt";
    static BufferedWriter writer;


    public static String mapLine(String line) {
        String[] fields = line.split(",");
        String carrierDDI = fields[0];
        String genesysRP = fields[1];
        return "id " + "translate-"+ carrierDDI + "-to-" + genesysRP + "\n"
                + "type replace" + "\n"
                + "add-string " + carrierDDI + "\n"
                + "add-index 0" + "\n"
                + "delete-string " + genesysRP + "\n"
                + "delete-index 0" + "\n";
    }

    public static void printResultsToFile(String line) {
        writeRaceEntry(writer, line);
    }

    public static BufferedWriter getWriterInstance() throws IOException {
        if (writer != null) {
            return writer;
        }
//        return new BufferedWriter(new FileWriter(fileLocation + fileName, true));
//        return new BufferedWriter(new FileWriter(fileLocation + fileName1, true));
        return new BufferedWriter(new FileWriter(fileLocation + fileName2, true));
    }

    public static void writeRaceEntry(BufferedWriter writer, String line) {
        try {
            writer = getWriterInstance();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
