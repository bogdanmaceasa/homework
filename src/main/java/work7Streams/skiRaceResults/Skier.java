package work7Streams.skiRaceResults;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class Skier {

    private int athleteNumber;
    private String athleteName;
    private String countryCode;

}
