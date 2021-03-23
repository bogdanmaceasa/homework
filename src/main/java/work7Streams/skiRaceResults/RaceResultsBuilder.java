package work7Streams.skiRaceResults;

import java.time.LocalTime;
import java.util.List;

public class RaceResultsBuilder<T> {

    private RaceResults<T> raceResults = new RaceResults<>();

    public RaceResultsBuilder<T> withT(T t) {
        raceResults.setT(t);
        return this;
    }

    public RaceResultsBuilder<T> withShootingResults(List<String> stringList) {
        raceResults.setShootingResult(stringList);
        return this;
    }

    public RaceResultsBuilder<T> withTime(LocalTime time) {
        raceResults.setTime(time);
        int penalty = 0;
        List<String> stringList = raceResults.getShootingResult();
        for (String string : stringList) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == 'o') {
                    penalty += 1;
                }
            }
            raceResults.setFinalTime(raceResults.getTime().plusSeconds(penalty * 10));
            raceResults.setPenalty(penalty * 10);
            raceResults.timeToString(raceResults.getFinalTime());

        }
        return this;
    }

    public RaceResults<T> build() {
        return raceResults;
    }
}
