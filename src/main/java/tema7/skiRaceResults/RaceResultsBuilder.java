package tema7.skiRaceResults;

import java.time.LocalTime;
import java.util.List;

public class RaceResultsBuilder {

    private RaceResults raceResults = new RaceResults();

    public <T> RaceResultsBuilder withT(T t){
        raceResults.setT(t);
        return this;
    }

    public RaceResultsBuilder withShootingResults(List<String> stringList){
        raceResults.setShootingResult(stringList);
        return this;
    }

    public RaceResultsBuilder withTime(LocalTime time) {
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
            raceResults.setPenalty(penalty*10);
            raceResults.setTimeToString(raceResults.getFinalTime());

        }
        return this;
    }

    public RaceResults build(){
        return raceResults;
    }
}
