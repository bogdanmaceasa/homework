package tema7.skiRaceResults;

import java.io.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PublicMethods {

    public static String[] mapLineToEmployee(String line) {
        return line.split(",");
    }

    public static RaceResults mapLineToSkierResults(String line) {
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

    public static void printResultsToFile(Set<RaceResults> skierRaceResults) throws IOException {

        String separator = File.separator;
        String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
        String fileName = "RaceFinalResults.txt";

        int i = 1;

        ComparatorForResults comparatorForTreeSet = new ComparatorForResults();
        TreeSet<RaceResults> skiFinalStandings = new TreeSet<>(comparatorForTreeSet);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileLocation + fileName));
            skiFinalStandings.addAll(skierRaceResults);
            for (RaceResults<Skier> skier : skiFinalStandings) {

                String outputString = "- "
                        + String.format("%-15s", skier.getT().getAthleteName())
                        + " - "
                        + String.format("%-10s", (skier.setTimeToString(skier.getFinalTime())))
                        + " ("
                        + String.format("%-10s", (skier.setTimeToString(skier.getTime())))
                        + " + "
                        + skier.getPenalty()
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
                i++;

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error while reading file.Please check " + fileName);
        } catch (IOException e) {
            System.out.println("Error while reading file.Please check " + fileName);
        } finally {
            writer.close();
            // DE CE CERE IOException ?!?!?!
        }
    }

}
