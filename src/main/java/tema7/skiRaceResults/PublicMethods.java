package tema7.skiRaceResults;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Log4j
public class PublicMethods {

    static String separator = File.separator;
    static String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
    static String fileName = "RaceFinalResults.txt";
    static String fileName1 = "RaceFinalResultsStream.txt";
    static BufferedWriter writer;


    public static RaceResults<Skier> mapLineToSkierResults(String line) {
        String[] fields = line.split(",");
        int minutesFromString = Integer.parseInt(fields[3].split(":")[0]);
        int secondsFromString = Integer.parseInt(fields[3].split(":")[1]);
        return new RaceResultsBuilder<Skier>()
                .withT(Skier.builder()
                        .athleteNumber(Integer.parseInt(fields[0]))
                        .athleteName(fields[1])
                        .countryCode(fields[2])
                        .build())
                .withShootingResults(List.of(fields[4], fields[5], fields[6]))
                .withTime(LocalTime.of(0, minutesFromString, secondsFromString))
                .build();
    }

    public static void printResultsToFile(Set<RaceResults<Skier>> skierRaceResults) {

        int i = 1;

//        ComparatorForResults comparatorForTreeSet = new ComparatorForResults();
//        TreeSet<RaceResults> skiFinalStandings = new TreeSet<>(comparatorForTreeSet);
//        skiFinalStandings.addAll(skierRaceResults);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileLocation + fileName));
            for (RaceResults<Skier> skier : skierRaceResults) {
                String outputString = "- "
                        + String.format("%-14s", skier.getT().getAthleteName())
                        + " - "
                        + String.format("%-10s", (skier.timeToString(skier.getFinalTime())))
                        + " ("
                        + String.format("%-10s", (skier.timeToString(skier.getTime())))
                        + " + "
                        + skier.getPenalty()
                        + "sec)";

                if (i == 1) {
                    writer.write(String.format("%-14s", "*Winner* ") + outputString);
                    writer.newLine();
                }
                if (i == 2) {
                    writer.write(String.format("%-14s", "*Runner-up* ") + outputString);
                    writer.newLine();
                }
                if (i == 3) {
                    writer.write(String.format("%-14s", "*Third place* ") + outputString);
                    writer.newLine();
                }
                if (i > 3) {
                    writer.write(String.format("%-14s", i + "th ") + outputString);
                    writer.newLine();
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error while reading file.Please check " + fileName);
        } catch (IOException e) {
            System.out.println("Error while reading file.Please check " + fileName);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printResultsToFile(RaceResults<Skier> skierRaceResults, int i) {
        writeRaceEntry(writer, skierRaceResults, i);
    }

    public static BufferedWriter getWriterInstance() throws IOException {
        if (writer != null) {
            return writer;
        }
        return new BufferedWriter(new FileWriter(fileLocation + fileName1,true));
    }

    public static void writeRaceEntry(BufferedWriter writer, RaceResults<Skier> skierRaceResults, int i) {
        try {
            writer = getWriterInstance();
            String outputString = "- "
                    + String.format("%-15s", skierRaceResults.getT().getAthleteName())
                    + " - "
                    + String.format("%-10s", (skierRaceResults.timeToString(skierRaceResults.getFinalTime())))
                    + " ("
                    + String.format("%-10s", (skierRaceResults.timeToString(skierRaceResults.getTime())))
                    + " + "
                    + skierRaceResults.getPenalty()
                    + "sec)";
            if (i == 1) {
                writer.write(String.format("%-13s", "Winner ") + outputString);
                writer.newLine();
            }
            if (i == 2) {
                writer.write(String.format("%-13s", "Runner-up ") + outputString);
                writer.newLine();
            }
            if (i == 3) {
                writer.write(String.format("%-13s", "Third place ") + outputString);
                writer.newLine();
            }
            if (i > 3) {
                writer.write(String.format("%-13s", i + "th ") + outputString);
                writer.newLine();
            }

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
