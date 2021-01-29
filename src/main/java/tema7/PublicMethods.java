package tema7;

import lombok.extern.log4j.Log4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Date;

@Log4j
public class PublicMethods {

/*
1. Implement a method to get a list of all file/directory names from the given. => listCurrentDirectory
2. Implement a method to get specific files by extensions from a specified folder. => listSpecificFiles
3. Implement a method to check if a file or directory specified by pathname exists or not. => fileAtPathExists
4. Implement a method to check if a file or directory has read and write permission. => canReadWriteFile
5. Implement a method to check if given pathname is a directory or a file. => isFileOrDirectory
6. Implement a method to get last modified time of a file. => lastModified
7. Implement a method to get file size in bytes, kb, mb. => fileSize
8. Implement a method to read a file line by line and store it into a variable.
9. Implement a method to store text file content line by line into an array.
10. Implement a method to write and read a plain text file.
11. Implement a method to append text to an existing file. => writeEntry
12. Implement a method to read first 3 lines from a file.
13. Implement a method to find the longest word in a text file.
14. Implement a method to find a specific word in a text file, will return true if exists, false otherwise.
*/

    static String separator = File.separator;
    static String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
    static String fileName = "IOOutputs.txt";
    static BufferedWriter writer;
    static Date localTime = new Date();

    public static void listCurrentDirectory(String string) {

        writeEntry(writer, "=========Printed at: " + localTime + "=========");
        String[] list = new File(string).list();

        if (list != null) {
            for (String file : list) {
                writeEntry(writer, file);
            }
        } else writeEntry(writer, "file is empty");

    }

    public static void listSpecificFiles(String string, String extension) {

        writeEntry(writer, "=========Printed at: " + localTime + "=========");
        Arrays.stream(new File(string).list()).filter(s -> s.endsWith(extension)).forEach(a -> writeEntry(writer, a));

    }

    public static void fileAtPathExists(String string) {

        writeEntry(writer, "=========Printed at: " + localTime + "=========");
        File list = new File(string);
        if (list.exists()) {
            writeEntry(writer, "file exists at the entered path");
        } else writeEntry(writer, "file does not exist at the entered path");

    }

    public static void canReadWriteFile(String string) {

        writeEntry(writer, "=========Printed at: " + localTime + "=========");
        File list = new File(string);
        if (list.exists()) {
            if (list.canRead() && list.canRead()) {
                writeEntry(writer, "file has read/write permissions");
            } else writeEntry(writer, "file does not have read/write permissions");
        } else writeEntry(writer, "file does not exist at the entered path");

    }

    public static void isFileOrDirectory(String string) {

        writeEntry(writer, "=========Printed at: " + localTime + "=========");
        File list = new File(string);
        if (list.exists()) {
            if (list.isDirectory()) {
                writeEntry(writer, "at this path there is directory");
            } else if (list.isFile())
                writeEntry(writer, "at this path there is file");
        } else writeEntry(writer, "file does not exist at the entered path");

    }

    public static void lastModified(String string) {

        writeEntry(writer, "=========Printed at: " + localTime + "=========");
        File list = new File(string);
        if (list.exists()) {
            writeEntry(writer, "file was last modified at: " + new Date(list.lastModified()));
        } else writeEntry(writer, "file does not exist at the entered path");

    }

    public static void fileSize(String string) {

        writeEntry(writer, "=========Printed at: " + localTime + "=========");
        File list = new File(string);
        double kb = (double)list.length()/1024;
        double mb = kb / 1024;
        if (list.exists()) {
            String str = list.length() + "bytes, " + String.format("%.3f", kb) + "Kb, " + String.format("%.4f", mb) + "Mb.";
            writeEntry(writer, "file size is: " + str);
        } else writeEntry(writer, "file does not exist at the entered path");

    }



    // WRITING IN .TXT METHODS

    private static void writeEntry(BufferedWriter writer, String string) {
        try {
            writer = getWriterInstance();
            writer.write(string);
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

    private static BufferedWriter getWriterInstance() throws IOException {
        if (writer != null) {
            return writer;
        }
        return new BufferedWriter(new FileWriter(fileLocation + fileName, true));
    }

}
