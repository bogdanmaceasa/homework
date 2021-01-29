package tema7;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static tema7.PublicMethods.*;

public class Tema7Main {

    public static void main(String[] args) {

//        String pathname = "src/main/java/tema7/skiRaceResults"; // not working?
        String pathname = "src/main/java/tema7";
        String extension = ".java";
        String file = "src/main/java/tema7/Tema7Main.java";

//        listCurrentDirectory(pathname);
//        listSpecificFiles(pathname, extension);
//        fileAtPathExists(file);
//        canReadWriteFile(file);
//        isFileOrDirectory(file);
//        lastModified(file);
        fileSize(file);

    }

}
