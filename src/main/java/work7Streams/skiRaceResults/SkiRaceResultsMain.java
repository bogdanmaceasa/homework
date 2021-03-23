package work7Streams.skiRaceResults;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

@Log4j
public class SkiRaceResultsMain {

    public static void main(String[] args) {

        String separator = File.separator;
        String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
        String fileName = "SkiStandings.csv";
        File outFile = new File(fileLocation + "RaceFinalResultsStream.txt");
        File file = new File(fileLocation + fileName);

        if (outFile.exists()) {
            outFile.delete();
        }

        try {
//          METODA 1 - folosind o List<String[]> intermediara - din elementele acesteia vom genera obiectele

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

//          METODA 2 - folosind un Set<RaceResults<Skier>> peste care vom opera operatia de print al rezultatului
//
            Set<RaceResults<Skier>> skiStandingsToSet = Files.lines(file.toPath())
                    .skip(1)
                    .map(PublicMethods::mapLineToSkierResults)
                    .sorted(new ComparatorForResults())
                    .collect(Collectors.toCollection(LinkedHashSet::new));
            PublicMethods.printResultsToFile(skiStandingsToSet);

//          METODA 3 - folosind streams si consumand Streamul pentru a printa in fisier fiecare element

            int[] position = new int[]{1};
            Files.lines(file.toPath())
                    .skip(1)
                    .map(PublicMethods::mapLineToSkierResults)
                    .sorted(new ComparatorForResults())
                    .forEach(s -> PublicMethods.printResultsToFile(s, position[0]++));

        } catch (IOException e) {
            System.out.println("Error while reading file.Please check " + fileName);
        }

    }
}
