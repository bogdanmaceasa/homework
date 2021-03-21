package tema7Streams.skiRaceResults;

import java.util.Comparator;

public class ComparatorForResults implements Comparator<RaceResults> {

    @Override
    public int compare(RaceResults o1, RaceResults o2) {
        return o1.getFinalTime().compareTo(o2.getFinalTime());
    }


}
