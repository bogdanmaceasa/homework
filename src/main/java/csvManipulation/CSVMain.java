package csvManipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class CSVMain {

    public static void main(String[] args) {


        String fileLocation = "src/main/resources/";
        String fileName = "edit_NUE.csv";
        String fileName1 = "edit_MNL.csv";
        String fileName2 = "edit_MAS.csv";
        File outFile = new File(fileLocation + "edited_NUE.txt");
        File outFile1 = new File(fileLocation + "edited_MNL.txt");
        File outFile2 = new File(fileLocation + "edited_MAS.txt");
        File file = new File(fileLocation + fileName);
        File file1 = new File(fileLocation + fileName1);
        File file2 = new File(fileLocation + fileName2);
        File sessionFileName = new File(fileLocation +"session_NUE.txt");
        File sessionFileName1 = new File(fileLocation +"session_MNL.txt");
        File sessionFileName2 = new File(fileLocation +"session_MAS.txt");

        if (outFile2.exists()) {
            outFile2.delete();
        }
        if (sessionFileName2.exists()) {
            sessionFileName2.delete();
        }

        try {
            Files.lines(file2.toPath())
                    .map(csvManipulation.PublicMethods::mapLine)
                    .forEach(PublicMethods::printResultsToFile);

        } catch (IOException e) {
            System.out.println("Error while reading file.Please check " + fileName);
        }

    }
}



