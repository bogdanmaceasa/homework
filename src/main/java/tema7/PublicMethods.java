package tema7;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@Log4j
public class PublicMethods {

/*
1. Implement a method to get a list of all file/directory names from the given.                                 => listCurrentDirectory
2. Implement a method to get specific files by extensions from a specified folder.                              => listSpecificFiles
3. Implement a method to check if a file or directory specified by pathname exists or not.                      => fileAtPathExists
4. Implement a method to check if a file or directory has read and write permission.                            => canReadWriteFile
5. Implement a method to check if given pathname is a directory or a file.                                      => isFileOrDirectory
6. Implement a method to get last modified time of a file.                                                      => lastModified
7. Implement a method to get file size in bytes, kb, mb.                                                        => fileSize
8. Implement a method to read a file line by line and store it into a variable.                                 => readLinesFromFile
9. Implement a method to store text file content line by line into an array.                                    => storeLinesFromFile
10. Implement a method to write and read a plain text file.                                                     => readWriteFile
11. Implement a method to append text to an existing file.                                                      => writeEntry
12. Implement a method to read first 3 lines from a file.                                                       => readFirst3Lines ?!??! stream-wise ?!
13. Implement a method to find the longest word in a text file.                                                 => findLongestWordInFile ?!?!?! print in java8 ?
14. Implement a method to find a specific word in a text file, will return true if exists, false otherwise.     => findWordInFile !??!!? java8
*/

    static String separator = File.separator;
    static String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
    static String fileName = "IOOutputs.txt";
    static BufferedWriter writer;
    static Date localTime = new Date();
    static String strMaxLength = "";


    public static void listCurrentDirectory(String fileLocation) {

        writeEntry(writer, "=========Printed from listCurrentDirectory at: " + localTime + "=========");
        String[] list = new File(fileLocation).list();

        if (list != null) {
            for (String file : list) {
                writeEntry(writer, file);
            }
        } else writeEntry(writer, "file is empty");

    }

    public static void listSpecificFiles(String fileLocation, String extension) {

        writeEntry(writer, "=========Printed from listSpecificFiles at: " + localTime + "=========");
        Arrays.stream(new File(fileLocation).list())
                .filter(s -> s.endsWith(extension))
                .forEach(a -> writeEntry(writer, a));

    }

    public static void fileAtPathExists(String fileLocation) {

        writeEntry(writer, "=========Printed from fileAtPathExists at: " + localTime + "=========");
        File list = new File(fileLocation);
        if (list.exists()) {
            writeEntry(writer, "file exists at the entered path");
        } else writeEntry(writer, "file does not exist at the entered path");

    }

    public static void canReadWriteFile(String fileLocation) {

        writeEntry(writer, "=========Printed from canReadWriteFile at: " + localTime + "=========");
        File list = new File(fileLocation);
        if (list.exists()) {
            if (list.canRead() && list.canRead()) {
                writeEntry(writer, "file has read/write permissions");
            } else writeEntry(writer, "file does not have read/write permissions");
        } else writeEntry(writer, "file does not exist at the entered path");

    }

    public static void isFileOrDirectory(String fileLocation) {

        writeEntry(writer, "=========Printed from isFileOrDirectory at: " + localTime + "=========");
        File list = new File(fileLocation);
        if (list.exists()) {
            if (list.isDirectory()) {
                writeEntry(writer, "at this path there is directory");
            } else if (list.isFile())
                writeEntry(writer, "at this path there is file");
        } else writeEntry(writer, "file does not exist at the entered path");

    }

    public static void lastModified(String fileLocation) {

        writeEntry(writer, "=========Printed from lastModified at: " + localTime + "=========");
        File list = new File(fileLocation);
        if (list.exists()) {
            writeEntry(writer, "file was last modified at: " + new Date(list.lastModified()));
        } else writeEntry(writer, "file does not exist at the entered path");

    }

    public static void fileSize(String fileLocation) {

        writeEntry(writer, "=========Printed from fileSize at: " + localTime + "=========");
        File list = new File(fileLocation);
        double kb = (double) list.length() / 1024;
        double mb = kb / 1024;
        if (list.exists()) {
            String str = list.length() + "bytes, " + String.format("%.3f", kb) + "Kb, " + String.format("%.4f", mb) + "Mb.";
            writeEntry(writer, "file size is: " + str);
        } else writeEntry(writer, "file does not exist at the entered path");

    }

    public static void readLinesFromFile(String fileLocation) {

        System.out.println("=========Printed from readLinesFromFile at: " + localTime + "=========");
        String var = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileLocation)))) {
            var = reader.lines().collect(Collectors.joining("\n"));

        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        System.out.println("file read line by line: \n" + var);
    }

    public static void storeLinesFromFile(String fileLocation) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {

            System.out.println("=========Printed from storeLinesFromFile at: " + localTime + "=========");
            String[] var = reader.lines()
                    .toArray(String[]::new);
            int i = 0;
            for (String str : var) {
                System.out.println("Line " + ++i + "- " + str);
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void readWriteFile(String fileLocation) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {

            writeEntry(writer, "=========Printed from readWriteFile at: " + localTime + "=========");
            reader.lines().forEach(s -> writeEntry(writer, s));
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void readFirst3Lines(String fileLocation) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {
            int i = 0;
            writeEntry(writer, "=========Printed from readFirst3Lines at: " + localTime + "=========");

            while (i < 3) {
                writeEntry(writer, reader.readLine());
                i++;
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void findLongestWordInFile(String fileLocation) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {

            System.out.println("=========Printed from findLongestWordInFile at: " + localTime + "=========");
            reader.lines()
                  .forEach(s -> Arrays.stream(s.split("\\s"))
                                      .forEach(PublicMethods::findMaxLength));
            System.out.println(strMaxLength);

        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void findWordInFile(String fileLocation, String word) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {

            System.out.println("=========Printed from findWordInFile at: " + localTime + "=========");
            reader.lines()
                    .forEach(s -> Arrays.stream(s.split("\\s"))
                            .forEach(w -> isEqual(w,word))) ;


        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    // WRITING IN .TXT METHODS

    private static void findMaxLength(String string) {
        if (string.length() > strMaxLength.length()) {
            strMaxLength = string;
        }
    }

    private static void isEqual(String string, String inputWord){
        if ( string.equals(inputWord)){
            System.out.println("Occurance found");
        }
    }

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
