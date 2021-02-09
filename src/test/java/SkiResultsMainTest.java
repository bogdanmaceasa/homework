import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import tema7.skiRaceResults.ComparatorForResults;
import tema7.skiRaceResults.PublicMethods;
import tema7.skiRaceResults.RaceResults;
import tema7.skiRaceResults.Skier;

import java.util.List;
import java.util.stream.Collectors;


@RunWith(MockitoJUnitRunner.class)
public class SkiResultsMainTest {


    @InjectMocks
    private PublicMethods skiRaceResults;
    private ComparatorForResults comparatorForResults = new ComparatorForResults();

    @Test
    public void csvLineToSkierResultsMappingTest() {
        // Given
        String csvLine1 = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";

        // When
        RaceResults<Skier> skier = skiRaceResults.mapLineToSkierResults(csvLine1);

        // Then
        Assert.assertEquals(11, skier.getT().getAthleteNumber());
        Assert.assertEquals("Umar Jorgson", skier.getT().getAthleteName());
        Assert.assertEquals("SK", skier.getT().getCountryCode());
        Assert.assertEquals("30min:27sec", skier.timeToString(skier.getTime()));
        Assert.assertEquals(skier.getPenalty(), 30);
    }

    @Test
    public void csvLineToSkierResultsListMappingTest() {
        // Given
        String line1 = "11,Umar Jorgson,SK,30:27,xxxxx,xxxxx,xxxxx";
        String line2 = "1,Jimmy Smiles,UK,30:27,xxxxx,xxxxx,xxxxo";
        String line3 = "27,Piotr Jimmy,CZ,30:27,xxxxx,xxxxx,xxxoo";

        RaceResults<Skier> skier1 = skiRaceResults.mapLineToSkierResults(line1);
        RaceResults<Skier> skier2 = skiRaceResults.mapLineToSkierResults(line2);
        RaceResults<Skier> skier3 = skiRaceResults.mapLineToSkierResults(line3);

        // When
        List<RaceResults<Skier>> sortedList =  List.of(skier1,skier2,skier3).stream().sorted(comparatorForResults).collect(Collectors.toList());
        List<RaceResults<Skier>> sortedManualTestList = List.of(skier1,skier2,skier3);

        // Then
        Assert.assertEquals(sortedManualTestList,sortedList);

    }

}
