package tema7;

import static tema7.PublicMethods.*;

public class Tema7Main {

    public static void main(String[] args) {

//        String pathname = "src/main/java/tema7/skiRaceResults"; // not working?
        String pathname = "src/main/java/tema7";
        String extension = ".java";
        String file = "src/main/java/tema7/skiRaceResults/Skier.java";
        String test = "src/main/resources/test.txt";

        listCurrentDirectory(pathname);
        listSpecificFiles(pathname, extension);
        fileAtPathExists(file);
        canReadWriteFile(file);
        isFileOrDirectory(file);
        lastModified(file);
        fileSize(file);
        readLinesFromFile(file);
        storeLinesFromFile(file);
        readWriteFile(file);
        readFirst3Lines(file);
        findLongestWordInFile(file);
        findWordInFile(file, "private");

    }

}
