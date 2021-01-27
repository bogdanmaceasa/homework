package tema7.skiRaceResults;

import java.util.Comparator;

public class ComparatorForResults implements Comparator<RaceResults> {

    @Override
    public int compare(RaceResults o1, RaceResults o2) {
//        if (o1.getFinalTime().compareTo(o2.getFinalTime()) > 1 ){
//            return 1;
//        }
//        if (o1.getFinalTime().compareTo(o2.getFinalTime()) < 1 ){
//            return -1;
//        }
        return o1.getFinalTime().compareTo(o2.getFinalTime());
    }



}
