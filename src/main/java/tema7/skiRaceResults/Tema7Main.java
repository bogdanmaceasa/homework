package tema7.skiRaceResults;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.nio.file.Files;
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
//          METODA 1 - folosind o lista de String[] intermediara - dupa aceasta vom genera obiectele

//            List<String[]> skiStandingsToList = Files.readAllLines(file.toPath())
//                    .stream()
//                    .skip(1)
//                    .map(PublicMethods::mapLineToEmployee)
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
                    .map(PublicMethods::mapLineToSkierResults)
                    .collect(Collectors.toSet());
            PublicMethods.printResultsToFile(skiStandingsToList); // JAVA 8 ?!

        } catch (IOException e) {
            System.out.println("Error while reading file.Please check " + fileName);
        }

    }
}
