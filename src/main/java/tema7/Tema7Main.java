package tema7;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Log4j
public class Tema7Main {

    public static void main(String[] args) {

        String separator = File.separator;
        String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
        String fileName = "SkiStandings.csv";
        File file = new File(fileLocation + fileName);

        try {
//      METODA 1 - folosind o lista de String[] intermediara - dupa aceasta vom genera obiectele
//            List<String[]> skiStandingsToList = Files.readAllLines(file.toPath())
//                    .stream()
//                    .skip(1)
//                    .map(s -> mapLineToEmployee(s))
//                    .collect(Collectors.toList());
//
//            ComparatorForResults comparatorForTreeSet = new ComparatorForResults();
//            List<RaceResults> raceResultsSet = new ArrayList<>();
//
//            for (String[] stringList : skiStandingsToList) {
//                int minutesFromString = Integer.parseInt(stringList[3].split(":")[0]);
//                int secondsFromString = Integer.parseInt(stringList[3].split(":")[1]);
//                raceResultsSet.add(new RaceResultsBuilder()
//                        .withT(Skier.builder()
//                                .athleteNumber(Integer.parseInt(stringList[0]))
//                                .athleteName(stringList[1])
//                                .countryCode(stringList[2])
//                                .build())
//                        .withShootingResults(List.of(stringList[4], stringList[5], stringList[6]))
//                        .withTime(LocalTime.of(0, minutesFromString, secondsFromString))
//                        .build());
//            }
//
//            for (RaceResults raceResults : raceResultsSet) {
//                System.out.println(raceResults.toString());
//            }

//          METODA 2 - folosind o lista de RaceResults

            Set<RaceResults> skiStandingsToList = Files.readAllLines(file.toPath())
                    .stream()
                    .skip(1)
                    .map(Tema7Main::mapLineToSkierResults)
                    .collect(Collectors.toSet());
            printResultsToFile(skiStandingsToList); // JAVA 8 ?!

        } catch (IOException e) {
            System.out.println("Error while reading file.Please check " + fileName);
        }

    }

    private static String[] mapLineToEmployee(String line) {
        return line.split(",");
    }

    private static RaceResults mapLineToSkierResults(String line) {
        String[] fields = line.split(",");
        int minutesFromString = Integer.parseInt(fields[3].split(":")[0]);
        int secondsFromString = Integer.parseInt(fields[3].split(":")[1]);
        return new RaceResultsBuilder()
                .withT(Skier.builder()
                        .athleteNumber(Integer.parseInt(fields[0]))
                        .athleteName(fields[1])
                        .countryCode(fields[2])
                        .build())
                .withShootingResults(List.of(fields[4], fields[5], fields[6]))
                .withTime(LocalTime.of(0, minutesFromString, secondsFromString))
                .build();
    }

    private static void printResultsToFile(Set<RaceResults> skierRaceResults)throws IOException {

        String separator = File.separator;
        String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
        String fileName = "RaceFinalResults.txt";

        int i = 1;

        ComparatorForResults comparatorForTreeSet = new ComparatorForResults();
        TreeSet<RaceResults> skiFinalStandings = new TreeSet<>(comparatorForTreeSet);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileLocation + fileName));
        for (RaceResults<Skier> raceResults : skierRaceResults) {
            skiFinalStandings.add(raceResults);
        }
        for (RaceResults<Skier> skier : skiFinalStandings) {
            if (i == 1) {
                writer.write("WINNER IS ****** " + skier.getT().getAthleteName() + " ******");
                writer.newLine();
                writer.write(" final time: " + skier.getFinalTime());
                writer.newLine();
            }
            if (i == 2) {
                writer.write("Runner-up is " + skier.getT().getAthleteName() + ", final time: " + skier.getFinalTime());
                writer.newLine();
            }
            if (i == 3) {
                writer.write("Third place is " + skier.getT().getAthleteName() + ", final time: " + skier.getFinalTime());
                writer.newLine();
            }
            if (i > 3) {
                writer.write(i + "th ranking player is " + skier.getT().getAthleteName() + ", final time: " + skier.getFinalTime());
                writer.newLine();
            }
            i++;

        }
    } catch (FileNotFoundException e) {
            System.out.println("Error while reading file.Please check " + fileName);
    } catch (IOException e) {
            System.out.println("Error while reading file.Please check " + fileName);
    }finally {
            writer.close();
            // DE CE CERE IOException ?!?!?!
        }
}

}
